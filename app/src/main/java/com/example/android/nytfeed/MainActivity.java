package com.example.android.nytfeed;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
             //   case R.id.navigation_dashboard:
              //      mTextMessage.setText(R.string.title_dashboard);
               //     return true;
                case R.id.navigation_books:
                    mTextMessage.setText(R.string.title_books);
                    Intent intent = new Intent(getApplicationContext(), BookActivity.class);
                    startActivity(intent);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nytimes.com/svc/topstories/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
TopApiInterface tai = retrofit.create( TopApiInterface.class);
Call<TopResponse> call = tai.getTopStories("");
call.enqueue(new Callback<TopResponse>() {
    @Override
    public void onResponse(Call<TopResponse> call, Response<TopResponse> response) {
        List<TopStories> topStories = response.body().getResults();
        Log.d("answer is ", topStories.get(0).getImageUrl());
        Log.d("answer is ", topStories.get(0).getStoryTitle());
    }

    @Override
    public void onFailure(Call<TopResponse> call, Throwable t) {
Log.e("request failed "," no response");
    }
});

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}

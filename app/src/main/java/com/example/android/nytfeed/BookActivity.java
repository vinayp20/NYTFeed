package com.example.android.nytfeed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.books_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nytimes.com/svc/books/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

          BooksApiInterface booksApiInterface = retrofit.create(BooksApiInterface.class);
        Call<BooksResponse> call = booksApiInterface.getBestsellers("3d60d603e91e4c31beaadcf96f4483ac");
        call.enqueue(new Callback<BooksResponse>() {
            @Override
            public void onResponse(Call<BooksResponse> call, Response<BooksResponse> response) {
                List<Books> bestsellers = response.body().getResults();
                Log.d("bestsellers listSizeIs", bestsellers.size()+"");
                Log.d("bestsellers listSizeIs", bestsellers.get(0).getTitle());
                recyclerView.setAdapter(new BooksAdapter(bestsellers, R.layout.list_item_book, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<BooksResponse> call, Throwable t) {
               Log.e("no response "," check request");
            }
        });

    }
}

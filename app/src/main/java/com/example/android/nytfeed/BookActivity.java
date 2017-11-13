package com.example.android.nytfeed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import retrofit2.Retrofit;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://developer.nytimes.com")
                .build();
    }
}

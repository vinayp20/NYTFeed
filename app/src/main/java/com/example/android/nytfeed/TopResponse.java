package com.example.android.nytfeed;

import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TopResponse {

    public List<TopStories> getResults() {
        return results;
    }

    public void setResults(List<TopStories> results) {
        this.results = results;
    }

    @SerializedName("results")
    private List<TopStories> results;
}

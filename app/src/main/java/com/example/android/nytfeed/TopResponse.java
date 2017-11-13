package com.example.android.nytfeed;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TopResponse {
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @SerializedName("url")
    private String url;
    @SerializedName("title")
    private String title;

    public List<TopStories> getResults() {
        return results;
    }

    public void setResults(List<TopStories> results) {
        this.results = results;
    }

    @SerializedName("results")
    private List<TopStories> results;
}

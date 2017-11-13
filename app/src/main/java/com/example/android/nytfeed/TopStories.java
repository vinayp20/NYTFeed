package com.example.android.nytfeed;

import com.google.gson.annotations.SerializedName;

public class TopStories {
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getStoryTitle() {
        return storyTitle;
    }

    public void setStoryTitle(String storyTitle) {
        this.storyTitle = storyTitle;
    }

    @SerializedName("url")
    String imageUrl;
    @SerializedName("title")
    String storyTitle;
    public TopStories(String imageUrl, String storyTitle){
        this.imageUrl = imageUrl;
        this.storyTitle = storyTitle;
    }
}

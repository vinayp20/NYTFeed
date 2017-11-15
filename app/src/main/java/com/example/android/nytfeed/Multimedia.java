package com.example.android.nytfeed;


import com.google.gson.annotations.SerializedName;

public class Multimedia {
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @SerializedName("url")
    String url;
    @SerializedName("format")
    String format;
}

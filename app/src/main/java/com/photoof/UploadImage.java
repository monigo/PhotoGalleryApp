package com.photoof;

public class UploadImage {

    private String mImageUrl;
    private String key;

    public UploadImage(){

    }

    public UploadImage(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public UploadImage(String mImageUrl, String key) {
        this.mImageUrl = mImageUrl;
        this.key = key;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

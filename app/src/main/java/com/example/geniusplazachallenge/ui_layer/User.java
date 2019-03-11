package com.example.geniusplazachallenge.ui_layer;

import android.graphics.Bitmap;

/**
 * Created by Andrew El-Masry March 10th, 2019
 *
 * This is the user object.
 */
public class User {
    String userName, imgUrl;
    Bitmap avatar;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String firstName) {
        this.userName = firstName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}

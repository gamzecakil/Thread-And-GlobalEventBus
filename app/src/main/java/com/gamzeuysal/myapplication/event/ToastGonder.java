package com.gamzeuysal.myapplication.event;

import android.widget.Toast;

public class ToastGonder {
    private String toastMessage;
    //Constructor
    public ToastGonder(String toastMessage)
    {
        this.toastMessage=toastMessage;
    }

    public String getToastMessage() {
        return toastMessage;
    }

    public void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
    }
}

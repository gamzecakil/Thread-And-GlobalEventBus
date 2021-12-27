package com.gamzeuysal.myapplication.event;

import com.gamzeuysal.myapplication.User;

public class ObjeGonder {
    private User user;
    //Constructor
    public ObjeGonder(User user)
    {
        this.user=user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

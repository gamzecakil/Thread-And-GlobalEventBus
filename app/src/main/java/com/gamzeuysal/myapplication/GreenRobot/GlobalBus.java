package com.gamzeuysal.myapplication.GreenRobot;

import org.greenrobot.eventbus.EventBus;

public class GlobalBus {
    private static EventBus eventBus;
    public static EventBus getBus()
    {
        if(eventBus==null)
            eventBus=EventBus.getDefault();
        return eventBus;
    }
}

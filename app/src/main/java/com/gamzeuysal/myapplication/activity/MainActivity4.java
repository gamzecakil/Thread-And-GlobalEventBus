package com.gamzeuysal.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.gamzeuysal.myapplication.GreenRobot.GlobalBus;
import com.gamzeuysal.myapplication.R;
import com.gamzeuysal.myapplication.event.StringGonder;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity4 extends AppCompatActivity {
    //StringGonder eventini dinliyor
    private final static String TAG=MainActivity4.class.getSimpleName();
TextView veri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        veri=findViewById(R.id.txtVeri);
        GlobalBus.getBus().register(this);
        Log.e(TAG, "  register oldu");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GlobalBus.getBus().unregister(this);
    }
    @Subscribe (sticky = true,threadMode = ThreadMode.MAIN)
    public void onEvent(StringGonder event)
    {
        veri.setText(event.getMsg());
    }
}
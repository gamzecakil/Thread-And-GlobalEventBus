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

public class MainActivity3 extends AppCompatActivity {
//StringGonder eventını dinliyor
    private static  final String TAG=MainActivity3.class.getSimpleName();
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        textView=findViewById(R.id.txtString);
        GlobalBus.getBus().register(this);
        Log.e(TAG," register olundu ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GlobalBus.getBus().unregister(this);
        Log.e(TAG," unregister olundu ");
    }
    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    public void onEvent(StringGonder event)
    {
        Log.e(TAG," Subscribe girdin ");
        textView.setText(event.getMsg());
    }
}
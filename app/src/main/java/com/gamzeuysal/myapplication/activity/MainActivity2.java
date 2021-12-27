package com.gamzeuysal.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.gamzeuysal.myapplication.GreenRobot.GlobalBus;
import com.gamzeuysal.myapplication.R;
import com.gamzeuysal.myapplication.event.ObjeGonder;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity2 extends AppCompatActivity {
    // ObjeGonder eventini dinliyor
    private final static String TAG=MainActivity2.class.getSimpleName();
    TextView txtName,txtSurname,txtDepartment,txtAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtName=findViewById(R.id.txtName);
        txtSurname=findViewById(R.id.txtSurname);
        txtDepartment=findViewById(R.id.txtDepartment);
        txtAge=findViewById(R.id.txtAge);

        GlobalBus.getBus().register(this);
        Log.e(TAG," register olundu");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GlobalBus.getBus().unregister(this);
        Log.e(TAG," unregister olundu");
    }
    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    public void onEvent(ObjeGonder objeGonder)
    {
        txtName.setText(" Adi :"+objeGonder.getUser().getName());
        txtSurname.setText("Soyadi : "+objeGonder.getUser().getSurname());
        txtDepartment.setText("Department : "+objeGonder.getUser().getDepartment());
        txtAge.setText("Age : "+objeGonder.getUser().getAge());
        Log.e(TAG," subscribe calisti");
    }
}
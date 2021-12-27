package com.gamzeuysal.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.gamzeuysal.myapplication.GreenRobot.GlobalBus;
import com.gamzeuysal.myapplication.activity.MainActivity2;
import com.gamzeuysal.myapplication.activity.MainActivity3;
import com.gamzeuysal.myapplication.activity.MainActivity4;
import com.gamzeuysal.myapplication.event.ObjeGonder;
import com.gamzeuysal.myapplication.event.StringGonder;
import com.gamzeuysal.myapplication.event.ToastGonder;
import com.gamzeuysal.myapplication.fragment.FirstFragment;
import com.gamzeuysal.myapplication.fragment.SecondFragment;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG=MainActivity.class.getSimpleName();
int event,event1;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random random=new Random();
        User user=new User("Gamze","Uysal","Yazilimci",27);
        event1=random.nextInt(5);

        addFragment();//Fragment eklmeyi cagır.

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(i<3)
                    {
                        Thread.sleep(5000);
                        event=random.nextInt(3);//0,1,2 gelir
                        switch (event)
                        {
                            case 0:
                                //StringGonder
                                Log.e(TAG ,"   case 0  StringGonder event calisiyor ");
                                GlobalBus.getBus().postSticky(new StringGonder(" String Gonderildi event calisti"));
                                Log.e(TAG ,"   case 0 StringGonder post edildi  ");

                                //MainActivity3 ve MainActivity4 activileri StringGonder eventini dinliyor.
                                Intent intent1=new Intent(MainActivity.this, MainActivity3.class);
                                startActivity(intent1);
                                Intent intent2=new Intent(MainActivity.this, MainActivity4.class);
                                startActivity(intent2);

                                break;
                            case 1:
                                //ToastGonder
                                Log.e(TAG,"  case 1 ToastGonder event calisiyor");
                                GlobalBus.getBus().post(new ToastGonder("Toast message gonderildi"));
                                Log.e(TAG ,"   case 1 ToastGonder  post edildi  ");
                                break;
                            case 2:
                                //ObjeGonder
                                Intent intent=new Intent(MainActivity.this, MainActivity2.class);
                                startActivity(intent);

                                Log.e(TAG," case 2 ObjeGonder event calisiyor ");
                                GlobalBus.getBus().postSticky(new ObjeGonder(user));
                                Log.e(TAG," case 2 ObjeGonder post edildi ");
                                break;
                        }
                        i++;
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }
    public void addFragment()
    {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameLayout2,new FirstFragment(),"fragmentOne");
        fragmentTransaction.add(R.id.frameLayout3,new SecondFragment(),"fragmentSecond");
        fragmentTransaction.commit();
    }
}
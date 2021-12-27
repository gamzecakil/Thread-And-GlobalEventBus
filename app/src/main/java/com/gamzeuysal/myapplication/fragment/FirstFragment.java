package com.gamzeuysal.myapplication.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.gamzeuysal.myapplication.GreenRobot.GlobalBus;
import com.gamzeuysal.myapplication.R;
import com.gamzeuysal.myapplication.event.StringGonder;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class FirstFragment extends Fragment {
//Bu fragment StringGonder eventını dinlesin
    private static  final String TAG= FragmentTransaction.class.getSimpleName();
    TextView firstFragmentText;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GlobalBus.getBus().register(this);
        Log.e(TAG," register oldu");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable  Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.first_fragment,container,false);
        firstFragmentText=view.findViewById(R.id.txtFirstFragment);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        GlobalBus.getBus().unregister(this);
        Log.e(TAG," unregister oldu");
    }
    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    public void onEvent(StringGonder event)
    {
        try {
            firstFragmentText.setText(event.getMsg());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.e(TAG," subscribe calisti  ");
    }
}

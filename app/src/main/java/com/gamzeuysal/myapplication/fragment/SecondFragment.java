package com.gamzeuysal.myapplication.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.gamzeuysal.myapplication.GreenRobot.GlobalBus;
import com.gamzeuysal.myapplication.R;
import com.gamzeuysal.myapplication.event.ToastGonder;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class SecondFragment extends Fragment {
    //Bu fragment ToastGonder eventını dinlesin.
    private static final  String TAG=SecondFragment.class.getSimpleName();
TextView textView;
    @Override
    public void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GlobalBus.getBus().register(this);
        Log.e(TAG," register oldu");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.second_fragment,container,false);
        textView=view.findViewById(R.id.txtSecondFragment);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        GlobalBus.getBus().unregister(this);
        Log.e(TAG," unregister oldu");
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(ToastGonder event)
    {
        try {
            textView.setText("Toast message gosteriliyor");
            Toast.makeText(requireContext(),event.getToastMessage(),Toast.LENGTH_LONG).show();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.e(TAG," Subscribe calisti");
    }
}

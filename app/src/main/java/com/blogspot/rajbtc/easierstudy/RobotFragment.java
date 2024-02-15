package com.blogspot.rajbtc.easierstudy;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Switch;
import android.widget.TextView;

import io.github.controlwear.virtual.joystick.android.JoystickView;


public class RobotFragment extends Fragment {

    WebView webView;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_robot, container, false);
        setupButton();
        run();
        return view;
    }


    void setupButton(){

        webView=new WebView(getContext());
        webView.loadUrl("HTTP://192.168.4.1/25");

        ((Switch)view.findViewById(R.id.robot1Sw)).setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked)
                webView.loadUrl("HTTP://192.168.4.1/15");
            else
                webView.loadUrl("HTTP://192.168.4.1/5");
        });
        ((Switch)view.findViewById(R.id.robot2Sw)).setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked)
                webView.loadUrl("HTTP://192.168.4.1/16");
            else
                webView.loadUrl("HTTP://192.168.4.1/6");
        });
        ((Switch)view.findViewById(R.id.robot3Sw)).setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked)
                webView.loadUrl("HTTP://192.168.4.1/17");
            else
                webView.loadUrl("HTTP://192.168.4.1/7");
        });
        ((Switch)view.findViewById(R.id.robot4Sw)).setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked)
                webView.loadUrl("HTTP://192.168.4.1/18");
            else
                webView.loadUrl("HTTP://192.168.4.1/8");
        });

    }

    void run(){

        final JoystickView joystickRight = (JoystickView) view.findViewById(R.id.robotJoystick);
        joystickRight.setOnMoveListener((angle, strength) -> {

            Log.e("==========","Straight: "+strength+"     Angle: "+angle);

            if(strength<50){

                webView.loadUrl("HTTP://192.168.4.1/25");
            }else {
                if ((340 < angle && angle < 360) || (angle > -1 && angle < 23)) {

                    webView.loadUrl("HTTP://192.168.4.1/24");
                } else if (angle > 22 && angle < 67) {

                } else if (angle > 22 && angle < 67) {

                } else if (angle > 66 && angle < 112) {
                    webView.loadUrl("HTTP://192.168.4.1/21");
                } else if (angle > 111 && angle < 202) {

                    webView.loadUrl("HTTP://192.168.4.1/23");
                } else if (angle > 201 && angle < 247) {

                } else if (angle > 246 && angle < 292) {

                    webView.loadUrl("HTTP://192.168.4.1/22");
                } else if (angle > 291 && angle < 341) {

                }


            }

        });
    }

}
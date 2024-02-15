package com.blogspot.rajbtc.easierstudy;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;


public class MotorFragment extends Fragment {
    WebView webView;
    View view;

    Button up1,up2,down1,down2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_motor, container, false);
        setUp();
        return view;
    }



    void setUp(){

        webView=new WebView(getContext());
        webView.loadUrl("HTTP://192.168.4.1/25");
        up1=view.findViewById(R.id.motorUp1Btn);
        up2=view.findViewById(R.id.motorUp2Btn);
      down1=view.findViewById(R.id.motorDown1Btn);
        down2=view.findViewById(R.id.motorDown2Btn);


        up1.setOnTouchListener((v, event) -> {
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                webView.loadUrl("HTTP://192.168.4.1/11");
            }else if(event.getAction() == MotionEvent.ACTION_UP){
                webView.loadUrl("HTTP://192.168.4.1/1");
            }


            return true;
        });

        up2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    webView.loadUrl("HTTP://192.168.4.1/13");
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    webView.loadUrl("HTTP://192.168.4.1/3");
                }


                return true;
            }
        });

        down1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    webView.loadUrl("HTTP://192.168.4.1/12");
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    webView.loadUrl("HTTP://192.168.4.1/2");
                }


                return true;
            }
        });

        down2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    webView.loadUrl("HTTP://192.168.4.1/14");
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    webView.loadUrl("HTTP://192.168.4.1/4");
                }


                return true;
            }
        });


    }
}
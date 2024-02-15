package com.blogspot.rajbtc.easierstudy;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ToggleButton;

import androidx.fragment.app.Fragment;

public class SwitchFragment extends Fragment {

    String name,TAG="===Main Fragment===";
    View view;

    WebView webView;
    ToggleButton firstS,secondS,thirdS,forthS,fifthS,sixS,sevenS,eightS;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_switch, container, false);
        setUp();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        firstS.setChecked(false);
        secondS.setChecked(false);
        thirdS.setChecked(false);
        forthS.setChecked(false);
        fifthS.setChecked(false);
        sixS.setChecked(false);
        sevenS.setChecked(false);
        eightS.setChecked(false);

    }



    void setUp(){
        firstS=view.findViewById(R.id.firstSw);
        secondS=view.findViewById(R.id.secondSw);
        thirdS=view.findViewById(R.id.thirdSw);
        forthS=view.findViewById(R.id.forthSw);
        fifthS=view.findViewById(R.id.fifthSw);
        sixS=view.findViewById(R.id.sixSw);
        sevenS=view.findViewById(R.id.sevenSw);
        eightS=view.findViewById(R.id.eightSw);

        webView=new WebView(getContext());

        webView.loadUrl("HTTP://192.168.4.1/25");


        firstS.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Log.e("====","+++");
            if(isChecked){
                webView.loadUrl("HTTP://192.168.4.1/11");
            }else{
                webView.loadUrl("HTTP://192.168.4.1/1");
            }
        });

        secondS.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Log.e("====","+++");
            if(isChecked){
                webView.loadUrl("HTTP://192.168.4.1/12");
            }else{
                webView.loadUrl("HTTP://192.168.4.1/2");
            }

        });

        thirdS.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Log.e("====","+++");
            if(isChecked){
                webView.loadUrl("HTTP://192.168.4.1/13");
            }else{
                webView.loadUrl("HTTP://192.168.4.1/3");
            }
        });

        forthS.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Log.e("====","+++");
            if(isChecked){
                webView.loadUrl("HTTP://192.168.4.1/14");
            }else{
                webView.loadUrl("HTTP://192.168.4.1/4");
            }
        });

        fifthS.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Log.e("====","+++");
            if(isChecked){
                webView.loadUrl("HTTP://192.168.4.1/15");
            }else{
                webView.loadUrl("HTTP://192.168.4.1/5");
            }
        });

        sixS.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Log.e("====","+++");
            if(isChecked){
                webView.loadUrl("HTTP://192.168.4.1/16");
            }else{
                webView.loadUrl("HTTP://192.168.4.1/6");
            }
        });

        sevenS.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Log.e("====","+++");
            if(isChecked){
                webView.loadUrl("HTTP://192.168.4.1/17");
            }else{
                webView.loadUrl("HTTP://192.168.4.1/7");
            }
        });

        eightS.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Log.e("====","+++");
            if(isChecked){
                webView.loadUrl("HTTP://192.168.4.1/18");
            }else{
                webView.loadUrl("HTTP://192.168.4.1/8");
            }
        });



        view.findViewById(R.id.ToggleButton1Cv).setOnClickListener(v -> {
            checkAndCheckLoad(firstS,11);
        });
        view.findViewById(R.id.ToggleButton2Cv).setOnClickListener(v -> {
            checkAndCheckLoad(secondS,12);
        });
        view.findViewById(R.id.ToggleButton3Cv).setOnClickListener(v -> {

            checkAndCheckLoad(thirdS,13);
        });
        view.findViewById(R.id.ToggleButton4Cv).setOnClickListener(v -> {
            checkAndCheckLoad(forthS,14);
        });
        view.findViewById(R.id.ToggleButton5Cv).setOnClickListener(v -> {
            checkAndCheckLoad(fifthS,15);
        });
        view.findViewById(R.id.ToggleButton6Cv).setOnClickListener(v -> {
            checkAndCheckLoad(sixS,16);
        });
        view.findViewById(R.id.ToggleButton7Cv).setOnClickListener(v -> {
            checkAndCheckLoad(sevenS,18);
        });
        view.findViewById(R.id.ToggleButton8Cv).setOnClickListener(v -> {
            checkAndCheckLoad(eightS,19);
        });





}

    void checkAndCheckLoad(ToggleButton sw, int val){
//        Log.e("====","+++");
//        if(sw.isChecked()){
//            sw.setChecked(false);
//            webView.loadUrl("HTTP://192.168.4.1/"+(val-10));
//        }else{
//            sw.setChecked(true);
//            webView.loadUrl("HTTP://192.168.4.1/"+val);
//        }

    }



}
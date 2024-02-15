package com.blogspot.rajbtc.easierstudy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiNetworkSuggestion;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "";
    ViewPager viewPager;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // setUp();
        versionCheck();


        viewPager2=findViewById(R.id.viewPage);
        viewPager2.setUserInputEnabled(false);
       // viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
       // viewPager.setEnabled(false);
        ViewPager2Adapter adapter=new ViewPager2Adapter(getSupportFragmentManager(),getLifecycle());
        viewPager2.setAdapter(adapter);

        tabLayout=findViewById(R.id.tabLay);
        new TabLayoutMediator(tabLayout,viewPager2,(tab,position)->{
            String[] name={"Switch","Motor","Robot"};
            tab.setText(name[position]);
        }).attach();;




      // tabLayout.setupWithViewPager(viewPager2);

//        final WifiNetworkSuggestion suggestion1 =
//                new WifiNetworkSuggestion.Builder()
//                        .setSsid("My Robot")
//                        .setWpa2Passphrase("12345678")
//                        .build();
//
//        final List<WifiNetworkSuggestion> suggestionsList =
//                new ArrayList<WifiNetworkSuggestion>();
//        suggestionsList.add(suggestion1);
//
//        WifiManager wifiManager =
//                (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
//        int status = wifiManager.addNetworkSuggestions(suggestionsList);
//        if (status == 0 ){
//            Toast.makeText(this,"PSK network added",Toast.LENGTH_LONG).show();
//            Log.i(TAG, "PSK network added: "+status);
//        }else {
//            Toast.makeText(this,"PSK network not added",Toast.LENGTH_LONG).show();
//            Log.i(TAG, "PSK network not added: "+status);
//        }
    }

    void versionCheck(){
        FirebaseDatabase.getInstance().getReference("Version").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.e("++++++++++",snapshot.getValue().toString());
                if((double)snapshot.getValue()>Double.parseDouble(BuildConfig.VERSION_NAME))
                {
                    AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Update Alert")
                            .setIcon(R.drawable.robo)
                            .setMessage("Please update your app")
                            .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=com.blogspot.prajbtc.ioteasier")));
                                    finish();
                                }
                            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                            System.exit(0);
                        }
                    }).create().show();

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuAbout) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("IoT Easier")
                    .setMessage("IoT Easier is a firebase database controlling app that connects and manipulates any database by applying database url & secreate only. Users can control their IoT loads using their own database. No need to learn app development to develop your IoT-based project.")
                    .create().show();


        }
        else if (item.getItemId() == R.id.menuDev) {
                startActivity(new Intent(this, AboutDeveloper.class));
            } else {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/dev?id=8761614094262930672")));
            }


            return true;
        }


}
package com.blogspot.rajbtc.easierstudy;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class AboutDeveloper extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_developer);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    public void callPappuraj(View view) {
        makePhoneCall("+8801832755401");
    }

    public void fbPappuraj(View view) {
        brows("https://www.facebook.com/PAPPURAJ.DUET");
    }

    public void mailPappuraj(View view) {
        sendEmail("pappuraj.duet@gmail.com");
    }

    public void linkedinPappuraj(View view) {
        brows("https://www.linkedin.com/in/pappuraj");
    }

    public void callShiplob(View view) {
        makePhoneCall("+8801813112449");
    }

    public void fbShiplob(View view) {
        brows("https://www.facebook.com/shiplob50");
    }

    public void mailShiplob(View view) {
        sendEmail("shiplob50@gmail.com");
    }

    public void linkedinShiplob(View view) {
        brows("https://www.linkedin.com/in/sukanta-sharma-shiplob-705359137");
    }

    public void callDeep(View view) {
        makePhoneCall("+8801838255986");
    }

    public void fbDeep(View view) {
        brows("https://www.facebook.com/dhip.chy");
    }

    public void mailDeep(View view) {
        sendEmail("dhip.chy2015@gmail.com");
    }

    public void linkedinDeep(View view) {
        brows("https://www.linkedin.com/in/deep-chowdhury-2164531b5");
    }



    void brows(String URL){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
        startActivity(browserIntent);
    }




    protected void sendEmail(String mail) {
        try {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"+mail)); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"example.yahoo.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT, "App feedback");
            startActivity(intent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There are no email client installed on your device.",Toast.LENGTH_SHORT).show();
        }
    }




    private void makePhoneCall(String number) {
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        } else {
            Toast.makeText(this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission GRANTED", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
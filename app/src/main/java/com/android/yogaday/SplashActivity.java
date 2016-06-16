package com.android.yogaday;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

         /*
             * Showing splash screen with a timer.
             */

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity

                 /*code to run registration activity only once*/
                SharedPreferences sharedPreferences = getSharedPreferences("prefs",0);
        /*setting flag value*/
                 boolean firstRun = sharedPreferences.getBoolean("firstRun",false);
                if(firstRun == false) {

                    Intent intent = new Intent(SplashActivity.this, RegistrationActivity.class);
                    startActivity(intent);
                    // close this activity
                    finish();
                }
                else{
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    // close this activity
                    finish();
                }
            }
        },SPLASH_TIME_OUT);
    }
}

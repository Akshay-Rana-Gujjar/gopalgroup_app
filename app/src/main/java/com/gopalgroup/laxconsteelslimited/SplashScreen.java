package com.gopalgroup.laxconsteelslimited;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {

    final int SPLASHSCREEN_TIMEOUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        final Context context = this;

        new Handler().postDelayed(new Runnable(){

            @Override
            public void run() {
                startActivity(new Intent(context, MainActivity.class));
                // close this activity
                finish();

            }
        },SPLASHSCREEN_TIMEOUT);
    }
}

package cpm.example.sample.assignment3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import cpm.example.sample.assignment3.R;

/*
 * SplashScreen
 */

public class SplashActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        /*
        Delays the activity for @SPLASH_TIME_OUT millsecs
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(SplashActivity.this, ScreenBActivity.class));
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
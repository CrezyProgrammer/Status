package com.facebookfanstatus.facebookfanstatus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
          final Handler handler = new Handler();
                  handler.postDelayed(() -> {
                      startActivity(new Intent(this, HomeActivity.class));

                  }, 1000);
    }

}
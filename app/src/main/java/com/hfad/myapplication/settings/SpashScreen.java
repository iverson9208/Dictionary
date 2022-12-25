package com.hfad.myapplication.settings;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.hfad.myapplication.MainActivity;
import com.hfad.myapplication.R;

public class SpashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash_screen);
  new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(SpashScreen.this,  MainActivity.class));
            finish();

        }
  }, 2500);
    }
}
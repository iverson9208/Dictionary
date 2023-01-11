package com.hfad.myapplication.settings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.hfad.myapplication.MainActivity;
import com.hfad.myapplication.R;

public class Application1 extends AppCompatActivity {
    private ActionBar actionBar;
    private TextView textView;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application1);
        if(getSupportActionBar()!=null)
        {
            actionBar=getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setTitle("Приложение 1");
        }

    }
    public boolean onSupportNavigateUp(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home) {

            onBackPressed();
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Application1.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
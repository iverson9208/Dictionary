package com.hfad.myapplication.settings;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;


import com.hfad.myapplication.MainActivity;
import com.hfad.myapplication.R;

public class table_chapter20 extends AppCompatActivity {
private ActionBar actionBar;
private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_chapter20);
if(getSupportActionBar()!=null)
{
    actionBar=getSupportActionBar();
    actionBar.setDisplayHomeAsUpEnabled(false);
    actionBar.setTitle("Глава 20");
}
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(table_chapter20.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    public boolean onSupportNavigateUp(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home) {
            setContentView(R.layout.activity_main);
            finish();
        }
        return true;
    }


}
package com.hfad.myapplication.settings;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import com.hfad.myapplication.R;

public class table_chapter20 extends AppCompatActivity {
private ActionBar actionBar;
private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
if(getSupportActionBar()!=null)
{
    actionBar=getSupportActionBar();
    actionBar.setDisplayHomeAsUpEnabled(true);
    actionBar.setTitle("О приложении");
}
    }


    public boolean onSupportNavigateUp(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home) finish();
        return true;
    }

}
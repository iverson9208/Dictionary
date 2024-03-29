package com.hfad.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.hfad.myapplication.databinding.ActivityMainBinding;
import com.hfad.myapplication.settings.SView;
import com.hfad.myapplication.settings.SettingsActivity;
import com.hfad.myapplication.settings.tabb;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
private DrawerLayout drawer;
private ListView listView;
private String[] array;
private ArrayAdapter<String> arrayAdapter;
private Toolbar toolbar;
private int categoryIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBarMain.toolbar);
        listView=findViewById(R.id.listview);
        array=getResources().getStringArray(R.array.intro);
        arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,new ArrayList<String>(Arrays.asList(array)));
        listView.setAdapter(arrayAdapter);

        drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,binding.appBarMain.toolbar,R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
drawer.addDrawerListener(toggle);
toggle.syncState();
listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Intent intent=new Intent(MainActivity.this,TextContentActivity.class);
        intent.putExtra("category", categoryIndex);
        intent.putExtra("position", position);
        startActivity(intent);
    }
});
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.action_settings)
        {
            Intent intent=new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        }
        if(id==R.id.search_text)
        {
            Intent intent = new Intent(MainActivity.this, SView.class);
            startActivity(intent);
        }
            if (id == R.id.about) {
                Intent intent = new Intent(MainActivity.this, tabb.class);
                startActivity(intent);
            }

        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
       if (id==R.id.id_head1){
          // toolbar.setTitle(R.string.head1);
           array=getResources().getStringArray(R.array.chapter1);
           arrayAdapter.clear();
           arrayAdapter.addAll(array);
           arrayAdapter.notifyDataSetChanged();
           drawer.closeDrawer(GravityCompat.START);
           categoryIndex=0;
       } else
           if(id==R.id.id_head2){
               array=getResources().getStringArray(R.array.chapter2);
               arrayAdapter.clear();
               arrayAdapter.addAll(array);
               arrayAdapter.notifyDataSetChanged();
               drawer.closeDrawer(GravityCompat.START);
               categoryIndex=1;
           }else
              if(id==R.id.id_head3){
                  array=getResources().getStringArray(R.array.chapter3);
                  arrayAdapter.clear();
                  arrayAdapter.addAll(array);
                  arrayAdapter.notifyDataSetChanged();
                  drawer.closeDrawer(GravityCompat.START);
                  categoryIndex=2;
              }else
                  if(id==R.id.id_head4)
                  {
                      array=getResources().getStringArray(R.array.chapter4);
                      arrayAdapter.clear();
                      arrayAdapter.addAll(array);
                      arrayAdapter.notifyDataSetChanged();
                      drawer.closeDrawer(GravityCompat.START);
                      categoryIndex=3;
                  }else
                  if(id==R.id.id_head5)
                  {
                      array=getResources().getStringArray(R.array.chapter5);
                      arrayAdapter.clear();
                      arrayAdapter.addAll(array);
                      arrayAdapter.notifyDataSetChanged();
                      drawer.closeDrawer(GravityCompat.START);
                      categoryIndex=4;

                  }else
                  if(id==R.id.id_end_title)
                  {
                      array=getResources().getStringArray(R.array.Conclusion);
                      arrayAdapter.clear();
                      arrayAdapter.addAll(array);
                      arrayAdapter.notifyDataSetChanged();
                      drawer.closeDrawer(GravityCompat.START);
                      categoryIndex=5;
                  }else
                  if(id==R.id.id_app_end)
                  {
                      array=getResources().getStringArray(R.array.annex);
                      arrayAdapter.clear();
                      arrayAdapter.addAll(array);
                      arrayAdapter.notifyDataSetChanged();
                      drawer.closeDrawer(GravityCompat.START);
                      categoryIndex=6;
                  }
                drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    //
}
package com.hfad.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.R.id;
import android.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.hfad.myapplication.databinding.ActivityMainBinding;

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
        listView=findViewById(R.id.listview);
        array=getResources().getStringArray(R.array.chapter1);
        arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,new ArrayList<String>(Arrays.asList(array)));
        listView.setAdapter(arrayAdapter);
        setSupportActionBar(binding.appBarMain.toolbar);
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
                  array=getResources().getStringArray(R.array.chapter2);
                  arrayAdapter.clear();
                  arrayAdapter.addAll(array);
                  arrayAdapter.notifyDataSetChanged();
                  drawer.closeDrawer(GravityCompat.START);
              }else
                drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    //
}
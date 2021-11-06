package com.example.newproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

public class HomePage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

      DrawerLayout drawerLayout;
      NavigationView navigationView;
      Toolbar toolbar;
      RecyclerView recyclerView;
      MyAdapter adapter;

   ImageView img1, img2,img3,img4,img5,img6;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recyclerViewId);
        setSupportActionBar(toolbar);


        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);


        img1 = (ImageView) findViewById(R.id.mobilS);
        img2 = (ImageView) findViewById(R.id.carS);
        img3 = (ImageView) findViewById(R.id.arson);
        img4 = (ImageView) findViewById(R.id.assult) ;
        img5 = (ImageView) findViewById(R.id.violenc) ;
        img6 = (ImageView) findViewById(R.id.kidnap) ;

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        img5.setOnClickListener(this);
        img6.setOnClickListener(this);

    }

    @Override
    public void onClick(View view)
    {
        Intent intent;
        switch(view.getId())
        {
            case R.id.mobilS:
                intent = new Intent(HomePage.this,MobileSnatch.class);
                startActivity(intent);
                break;

            case R.id.carS:
                intent = new Intent(HomePage.this,CarSnatch.class);
                startActivity(intent);
                break;

            case R.id.assult:
                intent = new Intent(HomePage.this,Assult.class);
                startActivity(intent);
                break;

            case R.id.violenc:
                intent = new Intent(HomePage.this,FirForm.class);
                startActivity(intent);
                break;

            case R.id.arson:
                intent = new Intent(HomePage.this,Arson.class);
                startActivity(intent);
                break;

            case R.id.kidnap:
                intent = new Intent(HomePage.this,Kidnap.class);
                startActivity(intent);
                break;
        }

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
        super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {

        switch(item.getItemId())
        {
            case R.id.nav_home:
                Intent intent = new Intent(HomePage.this,HomePage.class);
                startActivity(intent);
                break;

            case R.id.nav_other:
                Intent intent1 = new Intent(HomePage.this,OtherCrimes.class);
                startActivity(intent1);
                break;



            case R.id.nav_signout:
                Intent intent2 = new Intent(HomePage.this,MainActivity2.class);
                startActivity(intent2);
                break;

            case R.id.nav_about_us:
                Intent intent3 = new Intent(HomePage.this,Aboutus.class);
                startActivity(intent3);
                break;
            case R.id.nav_feedback:
                Intent intent4 = new Intent(HomePage.this,Aboutus.class);
                startActivity(intent4);
                break;


        }


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        return false;
    }
    
}
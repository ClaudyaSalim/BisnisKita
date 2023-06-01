package com.example.bisniskita;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.bisniskita.adapter.PagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    BottomNavigationView bottomNavbar;
    PagerAdapter pagerAdapter;
    ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavbar = findViewById(R.id.bottomNavbar);
        bottomNavbar.setOnItemSelectedListener(this);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), this.getLifecycle());

        viewPager = findViewById(R.id.vpApp);
        viewPager.setUserInputEnabled(false);
        viewPager.setAdapter(pagerAdapter);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int menuItem = item.getItemId();

        switch (menuItem){
            case R.id.home:
                viewPager.setCurrentItem(0);
                break;
            case R.id.cart:
                viewPager.setCurrentItem(1);
                break;
            case R.id.transaction:
                viewPager.setCurrentItem(2);
                break;
            case R.id.profile:
                viewPager.setCurrentItem(3);
                break;

        }

        return true;
    }
}
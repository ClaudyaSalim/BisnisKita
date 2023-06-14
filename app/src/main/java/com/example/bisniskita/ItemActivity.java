package com.example.bisniskita;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ItemActivity extends AppCompatActivity {

    Button buyNowBtn;
    FloatingActionButton cartBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        Toolbar shopDetailBar = (Toolbar) findViewById(R.id.shop_detail_bar);
        setSupportActionBar(shopDetailBar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("");
        actionBar.setDisplayHomeAsUpEnabled(true);

        buyNowBtn = findViewById(R.id.buy_now_btn);
        cartBtn = findViewById(R.id.cart_btn);

        buyNowBtn.setOnClickListener(e->{
            Intent toConfirm = new Intent(this, ConfirmActivity.class);
            startActivity(toConfirm);
        });


        cartBtn.setOnClickListener(e->{
            Intent toHome = new Intent(this,HomeActivity.class);
            startActivity(toHome);
        });

    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent toHome = new Intent(this, HomeActivity.class);
        startActivityForResult(toHome, 0);
        return true;
    }
}
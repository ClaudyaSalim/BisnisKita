package com.example.bisniskita;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.example.bisniskita.adapter.ItemsAdapter;
import com.example.bisniskita.database.MyItem;
import com.example.bisniskita.model.Item;

import java.util.ArrayList;

public class DetailShopActivity extends AppCompatActivity {

    RecyclerView shopitems;
    ItemsAdapter itemsAdapter;
    RecyclerView itemsRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Item> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_shop);

        String shopName = getIntent().getStringExtra("Shop name");

        Toolbar shopDetailBar = (Toolbar) findViewById(R.id.shop_detail_bar);
        setSupportActionBar(shopDetailBar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("");
        actionBar.setDisplayHomeAsUpEnabled(true);

        TextView title = shopDetailBar.findViewById(R.id.pageText);
        title.setText(shopName);

        itemsRecyclerView = findViewById(R.id.recyclerview);
        itemsRecyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this, 2);
        itemsRecyclerView.setLayoutManager(layoutManager);
        data = new ArrayList<>();
        for(int i = 0; i < MyItem.nama_barang.length; i++){
            String itemName = MyItem.nama_barang[i];
            Log.e("Shop Name", shopName);
            Log.e("Item Name", itemName);
            if(itemName.contains(shopName)){
                data.add(new Item(

                        MyItem.nama_barang[i],
                        MyItem.harga_barang[i],
                        MyItem.gambar[i]

                ));
            }
        }

        itemsAdapter = new ItemsAdapter(this, data);
        itemsRecyclerView.setAdapter(itemsAdapter);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent toHome = new Intent(this, HomeActivity.class);
        startActivityForResult(toHome, 0);
        return true;
    }
}
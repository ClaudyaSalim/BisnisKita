package com.example.bisniskita.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.autofill.AutofillValue;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.bisniskita.HomeActivity;
import com.example.bisniskita.MainActivity;
import com.example.bisniskita.R;
import com.example.bisniskita.adapter.ItemsAdapter;
import com.example.bisniskita.adapter.ShopsAdapter;
import com.example.bisniskita.database.MyShops;
import com.example.bisniskita.model.Item;
import com.example.bisniskita.database.MyItem;
import com.example.bisniskita.model.Shop;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    RecyclerView itemsRecyclerView, shopRecyclerView;
    ItemsAdapter itemsAdapter;
    ShopsAdapter shopsAdapter;
    RecyclerView.LayoutManager layoutManager, horizontalLayout;
    ArrayList<Item> data;
    ArrayList<Shop> dataShops;
    Boolean searched;

    public HomeFragment() {}


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        // parameter
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // parameter
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View homeView = inflater.inflate(R.layout.fragment_home, container, false);

        shopRecyclerView = homeView.findViewById(R.id.shop_rv);
        shopRecyclerView.setHasFixedSize(true);

        itemsRecyclerView =  homeView.findViewById(R.id.recyclerview);
        itemsRecyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(this.getContext(), 2);
        horizontalLayout = new LinearLayoutManager(
                this.getContext(),
                LinearLayoutManager.HORIZONTAL,
                false);
        shopRecyclerView.setLayoutManager(horizontalLayout);
        itemsRecyclerView.setLayoutManager(layoutManager);


        // isi array list
        dataShops = new ArrayList<>();
        for(int i = 0; i < MyShops.nama_toko.length; i++){
            dataShops.add(new Shop(

                MyShops.nama_toko[i],
                MyShops.kategori[i],
                MyShops.gambar[i]

            ));
        }

        // shop adapter
        shopsAdapter = new ShopsAdapter(dataShops, this.getContext());
        shopRecyclerView.setAdapter(shopsAdapter);

        data = new ArrayList<>();
        for(int i=0; i < MyItem.nama_barang.length; i++){
            data.add(new Item(

                    MyItem.nama_barang[i],
                    MyItem.harga_barang[i],
                    MyItem.gambar[i]

            ));
        }

        itemsAdapter = new ItemsAdapter(this.getContext(), data);
        itemsRecyclerView.setAdapter(itemsAdapter);
        searched = false;

        // menu

        // bikin search function
        SearchView searchView = homeView.findViewById(R.id.searchBar);
        search(searchView);

        ImageButton logoutBtn = homeView.findViewById(R.id.logoutIcon);
        logoutBtn.setOnClickListener(e->{
            Intent toLogin = new Intent(this.getContext(), MainActivity.class);
            startActivity(toLogin);
        });

//        ImageButton profileBtn = homeView.findViewById(R.id.profilIcon);
//        profileBtn.setOnClickListener(e->{
//            Intent toProfile = new Intent(this.getContext(), HomeActivity.class);
//        });

        return homeView;
    }


    public void search(SearchView searchView){

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                newText = newText.toLowerCase();
                ArrayList<Item> itemFilter = new ArrayList<>();
                ArrayList<Shop> shopFilter = new ArrayList<>();
                for(Item model:data){
                    String nama = model.getNama().toLowerCase();
                    if (nama.contains(newText)){
                        itemFilter.add(model);
                    }
                }
                for(Shop model:dataShops){
                    String nama = model.getNama().toLowerCase();
                    if (nama.contains(newText)){
                        shopFilter.add(model);
                    }
                }
                itemsAdapter.setFilter(itemFilter);
                shopsAdapter.setFilter(shopFilter);
                return true;
            }

        });

    }
}
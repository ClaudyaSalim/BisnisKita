package com.example.bisniskita.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.bisniskita.ConfirmActivity;
import com.example.bisniskita.HomeActivity;
import com.example.bisniskita.R;
import com.example.bisniskita.adapter.CartAdapter;
import com.example.bisniskita.model.Cart;
import com.example.bisniskita.model.Item;

import java.util.ArrayList;


public class CartFragment extends Fragment {

    Toolbar menuBar;
    RecyclerView cartRecyclerView;
    CartAdapter cartAdapter;
    ArrayList<Cart>dataCart;
    Button buyNowBtn;

    public CartFragment() {
        // Required empty public constructor
    }


    public static CartFragment newInstance(String param1, String param2) {
        CartFragment fragment = new CartFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setHasOptionsMenu(true);
//        ActionBar actionBar = getActivity();
//        actionBar.setDisplayHomeAsUpEnabled(true);
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View cartView = inflater.inflate(R.layout.fragment_cart, container, false);

        // menu bar
        menuBar = cartView.findViewById(R.id.cart_bar);
        TextView title = menuBar.findViewById(R.id.pageText);
        title.setText("Cart");

        // function
        cartRecyclerView = cartView.findViewById(R.id.cart_rv);

        // isi array list
        dataCart = new ArrayList<>();
        dataCart.add(new Cart(
                new Item("Tas Ransel Revyla", 58000, R.drawable.handmadeshoesby),
                "Revyla",
                1,
                58000));
        dataCart.add(new Cart(
                new Item("Wallet Print Star", 12000, R.drawable.handmadeshopesby2),
                "Print Star",
                1,
                12000));

        cartAdapter = new CartAdapter(this.getContext(), dataCart);
        cartRecyclerView.setAdapter(cartAdapter);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        buyNowBtn = cartView.findViewById(R.id.buy_now_btn);
        buyNowBtn.setOnClickListener(e->{
            Intent toConfirm = new Intent(this.getContext(), HomeActivity.class);
            startActivity(toConfirm);
        });

        return cartView;
    }

    // buat masukin file menu


//    @Override
//    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
//        inflater.inflate(R.menu.bottom_navbar, menu);
//    }
//
//    // back arrow
//    public boolean onOptionsItemSelected(MenuItem item){
//        Intent toGames = new Intent(this, HomeFragment.class);
//        startActivityForResult(toGames, 0);
//        return true;
//    }
}
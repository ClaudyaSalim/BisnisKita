package com.example.bisniskita.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.bisniskita.fragment.CartFragment;
import com.example.bisniskita.fragment.HomeFragment;
import com.example.bisniskita.fragment.ProfileFragment;
import com.example.bisniskita.fragment.TransactionFragment;

public class PagerAdapter extends FragmentStateAdapter {

    private Fragment homeFragment, profileFragment, cartFragment, transactionFragment;

    private Fragment[] fragments;

    public PagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        initializeFragment();
    }

    public void initializeFragment(){
        homeFragment = new HomeFragment();
        cartFragment = new CartFragment();
        transactionFragment = new TransactionFragment();
        profileFragment = new ProfileFragment();

        fragments = new Fragment[]{homeFragment, cartFragment, transactionFragment, profileFragment};
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments[position];
    }

    @Override
    public int getItemCount() {
        return fragments.length;
    }
}

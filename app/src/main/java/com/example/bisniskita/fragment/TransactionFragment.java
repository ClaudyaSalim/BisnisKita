package com.example.bisniskita.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.bisniskita.HomeActivity;
import com.example.bisniskita.R;
import com.example.bisniskita.adapter.CartAdapter;
import com.example.bisniskita.adapter.TransactionAdapter;
import com.example.bisniskita.model.Cart;
import com.example.bisniskita.model.Item;
import com.example.bisniskita.model.Transaction;

import java.util.ArrayList;

public class TransactionFragment extends Fragment {

    Toolbar menuBar;
    RecyclerView cartRecyclerView;
    TransactionAdapter transactionAdapter;
    ArrayList<Transaction> dataTransaction;

    public TransactionFragment() {
        // Required empty public constructor
    }


    public static TransactionFragment newInstance(String param1, String param2) {
        TransactionFragment fragment = new TransactionFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View transactionView = inflater.inflate(R.layout.fragment_transaction, container, false);

        // menu bar
        menuBar = transactionView.findViewById(R.id.transaction_bar);
        TextView title = menuBar.findViewById(R.id.pageText);
        title.setText("Transaction");

        // function
        cartRecyclerView = transactionView.findViewById(R.id.transaction_rv);

        // isi array list
        dataTransaction = new ArrayList<>();
        dataTransaction.add(new Transaction(
                new Item("Tas Ransel Revyla", 58000, R.drawable.handmadeshoesby),
                "Revyla",
                3,
                58000*3));

        transactionAdapter = new TransactionAdapter(this.getContext(), dataTransaction);
        cartRecyclerView.setAdapter(transactionAdapter);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return transactionView;
    }
}
package com.example.bisniskita.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bisniskita.R;
import com.example.bisniskita.model.Transaction;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder>{

    Context context;
    ArrayList<Transaction>dataTransaction;

    public TransactionAdapter(Context context, ArrayList<Transaction> dataTransaction) {
        this.context = context;
        this.dataTransaction = dataTransaction;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView namaBarang, namaToko, qtyBarang, hargaFinal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            namaBarang = itemView.findViewById(R.id.nama_barang);
            namaToko = itemView.findViewById(R.id.nama_toko);
            qtyBarang = itemView.findViewById(R.id.qty_order);
            hargaFinal = itemView.findViewById(R.id.harga_final);

        }
    }

    @NonNull
    @Override
    public TransactionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_transaction, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionAdapter.ViewHolder holder, int position) {
        TextView namaBarang = holder.namaBarang;
        TextView namaToko = holder.namaToko;
        TextView qtyBarang = holder.qtyBarang;
        TextView hargaFinal = holder.hargaFinal;

        namaBarang.setText(dataTransaction.get(position).getProduct().getNama());
        namaToko.setText(dataTransaction.get(position).getNamaToko());
        qtyBarang.setText(String.valueOf(dataTransaction.get(position).getQuantity()));
        hargaFinal.setText("Rp" + String.valueOf(dataTransaction.get(position).getFinalPrice()));

    }

    @Override
    public int getItemCount() {
        return dataTransaction.size();
    }
}

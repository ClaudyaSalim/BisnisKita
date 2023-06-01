package com.example.bisniskita.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bisniskita.DetailShopActivity;
import com.example.bisniskita.R;
import com.example.bisniskita.fragment.HomeFragment;
import com.example.bisniskita.model.Item;
import com.example.bisniskita.model.Shop;

import java.util.ArrayList;

public class ShopsAdapter extends RecyclerView.Adapter<ShopsAdapter.ViewHolder> {

    ArrayList<Shop> dataShop;
    Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textnama,textKategori;
        ImageView gambarbarang;
        CardView cardList;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardList = itemView.findViewById(R.id.card_list); // card toko
            textnama = itemView.findViewById(R.id.nama_barang); // nama toko
            textKategori = itemView.findViewById(R.id.harga_barang); // kategori toko
            gambarbarang= itemView.findViewById(R.id.image_barang); // gambar toko

            cardList.setOnClickListener(e->{
                Log.e("Check", textnama.getText().toString());
//                new HomeFragment(textnama.getText().toString());
                Intent toDetailShop = new Intent(context, DetailShopActivity.class);
                toDetailShop.putExtra("Shop name", textnama.getText().toString());
                context.startActivity(toDetailShop);
            });
        }
    }

    public ShopsAdapter(ArrayList<Shop> dataShop, Context context) {
        this.dataShop = dataShop;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextView text_nama = holder.textnama;
        TextView text_harga = holder.textKategori;
        ImageView gambar_barang = holder.gambarbarang;

        text_nama.setText(dataShop.get(position).getNama());
        text_harga.setText(dataShop.get(position).getkategori());
        gambar_barang.setImageResource(dataShop.get(position).getGambar());
    }

    @Override
    public int getItemCount() {
        return dataShop.size();
    }

    public void setFilter(ArrayList<Shop> filterModel) {
        dataShop = new ArrayList<>();
        dataShop.addAll(filterModel);
        notifyDataSetChanged();
    }

}

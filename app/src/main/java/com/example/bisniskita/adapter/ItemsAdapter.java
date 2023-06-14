package com.example.bisniskita.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bisniskita.ItemActivity;
import com.example.bisniskita.R;
import com.example.bisniskita.model.Item;

import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    Context context;
    ArrayList<Item> dataItem;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textnama,textharga;
        ImageView gambarbarang;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textnama = itemView.findViewById(R.id.nama_barang);
            textharga = itemView.findViewById(R.id.harga_barang);
            gambarbarang= itemView.findViewById(R.id.image_barang);

            itemView.setOnClickListener(e->{
                Intent toItem = new Intent(context, ItemActivity.class);
                context.startActivity(toItem);
            });
        }
    }

    public ItemsAdapter(Context context, ArrayList<Item> dataItem) {
        this.context = context;
        this.dataItem = dataItem;
    }

    @NonNull
    @Override
    public ItemsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.ViewHolder holder, int position) {
        TextView text_nama = holder.textnama;
        TextView text_harga = holder.textharga;
        ImageView gambar_barang = holder.gambarbarang;
        int harga = dataItem.get(position).getHarga();

        text_nama.setText(dataItem.get(position).getNama());
        text_harga.setText("Rp" + harga);
        gambar_barang.setImageResource(dataItem.get(position).getGambar());
    }

    @Override
    public int getItemCount() {return dataItem.size();}


    public void setFilter(ArrayList<Item> filterModel) {
        dataItem = new ArrayList<>();
        dataItem.addAll(filterModel);
        notifyDataSetChanged();
    }
}

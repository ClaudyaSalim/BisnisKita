package com.example.bisniskita.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bisniskita.R;
import com.example.bisniskita.model.Cart;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    Context context;
    ArrayList<Cart>dataCart;

    public CartAdapter(Context context, ArrayList<Cart> dataCart) {
        this.context = context;
        this.dataCart = dataCart;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_cart, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextView text_nama = holder.textNama;
        TextView text_toko = holder.textToko;
        TextView text_harga = holder.textHarga;
        ImageView gambar_barang = holder.imageBarang;

        text_nama.setText(dataCart.get(position).getProduct().getNama());
        text_toko.setText(dataCart.get(position).getNamaToko());
        text_harga.setText("Rp" + dataCart.get(position).getProduct().getHarga());
        gambar_barang.setImageResource(dataCart.get(position).getProduct().getGambar());
    }

    @Override
    public int getItemCount() {
        return dataCart.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textNama, textToko, textHarga;
        ImageView imageBarang;
        EditText qtyEt;
        ImageButton minusBtn, plusBtn;
        int newHarga;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textNama = itemView.findViewById(R.id.nama_barang);
            textToko = itemView.findViewById(R.id.nama_toko);
            textHarga = itemView.findViewById(R.id.harga_barang);
            imageBarang = itemView.findViewById(R.id.image_barang);
            qtyEt = itemView.findViewById(R.id.qty_et);
            minusBtn = itemView.findViewById(R.id.minus_btn);
            plusBtn = itemView.findViewById(R.id.plus_btn);

            qtyEt.setText("1");
            Log.e("Quantity", qtyEt.getText().toString());
//            Log.e("Toko", dataCart.get(getAdapterPosition()).getNamaToko());

//            listener(qtyEt, harga);
//            dataCart.get(getAdapterPosition()).getProduct().setHarga();

            qtyEt.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    String qty = s.toString();
                    if(!qty.equals("")){
                        int harga = dataCart.get(getAdapterPosition()).getProduct().getHarga();
//                        int hargaFinal = dataCart.get(getAdapterPosition()).getFinalPrice();
                        int qtyInt = Integer.parseInt(qty);
                        int newHarga = qtyInt*harga;
                        textHarga.setText("Rp" + newHarga);
                        dataCart.get(getAdapterPosition()).setQuantity(qtyInt);
                        dataCart.get(getAdapterPosition()).setFinalPrice(newHarga);
                    }
                }
            });

            minusBtn.setOnClickListener(e->{
                int newQty=0;
                String qty = qtyEt.getText().toString();
                int qtyInt = Integer.parseInt(qty);
                if(qtyInt>0){
                    newQty = qtyInt-1;
                    qtyEt.setText(String.valueOf(newQty));
                }
//                if(qty.equals("0")){
//                    dataCart.remove(getAdapterPosition());
//                }
            });

            plusBtn.setOnClickListener(e->{
                int newQty=0;
                String qty = qtyEt.getText().toString();
                int qtyInt = Integer.parseInt(qty);
                newQty = qtyInt+1;
                qtyEt.setText(String.valueOf(newQty));
//                if(qty.equals("0")){
//                    dataCart.remove(getAdapterPosition());
//                }
            });

        }
    }



}

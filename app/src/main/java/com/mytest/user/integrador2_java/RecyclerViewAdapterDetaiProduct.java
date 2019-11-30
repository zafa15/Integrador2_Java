package com.mytest.user.integrador2_java;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapterDetaiProduct extends RecyclerView.Adapter<RecyclerViewAdapterDetaiProduct.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView address;
        ImageView ubiq;

        public ViewHolder(View itemView) {
            super(itemView);
            address = (TextView)itemView.findViewById(R.id.addres_store);
            ubiq = (ImageView)itemView.findViewById(R.id.ubic_icon);
        }
    }

    public List<DetailProduct> storelista;

    public RecyclerViewAdapterDetaiProduct(List<DetailProduct> storelista){
        this.storelista = storelista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.liststore,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.address.setText(storelista.get(position).getAddres());
        holder.ubiq.setImageResource(storelista.get(position).getImg_icon());
    }

    @Override
    public int getItemCount() {
        return storelista.size();
    }
}

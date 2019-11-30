package com.mytest.user.integrador2_java;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapterFavorites extends RecyclerView.Adapter<RecyclerViewAdapterFavorites.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView brand;
        private TextView name_article;
        private TextView provide;
        private TextView stock;
        ImageView img_url;

        public ViewHolder(View itemView) {
            super(itemView);
            name_article = (TextView)itemView.findViewById(R.id.name_article);
            brand = (TextView)itemView.findViewById(R.id.name_brand);
            provide = (TextView)itemView.findViewById(R.id.name_provider);
            stock = (TextView)itemView.findViewById(R.id.num_stock);
            img_url = (ImageView)itemView.findViewById(R.id.img_url);
        }
    }

    public List<Article> favorites_list;

    public RecyclerViewAdapterFavorites(List<Article> favorites_list){
        this.favorites_list = favorites_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name_article.setText(favorites_list.get(position).getName());
        holder.brand.setText(favorites_list.get(position).getBrand());
        holder.provide.setText(favorites_list.get(position).getName());
        holder.img_url.setImageResource(favorites_list.get(position).getImg_url_final());
    }

    @Override
    public int getItemCount() {
        return favorites_list.size();
    }
}

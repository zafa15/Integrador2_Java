package com.mytest.user.integrador2_java;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DetailProductActivity extends AppCompatActivity {
    private RecyclerView recyclerViewAddres;
    private RecyclerViewAdapterDetaiProduct list_store;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_product_activity);

        recyclerViewAddres = (RecyclerView)findViewById(R.id.recycler_address);
        recyclerViewAddres.setLayoutManager(new LinearLayoutManager(this));

        list_store = new RecyclerViewAdapterDetaiProduct(get_stores());
        recyclerViewAddres.setAdapter(list_store);
    }

    public List<DetailProduct> get_stores(){
        List<DetailProduct> store = new ArrayList<>();
        store.add(new DetailProduct("Av. Miraflores 478",R.drawable.placeholder));
        store.add(new DetailProduct("Av. Jose Larco 743",R.drawable.placeholder));
        store.add(new DetailProduct("Av. Jose Maria Arguedas 743",R.drawable.placeholder));
        return store;
    }
}

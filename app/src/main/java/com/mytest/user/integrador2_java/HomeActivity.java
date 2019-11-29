package com.mytest.user.integrador2_java;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    Spinner spinner_categories;
    String url = "http://localhost/Service/integrador2/public/api/";
    private RequestQueue mQueue;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        spinner_categories = findViewById(R.id.categories);


        mQueue = Volley.newRequestQueue(this);
        getCategories();
    }

    private void getCategories(){
        String categ= "categories";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url + categ, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                ArrayList<Category> catelist = new ArrayList<Category>();
                try {
                    JSONArray jsonArray = response.getJSONArray("categorias");

                    for (int i = 0; i<jsonArray.length();i++){
                        Category c = new Category();
                        //JSONObject employee = jsonArray.getJSONObject(i);
                        c.setName(jsonArray.getJSONObject(i).getString("name"));
                        catelist.add(c);
                    }
                    ArrayAdapter<Category> a = new ArrayAdapter <Category>(HomeActivity.this, android.R.layout.simple_dropdown_item_1line, catelist);
                    spinner_categories.setAdapter(a);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
    }
}

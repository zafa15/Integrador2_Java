package com.mytest.user.integrador2_java;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editname;
    EditText editemail;
    EditText editdocument;
    EditText edittelefono;

    String URL = "http://192.168.83.107/integrador2/public/api/user_register";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editname = findViewById(R.id.name);
        editemail = findViewById(R.id.name);
        editdocument = findViewById(R.id.document);
        edittelefono = findViewById(R.id.telefono);

        findViewById(R.id.btn_register_user).setOnClickListener(this);
    }

    private void userSingUp(){
        String name = editname.getText().toString();
        String email = editemail.getText().toString();
        String document = editdocument.getText().toString();
        String telefono = edittelefono.getText().toString();

        if (name.isEmpty()){
            editname.setError("Nombre es requerido");
            editname.requestFocus();
            return;
        }

        if (email.isEmpty()){
            editemail.setError("El correo es requerido");
            editemail.requestFocus();
            return;
        }


        if (document.isEmpty()){
            editdocument.setError("Número de identidad es requerido");
            editdocument.requestFocus();
            return;
        }

        if (telefono.isEmpty()){
            edittelefono.setError("Su número telefónico es requerido");
            edittelefono.requestFocus();
            return;
        }


        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()){
                    //Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                    //startActivity(intent);
                    Toast.makeText(RegisterActivity.this,"Creación Exitosa, usa tu DNI como contraseña",Toast.LENGTH_SHORT);
                    //finish();
                }else{
                    Toast.makeText(RegisterActivity.this,"El usuario no se pudo conectar",Toast.LENGTH_SHORT);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RegisterActivity.this,error.toString(),Toast.LENGTH_SHORT);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String, String>();
                parametros.put("name",editname.getText().toString());
                parametros.put("email",editemail.getText().toString());
                parametros.put("document",editdocument.getText().toString());
                parametros.put("telefono",edittelefono.getText().toString());
                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_register_user:
                userSingUp();
                break;
        }
    }
}

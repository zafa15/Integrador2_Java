package com.mytest.user.integrador2_java;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editname;
    EditText editemail;
    EditText editdocument;
    EditText edittelefono;

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

        /*Call<ResponseBody> call = RetrofitServer
                .getInstance()
                .getService()
                .registerUser(name,document,email,telefono);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    try {
                        String s = response.body().string();
                        Toast.makeText(RegisterActivity.this,s,Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(RegisterActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });*/
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

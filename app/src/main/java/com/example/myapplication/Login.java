package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.utils.UserUtil;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void loginClick(View v) {
        String inpEmail = ((EditText) findViewById(R.id.inp_email)).getText().toString();
        String inpPassword = ((EditText) findViewById(R.id.inp_password)).getText().toString();
        RequestBody requestBodyEmail =  RequestBody
                .create(
                        MediaType.parse("text/plain"), inpEmail
                );
        RequestBody requestBodyPassword = RequestBody
                .create(
                        MediaType.parse("text/plain"), inpPassword
                );
        (new UserUtil()).getUser().login(requestBodyEmail, requestBodyPassword).enqueue( new Callback<String>(){

            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(Login.this,response.body(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(Login.this,t.getMessage(),Toast.LENGTH_LONG).show();
                Log.d("error :", t.getMessage());

            }
        }   );

    }
}
package com.example.bisniskita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button loginBtn, toRegisterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = findViewById(R.id.loginBtn);
        toRegisterBtn = findViewById(R.id.toRegisterBtn);

        // kalau klik tombol login
        loginBtn.setOnClickListener(e->{
            // intent home
            Intent toHome = new Intent(this, HomeActivity.class);
            startActivity(toHome);
        });

        // kalau klik tombol register here
        toRegisterBtn.setOnClickListener(e->{
            // pindah ke register
            Intent toRegister = new Intent(this, RegisterActivity.class);
            startActivity(toRegister);
        });

    }
}
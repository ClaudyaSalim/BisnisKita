package com.example.bisniskita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {

    Button registerBtn, toLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerBtn = findViewById(R.id.registerBtn);
        toLoginBtn = findViewById(R.id.toLoginBtn);

        // kalau klik tombol register
        registerBtn.setOnClickListener(e->{
            // pindah ke home
            Intent toHome = new Intent(this, HomeActivity.class);
            startActivity(toHome);
        });

        // kalau klik tombol login here
        toLoginBtn.setOnClickListener(e->{
            // pindah ke login
            Intent toLogin = new Intent(this, MainActivity.class);
            startActivity(toLogin);
        });

    }
}
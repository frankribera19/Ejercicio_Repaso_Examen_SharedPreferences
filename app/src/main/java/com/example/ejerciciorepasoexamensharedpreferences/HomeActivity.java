package com.example.ejerciciorepasoexamensharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;


import com.example.ejerciciorepasoexamensharedpreferences.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        sharedPreferences = getSharedPreferences(Constantes.USER, MODE_PRIVATE);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });
    }

    private void logout() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(Constantes.EMAIL);
        editor.remove(Constantes.PASSWORD);
        editor.apply();
        startActivity(new Intent(HomeActivity.this, MainActivity.class));
        finish();
    }
}
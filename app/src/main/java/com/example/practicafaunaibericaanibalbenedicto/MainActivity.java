package com.example.practicafaunaibericaanibalbenedicto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btnCarnivores = findViewById(R.id.btnCarnivores);
        ImageButton btnRaptors = findViewById(R.id.btnRaptors);

        btnCarnivores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Botón de carnívoros presionado");
                startActivity(new Intent(MainActivity.this, CarnivoresActivity.class));
            }
        });

        btnRaptors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Botón de rapaces presionado");
                startActivity(new Intent(MainActivity.this, RaptorsActivity.class));
            }
        });
    }
}
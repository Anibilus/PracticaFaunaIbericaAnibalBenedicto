package com.example.practicafaunaibericaanibalbenedicto;

// AnimalDetailsActivity.java
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AnimalDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_details);
        ImageView imageViewAnimal = findViewById(R.id.imageViewAnimal);
        // Obtener el ID del recurso de texto del intent
        int textFileResourceId = getIntent().getIntExtra("textFileResourceId", 0);
        Log.d("AnimalDetailsActivity", "ID del recurso de texto: " + textFileResourceId);
        // TextView textViewAnimalName = findViewById(R.id.textViewAnimalName); // No se está utilizando
        TextView textViewAnimalInfo = findViewById(R.id.textViewAnimalInfo);
        // Leer el contenido del archivo de texto y mostrarlo en un TextView
        textViewAnimalInfo.setText(readTextFile(textFileResourceId));
    }

    private String readTextFile(int resourceId) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStream inputStream = getResources().openRawResource(resourceId);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("AnimalDetailsActivity", "Error al leer el archivo de texto: " + e.getMessage());
        }
        Log.d("AnimalDetailsActivity", "Contenido del archivo de texto: " + stringBuilder.toString());
        return stringBuilder.toString();
    }
}
package com.example.practicafaunaibericaanibalbenedicto;

// AnimalDetailsActivity.java
import android.content.res.Configuration;
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

        // Verificar la orientación del dispositivo
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Estamos en modo horizontal, usar layout_land
            setContentView(R.layout.activity_animal_details_horizontal);
        } else {
            // Estamos en modo vertical, usar layout
            setContentView(R.layout.activity_animal_details);
        }

        // Recibe los datos del intent
        String animalName = getIntent().getStringExtra("animalName");
        int animalImageResource = getIntent().getIntExtra("animalImage", 0);
        int animalTextFileResource = getIntent().getIntExtra("animalTextFile", 0);

        // Configura la vista con los datos del animal
        ImageView imageViewAnimal = findViewById(R.id.imageViewAnimal);
        TextView textViewAnimalName = findViewById(R.id.textViewAnimalName);
        TextView textViewAnimalInfo = findViewById(R.id.textViewAnimalInfo);

        imageViewAnimal.setImageResource(animalImageResource);
        textViewAnimalName.setText(animalName);

        // Carga el contenido del archivo .txt correspondiente al animal
        try (InputStream inputStream = getResources().openRawResource(animalTextFileResource);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {

            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }

            // Configura el texto del TextView con el contenido del archivo
            String animalInfo = stringBuilder.toString();
            textViewAnimalInfo.setText(animalInfo);

        } catch (IOException e) {
            e.printStackTrace();
            // Manejo de error: el archivo no pudo ser abierto o no existe
            textViewAnimalInfo.setText("Error al cargar la información");
        }
    }
}

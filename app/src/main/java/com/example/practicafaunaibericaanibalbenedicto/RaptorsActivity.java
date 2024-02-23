package com.example.practicafaunaibericaanibalbenedicto;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RaptorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raptors);

        ListView listViewRaptors = findViewById(R.id.listViewRaptors);
        TextView textViewRaptorsTitle = findViewById(R.id.textViewRaptorsTitle);

        // Ejemplo de lista de aves rapaces
        String[] raptorsArray = {"Águila", "Halcón", "Búho", "Cóndor", "Gavilán"};

        // Crear un adaptador para la lista
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, raptorsArray);

        // Asignar el adaptador a la lista
        listViewRaptors.setAdapter(adapter);

        // Configurar el título de la lista
        textViewRaptorsTitle.setText("Aves Rapaces");
    }
}

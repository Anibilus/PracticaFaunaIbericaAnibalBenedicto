package com.example.practicafaunaibericaanibalbenedicto;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import android.widget.ListView;

public class CarnivoresActivity extends AppCompatActivity {

    private ArrayList<Animal> carnivoresList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carnivores);

        carnivoresList = getCarnivoresList();

        AnimalListAdapter adapter = new AnimalListAdapter(this, R.layout.list_item_animal, carnivoresList);

        ListView listViewAnimals = findViewById(R.id.listViewAnimals);
        listViewAnimals.setAdapter(adapter);

        listViewAnimals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Obtener el animal seleccionado
                Animal selectedAnimal = carnivoresList.get(position);
                // Obtener el ID del recurso de texto correspondiente
                int textFileResourceId = selectedAnimal.getTextFileResource();
                Log.d("CarnivoresActivity", "ID del recurso de texto: " + textFileResourceId);
                // Iniciar la actividad AnimalDetailsActivity y pasar el ID del recurso de texto
                Intent intent = new Intent(CarnivoresActivity.this, AnimalDetailsActivity.class);
                intent.putExtra("textFileResourceId", textFileResourceId);
                startActivity(intent);
            }
        });
    }

    private ArrayList<Animal> getCarnivoresList() {
        ArrayList<Animal> carnivores = new ArrayList<>();
        carnivores.add(new Animal("León", R.drawable.leon_image, R.raw.leon));
        carnivores.add(new Animal("Tigre", R.drawable.tigre_image, R.raw.tigre));
        carnivores.add(new Animal("Lobo", R.drawable.lobo_image, R.raw.lobo));
        return carnivores;
    }
}

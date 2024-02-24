package com.example.practicafaunaibericaanibalbenedicto;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class RaptorsActivity extends AppCompatActivity {

    private List<Animal> raptorsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raptors);

        raptorsList = getRaptorsList();

        RecyclerView recyclerViewAnimals = findViewById(R.id.recyclerViewRaptors);
        recyclerViewAnimals.setLayoutManager(new LinearLayoutManager(this));

        AnimalAdapter adapter = new AnimalAdapter(this, raptorsList);
        recyclerViewAnimals.setAdapter(adapter);
    }

    private List<Animal> getRaptorsList() {
        List<Animal> raptors = new ArrayList<>();
        raptors.add(new Animal("Águila Real", R.drawable.aguila_real_image, R.raw.aguila_real));
        raptors.add(new Animal("Cóndor", R.drawable.condor_image, R.raw.condor_info));
        raptors.add(new Animal("Águila Calva", R.drawable.aguila_calva_image, R.raw.aguila_calva_info));
        raptors.add(new Animal("Buitre Negro", R.drawable.buitre_negro_image, R.raw.buitre_negro_info));
        raptors.add(new Animal("Aguilucho", R.drawable.aguilucho_image, R.raw.aguilucho_info));
        raptors.add(new Animal("Animal_inventado"));
        raptors.add(new Animal("Animal_inventado2", R.drawable.animal_inventado2));
        raptors.add(new Animal("periquito"));
        raptors.add(new Animal());

        return raptors;
    }
}
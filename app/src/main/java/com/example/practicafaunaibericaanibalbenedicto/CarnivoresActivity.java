package com.example.practicafaunaibericaanibalbenedicto;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class CarnivoresActivity extends AppCompatActivity {

    private List<Animal> carnivoresList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carnivores);

        carnivoresList = getCarnivoresList();

        RecyclerView recyclerViewAnimals = findViewById(R.id.recyclerViewAnimals);
        recyclerViewAnimals.setLayoutManager(new LinearLayoutManager(this));

        AnimalAdapter adapter = new AnimalAdapter(this, carnivoresList);
        recyclerViewAnimals.setAdapter(adapter);
    }

    private List<Animal> getCarnivoresList() {
        List<Animal> carnivores = new ArrayList<>();
        carnivores.add(new Animal("León", R.drawable.leon_image, R.raw.leon));
        carnivores.add(new Animal("Tigre", R.drawable.tigre_image, R.raw.tigre));
        carnivores.add(new Animal("Lobo", R.drawable.lobo_image, R.raw.lobo));
        carnivores.add(new Animal("Leopardo", R.drawable.leopardo_image, R.raw.leopardo));
        carnivores.add(new Animal("Puma", R.drawable.puma_image, R.raw.puma));
        carnivores.add(new Animal("Jaguar", R.drawable.jaguar_image, R.raw.jaguar));
        carnivores.add(new Animal("Hiena", R.drawable.hiena_image, R.raw.hiena));
        carnivores.add(new Animal("Pantera", R.drawable.pantera_image, R.raw.pantera));
        carnivores.add(new Animal("Lince Ibérico", R.drawable.lince_iberico_image, R.raw.lince_iberico));
        carnivores.add(new Animal("Oso Polar", R.drawable.oso_polar_image, R.raw.oso_polar));
        carnivores.add(new Animal("Coyote", R.drawable.coyote_image, R.raw.coyote));
        carnivores.add(new Animal("Zorro Ártico", R.drawable.zorro_artico_image, R.raw.zorro_artico));
        carnivores.add(new Animal("Halcón Peregrino", R.drawable.halcon_peregrino_image, R.raw.halcon_peregrino));
        carnivores.add(new Animal("León Marino", R.drawable.leon_marino_image, R.raw.leon_marino));
        carnivores.add(new Animal("Cebra"));

        return carnivores;
    }
}



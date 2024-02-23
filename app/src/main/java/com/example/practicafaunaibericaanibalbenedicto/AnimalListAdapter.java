package com.example.practicafaunaibericaanibalbenedicto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class AnimalListAdapter extends ArrayAdapter<Animal> {

    private Context mContext;
    private int mResource;

    public AnimalListAdapter(Context context, int resource, ArrayList<Animal> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtener información sobre el animal en la posición actual
        String name = getItem(position).getName();
        int imageResource = getItem(position).getImageResource();

        // Crear una nueva vista si aún no hay una disponible
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(mResource, parent, false);
        }

        // Obtener referencias a los elementos de la vista
        ImageView imageViewAnimal = convertView.findViewById(R.id.imageButtonAnimal);

        TextView textViewAnimalName = convertView.findViewById(R.id.textViewAnimalName);

        // Establecer los datos del animal en los elementos de la vista
        imageViewAnimal.setImageResource(imageResource);
        textViewAnimalName.setText(name);

        return convertView;
    }
}


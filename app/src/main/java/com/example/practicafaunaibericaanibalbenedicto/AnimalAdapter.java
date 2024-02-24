package com.example.practicafaunaibericaanibalbenedicto;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.ref.WeakReference;
import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {

    private List<Animal> animalList;
    private Context context;

    public AnimalAdapter(Context context, List<Animal> animalList) {
        this.context = context;
        this.animalList = animalList;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_animal, parent, false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        Animal animal = animalList.get(position);

        // Cargar la imagen utilizando Glide
        Glide.with(context)
                .load(animal.getImageResource())
                .apply(new RequestOptions().centerCrop())
                .into(holder.imageView);

        holder.textView.setText(animal.getName());

        // Agregar un OnClickListener para abrir AnimalDetailsActivity
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AnimalDetailsActivity.class);
                intent.putExtra("animalName", animal.getName());
                intent.putExtra("animalImage", animal.getImageResource());
                intent.putExtra("animalTextFile", animal.getTextFileResource());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    public static class AnimalViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewAnimal);
            textView = itemView.findViewById(R.id.textViewAnimalName);
        }
    }

    // Clase para cargar la imagen de manera asíncrona
    private static class LoadImageTask extends AsyncTask<Integer, Void, Bitmap> {
        private WeakReference<ImageView> imageViewReference;

        LoadImageTask(ImageView imageView) {
            imageViewReference = new WeakReference<>(imageView);
        }

        @Override
        protected Bitmap doInBackground(Integer... resourceIds) {
            int resourceId = resourceIds[0];
            return BitmapFactory.decodeResource(imageViewReference.get().getContext().getResources(), resourceId);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (imageViewReference != null && bitmap != null) {
                ImageView imageView = imageViewReference.get();
                imageView.setImageBitmap(bitmap);
            }
        }
    }
}


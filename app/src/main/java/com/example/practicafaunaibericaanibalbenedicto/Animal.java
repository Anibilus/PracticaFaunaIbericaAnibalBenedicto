package com.example.practicafaunaibericaanibalbenedicto;

public class Animal {
    private String name;
    private int imageResource;
    private int textFileResource; // Nuevo atributo para almacenar el recurso de texto

    // Constructor modificado
    public Animal(String name, int imageResource, int textFileResource) {
        this.name = name;
        this.imageResource = imageResource;
        this.textFileResource = (textFileResource != 0) ? textFileResource : R.raw.sindatos;
    }
    public Animal(String name, int imageResource) {
        this.name = name;
        this.imageResource = imageResource;
        this.textFileResource = R.raw.sindatos;
    }
    public Animal(String name) {
        this.name = name;
        this.imageResource = R.drawable.placeholder_image;
        this.textFileResource = R.raw.sindatos;
    }
    public Animal() {
        this.name = "Animal No encontrado";
        this.imageResource = R.drawable.placeholder_image;
        this.textFileResource = R.raw.sindatos;
    }

    public String getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }

    public int getTextFileResource() {
        return textFileResource;
    }

    // Método para obtener el nombre del archivo de texto correspondiente
    public String getTextFileName() {
        // Obtener el nombre del recurso de texto basado en su ID
        return String.valueOf(textFileResource);
    }
}



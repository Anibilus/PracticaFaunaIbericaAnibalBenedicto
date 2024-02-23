package com.example.practicafaunaibericaanibalbenedicto;

public class Animal {
    private String name;
    private int imageResource;
    private int textFileResource; // Nuevo atributo para almacenar el recurso de texto

    public Animal(String name, int imageResource, int textFileResource) {
        this.name = name;
        this.imageResource = imageResource;
        this.textFileResource = textFileResource;
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



package com.example.fruit;

public class Fruit {
    private String name;
    private int imageId;

    public Fruit(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() { return name; }

    public int getImageId() { return imageId; }

    public String toString() { return this.name; }

    public String getInitial() {
        return String.valueOf(this.name.charAt(0));
    }

}

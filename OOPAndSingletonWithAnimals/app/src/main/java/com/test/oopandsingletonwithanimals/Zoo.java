package com.test.oopandsingletonwithanimals;

import java.util.ArrayList;

/**
 * Created by audreyeso on 9/18/16.
 */
public class Zoo {
    //Define the Zoo object
    private static Zoo zoo;

    //Definition of the list to hold the animals
    private static ArrayList<Animal> animals;

    private Zoo(){
        animals = new ArrayList<>();
    }

    public static Zoo getInstance(){
        if(zoo == null)
            zoo = new Zoo();
        return zoo;
    }

    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    public ArrayList<Animal> getAnimals(){
        return animals;
    }
}
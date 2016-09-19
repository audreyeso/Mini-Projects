package com.test.oopandsingletonwithanimals;

/**
 * Created by audreyeso on 9/18/16.
 */
public abstract class Reptile extends Animal {
    boolean hasShell;

    public Reptile(boolean hasLegs, int topSpeed, boolean isEndangered, String name){
        super(topSpeed, isEndangered, name);
        this.hasShell = hasLegs;
    }

    public boolean getHasShell() {
        return hasShell;
    }

    public void setHasShell(boolean hasShell) {
        this.hasShell = hasShell;
    }
}
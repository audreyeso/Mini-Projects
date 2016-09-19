package com.test.oopandsingletonwithanimals;

/**
 * Created by audreyeso on 9/18/16.
 */
public abstract class Mammal extends Animal {
    int mNumLegs;

    public Mammal(int numLegs, int topSpeed, boolean isEndangered, String name){
        super(topSpeed, isEndangered, name);
        this.mNumLegs = numLegs;
    }

    public int getNumLegs() {
        return mNumLegs;
    }

    public void setNumLegs(int numLegs) {
        this.mNumLegs = numLegs;
    }
}
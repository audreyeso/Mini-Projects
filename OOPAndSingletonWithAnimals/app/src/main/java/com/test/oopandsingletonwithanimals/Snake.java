package com.test.oopandsingletonwithanimals;

/**
 * Created by audreyeso on 9/18/16.
 */
public class Snake extends Reptile{
    private boolean mIsPoisonous;

    public Snake(boolean isPoisonous){
        super(false,5,false,"Snake");
        mIsPoisonous = isPoisonous;
    }

    @Override
    public String makeNoise() {
        return "Hiss!!!";
    }

    @Override
    public String toString() {
        return "Snake" + (mIsPoisonous? " (Poisonous)" : "");
    }
}
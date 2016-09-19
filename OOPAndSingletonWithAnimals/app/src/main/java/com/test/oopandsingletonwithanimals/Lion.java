package com.test.oopandsingletonwithanimals;

/**
 * Created by audreyeso on 9/18/16.
 */
public class Lion extends Mammal {
    private boolean mIsAlpha;

    public Lion(boolean isAlpha){
        super(4, 50, false, "Lion");
        mIsAlpha = isAlpha;
    }

    public boolean isAlpha() {
        return mIsAlpha;
    }

    public void setIsAlpha(boolean mIsAlpha) {
        this.mIsAlpha = mIsAlpha;
    }

    @Override
    public String makeNoise() {
        return "Roar!!!";
    }

    @Override
    public String toString() {
        return "Lion" + (mIsAlpha? " (Alpha)" : "");
    }
}
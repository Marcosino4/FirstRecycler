package com.example.firstrecicler;

import android.graphics.drawable.Drawable;

public class ModeloDivisas {
    public String name;
    public float value;
    public Drawable flag;

    public ModeloDivisas(String name, float value, Drawable flag) {
        this.name = name;
        this.value = value;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public float getValue() {
        return value;
    }

    public Drawable getFlag() {
        return flag;
    }
}

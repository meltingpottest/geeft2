package com.gabrieldev.geeftdrawer.model;


import android.content.Context;

/**
 * Created by oldboy on 08/01/16.
 */
public class Geeft {

    public String name;
    public String description;
    public String imageName;


    public int getImageResourceId(Context context)
    {
        try {
            return context.getResources().getIdentifier(this.imageName, "drawable", context.getPackageName());

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}

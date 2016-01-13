package com.gabrieldev.geeftdrawer.model;


import android.content.Context;

/**
 * Created by oldboy on 08/01/16.
 */
public class Geeft {

    private String mName;
    private String mGeefter;
    private String mDescription;
    private String mImageName;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getGeefter() {
        return mGeefter;
    }

    public void setGeefter(String geefter) {
        mGeefter = geefter;
    }


    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getImageName() {
        return mImageName;
    }

    public void setImageName(String imageName) {
        mImageName = imageName;
    }

    public Geeft(String name,String geefter,String description,String imageName){
        mName = name;
        mGeefter = geefter;
        mDescription = description;
        mImageName = imageName;
    }

    public int getImageResourceId(Context context)
    {
        try {
            return context.getResources().getIdentifier(this.mImageName, "drawable", context.getPackageName());

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}

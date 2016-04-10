package com.pandf.r3flex;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by pierre on 10/04/2016.
 */
public class UtilList {


    ArrayList<String> list = new ArrayList<String>();


    Context mContext;

    private String getMatColor(String typeColor)
    {
        String returnColor = "#2C2C2C";
        int arrayId = mContext.getResources().getIdentifier("mdcolor_" + typeColor, "array", mContext.getApplicationContext().getPackageName());

        if (arrayId != 0)
        {
            TypedArray colors = mContext.getResources().obtainTypedArray(arrayId);
            int index = (int) (Math.random() * colors.length());
            returnColor = Integer.toHexString(colors.getColor(index, Color.BLACK));
            colors.recycle();
        }
        Log.d("COLOR", returnColor);
        return "#" + returnColor;
    }

    public CircleModel[] getList(Context context, int nb) {


        mContext = context;
        CircleModel[] circlemodel = new CircleModel[0];


        switch (nb){
            case 1:

                circlemodel = get1itemlist();
                break;
            case 2:
                circlemodel = get2itemlist();
                break;
            case 3:
                circlemodel = get3itemlist();
                break;
            case 4:
                circlemodel = get4itemlist();
                break;
            case 5:
                circlemodel = get5itemlist();
                break;
            case 6:
                circlemodel = get6itemlist();
                break;
            default:
                circlemodel = get3itemlist();
                break;
        }


        return circlemodel;

    }

    private CircleModel[] get1itemlist() {

        list.add("#3498db");
        list.add("#e74c3c");
        list.add("#2ecc71");
        list.add("#e67e22");
        list.add("#1abc9c");
        list.add("#f1c40f");
        Random random = new Random();
        int nb = random.nextInt(6);

        CircleModel circleModels[] = {
                new CircleModel(getMatColor("400")),

        };


        return circleModels;

    }



    private CircleModel[] get2itemlist() {
        CircleModel circleModels[] = {
                new CircleModel(getMatColor("400")),
                new CircleModel(getMatColor("500"))
        };



        return circleModels;

    }

    private CircleModel[] get3itemlist() {
        CircleModel circleModels[] = {
                new CircleModel(getMatColor("500")),
                new CircleModel(getMatColor("400")),
                new CircleModel(getMatColor("600"))
        };



        return circleModels;

    }

    private CircleModel[] get4itemlist() {
        CircleModel circleModels[] = {
                new CircleModel(getMatColor("400")),
                new CircleModel(getMatColor("600")),
                new CircleModel(getMatColor("500")),
                new CircleModel(getMatColor("700"))
        };


        return circleModels;

    }

    private CircleModel[] get5itemlist() {
        CircleModel circleModels[] = {
                new CircleModel(getMatColor("600")),
                new CircleModel(getMatColor("400")),
                new CircleModel(getMatColor("700")),
                new CircleModel(getMatColor("500")),
                new CircleModel(getMatColor("800"))
        };



        return circleModels;

    }

    private CircleModel[] get6itemlist() {
        CircleModel circleModels[] = {
                new CircleModel(getMatColor("400")),
                new CircleModel(getMatColor("700")),
                new CircleModel(getMatColor("500")),
                new CircleModel(getMatColor("800")),
                new CircleModel(getMatColor("600")),
                new CircleModel(getMatColor("900"))
        };



        return circleModels;

    }


}

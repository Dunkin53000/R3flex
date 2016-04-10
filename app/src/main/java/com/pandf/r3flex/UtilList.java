package com.pandf.r3flex;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Created by pierre on 10/04/2016.
 */
public class UtilList {


    ArrayList<String> list = new ArrayList<String>();


    Context mContext;



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

        list.add("#1abc9c");
        list.add("#2ecc71");
        list.add("#3498db");
        list.add("#34495e");
        list.add("#f1c40f");
        list.add("#e67e22");
        list.add("#e74c3c");
        Random random = new Random();
        int nb = random.nextInt(6);

        CircleModel circleModels[] = {
                new CircleModel(list.get(nb)),

        };


        return circleModels;

    }



    private CircleModel[] get2itemlist() {
        CircleModel circleModels[] = {
                new CircleModel("#3498db"),
                new CircleModel("#e74c3c")
        };

        Collections.shuffle(Arrays.asList(circleModels));


        return circleModels;

    }

    private CircleModel[] get3itemlist() {
        CircleModel circleModels[] = {
                new CircleModel("#3498db"),
                new CircleModel("#2ecc71"),
                new CircleModel("#e74c3c")
        };

        Collections.shuffle(Arrays.asList(circleModels));


        return circleModels;

    }

    private CircleModel[] get4itemlist() {

        CircleModel circleModels[] = {
                new CircleModel("#3498db"),
                new CircleModel("#f1c40f"),
                new CircleModel("#e74c3c"),
                new CircleModel("#2ecc71")

        };

        Collections.shuffle(Arrays.asList(circleModels));


        return circleModels;

    }

    private CircleModel[] get5itemlist() {
        CircleModel circleModels[] = {
                new CircleModel("#f1c40f"),
                new CircleModel("#2ecc71"),
                new CircleModel("#3498db"),
                new CircleModel("#34495e"),
                new CircleModel("#e74c3c")
        };

        Collections.shuffle(Arrays.asList(circleModels));


        return circleModels;

    }

    private CircleModel[] get6itemlist() {
        CircleModel circleModels[] = {
                new CircleModel("#34495e"),
                new CircleModel("#f1c40f"),
                new CircleModel("#9b59b6"),
                new CircleModel("#2ecc71"),
                new CircleModel("#3498db"),
                new CircleModel("#e74c3c")
        };

        Collections.shuffle(Arrays.asList(circleModels));


        return circleModels;

    }


}

package com.pandf.r3flex;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by pierre on 10/04/2016.
 */
public class UtilList {


    ArrayList<String> list = new ArrayList<String>();


    public CircleModel[] getList(int nb) {


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
                new CircleModel(list.get(nb - 1)),
        };

        return circleModels;

    }

    private CircleModel[] get2itemlist() {
        CircleModel circleModels[] = {
                new CircleModel("#3498db"),
                new CircleModel("#e74c3c")
        };

        return circleModels;

    }

    private CircleModel[] get3itemlist() {
        CircleModel circleModels[] = {
                new CircleModel("#e67e22"),
                new CircleModel("#1abc9c"),
                new CircleModel("#f1c40f")
        };

        return circleModels;

    }

    private CircleModel[] get4itemlist() {
        CircleModel circleModels[] = {
                new CircleModel("#3498db"),
                new CircleModel("#2ecc71"),
                new CircleModel("#e67e22"),
                new CircleModel("#e74c3c")
        };

        return circleModels;

    }

    private CircleModel[] get5itemlist() {
        CircleModel circleModels[] = {
                new CircleModel("#e74c3c"),
                new CircleModel("#2ecc71"),
                new CircleModel("#e67e22"),
                new CircleModel("#1abc9c"),
                new CircleModel("#f1c40f")
        };

        return circleModels;

    }

    private CircleModel[] get6itemlist() {
        CircleModel circleModels[] = {
                new CircleModel("#3498db"),
                new CircleModel("#e74c3c"),
                new CircleModel("#2ecc71"),
                new CircleModel("#e67e22"),
                new CircleModel("#1abc9c"),
                new CircleModel("#f1c40f")
        };

        return circleModels;

    }


}

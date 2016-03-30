package com.example.patbak.csc413project3;

import android.content.Context;


/**
 * Created by patbak on 3/25/2016.
 */
public class ShapeFactory {

    public Shape getShape(Context context, String shape){
        if(shape == null){
            return null;
        }
        switch(shape){
            case "RECTANGLE":
                return new Rectangle(context);
            case "CIRCLE":
                return new Circle(context);
        }
        return null;
    }
}

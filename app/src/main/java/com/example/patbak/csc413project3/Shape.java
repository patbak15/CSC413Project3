package com.example.patbak.csc413project3;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by patbak on 3/17/2016.
 */
public abstract class Shape extends View {


    public Shape(Context context) {
        super(context); // required parameters
    }

    void setShapeAlpha(float alpha) {
        // sets the transparency of the shape
        // float betwenn 0.0 and 1.0f
        this.setAlpha(alpha); // might have to edit
    }

    void removeShape() {
        // makes the shape disappear from the view by
        // setting visability to 0.
        setShapeAlpha(0); // sets it to 0.

    }


    abstract String getShapeType(); // child class to implement

    @Override
    public abstract void onDraw(Canvas canvas);
}

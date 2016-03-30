package com.example.patbak.csc413project3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.Random;

/**
 * Created by patbak on 3/21/2016.
 */
public class Circle extends Shape {

    public Circle(Context context){
        // default constructor
        super(context);
    }

    @Override
    public void onDraw(Canvas canvas){
        Random rand = new Random();
        // circle (x, y, radius, paint)
        float xStart = rand.nextInt(canvas.getWidth());
        float yStart = rand.nextInt(canvas.getHeight());
        float radius = rand.nextInt(canvas.getWidth()/4); // quarter of the size
        Paint cirPaint = new Paint();
        cirPaint.setStyle(Paint.Style.FILL);
        cirPaint.setARGB(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        canvas.drawCircle(xStart, yStart, radius, cirPaint);

    }

    @Override
    public String getShapeType(){
        return "CIRCLE";
    }

}

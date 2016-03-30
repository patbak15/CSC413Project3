package com.example.patbak.csc413project3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;


import java.util.Random;

/**
 * Created by patbak on 3/17/2016.
 */
public class Rectangle extends Shape {

    public Rectangle(Context context){
      super(context);
    }

    @Override
    public void onDraw(Canvas canvas){
        // might not need super call?
        //super.onDraw(canvas);
        int width, length;
        // make random amounts for rectangle
        Random rand = new Random();
        // start point of rectangle
        int xStart = rand.nextInt(canvas.getWidth());
        int yStart = rand.nextInt(canvas.getHeight());
        // make rectangles with from 0 to 1/4 of the canvas
        width = rand.nextInt(canvas.getWidth()/4);
        length = rand.nextInt(canvas.getHeight()/4);
        // create rectangle (int left, int top, int right, int bottom)
        Rect rect = new Rect(xStart, yStart, xStart+width, yStart+length);
        // need Paint for Rect, random colors
        Paint recPaint = new Paint();
        // setColor(alpha, red, green, blue);
        recPaint.setARGB(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        canvas.drawRect(rect, recPaint); // draws to canvas

    }
    @Override
    public String getShapeType(){
        return "RECTANGLE";
    }
}

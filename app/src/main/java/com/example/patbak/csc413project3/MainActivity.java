package com.example.patbak.csc413project3;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    // create a vector of Shapes
    Vector <Shape> shapeVector = new Vector<Shape>();
    ShapeFactory shapeFactory = new ShapeFactory();
    int shapeCount;
    int numRect=0;
    int numCirc=0;
    // mainText to Update Shape Count
    TextView mainText;
    RelativeLayout drawSpace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // remove action bar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
            actionBar.hide();
        mainText = (TextView)findViewById(R.id.textView);
        drawSpace = (RelativeLayout)findViewById(R.id.drawSpace);

        // FIXME: 3/27/2016 onClick needs to be implemented 
        // need 3 buttons for RECT, CIRCL, and CLR
        Button cirButton = (Button) findViewById(R.id.circleButton);
        cirButton.setOnClickListener(new View.OnClickListener(){
            @Override
        public void onClick(View view){
                // create and draw Circle  here, add circle to Vector
                adjustShapeAlpha();
                Shape s = shapeFactory.getShape(view.getContext(), "CIRCLE");
                s.setShapeAlpha(1);
                shapeVector.addElement(s);
                updateShapeCount();
                drawSpace.addView(s);
            }
        });
        Button recButton = (Button)findViewById(R.id.rectButton);
        recButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // draw Rect
                adjustShapeAlpha();
                Shape s=shapeFactory.getShape(view.getContext(), "RECTANGLE");
                s.setShapeAlpha(1); // start at 1.0f
                shapeVector.addElement(s);
                updateShapeCount();
                drawSpace.addView(s);

            }
        });
        Button clrButton = (Button)findViewById(R.id.clearbutton);
        clrButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                shapeVector.clear();
                drawSpace.removeAllViews();
                updateShapeCount();
            }
        });
        clrButton.setOnLongClickListener(new View.OnLongClickListener(){

            @Override
            public boolean onLongClick(View view){
                System.exit(0); // exit app if long press
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    // adjust shape alpha needs work 
    // FIXME: 3/27/2016 CHANGE DEPENDENCY OF ALPHA
    //
   public void adjustShapeAlpha(){
           for (int i = 0; i < shapeVector.size(); i++) {
               double nAlpha = 1.0 - ((shapeCount-i)*.1);
               Shape tShape = shapeVector.get(i);
               if(nAlpha > 0) {
                   tShape.setShapeAlpha((float) nAlpha);
                   shapeVector.set(i, tShape); // replace w/ new alpha
               }else{
                   tShape.removeShape();
                   shapeVector.remove(i); // if alpha is below 0 remove
                   updateShapeCount();
               }
           }

    }
    public void updateShapeCount(){
        shapeCount =0;
        numCirc =0;
        numRect =0;
        // reset all values

        for(int i=0; i < shapeVector.size();i++){
            if(shapeVector.get(i).getShapeType() == "CIRCLE"){
                numCirc++;
                shapeCount++;
            }
            if(shapeVector.get(i).getShapeType() == "RECTANGLE"){
                numRect++;
                shapeCount++;
            }
        }
        String status = "Rectangles: " + numRect + " Circles: " + numCirc;
        mainText.setText(status);
    }
}

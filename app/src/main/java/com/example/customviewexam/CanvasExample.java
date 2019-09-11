package com.example.customviewexam;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.view.View;

import androidx.annotation.RequiresApi;

import java.util.Random;
public class CanvasExample extends View {
    Random r = new Random();


    public CanvasExample(Context context) {
        super(context);
    }
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        Paint circlePaint = new Paint();
        Paint rectPaint = new Paint();
        rectPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        rectPaint.setColor(Color.rgb(128, 0, 128));

        Rect rect = new Rect();
        rect.bottom = 200;
        rect.right = 10;
        rect.left = 200;
        rect.top = 10;

        Paint pText = new Paint();

        try {
            int circleColor = Color.rgb(r.nextInt(255), r.nextInt(255), r.nextInt(255));
            circlePaint.setColor(circleColor);

            float x = (float) r.nextInt(getWidth());
            float y = (float) r.nextInt(getHeight());
            float radius = r.nextInt(200);
            if (x <=0)
                x=1;
            if(y<=0)
                y=1;
            if (x >= getWidth())
                x=-1;
            if (y >= getHeight())
                y=-1;

            canvas.drawCircle(x, y, radius, circlePaint);
            canvas.drawRect(rect, rectPaint);

            float rx = rect.width();
            float ry = rect.height();
            float dis = (float) Math.sqrt((float) (Math.pow((rx-x),2)+Math.pow((ry-y),2)));

            pText.setTextSize(90);

            pText.setColor(Color.RED);
            Typeface tf = Typeface.create(Typeface.SANS_SERIF, 30, true);

            pText.setTypeface(tf);



            canvas.drawText(Float.toString(dis), getWidth()/2, getHeight()/2,pText);
            if (dis <=0) {
                rectPaint.setColor(Color.CYAN);
            }
            Thread.sleep(100);


        } catch (InterruptedException e){
            try {
                throw e;
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }

        invalidate();

    }
}


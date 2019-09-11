package com.example.customviewexam;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import java.util.Random;
public class CanvasExample extends View {
    Random r = new Random();
    public CanvasExample(Context context) {
        super(context);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint circlePaint = new Paint();
        try {
            int circlecolor = Color.rgb(r.nextInt(255), r.nextInt(255), r.nextInt(255));
            circlePaint.setColor(circlecolor);
            float x = (float) r.nextInt(getWidth());
            float y = (float) r.nextInt(getHeight());
            canvas.drawCircle(x, y, 150, circlePaint);
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


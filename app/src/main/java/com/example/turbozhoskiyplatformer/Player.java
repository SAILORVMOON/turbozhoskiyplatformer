package com.example.turbozhoskiyplatformer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;
import java.util.List;

public class Player extends Actor{

    List<Rect> frames = new ArrayList<>();
    Paint paint = new Paint();
    int currentFrame = 0;
    private int timeForCurrentFrame = 0;
    private int frameTime = 40;

    public Player(float x, float y, Bitmap bitmap, int countFrame) {
        super(x, y, bitmap);
        width = bitmap.getWidth() / countFrame;
        for (int i = 0; i < countFrame; i++) {
            frames.add(new Rect(i * width, 0, i*width+width, height));
        }
    }

    @Override
    public boolean onBound() {

        return false;
    }

    @Override
    public void onDraw(Canvas canvas) {
        Rect position = new Rect((int)x, (int)y, (int)x+width, (int)y+height);
        canvas.drawBitmap(bitmap, frames.get(currentFrame), position, paint);
    }

    @Override
    public void update(int ms) {
        timeForCurrentFrame += ms;
        if(timeForCurrentFrame >= frameTime){
            currentFrame = (currentFrame + 1) % frames.size();
            timeForCurrentFrame -= frameTime;
        }
    }
}

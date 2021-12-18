package com.example.turbozhoskiyplatformer;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public abstract class Actor {

    float x, y, velX, velY;
    int width, height;
    Bitmap bitmap;

    public Actor (float x, float y, Bitmap bitmap){
        this.x = x;
        this.y = y;
        this.bitmap = bitmap;
        width = bitmap.getWidth();
        height = bitmap.getHeight();
    }

    public abstract boolean onBound();
    public abstract void onDraw(Canvas canvas);
    public abstract void update(int ms);
}

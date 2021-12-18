package com.example.turbozhoskiyplatformer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class Game extends SurfaceView implements SurfaceHolder.Callback {

    SurfaceHolder surfaceHolder;
    Player player;
    Bitmap bitmapPlayer;

    public Game(Context context) {
        super(context);
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        bitmapPlayer = BitmapFactory.decodeResource(getResources(), R.drawable.player_run);
        player = new Player(10, 10, bitmapPlayer, 6);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        GameThread gameThread = new GameThread();
        gameThread.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }
    class GameThread extends Thread{
        @SuppressLint("ResourceAsColor")
        @Override
        public void run() {
            while(true){
                Canvas canvas = surfaceHolder.lockCanvas();
                canvas.drawColor(Color.BLUE);
                player.update(10);
                player.onDraw(canvas);
                surfaceHolder.unlockCanvasAndPost(canvas);
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

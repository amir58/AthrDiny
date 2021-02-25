package com.amirmohammed.athrdiny;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.LinkedList;
import java.util.Queue;

public class PaintView extends View {

    private Bitmap bitmap;
    public static int image;
    public static int color = Color.RED;

    public PaintView(Context context) {
        super(context);
    }

    public PaintView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

//    @Override
//    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        super.onSizeChanged(w, h, oldw, oldh);
//
//        Bitmap srcBitmap = BitmapFactory.decodeResource(getResources(), image);
//
//        bitmap = Bitmap.createScaledBitmap(srcBitmap, w, h, false);
//
//    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if (bitmap == null) {
            Bitmap srcBitmap = BitmapFactory.decodeResource(getResources(), image);
            bitmap = Bitmap.createScaledBitmap(srcBitmap, w, h, false);

            for (int i = 0; i < bitmap.getWidth(); i++) {
                for (int j = 0; j < bitmap.getHeight(); j++) {
                    int alpha = 255 - brightness(bitmap.getPixel(i, j));

                    if (alpha < 200) {
                        bitmap.setPixel(i,j,Color.WHITE);
                    } else {
                        bitmap.setPixel(i, j, Color.BLACK);
                    }
                }
            }
        }

    }

    private int brightness(int color) {
        return (color >> 16) & 0xff;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, 0, 0, null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        paint((int) event.getX(), (int) event.getY());
        return true;
    }

    private void paint(int x, int y) {
        int targetColor = bitmap.getPixel(x, y);

        if (targetColor != Color.BLACK) {
            floodFill(bitmap, new Point(x, y), targetColor, color);
            invalidate();
        }

    }



//    private void paint(int x, int y) {
//        int targetColor = bitmap.getPixel(x, y);
//
//        floodFill(bitmap, new Point(x, y), targetColor, color);
//        invalidate();
//    }

    public static void floodFill(Bitmap bitmap, Point point, int targetColor, int newColor) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        if (targetColor != newColor) {
            Queue<Point> points = new LinkedList<>();

            do {
                int x = point.x;
                int y = point.y;

                while (x > 0 && bitmap.getPixel(x - 1, y) == targetColor) {
                    x--;
                }

                boolean snapUp = false;
                boolean snapDown = false;

                while (x < width && bitmap.getPixel(x, y) == targetColor) {
                    bitmap.setPixel(x, y, newColor);

                    if (!snapUp && y > 0 && bitmap.getPixel(x, y - 1) == targetColor) {
                        points.add(new Point(x, y - 1));
                        snapUp = true;

                    } else if (snapUp && y > 0 && bitmap.getPixel(x, y - 1) != targetColor) {
                        snapUp = false;

                    }

                    if (!snapDown && y < height - 1 && bitmap.getPixel(x, y + 1) == targetColor) {
                        points.add(new Point(x, y + 1));
                        snapDown = true;

                    } else if (snapDown && y < height - 1 && bitmap.getPixel(x, y + 1) != targetColor) {
                        snapDown = false;
                    }

                    x++;

                }

            } while ((point = points.poll()) != null);
        }
    }

}

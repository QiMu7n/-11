package com.example.afalse.androidmonthdemo.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.example.afalse.androidmonthdemo.R;

public class ImageActivity extends AppCompatImageView {
    private Paint paint;
    ImageView imageView;
    public ImageActivity(Context context) {
        super(context);
    }

    public ImageActivity(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public ImageActivity(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(getWidth()/2,getHeight()/2,225,paint);


    }
}

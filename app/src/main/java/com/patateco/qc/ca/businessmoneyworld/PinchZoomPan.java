package com.patateco.qc.ca.businessmoneyworld;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

/**
 * Created by Adrian on 2018-03-27.
 */

public class PinchZoomPan extends View {

    private int mImageWidth;
    private int getmImageHeight;

    private float mPositionX;
    private float mPositionY;
    private float mLastTouchX;
    private float mLastTouchY;

    private static final int INVALID_POINTER_ID = -1;
    private int mActivePointerID = INVALID_POINTER_ID;

private ScaleGestureDetector mScaleDetector;
private float mScaleFactor = 1.0f;
private final static float mMinZoom = 0.5f;
private final static float mMaxZoom = 5.0f;

    public PinchZoomPan(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mScaleDetector = new ScaleGestureDetector(context,new ScaleListener());

    }
public boolean onTouchEvent (MotionEvent event){

   mScaleDetector.onTouchEvent(event);

   final int action = event.getAction();

   switch (action & MotionEvent.ACTION_MASK){
       case MotionEvent.ACTION_DOWN: {

    //coordonees ou on touche l'ecran
    final float x = event.getX();
    final float y = event.getY();

    //garder en memoire ou on a toucher
    mLastTouchX = x;
    mLastTouchY = y;

//save le ID du pointeur
    mActivePointerID = event.getPointerId(0);
break;

}
       case MotionEvent.ACTION_MOVE:{
           //trouver l'index du pointeur actif et trouver sa position
           final int pointerIndex = event.findPointerIndex(mActivePointerID);
           final float x = event.getX(pointerIndex);
           final float y = event.getY(pointerIndex);

           if (!mScaleDetector.isInProgress()) {
               //calculer la distance dans les x et y
               final float distanceX = x - mLastTouchX;
               final float distanceY = y - mLastTouchY;

               mPositionX += distanceX;
               mLastTouchY += distanceY;
           }
           //garder en memoire la derniere pos pour le prochain move
           mLastTouchX = x;
           mLastTouchY = y;

           invalidate();

       }
   }
}

protected void onDraw (Canvas canvas){
    super.onDraw(canvas);

    if (mBitmap != null){
        canvas.save();
        canvas.scale(mScaleFactor, mScaleFactor);
        canvas.drawBitmap(mBitmap, 0, 0, null);
canvas.restore();
    }
}
    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {

            mScaleFactor += scaleGestureDetector.getScaleFactor();
            mScaleFactor = Math.max(mMinZoom,Math.min(mScaleFactor,mMaxZoom));
            invalidate();
            return true;
        }
    }
}

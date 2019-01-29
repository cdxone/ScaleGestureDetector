package com.cdx.example.scalegesturedetector.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Toast;

public class MyView extends View {

    private Context mContext;
    private ScaleGestureDetector mScaleGestureDetector;

    public MyView(Context context) {
        super(context);
        init(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        MyOnScaleGestureListener myOnScaleGestureListener = new MyOnScaleGestureListener();
        mScaleGestureDetector = new ScaleGestureDetector(mContext,myOnScaleGestureListener);
    }

    class MyOnScaleGestureListener implements ScaleGestureDetector.OnScaleGestureListener{

        private final String TAG = MyOnScaleGestureListener.class.getSimpleName();

        //缩放中执行。
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            Log.e(TAG,"onScale:" + detector.getScaleFactor());
            if (detector.getScaleFactor() < 2){
                return false;
            }
            Toast.makeText(mContext, "==========缩放==========", Toast.LENGTH_SHORT).show();
            return true;
        }

        //缩放开始执行
        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            Log.e(TAG,"onScaleBegin");
            return true;
        }

        //缩放结束就执行
        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {
            Log.e(TAG,"onScaleEnd");
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //首先获取到event事件，然后将事件传递给ScaleGestreDetector
        mScaleGestureDetector.onTouchEvent(event);
        //返回true,
        return true;
    }
}

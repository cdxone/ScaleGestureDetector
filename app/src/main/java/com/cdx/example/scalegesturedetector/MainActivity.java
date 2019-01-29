package com.cdx.example.scalegesturedetector;

import android.view.View;

import com.cdx.example.scalegesturedetector.activity.Test1Activity;

import java.util.ArrayList;

import apis.amapv2.com.listviewlibrary.activity.BaseListActivty;
import apis.amapv2.com.listviewlibrary.bean.ItemObject;

public class MainActivity extends BaseListActivty {


    @Override
    protected void initData() {
        //显示标题
        mTvTitle.setVisibility(View.VISIBLE);
        mTvTitle.setText("ScaleGestureDetector的例子");

        ArrayList<ItemObject> data = new ArrayList<>();
        data.add(new ItemObject("ScaleGestureDetector实现缩放",Test1Activity.class));

        mMyListView.setData(data);
    }
}

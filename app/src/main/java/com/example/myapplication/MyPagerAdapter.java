package com.example.myapplication;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by 灰尘 on 2016/10/1.
 */
public class MyPagerAdapter extends PagerAdapter{

    private ArrayList<View> viewList;
    private ArrayList<String>titleList;

    public MyPagerAdapter(ArrayList<View>viewList,ArrayList<String>titleList){

        this.viewList=viewList;
        this.titleList=titleList;

    }

    //实例化一个页卡
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return viewList.get(position);
    }

    //销毁一个页卡
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
    }

    //页卡的数量
    @Override
    public int getCount() {
        return viewList.size();
    }

    //View是否来自于对象
    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view==object;
    }

    public CharSequence getPageTitle(int position){
        return titleList.get(position);
    }




}

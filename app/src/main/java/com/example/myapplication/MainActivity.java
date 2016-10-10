package com.example.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity implements ViewPager.OnPageChangeListener{

    private TabLayout tabLayout;    //标题布局
    private ViewPager viewPager;        //
    private LayoutInflater inflater;

    private View view1,view2,view3;     //页卡视图
    private ArrayList<View> viewList;        //装载页卡视图的集合
    private ArrayList<String>titleList;      //装载页卡标题的集合

    private ImageView imView;
    private TextView teView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化，将布局文件转化为View对象，且作为数据源
        viewList=new ArrayList<>();
        titleList=new ArrayList<>();
        viewPager= (ViewPager) findViewById(R.id.mViewPager);



        inflater=LayoutInflater.from(this);             //将view转换成一个布局文件
        view1=inflater.inflate(R.layout.activity_main,null);
        view2=inflater.inflate(R.layout.activity_main,null);
        view3=inflater.inflate(R.layout.activity_main,null);

        //添加页卡视图
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);

        //添加页卡标题
        titleList.add("花卉");
        titleList.add("盆栽");
        titleList.add("商店");


        tabLayout= (TabLayout) findViewById(R.id.mTabLayout);

        tabLayout.setTabMode(TabLayout.MODE_FIXED);       //设置Tab模式
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(2)));






    //适配器
        MyPagerAdapter adapter=new MyPagerAdapter(viewList,titleList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);//将TabLayout和ViewPager关联起来。
        tabLayout.setTabsFromPagerAdapter(adapter);//给Tabs设置适配器





    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 0:
                Toast.makeText(MainActivity.this, "我是", Toast.LENGTH_SHORT).show();
            break;
            case 1:
                Toast.makeText(MainActivity.this,"我是",Toast.LENGTH_LONG).show();
                break;
            case 2:
                Toast.makeText(this,"我是",Toast.LENGTH_LONG).show();
                break;
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

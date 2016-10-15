package com.example.myapplication;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import myapplication2.MainActivity2;

public class MainActivity extends Activity implements ViewPager.OnPageChangeListener ,AdapterView.OnItemClickListener{

    private TabLayout tabLayout;    //标题布局
    private ViewPager viewPager;        //
    private LayoutInflater inflater;

    private View view1,view2,view3;     //页卡视图
    private ArrayList<View> viewList;        //装载页卡视图的集合
    private ArrayList<String>titleList;      //装载页卡标题的集合

    private GridView gridView;
    private List<Map<String,Object>> dataList;      //数据源装载器
    private int[]image={R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,
                            R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,};
    private String[] imageName={"彩叶草","红星","兰花","三角梅","文竹","小金桔","朱蕉"};
    private SimpleAdapter simpleAdapter;        //view2的数据适配器

    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化，将布局文件转化为View对象，且作为数据源
        viewList=new ArrayList<>();
        titleList=new ArrayList<>();
        viewPager= (ViewPager) findViewById(R.id.mViewPager);
        //各个页卡视图的实例化
        dataList=new ArrayList<Map<String,Object>>();





        inflater=LayoutInflater.from(this);             //将view转换成一个布局文件
        view1=inflater.inflate(R.layout.view1,null);
        view2=inflater.inflate(R.layout.view2,null);
        view3=inflater.inflate(R.layout.view3,null);

        //添加页卡视图
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);

        //添加页卡标题
        titleList.add("盆栽");
        titleList.add("花卉");
        titleList.add("商店");


        tabLayout= (TabLayout) findViewById(R.id.mTabLayout);

        tabLayout.setTabMode(TabLayout.MODE_FIXED);       //设置Tab模式
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(2)));

        button= (Button) view3.findViewById(R.id.mButton1);  //在不同布局文件下的按钮实例化要是在改布局文件下的，所以要加上view3



        //适配器
        MyPagerAdapter adapter=new MyPagerAdapter(viewList,titleList);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(this);   //设置监听器
        tabLayout.setupWithViewPager(viewPager);//将TabLayout和ViewPager关联起来。
        tabLayout.setTabsFromPagerAdapter(adapter);//给Tabs设置适配器
        //页卡视图的各个内容
        //第二页卡适配器
        init();                                     //初始化适配器
        getData();                                  //获取数据源的方法
        gridView.setAdapter(simpleAdapter);





        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });


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
    //初始化会适配器方法
    private void init() {
        simpleAdapter=new SimpleAdapter(this,getData(),R.layout.item_view2_layout,
                        new String[]{"image","imageName"},new int[]{R.id.mImageView2,R.id.mTextView2});

    }
    private List<Map<String, Object>> getData() {
        gridView= (GridView) view2.findViewById(R.id.mGridView);
        for (int i = 0; i < image.length; i++) {
            Map<String,Object>map=new HashMap<String,Object>();
            map.put("image",image[i]);
            map.put("imageName",imageName[i]);
            dataList.add(map);
        }
        return dataList;
    }


    //点击事件的方法
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(this,"点击的是"+imageName[position],Toast.LENGTH_SHORT).show();

    }
}

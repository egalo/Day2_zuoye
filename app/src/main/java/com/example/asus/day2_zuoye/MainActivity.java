package com.example.asus.day2_zuoye;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tab)
    TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new MainFragment());
        list.add(new CollectFragment());
        ArrayList<String> tit = new ArrayList<>();
        tit.add("我的");
        tit.add("收藏");
        Pager pager = new Pager(getSupportFragmentManager(), list, tit);
        vp.setAdapter(pager);
        tab.setupWithViewPager(vp);
    }
}

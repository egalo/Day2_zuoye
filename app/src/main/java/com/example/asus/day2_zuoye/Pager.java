package com.example.asus.day2_zuoye;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class Pager extends FragmentPagerAdapter {
    private ArrayList<Fragment> list;
    private ArrayList<String> tit;

    public Pager(FragmentManager fm, ArrayList<Fragment> list, ArrayList<String> tit) {
        super(fm);
        this.list = list;
        this.tit = tit;
    }

    public Pager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tit.get(position);
    }
}

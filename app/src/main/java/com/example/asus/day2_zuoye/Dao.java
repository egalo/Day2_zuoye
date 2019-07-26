package com.example.asus.day2_zuoye;

import android.app.Application;
import android.content.Context;

public class Dao extends Application {

    public static DaoSession session;

    @Override
    public void onCreate() {
        super.onCreate();
        Context context = getApplicationContext();
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(context, "stu.db");
        DaoMaster daoMaster = new DaoMaster(openHelper.getWritableDatabase());
        session = daoMaster.newSession();
    }
}

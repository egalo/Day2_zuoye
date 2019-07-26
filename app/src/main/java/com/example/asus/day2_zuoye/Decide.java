package com.example.asus.day2_zuoye;

public interface Decide {
    void onSucceed(Zhihu zhihu);
    void onFailure(Throwable e);
}

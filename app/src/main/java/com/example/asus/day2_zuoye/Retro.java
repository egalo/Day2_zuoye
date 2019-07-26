package com.example.asus.day2_zuoye;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Retro {
    @GET("http://news-at.zhihu.com/api/4/news/hot")
    Observable<Zhihu> getZhihu();
}

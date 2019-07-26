package com.example.asus.day2_zuoye;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Student {
    @Id(autoincrement = true)
    private Long id;
    private String img;
    private String url;
    private String tit;
    @Generated(hash = 44861793)
    public Student(Long id, String img, String url, String tit) {
        this.id = id;
        this.img = img;
        this.url = url;
        this.tit = tit;
    }
    public Student(String img, String url, String tit) {
        this.img = img;
        this.url = url;
        this.tit = tit;
    }
    @Generated(hash = 1556870573)
    public Student() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getImg() {
        return this.img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getTit() {
        return this.tit;
    }
    public void setTit(String tit) {
        this.tit = tit;
    }
    
}

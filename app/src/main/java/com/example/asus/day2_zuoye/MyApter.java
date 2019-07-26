package com.example.asus.day2_zuoye;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyApter extends RecyclerView.Adapter<MyApter.Han> {
    private ArrayList<Zhihu.RecentBean> list;
    private Context context;
    private Dian dian;
    private LongDian longDian;

    public void setDian(Dian dian) {
        this.dian = dian;
    }

    public void setLongDian(LongDian longDian) {
        this.longDian = longDian;
    }

    public MyApter(ArrayList<Zhihu.RecentBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Han onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false);
        Han han = new Han(view);
        return han;
    }

    @Override
    public void onBindViewHolder(@NonNull Han han, final int i) {
        han.t1.setText(list.get(i).getTitle());
        han.t2.setText(list.get(i).getUrl());
        Glide.with(context).load(list.get(i).getThumbnail()).into(han.img);
        han.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dian.d(i);
            }
        });
        han.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longDian.d(i);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Han extends RecyclerView.ViewHolder{
        ImageView img;
        TextView t1;
        TextView t2;
        public Han(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            t1  =itemView.findViewById(R.id.t1);
            t2  = itemView.findViewById(R.id.t2);
        }
    }
    interface Dian{
        void d(int i);
    }
    interface LongDian{
        void d(int i);
    }
}


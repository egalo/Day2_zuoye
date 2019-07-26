package com.example.asus.day2_zuoye;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    private RecyclerView rl;
    private Prester prester;
    private ArrayList<Zhihu.RecentBean> recent;
    private MyApter myApter;
    private int index;
    private int longindex;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(getView());
    }

    private void initView(View view) {
        rl = view.findViewById(R.id.rl);
        rl.setLayoutManager(new LinearLayoutManager(getContext()));
        prester = new Prester();
        prester.presterServer(new Decide() {
            @Override
            public void onSucceed(Zhihu zhihu) {
                recent = (ArrayList<Zhihu.RecentBean>) zhihu.getRecent();
                myApter = new MyApter(recent, getContext());
                rl.setAdapter(myApter);
                myApter.setDian(new MyApter.Dian() {
                    @Override
                    public void d(int i) {
                        index = i;
                        Zhihu.RecentBean bean = recent.get(index);
                        String thumbnail = bean.getThumbnail();
                        String title = bean.getTitle();
                        String url = bean.getUrl();
                        Intent intent = new Intent(getContext(), ParticularActivity.class);
                        intent.putExtra("thumbnail",thumbnail);
                        intent.putExtra("title",title);
                        intent.putExtra("url",url);
                        startActivity(intent);
                    }
                });
                myApter.setLongDian(new MyApter.LongDian() {
                    @Override
                    public void d(int i) {
                        longindex = i;
                        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.pop, null);
                        final PopupWindow popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                        popupWindow.showAtLocation(inflate,Gravity.CENTER,0,0);
                        inflate.findViewById(R.id.ensure).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Zhihu.RecentBean bean = recent.get(longindex);
                                String thumbnail = bean.getThumbnail();
                                String title = bean.getTitle();
                                String url = bean.getUrl();
                                DaoSession session = Dao.session;
                                StudentDao dao = session.getStudentDao();
                                dao.insert(new Student(thumbnail,url,title));
                                popupWindow.dismiss();
                            }
                        });
                        inflate.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                popupWindow.dismiss();
                            }
                        });
                    }
                });
            }

            @Override
            public void onFailure(Throwable e) {
                Log.i("tag","======>"+e.getMessage());
            }
        });
    }
}

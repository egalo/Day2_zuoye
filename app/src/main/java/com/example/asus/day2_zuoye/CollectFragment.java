package com.example.asus.day2_zuoye;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
        public class CollectFragment extends Fragment {


    private RecyclerView recycle;
    private CollectApter apter;
    private ArrayList<Student> all;
    private ArrayList<Student> list;

    public CollectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_collect, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            recycle = getView().findViewById(R.id.recycle);
            recycle.setLayoutManager(new LinearLayoutManager(getContext()));
            DaoSession session = Dao.session;
            StudentDao dao = session.getStudentDao();
            all = (ArrayList<Student>) dao.loadAll();
            list = new ArrayList<>();
            list.addAll(all);
            apter = new CollectApter(list, getContext());
            recycle.setAdapter(apter);
            apter.notifyDataSetChanged();
        }

    }
}

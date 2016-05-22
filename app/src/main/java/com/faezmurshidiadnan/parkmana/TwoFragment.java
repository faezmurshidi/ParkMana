package com.faezmurshidiadnan.parkmana;

/**
 * Created by User on 20/05/16.
 */


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class TwoFragment extends Fragment{

    private RecyclerView rv;
    View myview;
    private List<Info> info;
    private List<Data> datas;

    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        myview = inflater.inflate(R.layout.fragment_two, container, false);

        //loadPref();


        return myview;

    }

    private void loadPref() {
        rv=(RecyclerView)myview.findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();

    }

    private void initializeData(){
        info = new ArrayList<>();
        info.add(new Info("Marina", "12","34","110"));
        info.add(new Info("Marina", "12","34","110"));
        info.add(new Info("bay","34","22","3.4"));

    }

    private void initializeAdapter(){
        info = new ArrayList<>();
        RVAdapter adapter = new RVAdapter(info);
        rv.setAdapter(adapter);
    }

}
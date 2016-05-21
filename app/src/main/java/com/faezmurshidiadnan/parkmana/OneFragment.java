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


public class OneFragment extends Fragment{

    private RecyclerView rv;
    View myview;
    private List<Info> info;
    private List<Person> persons;


    public OneFragment() {
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
        // Inflate the layout for this fragment
        myview = inflater.inflate(R.layout.recyclerview_activity, container, false);

        loadPref();

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
        persons = new ArrayList<>();
        persons.add(new Person("The Esplenade", "1.3km", R.drawable.emma, "120"));
        persons.add(new Person("Millenia Singapore", "25 years old", R.drawable.emma, "130"));
        persons.add(new Person("Singapore Flyer", "35 years old", R.drawable.emma,"132"));
    }

    private void initializeAdapter(){
        AVAdapter adapter = new AVAdapter(persons);
        rv.setAdapter(adapter);

}}
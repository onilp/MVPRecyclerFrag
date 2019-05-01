package com.example.mvprecyclerfrag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

public class FragmentOne extends Fragment {

    RecyclerView recyclerView;
    MyAdapter myAdapter;
    List<MyListData> myListData;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one,container,false);
        myListData = new ArrayList<>();
        addName();
        recyclerView = view.findViewById(R.id.recyclerViewFragmentOne);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        myAdapter = new MyAdapter(myListData);
        recyclerView.setAdapter(myAdapter);

        return view;
    }



    public void addName(){
        String [] names = {"Onil", "Cal", "Binsun","Zack","Robert", "Luis","Cesar","Christian","Dimitri","Rainer"};
        for(int i=0; i<names.length;i++) {
            MyListData name = new MyListData(names[i]);
            myListData.add(name);
        }
    }
}

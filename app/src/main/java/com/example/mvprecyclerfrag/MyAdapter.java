package com.example.mvprecyclerfrag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>  {
    List<MyListData> names;
    RecyclerView recyclerView;

    public MyAdapter(List<MyListData> names) {
        this.names = names;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        final MyListData name = names.get(position);
        myViewHolder.textViewName.setText(name.name);
        myViewHolder.textViewName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTwo fragmentTwo = new FragmentTwo();
                Bundle bundle = new Bundle();
                bundle.putString("name",name.getName());
                fragmentTwo.setArguments(bundle);

                AppCompatActivity activity =  (AppCompatActivity)v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.myLayout,fragmentTwo).addToBackStack("name").commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return names.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textViewName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
        }
    }
}

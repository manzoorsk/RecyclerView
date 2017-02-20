package com.example.admin.recyclerview.models;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.admin.recyclerview.DetailActivity;
import com.example.admin.recyclerview.R;
import com.example.admin.recyclerview.SpaceCraft;

import java.util.ArrayList;

/**
 * Created by admin on 10/18/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyHolder>{

    Context context;
    ArrayList<SpaceCraft> spaceCrafts;

    public MyAdapter(Context context, ArrayList<SpaceCraft> spaceCrafts) {
        this.context = context;
        this.spaceCrafts = spaceCrafts;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.model,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        final String name=spaceCrafts.get(position).getName();
        final int images=spaceCrafts.get(position).getImage();

        holder.text_view.setText(name);
        holder.image_view.setImageResource(images);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
            openDetailActivity(name,images);
                Toast.makeText(context,name,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return spaceCrafts.size();
    }

    private void openDetailActivity(String name,int image){
        Intent intent=new Intent(context, DetailActivity.class);

        intent.putExtra("NAME_KEY",name);
        intent.putExtra("IMAGE_KEY",image);
        context.startActivity(intent);
    }
}

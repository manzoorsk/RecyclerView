package com.example.admin.recyclerview.models;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.recyclerview.R;

/**
 * Created by admin on 10/18/2016.
 */
public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView text_view,text;
    ImageView image_view;
    ItemClickListener itemClickListener;

    public MyHolder(View itemView) {
        super(itemView);
        text_view= (TextView) itemView.findViewById(R.id.text_view);
        image_view=(ImageView)itemView.findViewById(R.id.image_view);
        text=(TextView)itemView.findViewById(R.id.sample);
        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener){

        this.itemClickListener=itemClickListener;

    }

    @Override
    public void onClick(View view) {

        this.itemClickListener.onItemClick(this.getLayoutPosition());
    }
}

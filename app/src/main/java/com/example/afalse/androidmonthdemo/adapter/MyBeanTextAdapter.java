package com.example.afalse.androidmonthdemo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.afalse.androidmonthdemo.R;
import com.example.afalse.androidmonthdemo.bean.DynastyBean;

import java.util.ArrayList;
import java.util.List;

public class MyBeanTextAdapter extends RecyclerView.Adapter<MyBeanTextAdapter.ViewHolder>{
    private List<DynastyBean.ResultBean> list=new ArrayList<>();
    public void refresh(List<DynastyBean.ResultBean> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_beantext,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.authors.setText(list.get(i).getTitle());
        viewHolder.count.setText(list.get(i).getContent());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView authors,count;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            authors=itemView.findViewById(R.id.authors);
            count=itemView.findViewById(R.id.count);
        }
    }
}

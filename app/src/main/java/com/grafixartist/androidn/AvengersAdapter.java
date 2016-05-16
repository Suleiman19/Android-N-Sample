package com.grafixartist.androidn;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

/**
 * AndroidN
 * Created by Suleiman19 on 5/14/16.
 * Copyright (c) 2016. Suleiman Ali Shakir. All rights reserved.
 */
public class AvengersAdapter extends RecyclerView.Adapter<AvengersAdapter.AvengerVH> {

    private List<Avenger> avengers;
    private Context context;

    OnItemClickListener clickListener;

    public AvengersAdapter(List<Avenger> avengers, Context context) {
        this.avengers = avengers;
        this.context = context;
    }

    @Override
    public AvengerVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.avenger_item, parent, false);
        return new AvengerVH(view);
    }

    @Override
    public void onBindViewHolder(AvengerVH holder, int position) {
        Avenger avenger = avengers.get(position);

        holder.name.setText(avenger.getName());
        Glide
                .with(context)
                .load(avenger.getPhoto())
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return avengers.size();
    }

    public List<Avenger> getAvengers() {
        return avengers;
    }

    class AvengerVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        ImageView imageView;

        public AvengerVH(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.avenger_namehero);
            imageView = (ImageView) itemView.findViewById(R.id.avenger_img);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(view, getAdapterPosition());
        }
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

}

package com.example.ninjabocil.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ninjabocil.R;
import com.example.ninjabocil.models.skill;
import com.example.ninjabocil.models.tailed;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapaterTailed extends RecyclerView.Adapter<AdapaterTailed.ViewHolder> {

    private List<tailed> tailedList = new ArrayList<>();
    private Context mcontext;

    public AdapaterTailed(List<tailed> tailedList) {
        this.tailedList = tailedList;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public AdapaterTailed.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.tailed_data, parent, false);
        ViewHolder holder = new ViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        tailed tl = tailedList.get(position);

        holder.nama.setText(tl.getNama());

        if (tl.getFototailed().isEmpty()) {
            holder.image.setImageResource(R.drawable.skill_ss_one);
        } else {
            Picasso.get().load(tl.getFototailed()).into(holder.image);
        }

        if (tl.getSkill()[0].isEmpty()) {
            holder.skill1.setImageResource(R.drawable.skill_ss_one);
        } else {
            Picasso.get().load(tl.getSkill()[0]).into(holder.skill1);
        }

        if (tl.getSkill()[1].isEmpty()) {
            holder.skill2.setImageResource(R.drawable.skill_ss_one);
        } else {
            Picasso.get().load(tl.getSkill()[1]).into(holder.skill2);
        }

        if (tl.getSkill()[2].isEmpty()) {
            holder.skill3.setImageResource(R.drawable.skill_ss_one);
        } else {
            Picasso.get().load(tl.getSkill()[2]).into(holder.skill3);
        }

        if (tl.getSkill()[3].isEmpty()) {
            holder.skill4.setImageResource(R.drawable.skill_ss_one);
        } else {
            Picasso.get().load(tl.getSkill()[3]).into(holder.skill4);
        }

    }

    @Override
    public int getItemCount() {
        return tailedList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nama;
        private ImageView image, skill1, skill2,skill3,skill4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nama = itemView.findViewById(R.id.tv_namaTailed);
            image = itemView.findViewById(R.id.image_tailed);
            skill1 = itemView.findViewById(R.id.tv_skill1Tailed);
            skill2 = itemView.findViewById(R.id.tv_skill2Tailed);
            skill3 = itemView.findViewById(R.id.tv_skill3Tailed);
            skill4 = itemView.findViewById(R.id.tv_skill4Tailed);

        }
    }
}

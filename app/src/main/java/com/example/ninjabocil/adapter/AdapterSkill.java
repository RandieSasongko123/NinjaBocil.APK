package com.example.ninjabocil.adapter;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ninjabocil.DetailSkillActivity;
import com.example.ninjabocil.R;
import com.example.ninjabocil.activity.DetailHeroActivity;
import com.example.ninjabocil.models.skill;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterSkill extends RecyclerView.Adapter<AdapterSkill.ViewHolder> {

    private List<skill> skillList = new ArrayList<>();

    public AdapterSkill(List<skill> skillList) {
        this.skillList = skillList;
    }

    @NonNull
    @Override
    public AdapterSkill.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.skill_data, parent, false);
        ViewHolder holder = new ViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSkill.ViewHolder holder, int position) {
        skill skl = skillList.get(position);

        holder.tvNama.setText(skl.getNama());
        holder.tvDamage.setText(skl.getDamage());
        holder.tvProc.setText(skl.getProcRate());
        holder.tvChakra.setText(skl.getChakra());
        holder.tvGrade.setText(skl.getGrade());

        if(holder.tvGrade.getText().toString().equalsIgnoreCase("SSS"))
        {
            holder.tvGrade.setTextColor(Color.parseColor("#E730DE"));
            holder.tvNama.setTextColor(Color.parseColor("#E730DE"));
            holder.tvDamage.setTextColor(Color.parseColor("#E730DE"));
            holder.tvProc.setTextColor(Color.parseColor("#E730DE"));
            holder.tvChakra.setTextColor(Color.parseColor("#E730DE"));
            holder.tvGrade.setTextColor(Color.parseColor("#E730DE"));
        }
        else if(holder.tvGrade.getText().toString().equalsIgnoreCase("SS"))
        {
            holder.tvGrade.setTextColor(Color.parseColor("#FF9608"));
            holder.tvNama.setTextColor(Color.parseColor("#FF9608"));
            holder.tvDamage.setTextColor(Color.parseColor("#FF9608"));
            holder.tvProc.setTextColor(Color.parseColor("#FF9608"));
            holder.tvChakra.setTextColor(Color.parseColor("#FF9608"));
            holder.tvGrade.setTextColor(Color.parseColor("#FF9608"));
        }
        else if(holder.tvGrade.getText().toString().equalsIgnoreCase("S"))
        {
            holder.tvGrade.setTextColor(Color.parseColor("#B71916"));
            holder.tvNama.setTextColor(Color.parseColor("#B71916"));
            holder.tvDamage.setTextColor(Color.parseColor("#B71916"));
            holder.tvProc.setTextColor(Color.parseColor("#B71916"));
            holder.tvChakra.setTextColor(Color.parseColor("#B71916"));
            holder.tvGrade.setTextColor(Color.parseColor("#B71916"));
        }
        else if(holder.tvGrade.getText().toString().equalsIgnoreCase("A"))
        {
            holder.tvGrade.setTextColor(Color.parseColor("#8434DE"));
            holder.tvNama.setTextColor(Color.parseColor("#8434DE"));
            holder.tvDamage.setTextColor(Color.parseColor("#8434DE"));
            holder.tvProc.setTextColor(Color.parseColor("#8434DE"));
            holder.tvChakra.setTextColor(Color.parseColor("#8434DE"));
            holder.tvGrade.setTextColor(Color.parseColor("#8434DE"));
        }
        else if(holder.tvGrade.getText().toString().equalsIgnoreCase("B"))
        {
            holder.tvGrade.setTextColor(Color.parseColor("#2378D0"));
            holder.tvNama.setTextColor(Color.parseColor("#2378D0"));
            holder.tvDamage.setTextColor(Color.parseColor("#2378D0"));
            holder.tvProc.setTextColor(Color.parseColor("#2378D0"));
            holder.tvChakra.setTextColor(Color.parseColor("#2378D0"));
            holder.tvGrade.setTextColor(Color.parseColor("#2378D0"));
        }
        else if(holder.tvGrade.getText().toString().equalsIgnoreCase("C"))
        {
            holder.tvGrade.setTextColor(Color.parseColor("#29A600"));
            holder.tvNama.setTextColor(Color.parseColor("#29A600"));
            holder.tvDamage.setTextColor(Color.parseColor("#29A600"));
            holder.tvProc.setTextColor(Color.parseColor("##29A600"));
            holder.tvChakra.setTextColor(Color.parseColor("#29A600"));
            holder.tvGrade.setTextColor(Color.parseColor("#29A600"));
        }
        else if(holder.tvGrade.getText().toString().equalsIgnoreCase("D"))
        {
            holder.tvGrade.setTextColor(Color.parseColor("#6B616B"));
            holder.tvNama.setTextColor(Color.parseColor("#6B616B"));
            holder.tvDamage.setTextColor(Color.parseColor("#6B616B"));
            holder.tvProc.setTextColor(Color.parseColor("#6B616B"));
            holder.tvChakra.setTextColor(Color.parseColor("#6B616B"));
            holder.tvGrade.setTextColor(Color.parseColor("#6B616B"));
        }

        if(skl.getImage().isEmpty())
        {
            holder.ivSkill.setImageResource(R.drawable.skill_ss_one);
        }
        else
        {
            Picasso.get().load(skl.getImage()).into(holder.ivSkill);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailSkillActivity.class);

                intent.putExtra("varNama", skl.getNama());
                intent.putExtra("varPreview", skl.getPreview());
                intent.putExtra("varGrade", skl.getGrade());
                intent.putExtra("varChakra", skl.getChakra());
                intent.putExtra("varDamage", skl.getDamage());
                intent.putExtra("varProc", skl.getProcRate());
                intent.putExtra("varEffect", skl.getEffect());
                intent.putExtra("varRound", skl.getRound());
                intent.putExtra("varLaunch", skl.getLaunch());
                intent.putExtra("varRestriction", skl.getRestriction());

                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return skillList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNama, tvDamage, tvProc, tvChakra, tvGrade, tvEffect, tvRound, tvLaunch, tvRestriction;
        private ImageView ivSkill;
        private VideoView vvSkill;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tv_namaSkill);
            tvDamage = itemView.findViewById(R.id.tv_APIdamageSkill);
            tvProc = itemView.findViewById(R.id.tv_APIrateSkill);
            tvChakra = itemView.findViewById(R.id.tv_APIchakraSkill);
            tvGrade = itemView.findViewById(R.id.tv_APIgradeSkill);
            ivSkill = itemView.findViewById(R.id.image_skill);
            vvSkill = itemView.findViewById(R.id.vv_previewSkill);

        }
    }
}

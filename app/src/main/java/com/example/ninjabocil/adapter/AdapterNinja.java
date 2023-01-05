package com.example.ninjabocil.adapter;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ninjabocil.R;
import com.example.ninjabocil.activity.DetailHeroActivity;
import com.example.ninjabocil.models.ninja;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterNinja extends RecyclerView.Adapter<AdapterNinja.ViewHolder> {

    private List<ninja> ninjaList = new ArrayList<>();

    public AdapterNinja(List<ninja> ninjaList) {
        this.ninjaList = ninjaList;
    }

    @NonNull
    @Override
    public AdapterNinja.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.hero_data, parent, false);
        ViewHolder holder = new ViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterNinja.ViewHolder holder, int position) {
        ninja nj = ninjaList.get(position);

        holder.tvNama.setText(nj.getNama());
        holder.tvGrade.setText(nj.getGrade());
        holder.tvChakra.setText(nj.getChakra());

        if(holder.tvGrade.getText().toString().equalsIgnoreCase("SSS"))
        {
            holder.tvGrade.setTextColor(Color.parseColor("#E730DE"));
            holder.tvNama.setTextColor(Color.parseColor("#E730DE"));
            holder.tvChakra.setTextColor(Color.parseColor("#E730DE"));
            holder.tvGrade.setTextColor(Color.parseColor("#E730DE"));
        }
        else if(holder.tvGrade.getText().toString().equalsIgnoreCase("SS"))
        {
            holder.tvGrade.setTextColor(Color.parseColor("#FF9608"));
            holder.tvNama.setTextColor(Color.parseColor("#FF9608"));
            holder.tvChakra.setTextColor(Color.parseColor("#FF9608"));
            holder.tvGrade.setTextColor(Color.parseColor("#FF9608"));
        }
        else if(holder.tvGrade.getText().toString().equalsIgnoreCase("S"))
        {
            holder.tvGrade.setTextColor(Color.parseColor("#B71916"));
            holder.tvNama.setTextColor(Color.parseColor("#B71916"));
            holder.tvChakra.setTextColor(Color.parseColor("#B71916"));
            holder.tvGrade.setTextColor(Color.parseColor("#B71916"));
        }
        else if(holder.tvGrade.getText().toString().equalsIgnoreCase("A"))
        {
            holder.tvGrade.setTextColor(Color.parseColor("#8434DE"));
            holder.tvNama.setTextColor(Color.parseColor("#8434DE"));
            holder.tvChakra.setTextColor(Color.parseColor("#8434DE"));
            holder.tvGrade.setTextColor(Color.parseColor("#8434DE"));
        }
        else if(holder.tvGrade.getText().toString().equalsIgnoreCase("B"))
        {
            holder.tvGrade.setTextColor(Color.parseColor("#2378D0"));
            holder.tvNama.setTextColor(Color.parseColor("#2378D0"));
            holder.tvChakra.setTextColor(Color.parseColor("#2378D0"));
            holder.tvGrade.setTextColor(Color.parseColor("#2378D0"));
        }
        else if(holder.tvGrade.getText().toString().equalsIgnoreCase("C"))
        {
            holder.tvGrade.setTextColor(Color.parseColor("#29A600"));
            holder.tvNama.setTextColor(Color.parseColor("#29A600"));
            holder.tvChakra.setTextColor(Color.parseColor("#29A600"));
            holder.tvGrade.setTextColor(Color.parseColor("#29A600"));
        }
        else if(holder.tvGrade.getText().toString().equalsIgnoreCase("D"))
        {
            holder.tvGrade.setTextColor(Color.parseColor("#6B616B"));
            holder.tvNama.setTextColor(Color.parseColor("#6B616B"));
            holder.tvChakra.setTextColor(Color.parseColor("#6B616B"));
            holder.tvGrade.setTextColor(Color.parseColor("#6B616B"));
        }

        if (nj.getFotohero().isEmpty())
        {
            holder.image.setImageResource(R.drawable.skill_ss_one);
        }
        else
        {
            Picasso.get().load(nj.getFotohero()).into(holder.image);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(holder.itemView.getContext(), DetailHeroActivity.class);
                intent.putExtra("varId", nj.getId());
                intent.putExtra("varNama", nj.getNama());
                intent.putExtra("varGrade", nj.getGrade());
                intent.putExtra("varChakra", nj.getChakra());
                intent.putExtra("varQuality", nj.getQuality());
                intent.putExtra("varPoint", nj.getPoint());
                intent.putExtra("varFoto", nj.getFotohero());
                intent.putExtra("varFotoDetail", nj.getFotodetail());
                intent.putExtra("varBackground", nj.getBackground());
                intent.putExtra("varSkill1", nj.getSkill()[0]);
                intent.putExtra("varSkill2", nj.getSkill()[1]);
                intent.putExtra("varSkill3", nj.getSkill()[2]);
                intent.putExtra("varSkill4", nj.getSkill()[3]);
                intent.putExtra("varSkill5", nj.getSkill()[4]);
                intent.putExtra("varSummon1", nj.getSummon()[0]);
                intent.putExtra("varSummon2", nj.getSummon()[1]);
                intent.putExtra("varSummon3", nj.getSummon()[2]);
                intent.putExtra("varTailed1", nj.getTailed()[0]);
                intent.putExtra("varTailed2", nj.getTailed()[1]);
                holder.itemView.getContext().startActivity(intent);

                

            }
        });

    }

    @Override
    public int getItemCount() {
        return ninjaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNama, tvGrade, tvChakra;
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tv_namaHero);
            tvGrade = itemView.findViewById(R.id.tv_APIgradeHero);
            tvChakra = itemView.findViewById(R.id.tv_APIchakraHero);
            image = itemView.findViewById(R.id.image_hero);

        }
    }
}

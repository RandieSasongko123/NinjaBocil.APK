package com.example.ninjabocil;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toolbar;
import android.widget.VideoView;

public class DetailSkillActivity extends AppCompatActivity {

    private TextView tvNama, tvGrade, tvChakra, tvDamage, tvEffect, tvRound, tvLaunch, tvRate, tvRestriction, tvUrl;
    private VideoView vvSkill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_skill);

        VideoView videoView = findViewById(R.id.vv_previewSkill);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.shadowclone));
        videoView.requestFocus();
        videoView.start();


//        videoView.setVideoURI(Uri.parse("https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1"));
//        videoView.start();
//        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.shadowclone;
//        String url = "https://www.youtube.com/watch?v=zABLecsR5UE&list=RDq31tGyBJhRY&index=4";
//        Uri uri = Uri.parse(videoPath);
//        Uri uri = Uri.parse(url);
//        videoView.setVideoURI(uri);
//        videoView.start();

        Intent intent = getIntent();

        tvNama = findViewById(R.id.detailnama_skill);
        tvGrade = findViewById(R.id.tv_apiGradeSkillDetail);
        tvChakra = findViewById(R.id.tv_apiChakraSkillDetail);
        tvDamage = findViewById(R.id.tv_apiDamageSkillDetail);
        tvEffect = findViewById(R.id.tv_apiEffectSkillDetail);
        tvRound = findViewById(R.id.tv_apiRoundSkillDetail);
        tvLaunch = findViewById(R.id.tv_apiLaunchSkillDetail);
        tvRate = findViewById(R.id.tv_apiRateSkillDetail);
        tvRestriction = findViewById(R.id.tv_apiRestrictionSkillDetail);

//        Preview
//        vvSkill = findViewById(R.id.vv_previewSkill);
//
//        MediaController mediaController = new MediaController(this);
//        vvSkill.setMediaController(mediaController);
//        mediaController.setAnchorView(vvSkill);
//
//        Uri uri = Uri.parse("https://www.youtube.com/watch?v=zABLecsR5UE&list=RDq31tGyBJhRY&index=4");
//
//        vvSkill.setVideoURI(uri);
//        vvSkill.requestFocus();
//        vvSkill.start();


        tvNama.setText(intent.getStringExtra("varNama"));
        tvGrade.setText(intent.getStringExtra("varGrade"));
        tvChakra.setText(intent.getStringExtra("varChakra"));
        tvDamage.setText(intent.getStringExtra("varDamage"));
        tvRate.setText(intent.getStringExtra("varProc"));
        tvEffect.setText(intent.getStringExtra("varEffect"));
        tvRound.setText(intent.getStringExtra("varRound"));
        tvLaunch.setText(intent.getStringExtra("varLaunch"));
        tvRestriction.setText(intent.getStringExtra("varRestriction"));


        if(tvGrade.getText().toString().equalsIgnoreCase("SSS"))
        {
            tvNama.setTextColor(Color.parseColor("#E730DE"));
            tvGrade.setTextColor(Color.parseColor("#E730DE"));
            tvChakra.setTextColor(Color.parseColor("#E730DE"));
            tvDamage.setTextColor(Color.parseColor("#E730DE"));
            tvEffect.setTextColor(Color.parseColor("#E730DE"));
            tvRound.setTextColor(Color.parseColor("#E730DE"));
            tvLaunch.setTextColor(Color.parseColor("#E730DE"));
            tvRate.setTextColor(Color.parseColor("#E730DE"));
            tvRestriction.setTextColor(Color.parseColor("#E730DE"));
        }
        else if(tvGrade.getText().toString().equalsIgnoreCase("SS"))
        {
            tvNama.setTextColor(Color.parseColor("#FF9608"));
            tvGrade.setTextColor(Color.parseColor("#FF9608"));
            tvChakra.setTextColor(Color.parseColor("#FF9608"));
            tvDamage.setTextColor(Color.parseColor("#FF9608"));
            tvEffect.setTextColor(Color.parseColor("#FF9608"));
            tvRound.setTextColor(Color.parseColor("#FF9608"));
            tvLaunch.setTextColor(Color.parseColor("#FF9608"));
            tvRate.setTextColor(Color.parseColor("#FF9608"));
            tvRestriction.setTextColor(Color.parseColor("#FF9608"));
        }
        else if(tvGrade.getText().toString().equalsIgnoreCase("S"))
        {
            tvNama.setTextColor(Color.parseColor("#B71916"));
            tvGrade.setTextColor(Color.parseColor("#B71916"));
            tvChakra.setTextColor(Color.parseColor("#B71916"));
            tvDamage.setTextColor(Color.parseColor("#B71916"));
            tvEffect.setTextColor(Color.parseColor("#B71916"));
            tvRound.setTextColor(Color.parseColor("#B71916"));
            tvLaunch.setTextColor(Color.parseColor("#B71916"));
            tvRate.setTextColor(Color.parseColor("#B71916"));
            tvRestriction.setTextColor(Color.parseColor("#B71916"));
        }
        else if(tvGrade.getText().toString().equalsIgnoreCase("A"))
        {
            tvNama.setTextColor(Color.parseColor("#8434DE"));
            tvGrade.setTextColor(Color.parseColor("#8434DE"));
            tvChakra.setTextColor(Color.parseColor("#8434DE"));
            tvDamage.setTextColor(Color.parseColor("#8434DE"));
            tvEffect.setTextColor(Color.parseColor("#8434DE"));
            tvRound.setTextColor(Color.parseColor("#8434DE"));
            tvLaunch.setTextColor(Color.parseColor("#8434DE"));
            tvRate.setTextColor(Color.parseColor("#8434DE"));
            tvRestriction.setTextColor(Color.parseColor("#8434DE"));
        }
        else if(tvGrade.getText().toString().equalsIgnoreCase("B"))
        {
            tvNama.setTextColor(Color.parseColor("#2378D0"));
            tvGrade.setTextColor(Color.parseColor("#2378D0"));
            tvChakra.setTextColor(Color.parseColor("#2378D0"));
            tvDamage.setTextColor(Color.parseColor("#2378D0"));
            tvEffect.setTextColor(Color.parseColor("#2378D0"));
            tvRound.setTextColor(Color.parseColor("#2378D0"));
            tvLaunch.setTextColor(Color.parseColor("#2378D0"));
            tvRate.setTextColor(Color.parseColor("#2378D0"));
            tvRestriction.setTextColor(Color.parseColor("#2378D0"));
        }
        else if(tvGrade.getText().toString().equalsIgnoreCase("C"))
        {
            tvNama.setTextColor(Color.parseColor("#29A600"));
            tvGrade.setTextColor(Color.parseColor("#29A600"));
            tvChakra.setTextColor(Color.parseColor("#29A600"));
            tvDamage.setTextColor(Color.parseColor("#29A600"));
            tvEffect.setTextColor(Color.parseColor("#29A600"));
            tvRound.setTextColor(Color.parseColor("#29A600"));
            tvLaunch.setTextColor(Color.parseColor("#29A600"));
            tvRate.setTextColor(Color.parseColor("#29A600"));
            tvRestriction.setTextColor(Color.parseColor("#29A600"));
        }
        else if(tvGrade.getText().toString().equalsIgnoreCase("D"))
        {
            tvNama.setTextColor(Color.parseColor("#6B616B"));
            tvGrade.setTextColor(Color.parseColor("#6B616B"));
            tvChakra.setTextColor(Color.parseColor("#6B616B"));
            tvDamage.setTextColor(Color.parseColor("#6B616B"));
            tvEffect.setTextColor(Color.parseColor("#6B616B"));
            tvRound.setTextColor(Color.parseColor("#6B616B"));
            tvLaunch.setTextColor(Color.parseColor("#6B616B"));
            tvRate.setTextColor(Color.parseColor("#6B616B"));
            tvRestriction.setTextColor(Color.parseColor("#E730DE"));
        }

    }
}
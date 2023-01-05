package com.example.ninjabocil.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.ninjabocil.R;
import com.example.ninjabocil.models.ninja;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DetailHeroActivity extends AppCompatActivity {

    private TextView id, nama, grade, chakra, point, quality;
    private ImageView foto,fotodetail, skill1, skill2 ,skill3, skill4, skill5, summon1, summon2, summon3, tailed1, tailed2;
    private LinearLayout ll_grade, ll_quality, ll_chakra, ll_point;
    private ScrollView background;

    private RecyclerView rvSpek;
    private ninja ninjaList;
    private RecyclerView.Adapter adSpek;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hero);

//        URL url = new URL(remoteFile);
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setDoInput(true);
//        conn.connect();
//        InputStream is = conn.getInputStream();
//        Bitmap bm = BitmapFactory.decodeStream(is);
//        FileOutputStream fos = mainActivity.openFileOutput(filename,
//                Context.MODE_PRIVATE);
//        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
//        byte[] byteArray = outStream.toByteArray();
//        fos.write(byteArray);
//        fos.close();

        Intent intent = getIntent();

//        findViewById(R.id.sv_detail).setBackground(Drawable.createFromPath("varBackground"));

        nama = findViewById(R.id.detailnama_hero);
        grade = findViewById(R.id.tv_apiGradeHero);
        chakra = findViewById(R.id.tv_apiChakraHero);
        point = findViewById(R.id.tv_apiGPHero);
        quality = findViewById(R.id.tv_apiQualityHero);
        fotodetail = findViewById(R.id.preview);
        skill1 = findViewById(R.id.tv_apiSkill1);
        skill2 = findViewById(R.id.tv_apiSkill2);
        skill3 = findViewById(R.id.tv_apiSkill3);
        skill4 = findViewById(R.id.tv_apiSkill4);
        skill5 = findViewById(R.id.tv_apiSkill5);
        summon1 = findViewById(R.id.tv_apiSummon1);
        summon2 = findViewById(R.id.tv_apiSummon2);
        summon3 = findViewById(R.id.tv_apiSummon3);
        tailed1 = findViewById(R.id.tv_apiTailed1);
        tailed2 = findViewById(R.id.tv_apiTailed2);
        background = findViewById(R.id.sv_detail);

        nama.setText(intent.getStringExtra("varNama"));
        grade.setText(intent.getStringExtra("varGrade"));
        chakra.setText(intent.getStringExtra("varChakra"));
        point.setText(intent.getStringExtra("varPoint"));
        quality.setText(intent.getStringExtra("varQuality"));

        ll_grade = findViewById(R.id.ll_grade);
        ll_quality = findViewById(R.id.ll_quality);
        ll_point = findViewById(R.id.ll_point);
        ll_chakra = findViewById(R.id.ll_chakra);

        if(grade.getText().toString().equalsIgnoreCase("SSS"))
        {
            GradientDrawable myGrade = (GradientDrawable) ll_grade.getBackground();
            myGrade.setStroke(convertDpToPx(2) , Color.parseColor("#E730DE"));

            GradientDrawable myQuality = (GradientDrawable) ll_quality.getBackground();
            myQuality.setStroke(convertDpToPx(2) , Color.parseColor("#E730DE"));

            GradientDrawable myPoint = (GradientDrawable) ll_point.getBackground();
            myPoint.setStroke(convertDpToPx(2) , Color.parseColor("#E730DE"));

            GradientDrawable myChakra = (GradientDrawable) ll_chakra.getBackground();
            myChakra.setStroke(convertDpToPx(2) , Color.parseColor("#E730DE"));

            grade.setTextColor(Color.parseColor("#E730DE"));
            nama.setTextColor(Color.parseColor("#E730DE"));
            chakra.setTextColor(Color.parseColor("#E730DE"));
            point.setTextColor(Color.parseColor("#E730DE"));
            quality.setTextColor(Color.parseColor("#E730DE"));
        }
        else if(grade.getText().toString().equalsIgnoreCase("SS"))
        {
            GradientDrawable myGrade = (GradientDrawable) ll_grade.getBackground();
            myGrade.setStroke(convertDpToPx(2) , Color.parseColor("#FF9608"));

            GradientDrawable myQuality = (GradientDrawable) ll_quality.getBackground();
            myQuality.setStroke(convertDpToPx(2) , Color.parseColor("#FF9608"));

            GradientDrawable myPoint = (GradientDrawable) ll_point.getBackground();
            myPoint.setStroke(convertDpToPx(2) , Color.parseColor("#FF9608"));

            GradientDrawable myChakra = (GradientDrawable) ll_chakra.getBackground();
            myChakra.setStroke(convertDpToPx(2) , Color.parseColor("#FF9608"));

            grade.setTextColor(Color.parseColor("#FF9608"));
            nama.setTextColor(Color.parseColor("#FF9608"));
            chakra.setTextColor(Color.parseColor("#FF9608"));
            point.setTextColor(Color.parseColor("#FF9608"));
            quality.setTextColor(Color.parseColor("#FF9608"));
        }
        else if(grade.getText().toString().equalsIgnoreCase("S"))
        {
            GradientDrawable myGrade = (GradientDrawable) ll_grade.getBackground();
            myGrade.setStroke(convertDpToPx(2) , Color.parseColor("#B71916"));

            GradientDrawable myQuality = (GradientDrawable) ll_quality.getBackground();
            myQuality.setStroke(convertDpToPx(2) , Color.parseColor("#B71916"));

            GradientDrawable myPoint = (GradientDrawable) ll_point.getBackground();
            myPoint.setStroke(convertDpToPx(2) , Color.parseColor("#B71916"));

            GradientDrawable myChakra = (GradientDrawable) ll_chakra.getBackground();
            myChakra.setStroke(convertDpToPx(2) , Color.parseColor("#B71916"));

            grade.setTextColor(Color.parseColor("#B71916"));
            nama.setTextColor(Color.parseColor("#B71916"));
            chakra.setTextColor(Color.parseColor("#B71916"));
            point.setTextColor(Color.parseColor("#B71916"));
            quality.setTextColor(Color.parseColor("#B71916"));
        }
        else if(grade.getText().toString().equalsIgnoreCase("A"))
        {
            GradientDrawable myGrade = (GradientDrawable) ll_grade.getBackground();
            myGrade.setStroke(convertDpToPx(2) , Color.parseColor("#8434DE"));

            GradientDrawable myQuality = (GradientDrawable) ll_quality.getBackground();
            myQuality.setStroke(convertDpToPx(2) , Color.parseColor("#8434DE"));

            GradientDrawable myPoint = (GradientDrawable) ll_point.getBackground();
            myPoint.setStroke(convertDpToPx(2) , Color.parseColor("#8434DE"));

            GradientDrawable myChakra = (GradientDrawable) ll_chakra.getBackground();
            myChakra.setStroke(convertDpToPx(2) , Color.parseColor("#8434DE"));


            grade.setTextColor(Color.parseColor("#8434DE"));
            nama.setTextColor(Color.parseColor("#8434DE"));
            chakra.setTextColor(Color.parseColor("#8434DE"));
            point.setTextColor(Color.parseColor("#8434DE"));
            quality.setTextColor(Color.parseColor("#8434DE"));
        }
        else if(grade.getText().toString().equalsIgnoreCase("B"))
        {
            GradientDrawable myGrade = (GradientDrawable) ll_grade.getBackground();
            myGrade.setStroke(convertDpToPx(2) , Color.parseColor("#2378D0"));

            GradientDrawable myQuality = (GradientDrawable) ll_quality.getBackground();
            myQuality.setStroke(convertDpToPx(2) , Color.parseColor("#2378D0"));

            GradientDrawable myPoint = (GradientDrawable) ll_point.getBackground();
            myPoint.setStroke(convertDpToPx(2) , Color.parseColor("#2378D0"));

            GradientDrawable myChakra = (GradientDrawable) ll_chakra.getBackground();
            myChakra.setStroke(convertDpToPx(2) , Color.parseColor("#2378D0"));


            grade.setTextColor(Color.parseColor("#2378D0"));
            nama.setTextColor(Color.parseColor("#2378D0"));
            chakra.setTextColor(Color.parseColor("#2378D0"));
            point.setTextColor(Color.parseColor("#2378D0"));
            quality.setTextColor(Color.parseColor("#2378D0"));
        }
        else if(grade.getText().toString().equalsIgnoreCase("C"))
        {
            GradientDrawable myGrade = (GradientDrawable) ll_grade.getBackground();
            myGrade.setStroke(convertDpToPx(2) , Color.parseColor("#29A600"));

            GradientDrawable myQuality = (GradientDrawable) ll_quality.getBackground();
            myQuality.setStroke(convertDpToPx(2) , Color.parseColor("#29A600"));

            GradientDrawable myPoint = (GradientDrawable) ll_point.getBackground();
            myPoint.setStroke(convertDpToPx(2) , Color.parseColor("#29A600"));

            GradientDrawable myChakra = (GradientDrawable) ll_chakra.getBackground();
            myChakra.setStroke(convertDpToPx(2) , Color.parseColor("#29A600"));


            grade.setTextColor(Color.parseColor("#29A600"));
            nama.setTextColor(Color.parseColor("#29A600"));
            chakra.setTextColor(Color.parseColor("#29A600"));
            point.setTextColor(Color.parseColor("#29A600"));
            quality.setTextColor(Color.parseColor("#29A600"));
        }
        else if(grade.getText().toString().equalsIgnoreCase("D"))
        {
            GradientDrawable myGrade = (GradientDrawable) ll_grade.getBackground();
            myGrade.setStroke(convertDpToPx(2) , Color.parseColor("#6B616B"));

            GradientDrawable myQuality = (GradientDrawable) ll_quality.getBackground();
            myQuality.setStroke(convertDpToPx(2) , Color.parseColor("#6B616B"));

            GradientDrawable myPoint = (GradientDrawable) ll_point.getBackground();
            myPoint.setStroke(convertDpToPx(2) , Color.parseColor("#6B616B"));

            GradientDrawable myChakra = (GradientDrawable) ll_chakra.getBackground();
            myChakra.setStroke(convertDpToPx(2) , Color.parseColor("#6B616B"));


            grade.setTextColor(Color.parseColor("#6B616B"));
            nama.setTextColor(Color.parseColor("#6B616B"));
            chakra.setTextColor(Color.parseColor("#6B616B"));
            point.setTextColor(Color.parseColor("#6B616B"));
            quality.setTextColor(Color.parseColor("#6B616B"));
        }

        if(intent.getStringExtra("varFotoDetail").isEmpty())
        {
            fotodetail.setImageResource(R.drawable.apiprof);
        }
        else
        {
            Picasso.get().load(intent.getStringExtra("varFotoDetail")).into(fotodetail);
        }


//        if(intent.getStringExtra("varBackground").isEmpty())
//        {
//            background.setBackgroundResource(R.drawable.skill_ss_one);
//        }
//        else
//        {
//            background.setBackground(Drawable.createFromPath("varBackground"));
//        }

//        Skill 1 - 5
        if(intent.getStringExtra("varSkill1").isEmpty())
        {
            skill1.setImageResource(R.drawable.skill_ss_one);
        }
        else
        {
            Picasso.get().load(intent.getStringExtra("varSkill1")).into(skill1);
        }

        if(intent.getStringExtra("varSkill2").isEmpty())
        {
            skill2.setImageResource(R.drawable.skill_ss_one);
        }
        else
        {
            Picasso.get().load(intent.getStringExtra("varSkill2")).into(skill2);
        }

        if(intent.getStringExtra("varSkill3").isEmpty())
        {
            skill3.setImageResource(R.drawable.skill_ss_one);
        }
        else
        {
            Picasso.get().load(intent.getStringExtra("varSkill3")).into(skill3);
        }

        if(intent.getStringExtra("varSkill4").isEmpty())
        {
            skill4.setImageResource(R.drawable.skill_ss_one);
        }
        else
        {
            Picasso.get().load(intent.getStringExtra("varSkill4")).into(skill4);
        }

        if(intent.getStringExtra("varSkill5").isEmpty())
        {
            skill5.setImageResource(R.drawable.skill_ss_one);
        }
        else
        {
            Picasso.get().load(intent.getStringExtra("varSkill5")).into(skill5);
        }

//        Summon 1 - 3
        if(intent.getStringExtra("varSummon1").isEmpty())
        {
            summon1.setImageResource(R.drawable.skill_ss_one);
        }
        else
        {
            Picasso.get().load(intent.getStringExtra("varSummon1")).into(summon1);
        }

        if(intent.getStringExtra("varSummon2").isEmpty())
        {
            summon2.setImageResource(R.drawable.skill_ss_one);
        }
        else
        {
            Picasso.get().load(intent.getStringExtra("varSummon2")).into(summon2);
        }

        if(intent.getStringExtra("varSummon3").isEmpty())
        {
            summon3.setImageResource(R.drawable.skill_ss_one);
        }
        else
        {
            Picasso.get().load(intent.getStringExtra("varSummon3")).into(summon3);
        }

//        Tailed 1-2
        if(intent.getStringExtra("varTailed1").isEmpty())
        {
            tailed1.setImageResource(R.drawable.skill_ss_one);
        }
        else
        {
            Picasso.get().load(intent.getStringExtra("varTailed1")).into(tailed1);
        }

        if(intent.getStringExtra("varTailed2").isEmpty())
        {
            tailed2.setImageResource(R.drawable.skill_ss_one);
        }
        else
        {
            Picasso.get().load(intent.getStringExtra("varTailed2")).into(tailed2);
        }


    }

    private int convertDpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
}
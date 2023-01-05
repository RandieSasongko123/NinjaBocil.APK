package com.example.ninjabocil.models;

import android.widget.ImageView;
import android.widget.TextView;

public class ninja {

    private String nama, chakra, grade, fotohero, quality, id, point, fotodetail, background;
    private String[] skill = new String[5];
    private String[] summon = new String[3];
    private String[] tailed = new String[2];

    public String getId() {
        return id;
    }

    public String getPoint() {
        return point;
    }

    public String getFotodetail() {
        return fotodetail;
    }

    public String getBackground() {
        return background;
    }

    public String getNama() {
        return nama;
    }

    public String getChakra() {
        return chakra;
    }

    public String getGrade() {
        return grade;
    }

    public String getFotohero() {
        return fotohero;
    }

    public String getQuality() {
        return quality;
    }

    public String[] getSkill() {
        return skill;
    }

    public String[] getSummon() {
        return summon;
    }

    public String[] getTailed() {
        return tailed;
    }
}

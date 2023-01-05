package com.example.ninjabocil.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class Search_bar extends LinearLayout {

    public Search_bar(Context context) {
        super(context);
    }

    public Search_bar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setGravity(Gravity.CENTER);
    }

    public Search_bar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Search_bar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}

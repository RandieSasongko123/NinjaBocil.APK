package com.example.ninjabocil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Handler;
import android.view.Window;

import com.example.ninjabocil.activity.MainActivity;

public class splashtest extends AppCompatActivity {

//    ProgressBar progressBar;
//    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        progressBar = findViewById(R.id.pb_splash);
//
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                startProgress();
//            }
//        });
//        thread.start();

        //menghilangkan ActionBar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splashtest);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }, 2000L); //3000 L = 3 detik

    }

//    public void startProgress(){
//        for(value=0;value<=100;value=value+1) {
//            try {
//                Thread.sleep(50);
//                progressBar.setProgress(value);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }

}
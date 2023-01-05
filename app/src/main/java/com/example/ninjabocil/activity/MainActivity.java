package com.example.ninjabocil.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.NotificationChannel;
import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.ninjabocil.R;
import com.example.ninjabocil.fragment.AboutFragment;
import com.example.ninjabocil.fragment.HeroFragment;
import com.example.ninjabocil.fragment.HomeFragment;
import com.example.ninjabocil.fragment.SkillFragment;
import com.example.ninjabocil.fragment.TailedBeastFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity  {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new HomeFragment());

        BottomNavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setSelectedItemId(R.id.fr_home);
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId())
                {
                    case R.id.fr_home:
                        fragment = new HomeFragment();
                        break;

                    case R.id.fr_dashboard:
                        fragment = new TailedBeastFragment();
                        break;

                    case R.id.fr_hero:
                        fragment = new HeroFragment();
                        break;

                    case R.id.fr_info:
                        fragment = new AboutFragment();
                        break;

                    case R.id.fr_menuBook:
                        fragment = new SkillFragment();
                        break;
                }
                return loadFragment(fragment);
            }
        });
    }

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        Fragment fragment = null;
//
//        switch (item.getItemId())
//        {
//            case R.id.fr_home:
//                fragment = new HomeFragment();
//                break;
//
//            case R.id.fr_dashboard:
//                fragment = new TailedBeastFragment();
//                break;
//
//            case R.id.fr_hero:
//                fragment = new HeroFragment();
//                break;
//
//            case R.id.fr_info:
//                fragment = new AboutFragment();
//                break;
//
//            case R.id.fr_menuBook:
//                fragment = new SkillFragment();
//                break;
//        }
//        return loadFragment(fragment);
//    }

    private boolean loadFragment(Fragment fragment) {

        if(fragment != null)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
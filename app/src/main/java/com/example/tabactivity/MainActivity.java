package com.example.tabactivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tl;
    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tl = findViewById(R.id.tabLayout);
        vp = findViewById(R.id.viewpager);
        Vpadapter vpadapter = new Vpadapter(getSupportFragmentManager());
        vp.setAdapter(vpadapter);
        tl.setupWithViewPager(vp);

    }

    class Vpadapter extends FragmentStatePagerAdapter
    {

        public Vpadapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: return new RedFragment();
                case 1: return new GreenFragment();
                case 2: return new YellowFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0: return "Red";
                case 1: return "Green";
                case 2: return "Yellow";
            }
            return "null";
        }
    }


}
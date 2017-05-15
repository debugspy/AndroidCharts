package com.example.leidong.androidcharts;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.leidong.androidcharts.fragments.RadarFragment;

/**
 * Created by leidong on 2017/5/12.
 */

public class RadarActivity extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radar);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        RadarFragment radarFragment = new RadarFragment();
        transaction.replace(R.id.radarchart, radarFragment);
        transaction.commit();
    }
}

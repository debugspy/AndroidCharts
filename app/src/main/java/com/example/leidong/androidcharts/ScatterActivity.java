package com.example.leidong.androidcharts;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.leidong.androidcharts.fragments.ScatterFragment;

/**
 * Created by leidong on 2017/5/12.
 */

public class ScatterActivity extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scatter);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        ScatterFragment scatterFragment = new ScatterFragment();
        transaction.replace(R.id.scatterchart, scatterFragment);
        transaction.commit();
    }
}

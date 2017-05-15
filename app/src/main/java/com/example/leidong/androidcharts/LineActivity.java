package com.example.leidong.androidcharts;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.leidong.androidcharts.fragments.LineFragment;

/**
 * Created by leidong on 2017/5/12.
 */

public class LineActivity extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        LineFragment lineFragment = new LineFragment();
        transaction.replace(R.id.linechart, lineFragment);
        transaction.commit();
    }
}

package com.example.leidong.androidcharts;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.leidong.androidcharts.fragments.BubbleFragment;

/**
 * Created by leidong on 2017/5/12.
 */

public class BubbleActivity extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        BubbleFragment bubbleFragment = new BubbleFragment();
        transaction.replace(R.id.bubblechart, bubbleFragment);
        transaction.commit();
    }
}

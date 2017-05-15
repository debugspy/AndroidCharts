package com.example.leidong.androidcharts;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.leidong.androidcharts.fragments.PieFragment;

/**
 * Created by leidong on 2017/5/12.
 */

public class PieActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie);

        initWidgets();
        initAction();
    }

    /**
     * 初始化动作
     */
    private void initAction() {
        button.setOnClickListener(this);
    }

    /**
     * 获取组件
     */
    private void initWidgets() {
        button = (Button) findViewById(R.id.button);
    }

    /**
     * 按钮点击
     * @param v
     */
    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (v.getId()){
            case R.id.button:
                PieFragment pieFragment = new PieFragment();
                transaction.replace(R.id.piechart, pieFragment);
                transaction.commit();
                break;
            default:
                break;
        }
    }
}

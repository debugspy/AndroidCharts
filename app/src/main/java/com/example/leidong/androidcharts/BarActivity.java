package com.example.leidong.androidcharts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by leidong on 2017/5/12.
 */

public class BarActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button1, button2;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);
        initWigits();
        initActions();
    }

    /**
     * 初始化操作
     */
    private void initActions() {
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    /**
     * 初始化控件
     */
    private void initWigits() {
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
    }


    /**
     * 对按钮的点击监控
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                clickButton1();
                break;
            case R.id.button2:
                clickButton2();
                break;
            default:
                break;
        }
    }

    /**
     * 点击按钮1
     */
    private void clickButton1() {
    }

    /**
     * 点击按钮2
     */
    private void clickButton2() {
    }
}

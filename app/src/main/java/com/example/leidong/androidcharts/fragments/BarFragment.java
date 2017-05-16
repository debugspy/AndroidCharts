package com.example.leidong.androidcharts.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.leidong.androidcharts.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;

/**
 * Created by leidong on 2017/5/14.
 */

public class BarFragment extends Fragment {
    private BarChart barChart;
    private BarData barData;
    //X轴数据
    private ArrayList<String> xDatas = new ArrayList<>();
    //Y轴数据
    private ArrayList<BarEntry> yDatas = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for(int i = 0; i < 12; i++){
            xDatas.add((i+1) + "月");
            yDatas.add(new BarEntry((float) (Math.random()*1000), i));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceStets){
        super.onCreateView(inflater, container, savedInstanceStets);
        View view = inflater.inflate(R.layout.bar_fragment, container, false);
        barChart = (BarChart) view.findViewById(R.id.barchart);
        barData = getBarData();
        showBarChart(barChart, barData);

        return view;
    }

    /**
     * 显示柱状图
     * @param barChart
     * @param barData
     */
    private void showBarChart(BarChart barChart, BarData barData) {
        barChart.setDrawBorders(false);//不画边框
        barChart.setDescription("一组数据的柱状图");//Description内容
        barChart.setDescriptionPosition(760, 70);
        barChart.setDescriptionTextSize(40);
        barChart.setNoDataText("数据为空，请传入数据！！！");
        barChart.setDrawGridBackground(false);//不画网格背景
        barChart.setTouchEnabled(true);//允许触摸
        barChart.setDragEnabled(true);//允许拖拽
        barChart.setScaleEnabled(true);//允许缩放
        barChart.setPinchZoom(false);//false，X、Y轴单独缩放
        barChart.getAxisLeft().setAxisMinValue(0.0f);

        //配置图例
        Legend legend = barChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);//图例颜色块形状
        legend.setFormSize(14);//颜色快大小
        legend.setTextSize(14);//图例字体
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART_INSIDE);//图例位置

        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//X轴位置

        YAxis yAxisRight = barChart.getAxisRight();
        yAxisRight.setEnabled(false);//禁用右侧Y轴

        barChart.animateXY(1000, 1000);//设置动画，X轴1秒，Y轴1秒

        barData.setValueTextSize(12);//BarData字体
        barData.setValueTextColor(Color.RED);//BarData颜色

        barChart.setData(barData);//填充数据
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    /**
     * 得到柱状图得数据
     * @return
     */
    public BarData getBarData() {
        BarDataSet barDataSet = new BarDataSet(yDatas, "Y轴数据");
        barDataSet.setColor(Color.GREEN);//设置柱子颜色

        ArrayList<IBarDataSet> barDataSets = new ArrayList<>();
        barDataSets.add(barDataSet);

        BarData barData = new BarData(xDatas, barDataSets);//填充BarData
        return barData;
    }
}

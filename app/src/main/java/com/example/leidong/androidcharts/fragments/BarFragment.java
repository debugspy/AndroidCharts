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
    private ArrayList<String> xDatas = new ArrayList<>();
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
        barChart.setDrawBorders(false);
        barChart.setDescription(null);
        barChart.setNoDataText("数据为空，请传入数据！！！");
        barChart.setDrawGridBackground(false);
        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);
        barChart.setPinchZoom(false);

        Legend legend = barChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setFormSize(14);
        legend.setTextSize(14);
        legend.setPosition(Legend.LegendPosition.ABOVE_CHART_CENTER);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        YAxis yAxisRight = barChart.getAxisRight();
        yAxisRight.setEnabled(false);

        barChart.animateXY(1000, 1000);

        barData.setValueTextSize(12);
        barData.setValueTextColor(Color.RED);

        barChart.setData(barData);
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
        barDataSet.setColor(Color.GREEN);

        ArrayList<IBarDataSet> barDataSets = new ArrayList<>();
        barDataSets.add(barDataSet);

        BarData barData = new BarData(xDatas, barDataSets);
        return barData;
    }
}

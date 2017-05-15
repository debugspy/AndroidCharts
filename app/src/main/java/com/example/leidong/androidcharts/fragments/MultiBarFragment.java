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

public class MultiBarFragment extends Fragment{
    private BarChart barChart;
    private BarData barData;
    private ArrayList<String> xDatas = new ArrayList<>();
    private ArrayList<BarEntry> yDatas1 = new ArrayList<>();
    private ArrayList<BarEntry> yDatas2 = new ArrayList<>();
    private ArrayList<BarEntry> yDatas3 = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        for(int i = 0; i < 12; i++){
            xDatas.add((i+1) + "月");
            yDatas1.add(new BarEntry((float) (Math.random()*1000), i));
            yDatas2.add(new BarEntry((float) (Math.random()*1000), i));
            yDatas3.add(new BarEntry((float) (Math.random()*1000), i));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.multi_bar_fragment, container, false);

        barChart = (BarChart) view.findViewById(R.id.multibarchart);
        barData = getBarData();
        showBarChart(barChart, barData);

        return view;
    }

    /**
     * 展示柱状图
     * @param barChart
     * @param barData
     */
    private void showBarChart(BarChart barChart, BarData barData) {
        barChart.setDrawBorders(false);
        barChart.setPinchZoom(false);
        barChart.setDrawGridBackground(false);
        barChart.setScaleEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setTouchEnabled(true);
        barChart.setNoDataText("数据为空，请传入数据！！！");
        barChart.setDescription(null);
        barChart.setPinchZoom(false);
        barChart.fitScreen();

        barData.setValueTextSize(12);
        barData.setValueTextColor(Color.BLUE);

        Legend legend = barChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setFormSize(14);
        legend.setTextSize(14);
        legend.setPosition(Legend.LegendPosition.ABOVE_CHART_CENTER);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAvoidFirstLastClipping(true);

        YAxis yAxisRight = barChart.getAxisRight();
        yAxisRight.setEnabled(false);

        barChart.animateXY(1000, 1000);

        barChart.setData(barData);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    /**
     * 获取柱状图片数据
     * @return
     */
    public BarData getBarData() {
        BarDataSet barDataSet1 = new BarDataSet(yDatas1, "第一组数据");
        barDataSet1.setColor(Color.GREEN);
        BarDataSet barDataSet2 = new BarDataSet(yDatas2, "第二组数据");
        barDataSet2.setColor(Color.YELLOW);
        BarDataSet barDataSet3 = new BarDataSet(yDatas3, "第三组数据");
        barDataSet3.setColor(Color.RED);

        ArrayList<IBarDataSet> barDataSets = new ArrayList<>();
        barDataSets.add(barDataSet1);
        barDataSets.add(barDataSet2);
        barDataSets.add(barDataSet3);

        BarData barData = new BarData(xDatas, barDataSets);

        return barData;
    }
}

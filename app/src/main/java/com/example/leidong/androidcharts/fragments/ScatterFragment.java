package com.example.leidong.androidcharts.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.leidong.androidcharts.R;
import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import java.util.ArrayList;

/**
 * Created by leidong on 2017/5/15.
 */

public class ScatterFragment extends Fragment{
    private ScatterChart scatterChart;
    private ScatterData scatterData;
    private ArrayList<String> xDatas = new ArrayList<>();
    private ArrayList<Entry> yDatas1 = new ArrayList<>();
    private ArrayList<Entry> yDatas2 = new ArrayList<>();
    private ArrayList<Entry> yDatas3 = new ArrayList<>();
    private ArrayList<Entry> yDatas4 = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        for(int i = 0; i < 12; i++){
            xDatas.add((i+1) + "月");
            yDatas1.add(new Entry(i, (int) (Math.random()*10)));
            yDatas2.add(new Entry(i+0.33f, (int) (Math.random()*10)));
            yDatas3.add(new Entry(i+0.66f, (int) (Math.random()*10)));
            yDatas4.add(new Entry(i+0.99f, (int) (Math.random()*10)));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.scatterchart_f, container, false);
        scatterChart = (ScatterChart) view.findViewById(R.id.scatterchart_f);
        scatterData = getScatterData();
        showScatterChart(scatterChart, scatterData);
        return view;
    }

    /**
     * 展示散点图
     * @param scatterChart
     * @param scatterData
     */
    private void showScatterChart(ScatterChart scatterChart, ScatterData scatterData) {
        scatterChart.animateXY(1000, 1000);
        scatterChart.setDrawBorders(false);
        scatterChart.setPinchZoom(false);
        scatterChart.setDescription("散点图");
        scatterChart.setDescriptionTextSize(40);
        scatterChart.setDescriptionPosition(759, 70);
        scatterChart.setDrawGridBackground(false);
        scatterChart.getAxisLeft().setAxisMinValue(0.0f);

        XAxis xAxis = scatterChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        YAxis yAxisRight = scatterChart.getAxisRight();
        yAxisRight.setEnabled(false);

        Legend legend = scatterChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART_INSIDE);

        scatterChart.setData(scatterData);
        scatterChart.invalidate();
    }

    /**
     * 得到数据
     * @return
     */
    public ScatterData getScatterData() {
        ScatterDataSet scatterDataSet1 = new ScatterDataSet(yDatas1, "第一组数据");
        scatterDataSet1.setColor(Color.rgb(255, 51, 153));
        scatterDataSet1.setScatterShape(ScatterChart.ScatterShape.CIRCLE);
        scatterDataSet1.setScatterShapeSize((float) (Math.random()*30));
        ScatterDataSet scatterDataSet2 = new ScatterDataSet(yDatas2, "第二组数据");
        scatterDataSet2.setColor(Color.rgb(255, 255, 51));
        scatterDataSet1.setScatterShape(ScatterChart.ScatterShape.CIRCLE);
        scatterDataSet1.setScatterShapeSize((float) (Math.random()*30));
        ScatterDataSet scatterDataSet3 = new ScatterDataSet(yDatas3, "第三组数据");
        scatterDataSet3.setColor(Color.rgb(102, 0, 255));
        scatterDataSet1.setScatterShape(ScatterChart.ScatterShape.CIRCLE);
        scatterDataSet1.setScatterShapeSize((float) (Math.random()*30));
        ScatterDataSet scatterDataSet4 = new ScatterDataSet(yDatas4, "第四组数据");
        scatterDataSet4.setColor(Color.rgb(0, 255, 102));
        scatterDataSet1.setScatterShape(ScatterChart.ScatterShape.CIRCLE);
        scatterDataSet1.setScatterShapeSize((float) (Math.random()*30));

        ArrayList<IScatterDataSet> scatterDataSets = new ArrayList<>();
        scatterDataSets.add(scatterDataSet1);
        scatterDataSets.add(scatterDataSet2);
        scatterDataSets.add(scatterDataSet3);
        scatterDataSets.add(scatterDataSet4);

        ScatterData scatterData = new ScatterData(xDatas, scatterDataSets);
        return scatterData;
    }
}

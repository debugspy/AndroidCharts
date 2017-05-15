package com.example.leidong.androidcharts.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leidong.androidcharts.R;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;

import java.util.ArrayList;

/**
 * Created by leidong on 2017/5/15.
 */

public class RadarFragment extends Fragment{
    private RadarChart radarChart;
    private RadarData radarData;
    private ArrayList<String> xDatas = new ArrayList<>();
    private ArrayList<Entry> yDatas1 = new ArrayList<>();
    private ArrayList<Entry> yDatas2 = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        for(int i = 0; i < 12; i++){
            xDatas.add("属性" + (i+1));
            yDatas1.add(new Entry((float) (Math.random()*10), i));
            yDatas2.add(new Entry((float) (Math.random()*10), i));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.radar_fragment, container, false);
        radarChart = (RadarChart) view.findViewById(R.id.radarchart_f);
        radarData = getRadarData();
        showRadarChart(radarChart, radarData);
        return view;
    }

    /**
     * 显示雷达图
     * @param radarChart
     * @param radarData
     */
    private void showRadarChart(RadarChart radarChart, RadarData radarData) {
        radarChart.setDescription("雷达图");
        radarChart.setRotationEnabled(true);
        radarChart.setDescriptionPosition(750, 70);
        radarChart.setDescriptionTextSize(50);
        radarChart.setDrawWeb(true);
        radarChart.setBackgroundColor(Color.rgb(255, 102, 0));
        radarChart.setWebLineWidth(1);
        radarChart.setWebColor(Color.rgb(255, 255, 0));
        radarChart.setWebColorInner(Color.rgb(255, 255, 0));
        radarChart.setWebLineWidthInner(1);

        Legend legend = radarChart.getLegend();
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART_INSIDE);
        legend.setForm(Legend.LegendForm.CIRCLE);



        radarChart.setData(radarData);
        radarChart.invalidate();
    }

    /**
     * 得到数据
     * @return
     */
    public RadarData getRadarData() {
        RadarDataSet radarDataSet1 = new RadarDataSet(yDatas1, "第一组属性");
        radarDataSet1.setColor(Color.rgb(255, 99, 71));
        radarDataSet1.setFillColor(Color.rgb(255, 174, 185));
        radarDataSet1.setDrawFilled(true);
        radarDataSet1.setFillAlpha(180);
        radarDataSet1.setLineWidth(2f);
        radarDataSet1.setDrawHighlightCircleEnabled(true);
        radarDataSet1.setDrawHighlightIndicators(false);

        RadarDataSet radarDataSet2 = new RadarDataSet(yDatas2, "第二组属性");
        radarDataSet2.setColor(Color.rgb(121, 162, 175));
        radarDataSet2.setFillColor(Color.rgb(147, 112, 219));
        radarDataSet2.setDrawFilled(true);
        radarDataSet2.setFillAlpha(180);
        radarDataSet2.setLineWidth(2f);
        radarDataSet2.setDrawHighlightCircleEnabled(true);
        radarDataSet2.setDrawHighlightIndicators(false);

        ArrayList<IRadarDataSet> radarDataSets = new ArrayList<>();
        radarDataSets.add(radarDataSet1);
        radarDataSets.add(radarDataSet2);

        RadarData radarData = new RadarData(xDatas, radarDataSets);
        return radarData;
    }
}

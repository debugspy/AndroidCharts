package com.example.leidong.androidcharts.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leidong.androidcharts.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

/**
 * Created by leidong on 2017/5/15.
 */

public class LineFragment extends Fragment {
    private LineChart lineChart;
    private LineData lineData;
    private ArrayList<String> xDatas = new ArrayList<>();
    private ArrayList<Entry> yDatas = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        for(int i = 0; i < 10; i++){
            xDatas.add("第"+(i+1)+"天");
            yDatas.add(new Entry((float) (Math.random()*1000), i));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.line_fragment, container, false);

        lineChart = (LineChart) view.findViewById(R.id.linechart_f);
        lineData = getLineData();
        showLineChart(lineChart, lineData);
        return view;
    }

    /**
     * 显示折线图
     * @param lineChart
     * @param lineData
     */
    private void showLineChart(LineChart lineChart, LineData lineData) {
        lineChart.setDoubleTapToZoomEnabled(false);
        lineChart.setPinchZoom(false);
        lineChart.setDrawBorders(false);
        lineChart.setScaleEnabled(false);
        lineChart.setDrawGridBackground(false);
        lineChart.setDescription("折线图");
        lineChart.setDescriptionPosition(750, 70);
        lineChart.setDescriptionTextSize(40);

        YAxis yAxisRight = lineChart.getAxisRight();
        yAxisRight.setEnabled(false);

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(12);

        Legend legend = lineChart.getLegend();
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART_INSIDE);
        legend.setForm(Legend.LegendForm.CIRCLE);

        lineChart.setData(lineData);
    }

    /**
     * 获取数据
     * @return
     */
    public LineData getLineData() {
        LineDataSet lineDataSet = new LineDataSet(yDatas, "");
        lineDataSet.setColor(Color.BLUE);
        lineDataSet.setDrawCircleHole(true);
        lineDataSet.setCircleRadius(4);
        lineDataSet.setCircleColor(Color.RED);
        lineDataSet.setLineWidth(2);

        LineData lineData = new LineData(xDatas, lineDataSet);
        lineData.setValueTextSize(12);
        return lineData;
    }
}

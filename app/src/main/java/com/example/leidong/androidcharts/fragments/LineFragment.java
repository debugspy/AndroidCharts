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
    //X轴数据
    private ArrayList<String> xDatas = new ArrayList<>();
    //Y轴数据
    private ArrayList<Entry> yDatas = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        for(int i = 0; i < 20; i++){
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
        lineChart.setDoubleTapToZoomEnabled(false);//禁止双击放大
        lineChart.setDrawBorders(false);//不画边界
        lineChart.setScaleEnabled(false);//禁止缩放
        lineChart.setDrawGridBackground(false);//不画网格背景
        lineChart.setDescription("折线图");//Description内容
        lineChart.setDescriptionPosition(750, 70);//Description位置
        lineChart.setDescriptionTextSize(40);//Description字体
        lineChart.animateXY(1000, 1000);//动画，X轴1秒，Y轴1秒

        YAxis yAxisRight = lineChart.getAxisRight();
        yAxisRight.setEnabled(false);//禁用Y轴右边

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//X轴放置位置
        xAxis.setTextSize(12);//设置X轴字体

        //图例配置
        Legend legend = lineChart.getLegend();
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART_INSIDE);//图例位置
        legend.setForm(Legend.LegendForm.CIRCLE);//图例颜色块形状

        lineChart.setData(lineData);//填充数据
    }

    /**
     * 获取数据
     * @return
     */
    public LineData getLineData() {
        LineDataSet lineDataSet = new LineDataSet(yDatas, "");
        lineDataSet.setColor(Color.BLUE);//设置折线练习按颜色
        lineDataSet.setDrawCircleHole(true);//设置数据点圆形显示
        lineDataSet.setCircleRadius(4);//数据点半径
        lineDataSet.setCircleColor(Color.RED);//数据点颜色
        lineDataSet.setLineWidth(2);//设置支线线宽

        LineData lineData = new LineData(xDatas, lineDataSet);
        lineData.setValueTextSize(12);
        return lineData;
    }
}

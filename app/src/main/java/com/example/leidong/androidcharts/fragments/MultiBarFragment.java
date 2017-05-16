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
    //X轴数据
    private ArrayList<String> xDatas = new ArrayList<>();
    //Y轴数据
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
     * 配置并展示柱状图
     * @param barChart
     * @param barData
     */
    private void showBarChart(BarChart barChart, BarData barData) {
        barChart.setDrawBorders(false);//不画边界
        barChart.setPinchZoom(false);//false时，x轴和y轴可以单独缩放，反之你懂的
        barChart.setDrawGridBackground(false);//不画网格背景
        barChart.setScaleEnabled(true);//能够缩放
        barChart.setDragEnabled(true);//允许拖拽
        barChart.setTouchEnabled(true);//允许触摸
        barChart.setNoDataText("数据为空，请传入数据！！！");//当不传入任何数据时，提示消息
        barChart.setDescription("多组数据柱状图");//Description内容
        barChart.setDescriptionTextSize(40);//Description字体大小
        barChart.setDescriptionPosition(750, 70);//Description位置
        barChart.setPinchZoom(false);//false时X轴和Y轴可以单独缩放
        barChart.fitScreen();//适应屏幕
        barData.setValueTextSize(12);//柱子上的字体大小
        barData.setValueTextColor(Color.BLUE);//柱子上的字的颜色
        barChart.getAxisLeft().setAxisMinValue(0.0f);

        //图例配置
        Legend legend = barChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);//图例颜色块形状
        legend.setFormSize(14);//颜色快大小
        legend.setTextSize(14);//颜色快说明字体
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART_INSIDE);//图例位置

        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//X轴放在最底部
        xAxis.setAvoidFirstLastClipping(true);//防止最左边和最右边的柱子被切割造成不完整

        YAxis yAxisRight = barChart.getAxisRight();
        yAxisRight.setEnabled(false);//禁止右边的Y轴使用

        barChart.animateXY(1000, 1000);//动画X轴1秒，Y轴1秒

        barChart.setData(barData);//填充数据
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
        barDataSet1.setColor(Color.GREEN);//第一组柱子颜色
        BarDataSet barDataSet2 = new BarDataSet(yDatas2, "第二组数据");
        barDataSet2.setColor(Color.YELLOW);//第二组柱子颜色
        BarDataSet barDataSet3 = new BarDataSet(yDatas3, "第三组数据");
        barDataSet3.setColor(Color.RED);//第三组柱子颜色

        ArrayList<IBarDataSet> barDataSets = new ArrayList<>();
        barDataSets.add(barDataSet1);
        barDataSets.add(barDataSet2);
        barDataSets.add(barDataSet3);

        BarData barData = new BarData(xDatas, barDataSets);//生成BarData

        return barData;
    }
}

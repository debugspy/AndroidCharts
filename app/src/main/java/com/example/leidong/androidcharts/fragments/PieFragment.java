package com.example.leidong.androidcharts.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leidong.androidcharts.R;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by leidong on 2017/5/14.
 */

public class PieFragment extends Fragment {
    private PieChart pieChart;
    private PieData pieData;
    //X轴数据
    private ArrayList<String> names = new ArrayList<>();
    //Y轴数据
    private ArrayList<Entry> counts = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        names.add("五毒");
        names.add("天香");
        names.add("真武");
        names.add("神刀");
        names.add("唐门");
        names.add("太白");
        names.add("丐帮");
        names.add("神威");

        counts.add(new Entry(12,0));
        counts.add(new Entry(4, 1));
        counts.add(new Entry(8, 2));
        counts.add(new Entry(16, 3));
        counts.add(new Entry(22, 4));
        counts.add(new Entry(18, 5));
        counts.add(new Entry(9, 6));
        counts.add(new Entry(11, 7));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.pie_fragment, container, false);

        pieChart = (PieChart) view.findViewById(R.id.piechart_f);
        pieData = getPieData();
        showPieChart(pieChart, pieData);
        return view;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    /**
     * 显示饼图
     * @param pieChart
     * @param pieData
     */
    private void showPieChart(PieChart pieChart, PieData pieData) {
        pieChart.setData(pieData);
        pieChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);//设置显示动画，转一圈
    }


    /**
     * 得到饼图数据
     * @return
     */
    public PieData getPieData() {
        //Configure pie chart
        pieChart.setUsePercentValues(true);//显示百分比格式
        pieChart.setDescription("饼图");//Description内容
        pieChart.setDescriptionPosition(750, 70);//Description位置
        pieChart.setDescriptionTextSize(40);//Description字体

        //饼图中间的小圆配置
        pieChart.setDrawHoleEnabled(true);//允许饼图中间有小圆
        pieChart.setHoleColor(Color.TRANSPARENT);//饼图中间小圆透明
        pieChart.setHoleRadius(20);//中间小圆的半径
        pieChart.setTransparentCircleRadius(23);//这个自己试，是中间小圆套着的外面一层圆
        pieChart.setCenterText("八荒门派");//中间文字

        //允许旋转
        pieChart.setRotationEnabled(true);
        pieChart.setRotationAngle(0);

        //配置图例
        Legend legend = pieChart.getLegend();
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART_INSIDE);//图例位置
        legend.setForm(Legend.LegendForm.CIRCLE);//设置图例颜色块形状
        legend.setTextSize(12);//设置图例字体

        PieDataSet pieDataSet = new PieDataSet(counts, "");
        pieDataSet.setSliceSpace(3);//扇形间距
        pieDataSet.setSelectionShift(15);//设置点击突出距离

        //添加颜色
        ArrayList<Integer> cs = new ArrayList<>();
        for (int c : ColorTemplate.VORDIPLOM_COLORS) {
            cs.add(c);
        }
        for (int c : ColorTemplate.JOYFUL_COLORS) {
            cs.add(c);
        }
        for (int c : ColorTemplate.COLORFUL_COLORS) {
            cs.add(c);
        }
        for (int c : ColorTemplate.LIBERTY_COLORS) {
            cs.add(c);
        }
        for (int c : ColorTemplate.PASTEL_COLORS) {
            cs.add(c);
        }
        cs.add(ColorTemplate.getHoloBlue());
        pieDataSet.setColors(cs);

        PieData pieData = new PieData(names, pieDataSet);
        pieData.setValueFormatter(new PercentFormatter());
        pieData.setValueTextSize(14f);//PieData字体
        pieData.setValueTextColor(Color.BLACK);//PieData字体颜色
        pieData.setHighlightEnabled(true);//高亮显示
        return pieData;
    }
}

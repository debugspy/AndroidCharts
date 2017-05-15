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
    private ArrayList<String> names = new ArrayList<>();
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

        counts.add(new Entry(2,0));
        counts.add(new Entry(4, 1));
        counts.add(new Entry(8, 2));
        counts.add(new Entry(16, 3));
        counts.add(new Entry(32, 4));
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
        pieChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        pieChart.invalidate();
    }


    /**
     * 得到饼图数据
     * @return
     */
    public PieData getPieData() {
        //Configure pie chart
        pieChart.setUsePercentValues(true);
        pieChart.setDescription(null);

        //Enable hole
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.TRANSPARENT);
        pieChart.setHoleRadius(20);
        pieChart.setTransparentCircleRadius(23);
        pieChart.setCenterText("八荒门派");

        //Enable rotation of the chart by touch
        pieChart.setRotationEnabled(true);
        pieChart.setRotationAngle(0);

        Legend legend = pieChart.getLegend();
        legend.setPosition(Legend.LegendPosition.ABOVE_CHART_CENTER);
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setTextSize(12);

        PieDataSet pieDataSet = new PieDataSet(counts, "各门派玩家数目占比");
        pieDataSet.setSliceSpace(3);
        pieDataSet.setSelectionShift(15);

        //Add many colors
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
        pieData.setValueTextSize(14f);
        pieData.setValueTextColor(Color.BLACK);
        pieData.setHighlightEnabled(true);
        return pieData;
    }
}

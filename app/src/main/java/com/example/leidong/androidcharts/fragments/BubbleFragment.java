package com.example.leidong.androidcharts.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.leidong.androidcharts.R;
import com.github.mikephil.charting.charts.BubbleChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleDataSet;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import java.util.ArrayList;

/**
 * Created by leidong on 2017/5/15.
 */

public class BubbleFragment extends Fragment{
    private BubbleChart bubbleChart;
    private BubbleData bubbleData;
    private ArrayList<String> xDatas = new ArrayList<>();
    private ArrayList<BubbleEntry> yDatas1 = new ArrayList<>();
    private ArrayList<BubbleEntry> yDatas2 = new ArrayList<>();
    private ArrayList<BubbleEntry> yDatas3 = new ArrayList<>();
    private ArrayList<BubbleEntry> yDatas4 = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        for(int i = 0; i < 12; i++){
            xDatas.add((i+1) + "月");
            yDatas1.add(new BubbleEntry(i, (float) Math.random()*100, (float) Math.random()*30));
            yDatas2.add(new BubbleEntry(i, (float) Math.random()*100, (float) Math.random()*30));
            yDatas3.add(new BubbleEntry(i, (float) Math.random()*100, (float) Math.random()*30));
            yDatas4.add(new BubbleEntry(i, (float) Math.random()*100, (float) Math.random()*30));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.bubble_fragment, container, false);
        bubbleChart = (BubbleChart) view.findViewById(R.id.bubblechart_f);
        bubbleData = getBubbleData();
        showBubbleChart(bubbleChart, bubbleData);
        return view;
    }

    /**
     * 展示气泡图
     * @param bubbleChart
     * @param bubbleData
     */
    private void showBubbleChart(BubbleChart bubbleChart, BubbleData bubbleData) {
        bubbleChart.setDrawBorders(false);
        bubbleChart.setDrawGridBackground(false);
        bubbleChart.setDescription("气泡图");
        bubbleChart.setDescriptionPosition(750, 70);
        bubbleChart.setPinchZoom(false);
        bubbleChart.setDescriptionTextSize(40);
        bubbleChart.animateXY(1000, 1000);

        XAxis xAxis = bubbleChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        YAxis yAxisRight = bubbleChart.getAxisRight();
        yAxisRight.setEnabled(false);

        Legend legend = bubbleChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART_INSIDE);

        bubbleChart.setData(bubbleData);
        bubbleChart.invalidate();
    }

    /**
     * 得到气泡图数据
     * @return
     */
    public BubbleData getBubbleData() {
        BubbleDataSet bubbleDataSet1 = new BubbleDataSet(yDatas1, "第一组气泡");
        bubbleDataSet1.setColor(Color.rgb(255, 51, 153));
        bubbleDataSet1.setValueTextSize(8);
        BubbleDataSet bubbleDataSet2 = new BubbleDataSet(yDatas2, "第二组气泡");
        bubbleDataSet2.setColor(Color.rgb(255, 255, 51));
        bubbleDataSet2.setValueTextSize(8);
        BubbleDataSet bubbleDataSet3 = new BubbleDataSet(yDatas3, "第三组气泡");
        bubbleDataSet3.setColor(Color.rgb(102, 0, 255));
        bubbleDataSet3.setValueTextSize(8);
        BubbleDataSet bubbleDataSet4 = new BubbleDataSet(yDatas4, "第四组气泡");
        bubbleDataSet4.setColor(Color.rgb(0, 255, 102));
        bubbleDataSet4.setValueTextSize(8);

        ArrayList<IBubbleDataSet> bubbleDataSets = new ArrayList<>();
        bubbleDataSets.add(bubbleDataSet1);
        bubbleDataSets.add(bubbleDataSet2);
        bubbleDataSets.add(bubbleDataSet3);
        bubbleDataSets.add(bubbleDataSet4);

        BubbleData bubbleData = new BubbleData(xDatas, bubbleDataSets);
        return bubbleData;
    }
}

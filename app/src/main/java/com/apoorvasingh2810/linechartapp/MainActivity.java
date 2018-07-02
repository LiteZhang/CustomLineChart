package com.apoorvasingh2810.linechartapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG= "MainActivity";

    private LineChart mChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    mChart=(LineChart)findViewById(R.id.lineChart);

//    mChart.setOnChartGestureListener(MainActivity.this);
//    mChart.setOnChartValueSelectedListener(MainActivity.this);

    mChart.setDragEnabled(true);
    mChart.setScaleEnabled(false);

        ArrayList<Entry> yValues= new ArrayList<>();

        yValues.add(new Entry(0,99f));
        yValues.add(new Entry(1,19f));
        yValues.add(new Entry(2,66f));
        yValues.add(new Entry(3,44f));
        yValues.add(new Entry(4,66f));
        yValues.add(new Entry(5,7f));
        yValues.add(new Entry(6,50f));

        LineDataSet set1=new LineDataSet(yValues, "Data Set 1");

        set1.setFillAlpha(110);
        set1.setColor(Color.CYAN);  //Changing Color of Line
        set1.setLineWidth(3f);
        set1.setValueTextSize(12f);
        set1.setValueTextColor(Color.BLACK);



        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        LineData data = new LineData(dataSets);

        mChart.setData(data);

    }


}

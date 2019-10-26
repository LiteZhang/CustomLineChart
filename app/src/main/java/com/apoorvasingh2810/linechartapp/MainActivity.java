package com.apoorvasingh2810.linechartapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private LineChart mRpmChart;
    private LineChart mBpmChart;
    private LineChart mApmChart;
    private LineChart mRpmPatternChart;
    private LineChart mFastSlowChart;

    Button btnSecondActivity;

    float[] RPM =  new float[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0, 0,0,0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            26.88f,
            23.65f,
            21.50f,
            21.50f,
            19.35f,
            18.27f,
            15.05f,
            12.90f,
            12.90f,
            12.90f,
            12.90f,
            12.90f,
            11.82f,
            10.75f,
            9.67f,
            9.67f,
            7.52f,
            7.52f,
            7.52f
    };

    float[] AVG_RPM = new float[]{
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            6.0f,
            6.0f,
            6.0f,
            8.25f,
            9.6f,
            10.5f,
            11.0f,
            11.5f,
            12.0f,
            11.5f,
            11.0f,
            10.5f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRpmChart = findViewById(R.id.rpm_chart);
        mBpmChart = findViewById(R.id.bpm_chart);
        mApmChart = findViewById(R.id.apm_chart);
        mRpmPatternChart = findViewById(R.id.rpm_pattern_chart);
        mFastSlowChart = findViewById(R.id.fast_slow_chart);

        btnSecondActivity = findViewById(R.id.btnSecondActivity);

        btnSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
//    mRpmChart.setOnChartGestureListener(MainActivity.this);
//    mRpmChart.setOnChartValueSelectedListener(MainActivity.this);
//        ChartUtils.initChart(mRpmChart);
//        mRpmChart.setDragEnabled(true);
//        mRpmChart.setScaleEnabled(false);
//        mRpmChart.getDescription().setEnabled(false);
//        XAxis xAxis = mRpmChart.getXAxis();
//        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM); // 设置X轴的位置
//        xAxis.setTextSize(10f);
//        xAxis.setTextColor(Color.RED);
//        xAxis.setDrawAxisLine(true);
//        xAxis.setDrawGridLines(true);

        ChartUtils.initNewChart(mRpmChart);

        ArrayList<Entry> rpmValues = new ArrayList<>();

        for (int i = 0; i< RPM.length; i++) {
            rpmValues.add(new Entry(i, RPM[i]));
        }

        ArrayList<Entry> avgRpmValues = new ArrayList<>();
        for (int i = 0; i< AVG_RPM.length; i++) {
            avgRpmValues.add(new Entry(i, AVG_RPM[i]));
        }
        ChartUtils.setRPMChartData(mRpmChart, rpmValues, avgRpmValues);

    }
}

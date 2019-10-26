package com.apoorvasingh2810.linechartapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.apoorvasingh2810.linechartapp.util.BluetoothHelper;
import com.apoorvasingh2810.linechartapp.util.PermissionHelper;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


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

    float[] BPM = new float[]{
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
            0.0f,
            81.0f,
            75.0f,
            88.0f,
            81.25f,
            81.85f,
            82.35f,
            79.77f,
            79.77f,
            84.11f,
            81.71f,
            81.98f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f
    };

    float[] MOVEMENTFAST = new float[]{
            66.25f,
            30.41f,
            57.91f,
            52.08f,
            36.25f,
            46.66f,
            45.41f,
            31.66f,
            25.83f,
            22.08f,
            19.16f,
            14.58f,
            20.0f,
            23.33f,
            22.91f,
            20.83f,
            16.25f,
            10.41f,
            9.16f,
            11.25f,
            10.41f,
            10.41f,
            8.33f,
            7.91f,
            6.66f,
            10.0f,
            10.0f,
            6.25f,
            4.16f,
            4.16f,
            1.66f,
            2.91f,
            7.5f,
            12.0f,
            13.75f,
            11.66f,
            8.33f,
            2.08f,
            6.25f,
            8.75f,
            11.25f,
            12.5f,
            7.91f,
            5.83f,
            7.5f,
            6.25f,
            2.08f,
            4.58f,
            5.41f,
            4.58f,
            5.41f,
            5.83f,
            6.66f,
            7.08f,
            7.5f,
            7.5f,
            7.5f,
            7.5f,
            7.083f,
            6.25f,
            2.083f,
            1.25f,
            2.08f,
            0.0f,
            1.66f,
            1.66f,
            3.33f,
            4.58f,
            4.16f,
            0.41f,
            0.83f,
            3.75f,
            5.0f,
            5.0f,
            5.83f,
            6.25f,
            6.25f,
            5.83f,
            5.41f,
            3.75f,
            1.25f,
            1.25f,
            1.25f,
            0.41f,
            0.0f,
            0.83f,
            0.0f,
            0.0f,
            0.0f,
            0.83f,
            0.41f,
            4.16f,
            6.25f
    };

    float[] MOVEMENT_SLOW = new float[]{
            97.25f,
            88.87f,
            98.25f,
            99.12f,
            98.87f,
            99.62f,
            99.0f,
            96.37f,
            91.62f,
            82.7f,
            78.875f,
            77.0f,
            69.75f,
            62.125f,
            70.0f,
            82.25f,
            87.875f,
            89.25f,
            82.75f,
            88.0f,
            84.125f,
            83.625f,
            75.0f,
            54.0f,
            43.0f,
            34.75f,
            21.125f,
            14.124999999999998f,
            10.5f,
            8.625f,
            5.125f,
            4.25f,
            18.125f,
            45.75f,
            57.125f,
            49.5f,
            27.500000000000004f,
            14.124999999999998f,
            18.75f,
            27.625f,
            36.375f,
            37.75f,
            19.875f,
            15.25f,
            22.5f,
            17.125f,
            14.499999999999998f,
            18.25f,
            23.5f,
            19.25f,
            13.125f,
            8.0f,
            9.625f,
            10.625f,
            13.5f,
            18.125f,
            24.5f,
            26.25f,
            17.5f,
            8.75f,
            3.75f,
            4.0f,
            2.875f,
            2.25f,
            1.5f,
            5.0f,
            10.25f,
            15.75f,
            18.0f,
            14.75f,
            9.25f,
            7.5f,
            5.375f,
            5.375f,
            6.5f,
            7.75f,
            9.375f,
            8.375f,
            7.249999999999999f,
            5.0f,
            4.0f,
            3.125f,
            3.0f,
            1.875f,
            1.375f,
            1.5f,
            1.25f,
            0.5f,
            1.7500000000000002f,
            3.25f,
            3.6249999999999996f,
            5.5f,
            9.625f
    };

    float[] APM = new float[]{
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
            0.029922951739758518f,
            0.0237514921860943f,
            0.022901367683402136f,
            0.02048523797686809f,
            0.024246515582223228f,
            0.02875208250465183f,
            0.023036360506834008f,
            0.030154097403799235f,
            0.056799722559759236f,
            0.06538521681188379f,
            0.04791127308705829f,
            0.08438005033766716f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f
    };

    float[] RPM_PATTERN = new float[]{
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
            -3.0211293907877756f,
            -0.15084374017743324f,
            -0.3423481569297556f,
            -1.253653979172625f,
            2.858719454474346f,
            2.9958513745099893f,
            -0.7605416224440438f,
            -0.21599477640690828f,
            -0.812421959236733f,
            2.903184555264336f,
            -1.455470202669481f,
            -0.4935805422231666f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f
    };

    float[] DISTANCE = new float[]{
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.4f,
            0.5542f,
            0.5542f,
            0.5542f,
            0.5542f,
            0.5542f,
            0.5542f,
            0.5542f,
            0.5542f,
            0.5542f,
            0.5542f,
            0.5542f,
            0.5542f,
            0.5542f,
            0.5542f,
            0.5542f,
            0.5542f,
            0.5542f,
            0.5542f,
            0.6056f,
            0.6056f,
            0.6056f,
            0.6056f,
            0.6056f,
            0.6056f,
            0.6056f,
            0.6056f,
            0.6056f,
            0.6056f,
            0.6056f,
            0.6056f,
            0.6056f,
            0.6056f,
            0.6056f,
            0.6056f
    };

    private static final String TAG = "MainActivity";

    private LineChart mRpmChart;
    private LineChart mBpmChart;
    private LineChart mApmChart;
    private LineChart mRpmPatternChart;
    private LineChart mDistanceChart;
    private LineChart mFastChart;
    private LineChart mSlowChart;

    Button btnSecondActivity;
    private static final String BLUETOOTH_MAC = "";

    private BluetoothHelper bluetoothHelper;
    private PermissionHelper permissionHelper;
    private boolean isSearching = false;
    private ArrayList<BluetoothHelper.BluetoothInfo> infoList  = new ArrayList<>(8);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRpmChart = findViewById(R.id.rpm_chart);
        mBpmChart = findViewById(R.id.bpm_chart);
        mApmChart = findViewById(R.id.apm_chart);
        mRpmPatternChart = findViewById(R.id.rpm_pattern_chart);
        mDistanceChart = findViewById(R.id.distance_chart);
        mFastChart = findViewById(R.id.fast_chart);
        mSlowChart = findViewById(R.id.slow_chart);

        btnSecondActivity = findViewById(R.id.btnSecondActivity);
        initBlueTooth();
        btnSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        ChartUtils.initNewChart(mRpmChart);
        ChartUtils.initNewChart(mBpmChart);
        ChartUtils.initNewChart(mApmChart);
        ChartUtils.initNewChart(mRpmPatternChart);
        ChartUtils.initNewChart(mDistanceChart);
        ChartUtils.initNewChart(mFastChart);
        ChartUtils.initNewChart(mSlowChart);

        ArrayList<Entry> rpmValues = new ArrayList<>();
        for (int i = 0; i< RPM.length; i++) {
            rpmValues.add(new Entry(i, RPM[i]));
        }
        ArrayList<Entry> avgRpmValues = new ArrayList<>();
        for (int i = 0; i< AVG_RPM.length; i++) {
            avgRpmValues.add(new Entry(i, AVG_RPM[i]));
        }
        ChartUtils.setRPMChartData(mRpmChart, rpmValues, avgRpmValues);

        /////////////  bpm //////////////////////////
        ArrayList<Entry> bmpValues = new ArrayList<>();
        for (int i = 0; i< BPM.length; i++) {
            bmpValues.add(new Entry(i, BPM[i]));
        }
        ChartUtils.setSingleLineChartData(mBpmChart,bmpValues , "BPM");
        /////////////  bpm //////////////////////////

        /////////////  apm //////////////////////////
        ArrayList<Entry> apmValues = new ArrayList<>();
        for (int i = 0; i< APM.length; i++) {
            apmValues.add(new Entry(i, APM[i]));
        }
        ChartUtils.setSingleLineChartData(mApmChart,apmValues , "APM");
        /////////////  apm //////////////////////////

        /////////////  rpm pattern //////////////////////////
        ArrayList<Entry> rpmPatternValues = new ArrayList<>();
        for (int i = 0; i< RPM_PATTERN.length; i++) {
            rpmPatternValues.add(new Entry(i, RPM_PATTERN[i]));
        }
        ChartUtils.setSingleLineChartData(mRpmPatternChart,rpmPatternValues , "RPM PATTERN");
        /////////////   rpm pattern //////////////////////////

        /////////////  rpm pattern //////////////////////////
        ArrayList<Entry> distanceValues = new ArrayList<>();
        for (int i = 0; i< DISTANCE.length; i++) {
            distanceValues.add(new Entry(i, DISTANCE[i]));
        }
        ChartUtils.setSingleLineChartData(mDistanceChart,distanceValues , "DISTANCE");
        /////////////   rpm pattern //////////////////////////


        ////////////////  MOVEMENT fast or slow  //////////////////////
        ArrayList<Entry> fastValues = new ArrayList<>();
        for (int i = 0; i< MOVEMENTFAST.length; i++) {
            fastValues.add(new Entry(i, MOVEMENTFAST[i]));
        }
        ChartUtils.setMovementChartData(mFastChart,fastValues,"MOVEMENT FAST" );
        Drawable drawable = ContextCompat.getDrawable(this, R.color.chartLineColor);
        ChartUtils.setChartFillDrawable(mFastChart, drawable);

        ArrayList<Entry> slowValues = new ArrayList<>();
        for (int i = 0; i< MOVEMENT_SLOW.length; i++) {
            slowValues.add(new Entry(i, MOVEMENT_SLOW[i]));
        }
        ChartUtils.setMovementChartData(mSlowChart,slowValues,"MOVEMENT SLOW" );
        ChartUtils.setChartFillDrawable(mSlowChart, drawable);
    }

    private void initBlueTooth() {
        bluetoothHelper = BluetoothHelper.getInstance(this);
        bluetoothHelper.scan(new BluetoothHelper.OnScanListener() {
            @Override
            public void onStart() {

            }

            @Override
            public void onFound(BluetoothHelper.BluetoothInfo info) {
                infoList.add(info);
//                listView.setData(infoList);
            }

            @Override
            public void onStop() {
                isSearching = false;
                for(BluetoothHelper.BluetoothInfo info : infoList) {

                }
//                searchBtn.setText(R.string.search_searchBegin);
//                //防止蓝牙列表数据有变（经典蓝牙和BLE蓝牙都支持的设备在扫描BLE蓝牙后supportType会改为ALL，但不会调用onFound）
//                listView.setData(infoList);
            }

            @Override
            public void onCancel() {
                isSearching = false;
//                searchBtn.setText(R.string.search_searchBegin);
//                //防止蓝牙列表数据有变（经典蓝牙和BLE蓝牙都支持的设备在扫描BLE蓝牙后supportType会改为ALL，但不会调用onFound）
//                listView.setData(infoList);
            }

            @Override
            public void onError() {
                isSearching = false;
//                searchBtn.setText(R.string.search_searchBegin);
            }
        });
        if (isSearching) {
            if (bluetoothHelper != null) {
                bluetoothHelper.stopScan();
                bluetoothHelper.setDiscoverable(false, 1);
            }
        }
//        permissionHelper = new PermissionHelper(this)
//                .addPermission(Manifest.permission.ACCESS_FINE_LOCATION)
//                .addTipsDialog(DialogHelper.makeDialog(getContext(), "定位权限不可用", "需要使用定位权限才能获取蓝牙信息", false,
//                        "立即打开", new DialogHelper.OnClickListener() {
//                            @Override
//                            public void onClick() {
//                                PermissionHelper.getPermissionInFragment(SearchFragment.this, Manifest.permission.ACCESS_COARSE_LOCATION, 1000);
//                            }
//                        }, "取消", null))
//                .addWarnDialog(DialogHelper.makeGoToSettingDialog(getContext(), "定位权限不可用", "请在应用设置-权限-中，允许定位权限", false));
    }

    //切换到后台停止扫描
    @Override
    public void onPause() {
        super.onPause();

        if (isSearching) {
            if (bluetoothHelper != null) {
                bluetoothHelper.stopScan();
                bluetoothHelper.setDiscoverable(false, 1);
            }
        }
    }

}

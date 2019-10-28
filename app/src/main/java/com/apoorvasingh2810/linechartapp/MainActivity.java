package com.apoorvasingh2810.linechartapp;

import android.Manifest;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.apoorvasingh2810.linechartapp.bean.DataBean;
import com.apoorvasingh2810.linechartapp.util.BluetoothHelper;
import com.apoorvasingh2810.linechartapp.util.PermissionHelper;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {


    float[] RPM = new float[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
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
    private ArrayList<BluetoothHelper.BluetoothInfo> infoList = new ArrayList<>(8);
    private String mContent;

    ArrayList<Entry> rpmValues = new ArrayList<>();
    ArrayList<Entry> avgRpmValues = new ArrayList<>();
    ArrayList<Entry> bmpValues = new ArrayList<>();
    ArrayList<Entry> apmValues = new ArrayList<>();
    ArrayList<Entry> rpmPatternValues = new ArrayList<>();
    ArrayList<Entry> distanceValues = new ArrayList<>();
    ArrayList<Entry> fastValues = new ArrayList<>();
    ArrayList<Entry> slowValues = new ArrayList<>();

    int drawCount = 0;
    public static final String MAC = "B8:27:EB:0E:36:87";
    public static final String CLASSIC = "00001101-0000-1000-8000-00805F9B34FB";
    public static final String SERVICE = "FFA5417A-2C26-43EA-8A6B-4BD5C51ADBCF";
    public static final String CHARACTER = "32B82DB5-79CA-451B-8C80-A9B4C2AD5E49";

    //    String content;
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

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            //申请WRITE_EXTERNAL_STORAGE权限
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    1);
        }

        ChartUtils.initNewChart(mRpmChart);
        ChartUtils.initNewChart(mBpmChart);
        ChartUtils.initNewChart(mApmChart);
        ChartUtils.initNewChart(mRpmPatternChart);
        ChartUtils.initNewChart(mDistanceChart);
        ChartUtils.initNewChart(mFastChart);
        ChartUtils.initNewChart(mSlowChart);

//        ArrayList<Entry> rpmValues = new ArrayList<>();
//        for (int i = 0; i< RPM.length; i++) {
//            rpmValues.add(new Entry(i, RPM[i]));
//        }
//        ArrayList<Entry> avgRpmValues = new ArrayList<>();
//        for (int i = 0; i< AVG_RPM.length; i++) {
//            avgRpmValues.add(new Entry(i, AVG_RPM[i]));
//        }
//        ChartUtils.setRPMChartData(mRpmChart, rpmValues, avgRpmValues);
//
//        /////////////  bpm //////////////////////////
//        ArrayList<Entry> bmpValues = new ArrayList<>();
//        for (int i = 0; i< BPM.length; i++) {
//            bmpValues.add(new Entry(i, BPM[i]));
//        }
//        ChartUtils.setSingleLineChartData(mBpmChart,bmpValues , "BPM");
//        /////////////  bpm //////////////////////////
//
//        /////////////  apm //////////////////////////
//        ArrayList<Entry> apmValues = new ArrayList<>();
//        for (int i = 0; i< APM.length; i++) {
//            apmValues.add(new Entry(i, APM[i]));
//        }
//        ChartUtils.setSingleLineChartData(mApmChart,apmValues , "APM");
//        /////////////  apm //////////////////////////
//
//        /////////////  rpm pattern //////////////////////////
//        ArrayList<Entry> rpmPatternValues = new ArrayList<>();
//        for (int i = 0; i< RPM_PATTERN.length; i++) {
//            rpmPatternValues.add(new Entry(i, RPM_PATTERN[i]));
//        }
//        ChartUtils.setSingleLineChartData(mRpmPatternChart,rpmPatternValues , "RPM PATTERN");
//        /////////////   rpm pattern //////////////////////////
//
//        /////////////  rpm pattern //////////////////////////
//        ArrayList<Entry> distanceValues = new ArrayList<>();
//        for (int i = 0; i< DISTANCE.length; i++) {
//            distanceValues.add(new Entry(i, DISTANCE[i]));
//        }
//        ChartUtils.setSingleLineChartData(mDistanceChart,distanceValues , "DISTANCE");
//        /////////////   rpm pattern //////////////////////////
//
//
//        ////////////////  MOVEMENT fast or slow  //////////////////////
//        ArrayList<Entry> fastValues = new ArrayList<>();
//        for (int i = 0; i< MOVEMENTFAST.length; i++) {
//            fastValues.add(new Entry(i, MOVEMENTFAST[i]));
//        }
//        ChartUtils.setMovementChartData(mFastChart,fastValues,"MOVEMENT FAST" );
//        Drawable drawable = ContextCompat.getDrawable(this, R.color.chartLineColor);
//        ChartUtils.setChartFillDrawable(mFastChart, drawable);
//
//        ArrayList<Entry> slowValues = new ArrayList<>();
//        for (int i = 0; i< MOVEMENT_SLOW.length; i++) {
//            slowValues.add(new Entry(i, MOVEMENT_SLOW[i]));
//        }
//        ChartUtils.setMovementChartData(mSlowChart,slowValues,"MOVEMENT SLOW" );
//        ChartUtils.setChartFillDrawable(mSlowChart, drawable);
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
                for (BluetoothHelper.BluetoothInfo info : infoList) {

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

        /*============================================================*/
        BluetoothHelper.OnConnectListener onConnectListener = new BluetoothHelper.OnConnectListener() {
            @Override
            public void onConnected() {
                Log.i("lite", "##########  onConnected ##########");
                try {
                    Thread.sleep(3000);
                } catch (Exception ex) {

                }
                readOnClassicMode();
//                loadingDialog.dismiss();
//
//                connectBtn.setText(R.string.connect_disconnect);
//                findSupportUUID.setText(R.string.connect_disconnect);
//
//                if (getActivity() instanceof MainActivity) {
//                    if (classicBtn.isChecked()) {
//                        ((MainActivity) getActivity()).startTransfer(name, mac, BluetoothHelper.BluetoothInfo.SUPPORT_TYPE_CLASSIC, UUID.fromString(classic), null, null);
//
//                    }
//                }
            }

            @Override
            public void onFoundBleUUIDs(List<BluetoothGattService> serviceList) {
                Log.i("lite", "##########  onFoundBleUUIDs ##########");
//                startTransferBtn.setEnabled(true);
//                //TODO
//                for (BluetoothGattService service : serviceList) {
//                    Log.e("TAG", service.getUuid().toString());
//                    List<BluetoothGattCharacteristic> characterList = service.getCharacteristics();
//                    for (BluetoothGattCharacteristic character : characterList) {
//                        Log.e("TAG", "\t" + character.getUuid().toString());
//                    }
//                }
//                try {
//                    if (!serviceUUIDEditText.getText().toString().equals(MainActivity.DEFAULT_SERVICE_UUID))
//                        serviceUUIDEditText.setText(serviceList.get(0).getUuid().toString());
//                    if (!characterUUIDEditText.getText().toString().equals(MainActivity.DEFAULT_CHARACTER_UUID))
//                        characterUUIDEditText.setText(serviceList.get(0).getCharacteristics().get(0).getUuid().toString());
//                } catch (NullPointerException e) {
//                    e.printStackTrace();
//                }
            }

            @Override
            public void onError() {
                Log.i("lite", "##########  onError ##########");
//                loadingDialog.dismiss();
//
//                connectBtn.setText(R.string.connect_connect);
//                findSupportUUID.setText(R.string.connect_finduuids);
//                startTransferBtn.setEnabled(false);
//
//                DialogHelper.makeDialog(getContext(), "失败", "连接失败").show();
            }

            @Override
            public void onDisconnect() {
                Log.i("lite", "##########  onDisconnect ##########");
//                connectBtn.setText(R.string.connect_connect);
//                findSupportUUID.setText(R.string.connect_finduuids);
//                startTransferBtn.setEnabled(false);
//                if (getActivity() instanceof MainActivity)
//                    ((MainActivity) getActivity()).stopTransfer();
            }
        };
        /*============================================================*/

        int type = BluetoothHelper.CLASSIC_CONNECT_AS_CLIENT;
        Log.i("lite", "##########  start connect ##########");
        bluetoothHelper.connect(MAC, UUID.fromString(CLASSIC), type, onConnectListener);
    }

    private void readOnClassicMode() {
        bluetoothHelper.read(new BluetoothHelper.OnReadListener() {
            @Override
            public void onReceived(byte[] data) {
                Log.i("lite", "##########  onReceived ##########");
                String text = decodeData(data);
                mContent += text;
                Log.i("lite", "=====>>>> size of text ==  : " + text.length());
////                Log.i("lite", "=====>>>> text : " + text);
                Log.i("lite", "=====>>>> mContent of text ==  : " + mContent.length());

//                writeFileSdcard("lite123456.txt", text);
//                String[]  contentList = mContent.split("},{");
                DataBean bean = null;
                int  deleteCount = 0;
                String tempStr =null;
                String[] strarray = mContent.split("[}{]");
                Log.i("lite", "=====>>>>strarray size " + strarray.length);
                for (int i = 0; i < strarray.length; i++) {
                    tempStr = strarray[i];

                    if (tempStr.contains("RPMlist") &&
                            tempStr.contains("DISTANCElist") &&
                            tempStr.contains("RPMPATTERNlist") &&
                            tempStr.contains("BPM") &&
                            tempStr.contains("SLOW") &&
                            tempStr.contains("PRESENCE") &&
                            tempStr.contains("DISTANCE") &&
                            tempStr.contains("AMP") &&
                            tempStr.contains("FASTlist") &&
                            tempStr.contains("RPMPATTERN") &&
                            tempStr.contains("PRESENCElist") &&
                            tempStr.contains("FAST") &&
                            tempStr.contains("RPM") &&
                            tempStr.contains("MOVEMENTSLOWlist") &&
                            tempStr.contains("AVGRPMlist") &&
                            tempStr.contains("SLOWlist") &&
                            tempStr.contains("MOVEMENTFASTlist") &&
                            tempStr.contains("AMPlist") &&
                            tempStr.contains("BPMlist")) {
                        try {
                            tempStr = "{" + tempStr + "}";
                            bean = new Gson().fromJson(tempStr, DataBean.class);
//
                            Log.i("lite", "=====>>>> getAMP : " + bean.getAMP());
                            Log.i("lite", "=====>>>> getBPM : " + bean.getBPM());
                            Log.i("lite", "=====>>>> getDISTANCE : " + bean.getDISTANCE());
                        } catch (Exception ex) {
                            Log.e("ERROR", ex.toString());
                        }
                        break;
                    }
                }
                if (bean != null) {
                    drawCount++;
//                    mRpmChart.clear();
                    String[] rpmList = bean.getRPMlist().split("_");
                    String[] rpmAvgList = bean.getAVGRPMlist().split("_");
                    rpmValues.clear();
                    for (int j = 0; j < rpmList.length; j++) {
                        float value = Float.valueOf(rpmList[j]);
                        rpmValues.add(new Entry(j, value));
                    }
                    avgRpmValues.clear();
                    for (int k = 0; k < rpmAvgList.length; k++) {
                        float value = Float.valueOf(rpmAvgList[k]);
                        avgRpmValues.add(new Entry(k, value));
                    }
                    ChartUtils.setRPMChartData(mRpmChart, rpmValues, avgRpmValues);
//                    mRpmChart.invalidate();
                    /////////////  bpm //////////////////////////

                    String[] bpmList = bean.getBPMlist().split("_");
                    bmpValues.clear();
                    for (int i = 0; i < bpmList.length; i++) {
                        float value = Float.valueOf(rpmAvgList[i]);
                        bmpValues.add(new Entry(i, value));
                    }
//                    ChartUtils.setSingleLineChartData(mBpmChart, bmpValues, "BPM");
                    ChartUtils.setChartData(mBpmChart, bmpValues);
                    /////////////  bpm //////////////////////////
//
//        /////////////  apm //////////////////////////
//
                    String[] apmList = bean.getAMPlist().split("_");
                    apmValues.clear();
                    for (int i = 0; i < apmList.length; i++) {
                        float value = Float.valueOf(apmList[i]);
                        apmValues.add(new Entry(i, value));
                    }
                    ChartUtils.setSingleLineChartData(mApmChart, apmValues, "APM");
//        /////////////  apm //////////////////////////
//
//        /////////////  rpm pattern //////////////////////////
//        ArrayList<Entry> rpmPatternValues = new ArrayList<>();
                    String[] rpmPatternList = bean.getRPMPATTERNlist().split("_");
                    rpmPatternValues.clear();
                    for (int i = 0; i < rpmPatternList.length; i++) {
                        float value = Float.valueOf(rpmPatternList[i]);
                        rpmPatternValues.add(new Entry(i, value));
                    }
                    ChartUtils.setSingleLineChartData(mRpmPatternChart, rpmPatternValues, "RPM PATTERN");
//        /////////////   rpm pattern //////////////////////////
//
//        /////////////  rpm distance //////////////////////////
//        ArrayList<Entry> distanceValues = new ArrayList<>();
                    String[] distanceList = bean.getDISTANCElist().split("_");
                    distanceValues.clear();
                    for (int i = 0; i < distanceList.length; i++) {
                        float value = Float.valueOf(distanceList[i]);
                        distanceValues.add(new Entry(i, value));
                    }
                    ChartUtils.setSingleLineChartData(mDistanceChart, distanceValues, "DISTANCE");
//        /////////////   rpm pattern //////////////////////////
//
//
//        ////////////////  MOVEMENT fast or slow  //////////////////////
//        ArrayList<Entry> fastValues = new ArrayList<>();
                    String[] fastList = bean.getFASTlist().split("_");
                    fastValues.clear();
                    for (int i = 0; i < fastList.length; i++) {
                        float value = Float.valueOf(fastList[i]);
                        fastValues.add(new Entry(i,value));
                    }
        ChartUtils.setMovementChartData(mFastChart,fastValues,"MOVEMENT FAST" );
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.color.chartLineColor);
        ChartUtils.setChartFillDrawable(mFastChart, drawable);
                    mFastChart.invalidate();

                    String[] slowList = bean.getSLOWlist().split("_");
                    slowValues.clear();
                    for (int i = 0; i < slowList.length; i++) {
                        float value = Float.valueOf(slowList[i]);
                        slowValues.add(new Entry(i,value));
                    }
                    ChartUtils.setMovementChartData(mSlowChart, slowValues, "MOVEMENT SLOW");
                    ChartUtils.setChartFillDrawable(mSlowChart, drawable);
                    mSlowChart.invalidate();
//                    mContent = mContent.substring(tempStr.length());
//                    deleteIndex = 0;
                    Log.i("lite", "%%%%%%%%%%% drawCount : " + drawCount);
                    return;
                }

//                if(strarray.length >= 3) {
//                    String jsonStr = "{" + strarray[1] + "}";
//                    System.out.println(jsonStr);
//                          DataBean bean = new Gson().fromJson(jsonStr, DataBean.class);
////
//                            Log.i("lite", "=====>>>> getAMP : " + bean.getAMP());
//                            Log.i("lite", "=====>>>> getBPM : " + bean.getBPM());
//                            Log.i("lite", "=====>>>> getDISTANCE : " + bean.getDISTANCE());
//                    mContent = mContent.substring( mContent.indexOf("}"));
//                            return;
//                }


//                if (getKeyStringCount(mContent, key) >= 2) {
//                    int index = 0;
//                    int count = 0;
//                    while ((index = mContent.indexOf(key, index)) != -1) {
//                        index = index + key.length();//先在字符串找key 找到后 去掉前面包含key的部分 再在字串中找
//                        count++;
//                    }
//                    StringTokenizer st = new StringTokenizer(mContent, "}{");
//                    while (st.hasMoreTokens()) {
//                        String str = st.nextToken();
//                        System.out.println(str);
//                        System.out.println("=====================");
//
//                        Log.i("lite", "=====>>>> token substring : " + str.substring(1, 7));
//                        if (str.substring(1, 7).equals("AVGRPM")) {
//                            String jsonStr = "{" + str + "}";
////                mContent = mContent.substring(mContent.indexOf("}") + 1);
//                            Log.i("lite", "=====>>>> jsonString : " + jsonStr);
////                Log.i("lite", "=====>>>> READ : " + text);
//                            DataBean bean = new Gson().fromJson(jsonStr, DataBean.class);
//
//                            Log.i("lite", "=====>>>> getAMP : " + bean.getAMP());
//                            Log.i("lite", "=====>>>> getBPM : " + bean.getBPM());
//                            Log.i("lite", "=====>>>> getDISTANCE : " + bean.getDISTANCE());
//
//                            String[] rpmList = bean.getRPMlist().split("_");
//                            String[] rpmAvgList = bean.getAVGRPMlist().split("_");
//
//                            for (int i = 0; i < rpmList.length; i++) {
//                                float value = Float.valueOf(rpmList[i]);
//                                rpmValues.add(new Entry(i, value));
//                            }
//
//                            for (int i = 0; i < rpmAvgList.length; i++) {
//                                float value = Float.valueOf(rpmAvgList[i]);
//                                avgRpmValues.add(new Entry(i, value));
//                            }
//                            ChartUtils.setRPMChartData(mRpmChart, rpmValues, avgRpmValues);
//                            mContent = mContent.substring(mContent.indexOf("}"));
//                        }
//                    }
//                }

                int start = (mContent.indexOf("{"));
                int end = (mContent.indexOf("}"));

//                if (text.indexOf("}") > 0) {
//                    System.out.println(mContent);
//                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//                    System.out.println(text);
//                    Log.i("lite", "@@@@@@@@@@@  =====>>>> end ==  : " + end);
//                    System.out.println("finish -----> " + text.indexOf("}"));
//
//                    try {
////                saveToSDCard("123.txt", content);
//                        saveToSDCard("lite12345.txt", mContent);
//                        Toast.makeText(getApplicationContext(), "保存成功", Toast.LENGTH_SHORT).show();
//                    } catch (Exception e) {
//                        Toast.makeText(getApplicationContext(), "保存失败", Toast.LENGTH_SHORT).show();
//                    }
////                    System.exit(0);
//                }

                Log.i("lite", "=====>>>> start ==  : " + start);
                Log.i("lite", "=====>>>> end ==  : " + end);

                if (start < 0 || end < 0)
                    return;
                if (start >= end) {
//                    mContent = mContent.substring(end);
                    return;
                }
//                mContent = mContent.substring(start);


//                readEditText.setText(text);
                //  float f = Float.parseFloat(str)
            }

            @Override
            public void onError() {
                Log.i("lite", "##########  onError ##########");
            }

            @Override
            public void onClose() {
                Log.i("lite", "##########  onClose ##########");
            }
        });
    }

    public void saveToSDCard(String filename, String content) throws Exception {
        File file = new File(Environment.getExternalStorageDirectory().getPath(), filename);
        OutputStream out = new FileOutputStream(file);
        out.write(content.getBytes());
        out.close();
    }

    /**
     * 将内容写入sd卡中
     *
     * @param filename 要写入的文件名
     * @param content  待写入的内容
     * @throws IOException
     */
    public static void writeExternal(Context context, String filename, String content) throws IOException {

        //获取外部存储卡的可用状态
        String storageState = Environment.getExternalStorageState();

        //判断是否存在可用的的SD Card
        if (storageState.equals(Environment.MEDIA_MOUNTED)) {

            //路径： /storage/emulated/0/Android/data/com.yoryky.demo/cache/yoryky.txt
            filename = storageState + File.separator + filename;

            FileOutputStream outputStream = new FileOutputStream(filename);
            outputStream.write(content.getBytes());
            outputStream.close();
        }
    }

    public void writeFileSdcard(String fileName, String message) {
        try {
            //FileOutputStream fout = openFileOutput(fileName, MODE_PRIVATE);
            FileOutputStream fout = new FileOutputStream(fileName);
            byte[] bytes = message.getBytes();

            fout.write(bytes);
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //读取/写入框中的数据和要传输的数据之间的转换
    private String decodeData(byte[] data) {
        return new String(data);
    }

    private byte[] encodeData(String data) {
        return data.getBytes();
    }

    //切换到后台停止扫描
    @Override
    public void onPause() {
        super.onPause();
        String en = Environment.getExternalStorageState();
        //获取SDCard状态,如果SDCard插入了手机且为非写保护状态
        if (en.equals(Environment.MEDIA_MOUNTED)) {
            try {
//                saveToSDCard("123.txt", content);
                writeExternal(this, "123.txt", mContent);
                Toast.makeText(getApplicationContext(), "保存成功", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "保存失败", Toast.LENGTH_SHORT).show();
            }
        } else {
            //提示用户SDCard不存在或者为写保护状态
            Toast.makeText(getApplicationContext(), "SDCard不存在或者为写保护状态", Toast.LENGTH_SHORT).show();
        }

        if (isSearching) {
            if (bluetoothHelper != null) {
                bluetoothHelper.stopScan();
                bluetoothHelper.setDiscoverable(false, 1);
            }
        }
    }

}

package com.apoorvasingh2810.linechartapp;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.apoorvasingh2810.linechartapp.util.BluetoothHelper;
import com.apoorvasingh2810.linechartapp.util.PermissionHelper;
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
        mFastSlowChart = findViewById(R.id.fast_slow_chart);

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
        ChartUtils.initNewChart(mFastSlowChart);

        ArrayList<Entry> rpmValues = new ArrayList<>();
        for (int i = 0; i< RPM.length; i++) {
            rpmValues.add(new Entry(i, RPM[i]));
        }
        ArrayList<Entry> avgRpmValues = new ArrayList<>();
        for (int i = 0; i< AVG_RPM.length; i++) {
            avgRpmValues.add(new Entry(i, AVG_RPM[i]));
        }
        ChartUtils.setRPMChartData(mRpmChart, rpmValues, avgRpmValues);

        ArrayList<Entry> bmpValues = new ArrayList<>();
        for (int i = 0; i< BPM.length; i++) {
            bmpValues.add(new Entry(i, BPM[i]));
        }
        ChartUtils.setBPMChartData(mBpmChart,bmpValues );
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

package com.apoorvasingh2810.linechartapp;

import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * @author lite.zhang
 * @name Line-Chart-Android_App
 * @class name：com.apoorvasingh2810.linechartapp
 * @class describe
 * @time 2019/10/26 11:34
 */

public class ChartUtils {

    public static int dayValue = 0;
    public static int weekValue = 1;
    public static int monthValue = 2;
    public static int count = 0;

    public static int brokenLine = 100;
    public static int curve = 200;
    public static int mLineType = brokenLine;

    private static final String[] xValue = new String[]{"120","100","80","60","40","20","0"};

    /**
     * 初始化图表
     *
     * @param chart 原始图表
     * @return 初始化后的图表
     */
    public static LineChart initChart(LineChart chart) {
        // 不显示数据描述
        chart.getDescription().setEnabled(false);
        // 没有数据的时候，显示“暂无数据”
        chart.setNoDataText("无加载数据");
        // 不显示表格颜色
        chart.setDrawGridBackground(true);
        // 不可以缩放
        chart.setScaleEnabled(false);
        // 不显示y轴右边的值
        chart.getAxisRight().setEnabled(false);
        chart.setDrawBorders(true);
        // 不显示图例
        Legend legend = chart.getLegend();
        legend.setEnabled(false);
        // 向左偏移15dp，抵消y轴向右偏移的30dp
        chart.setExtraLeftOffset(-15);

        XAxis xAxis = chart.getXAxis();
        // 不显示x轴
        xAxis.setDrawAxisLine(true);
        // 设置x轴数据的位置
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(Color.WHITE);
        xAxis.setTextSize(12);
        xAxis.setGridColor(Color.parseColor("#30FFFFFF"));
//        xAxis.setDrawGridLines(false);
        xAxis.enableGridDashedLine(10f, 10f, 0f);
        xAxis.setEnabled(false);
        // 设置x轴数据偏移量
        xAxis.setYOffset(-12);
        xAxis.setAxisMaximum(120f);
        xAxis.setDrawGridLines(true);
        xAxis.setLabelCount(8);

        YAxis yAxis = chart.getAxisLeft();
        // 不显示y轴
        yAxis.setDrawAxisLine(true);
        // 设置y轴数据的位置
        yAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        // 不从y轴发出横向直线
        yAxis.setDrawGridLines(true);
        yAxis.setTextColor(Color.WHITE);
        yAxis.setTextSize(12);
        // 设置y轴数据偏移量
        yAxis.setXOffset(30);
        yAxis.setYOffset(-3);
        yAxis.setAxisMinimum(0);
        yAxis.enableGridDashedLine(10f, 10f, 0f);
        yAxis.setEnabled(false);

        xAxis.setAxisLineColor(Color.WHITE);//设置x轴线颜色
        xAxis.setAxisLineWidth(0.5f);//设置x轴线宽度
        YAxis leftAxis = chart.getAxisLeft();
        YAxis axisRight = chart.getAxisRight();
        leftAxis.enableGridDashedLine(10f, 10f, 0f);  //设置Y轴网格线条的虚线，参1 实线长度，参2 虚线长度 ，参3 周期
        leftAxis.setGranularity(20f); // 网格线条间距
        axisRight.setEnabled(false);   //设置是否使用 Y轴右边的
        leftAxis.setEnabled(true);     //设置是否使用 Y轴左边的
        leftAxis.setGridColor(Color.parseColor("#7189a9"));  //网格线条的颜色
        leftAxis.setDrawLabels(true);        //是否显示Y轴刻度
        leftAxis.setStartAtZero(true);        //设置Y轴数值 从零开始
        leftAxis.setDrawGridLines(true);      //是否使用 Y轴网格线条
        leftAxis.setTextSize(12f);            //设置Y轴刻度字体
        leftAxis.setTextColor(Color.WHITE);   //设置字体颜色
        leftAxis.setAxisLineColor(Color.WHITE); //设置Y轴颜色
        leftAxis.setAxisLineWidth(0.5f);
        leftAxis.setDrawAxisLine(true);//是否绘制轴线

        Matrix matrix = new Matrix();
        //x轴缩放1.5倍
        matrix.postScale(1.5f, 1f);
        //在图表动画显示之前进行缩放
        chart.getViewPortHandler().refresh(matrix, chart, false);
        //x轴执行动画
        chart.animateX(2000);
        chart.invalidate();
        return chart;
    }

    /**
     * 设置图表数据
     *
     * @param chart  图表
     * @param values 数据
     */
    public static void setChartData(LineChart chart, List<Entry> values) {
        LineDataSet lineDataSet;

        if (chart.getData() != null && chart.getData().getDataSetCount() > 0) {
            Log.i("lite", "setChartData  chart.getData() != null #########");
            lineDataSet = (LineDataSet) chart.getData().getDataSetByIndex(0);
            lineDataSet.setValues(values);
            chart.getData().notifyDataChanged();
            chart.notifyDataSetChanged();
            //设置在曲线图中显示的最大数量
//            chart.setVisibleXRangeMaximum(10);
            //移到某个位置
            chart.moveViewToX(chart.getData().getEntryCount() - 5);
        } else {
            Log.i("lite", "setChartData  chart.getData() == null @@@@@@@");
            lineDataSet = new LineDataSet(values, "");
            // 设置曲线颜色
//            lineDataSet.setColor(Color.parseColor("#FFFFFF"));
            lineDataSet.setColor(Color.parseColor("#1F77B4"));
            // 设置平滑曲线
//            lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
            // 不显示坐标点的小圆点
            lineDataSet.setDrawCircles(false);
            // 不显示坐标点的数据
            lineDataSet.setDrawValues(false);
            lineDataSet.setValueTextColor(Color.parseColor("#FFFFFF"));
            // 不显示定位线
            lineDataSet.setHighlightEnabled(true);

            LineData data = new LineData(lineDataSet);
            chart.setData(data);
            chart.invalidate();
        }
    }

    /**
     * 设置线条填充背景颜色
     *
     * @param drawable
     */
    public static void setChartFillDrawable(LineChart chart, Drawable drawable) {
        if (chart.getData() != null && chart.getData().getDataSetCount() > 0) {
            LineDataSet lineDataSet = (LineDataSet) chart.getData().getDataSetByIndex(0);
            //避免在 initLineDataSet()方法中 设置了 lineDataSet.setDrawFilled(false); 而无法实现效果
            lineDataSet.setDrawFilled(true);
            lineDataSet.setFillDrawable(drawable);
            chart.invalidate();
        }
    }

    public static LineChart initNewChart(LineChart chart) {
        chart.setDragEnabled(true);
        chart.setScaleEnabled(false);
        chart.getDescription().setEnabled(false);
        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM); // 设置X轴的位置
        xAxis.setTextSize(10f);
        xAxis.setTextColor(Color.RED);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(true);
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 120; i++) {
            list.add(String.valueOf(i));
        }
//        Collections.reverse(list);
//        xAxis = chart.getXAxis();
//        xAxis.setValueFormatter(new IndexAxisValueFormatter(list));
//        Matrix matrix = new Matrix();
//        //x轴缩放1.5倍
//        matrix.postScale(1.5f, 1f);
//        //在图表动画显示之前进行缩放
//        chart.getViewPortHandler().refresh(matrix, chart, false);
        //x轴执行动画
        chart.animateX(1000);
        chart.invalidate();
        return chart;
    }


    public static void setRPMChartData(LineChart chart, List<Entry> rpm, List<Entry> avgRpm) {
        LineDataSet rpmDataSet = new LineDataSet(rpm, "RPM");
        LineDataSet avgRpmDataSet = new LineDataSet(avgRpm, "AVG_RPM");
        rpmDataSet.setFillAlpha(110);
        avgRpmDataSet.setFillAlpha(110);

        rpmDataSet.setColor(Color.parseColor("#1F77B4"));
        avgRpmDataSet.setColor(Color.parseColor("#FF7F0E"));

        rpmDataSet.setLineWidth(1f);
        rpmDataSet.setValueTextSize(12f);
        rpmDataSet.setValueTextColor(Color.BLACK);

        rpmDataSet.setDrawCircles(false);
        // 不显示坐标点的数据
        rpmDataSet.setDrawValues(false);
        rpmDataSet.setValueTextColor(Color.parseColor("#FFFFFF"));
        // 不显示定位线
        rpmDataSet.setHighlightEnabled(true);

        avgRpmDataSet.setDrawCircles(false);
        avgRpmDataSet.setDrawValues(false);
        avgRpmDataSet.setValueTextColor(Color.parseColor("#FFFFFF"));
        // 不显示定位线
        avgRpmDataSet.setHighlightEnabled(true);
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(rpmDataSet);
        dataSets.add(avgRpmDataSet);

        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 120; i++) {
            list.add(String.valueOf(i));
        }
        Collections.reverse(list);
        XAxis xAxis = chart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(list));
        LineData data = new LineData(dataSets);
//        chart.getData().notifyDataChanged();
//        if(chart.getData() != null) {
//            chart.getData().notifyDataChanged();
//        }

        chart.setData(data);
        chart.notifyDataSetChanged();
        chart.invalidate();
    }

    /**
     * 更新图表
     *
     * @param chart     图表
     * @param values    数据
     */
    public static void notifyDataSetChanged(LineChart chart, List<Entry> values,
                                            final int lineType) {

        chart.invalidate();
        setChartData(chart, values);
    }

    /**
     * 更新图表
     *
     * @param chart  图表
     * @param values 数据
     * @param xValue x轴刻度
     */
    public static void notifyDataSetChanged(LineChart chart, List<Entry> values,
                                            final String[] xValue) {

        chart.getXAxis().setValueFormatter(new IAxisValueFormatter() {

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                count++;
                Log.i("lite", " count  " + count);
                Log.i("lite", " xValue len  " + xValue.length);
                for (int i = 0; i < xValue.length; i++) {
                    Log.i("lite", " xValue [" + i + "] " + xValue[i]);
                }
                return xValue[(int) value];
            }
        });

        chart.invalidate();
        setChartData(chart, values);
    }

    public static void setSingleLineChartData(LineChart chart, List<Entry> entryList, String label) {
        LineDataSet lineDataSet;
        if (chart.getData() != null && chart.getData().getDataSetCount() > 0) {
            lineDataSet = (LineDataSet) chart.getData().getDataSetByIndex(0);
            lineDataSet.setValues(entryList);
            chart.getData().notifyDataChanged();
            chart.notifyDataSetChanged();
            //设置在曲线图中显示的最大数量
//            chart.setVisibleXRangeMaximum(10);
            //移到某个位置
            chart.moveViewToX(chart.getData().getEntryCount() - 5);
        } else {
            lineDataSet = new LineDataSet(entryList, label);
            lineDataSet.setFillAlpha(110);

            lineDataSet.setColor(Color.parseColor("#1F77B4"));

            lineDataSet.setLineWidth(1f);
            lineDataSet.setValueTextSize(12f);
            lineDataSet.setValueTextColor(Color.BLACK);

            lineDataSet.setDrawCircles(false);
            // 不显示坐标点的数据
            lineDataSet.setDrawValues(false);
            lineDataSet.setValueTextColor(Color.parseColor("#FFFFFF"));
            // 不显示定位线
            lineDataSet.setHighlightEnabled(true);
            List<String> list = new ArrayList<>();
            for (int i = 1; i <= 120; i++) {
                list.add(String.valueOf(i));
            }
            Collections.reverse(list);
            XAxis xAxis = chart.getXAxis();
            xAxis.setValueFormatter(new IndexAxisValueFormatter(list));
            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(lineDataSet);

            LineData data = new LineData(dataSets);

            chart.notifyDataSetChanged();
            chart.invalidate();
            chart.setData(data);
        }
    }

    public static void setMovementChartData(LineChart chart, List<Entry> movemoentList, String label) {
        LineDataSet lineDataSet = new LineDataSet(movemoentList, label);
        lineDataSet.setFillAlpha(110);

        lineDataSet.setColor(Color.parseColor("#1F77B4"));

        lineDataSet.setLineWidth(1f);
        lineDataSet.setValueTextSize(12f);
        lineDataSet.setValueTextColor(Color.BLACK);

        lineDataSet.setDrawCircles(false);
        // 不显示坐标点的数据
        lineDataSet.setDrawValues(false);
        lineDataSet.setValueTextColor(Color.parseColor("#FFFFFF"));
        // 不显示定位线
        lineDataSet.setHighlightEnabled(true);

//        d*0.0514 + 0.4
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 93; i++) {
            float dd = (float)(i*0.0514 + 0.4);
            NumberFormat nf = NumberFormat.getNumberInstance();
            nf.setMaximumFractionDigits(2);
            list.add(String.valueOf(nf.format(dd)));
        }
//        Collections.reverse(list);
        XAxis xAxis = chart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(list));

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet);

        LineData data = new LineData(dataSets);
        chart.notifyDataSetChanged();
        chart.invalidate();
        chart.setData(data);
    }
}


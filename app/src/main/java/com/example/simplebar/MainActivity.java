package com.example.simplebar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BarChart barChart;
    BarDataSet barDataSet;
    BarData barData;
    ArrayList<BarEntry> barEntries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        barChart =findViewById(R.id.bargraph);

        getEntries();

        barDataSet = new BarDataSet(barEntries,"Data set");
        barData =new BarData(barDataSet);

        barChart.setData(barData);

        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);
        String[] day ={"","lundi","mardi","mercredi","jeudi","vendredi","samedi","dimanche"};
        XAxis xAxis=barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(day));
        //xAxis.setCenterAxisLabels(true);
        //xAxis.setGranularity(1);
        //xAxis.setGranularityEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setVisibleXRangeMaximum(3);


    }

    private  void getEntries(){

        barEntries =new ArrayList<>();
        barEntries.add(new BarEntry(1f,2));
        barEntries.add(new BarEntry(2f,5));
        barEntries.add(new BarEntry(3f,10));
        barEntries.add(new BarEntry(4f,8));
        barEntries.add(new BarEntry(5f,3));
        barEntries.add(new BarEntry(6f,1));
        barEntries.add(new BarEntry(7f,10));
    }

}

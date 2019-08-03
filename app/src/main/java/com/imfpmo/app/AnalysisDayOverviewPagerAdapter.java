package com.imfpmo.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.github.mikephil.charting.charts.BarChart;

import java.util.ArrayList;

public class AnalysisDayOverviewPagerAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<AnalysisResultDay> tage;


    public AnalysisDayOverviewPagerAdapter(Context context, ArrayList<AnalysisResultDay> tage){
        this.context = context;
        this.layoutInflater = (LayoutInflater)this.context.getSystemService(this.context.LAYOUT_INFLATER_SERVICE);
        this.tage = tage;
    }

    @NonNull
    public Object instantiateItem(@NonNull ViewGroup container, int position)  {
        View view = this.layoutInflater.inflate(R.layout.analyse_diagram_bar_chart, container, false);
        BarChart barChart = view.findViewById(R.id.diagramm);
        switch (position){
            case 0: AnalysisDiagramMaker.makeTagGesamtCO2BarChart(tage, barChart, context); break;
            case 1: AnalysisDiagramMaker.makeTagGesamtDistanzBarChart(tage,barChart,context); break;
            case 2: AnalysisDiagramMaker.makeTagGesamtZeitBarChart(tage ,barChart,context);break;
        }
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

}

package com.imfpmo.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.github.mikephil.charting.charts.PieChart;

public class AnalyseMonatDiagramPagerAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private AnalyseergebnisMonat monat;


    public AnalyseMonatDiagramPagerAdapter(Context context, AnalyseergebnisMonat monat){
        this.context = context;
        this.layoutInflater = (LayoutInflater)this.context.getSystemService(this.context.LAYOUT_INFLATER_SERVICE);
        this.monat = monat;
    }

    @NonNull
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = this.layoutInflater.inflate(R.layout.analyse_diagram_pie_chart, container, false);
        PieChart pieChart = view.findViewById(R.id.diagramm);
        switch (position){
            case 0: AnalyseDiagramMaker.makeGesamtCO2Diagramm(monat.getCO2Auto(), monat.getCO2Opnv(), pieChart); break;
            case 1: AnalyseDiagramMaker.makeGesamtDistanzDiagramm(monat.getAutoDistanz(),monat.getOpnvDistanz(),monat.getFahrradDistanz(),monat.getFussDistanz(),pieChart); break;
            case 2: AnalyseDiagramMaker.makeGesamtZeitDiagramm(monat.getZeitAuto(),monat.getZeitFahrrad(),monat.getZeitOpnv(), monat.getZeitFuss(),pieChart);break;
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

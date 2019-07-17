package com.imfpmo.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;
import java.util.Objects;

public class AnalysisTagFragment extends Fragment {
    private  AnalyseergebnisTag tagAnalyse;

    public AnalysisTagFragment(AnalyseergebnisTag tag) {
        this.tagAnalyse = tag;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Objects.requireNonNull(getActivity()).setTitle("Analyse");

        View view = inflater.inflate(R.layout.analyse_tag_fragment, container, false);
        BottomNavigationView bottomNav = view.findViewById(R.id.bottom_navigation);
        bottomNav.setSelectedItemId(R.id.nav_analysis);
        ((MainActivity) getActivity()).FragmentListener(bottomNav);
        ListView l = view.findViewById(R.id.listview);

        int monat = tagAnalyse.getTag().get(Calendar.MONTH);
        int jahr = tagAnalyse.getTag().get(Calendar.YEAR);
        int tag = tagAnalyse.getTag().get(Calendar.DAY_OF_MONTH);
        getActivity().setTitle(tag + "." + monat+ "." + jahr);

        AnalyseWegListAdapter listAdapter = new AnalyseWegListAdapter(tagAnalyse);
        l.setAdapter(listAdapter);
        return view;
    }
}
package com.example.mureung.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by HyunJe on 2017-07-26.
 */

public class test extends Fragment {
    private ArrayList<String> day;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragmenta, container, false);


        day = new ArrayList<String>();
        day.add("10 0");
        day.add("11 20");
        day.add("12 50");
        day.add("13 80");
        day.add("14 100");

       String[] s = day.get(0).split("\\s");
        Log.e("parsing",""+s);










        return view;}
}

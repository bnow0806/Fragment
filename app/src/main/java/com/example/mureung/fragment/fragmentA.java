package com.example.mureung.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class fragmentA extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmenta, container, false);

        double lat=37.541;
        double lng=126.986;
        Uri uri=Uri.parse("geo:"+lat+","+lng+"?q=@"+lat+","+lng);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

        return view;
    }

}

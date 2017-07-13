package com.example.mureung.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by HyunJe on 2017-07-13.
 */

//실시간 대쉬보드, 연료탭 모드
public class fragmentB extends Fragment {
    double avgfuel = 1560;
//평균 유류비 선언
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragmentb, container, false);
        //inflate 로 fragment layout 설정

        final TextView fuel1=(TextView)view.findViewById(R.id.fuel1);
        fuel1.setText(avgfuel+"원");
        //text 값 데이터로 설정




return view;
}}

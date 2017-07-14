package com.example.mureung.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;


/**
 * Created by HyunJe on 2017-07-13.
 */

//실시간 대쉬보드, 연료탭 모드
public class fragmentB extends Fragment {
    double avgfuel = 1560;
//평균 유류비 초기값 선언
    private  static  final int PROGRESS=0x1;
    private ProgressBar mProgress;
    private  int mProgressStatus=0;
    int i=0;
    private TextView progress;
   //progressbar 변수 및 초기값 선언

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentb, container, false);
        //inflate 로 fragment layout 설정

        TextView fuel1=(TextView)view.findViewById(R.id.fuel1);
        progress=(TextView)view.findViewById(R.id.progress);
        fuel1.setText(avgfuel+"원");
        //text에 들어갈 값을 데이터로 설정

        mProgress=(ProgressBar) view.findViewById(R.id.progress_bar);

        //progress bar 선언
        //progress bar 동작 정의-작업스레드 정의
        new Thread(new Runnable() {
            @Override
            public void run() {
                //실재 동작 함수
                while (mProgressStatus<1000){
                    try{
                        Thread.sleep(10);//()시간동안 기다리는 함수
                    }catch (Exception e){}

                    i=i+1;
                    mProgressStatus= i;//status값 1씩 증가

                    //progressbar ui 업데이트-ui스레드
                    mProgress.post(new Runnable() {
                        @Override
                        public void run() {
                            mProgress.setProgress(mProgressStatus);
                            progress.setText((double)mProgressStatus/10+"%");
                        }
                    });
                }
            }
        }).start();
return view;
}}

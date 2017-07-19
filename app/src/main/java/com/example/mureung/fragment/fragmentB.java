package com.example.mureung.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by HyunJe on 2017-07-14.
 */

//실시간 대쉬보드, 연료탭 모드
public class fragmentB extends Fragment {
    double avgfuel = 1560;
//평균 유류비 초기값 선언

    /*private  static  final int PROGRESS=0x1;
    private  int mProgressStatus=0;
    int i=0;*/ //작업스레드 변수선언

    private ProgressBar mProgress;
    Handler handler;
    public WorkerTread thread=null;
    TextView progress;
    EditText eidtsrc;
    String srcdata=null;
    public int oldsrcdata=0;
   //progressbar 변수 및 초기값 선언

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragmentb2, container, false);
        //inflate 로 fragment layout 설정

        TextView fuel1=(TextView)view.findViewById(R.id.fuel1);
        progress=(TextView)view.findViewById(R.id.progress);


        //layout 값들 선언

        View.OnClickListener listener=new View.OnClickListener(){//onclick에 스레드멈춤담는법 없을까?-무의미
            public void onClick(View v){
                eidtsrc=(EditText)view.findViewById(R.id.edit_src) ;
                srcdata = eidtsrc.getText().toString();
                Log.e("111",srcdata);

                thread= new WorkerTread(handler, srcdata, oldsrcdata);
                thread.what=0;
                thread.start();

                //timer 로 일정시간후 thread 반복 동작을 멈추게함

               /* new Timer().schedule(new TimerTask() { public void run() {
                    thread.what=1;
                    oldsrcdata=thread.endsrcdata;
                    Log.e("777",String.valueOf(oldsrcdata));
                } }, 3000);*/

                /*oldsrcdata=thread.endsrcdata;
                Log.e("777",String.valueOf(oldsrcdata));*/
                }

        };
        Button button=(Button)view.findViewById(R.id.button);
        button.setOnClickListener(listener);

        View.OnClickListener listener2=new View.OnClickListener(){
            public void onClick(View v){
                thread.what=1;
                oldsrcdata=thread.endsrcdata;//선후관계 확실하게 해줘야됨!
            }
        };
                Button button2=(Button)view.findViewById(R.id.button2);
                button2.setOnClickListener(listener2);
    //reset button 으로 제어하는 방법

        fuel1.setText(avgfuel+"원");
        //퍼센트값 text에 들어갈 값을 데이터로 설정
        mProgress=(ProgressBar) view.findViewById(R.id.progress_bar);
        mProgress.setProgress(0);
        progress.setText(0.0+"%");//progressbar 옆 숫자 초기값 지정

        //handler class를 이용한 ui스레드 제어
        handler=new Handler(){
            public void handleMessage(Message msg){
                mProgress.setProgress(msg.arg1);
                progress.setText((double)msg.arg1/10+"%");
                Log.e("444","444");
            }
        };
        /*thread= new WorkerTread(handler, srcdata);
        thread.start();*/
        return view;
}



}







//progress bar 동작 정의-작업스레드 정의(자체정의 방법)
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                //실제 동작 함수
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
                            progress.setText((double)mProgressStatus/10+"%");//progressbar, text 출력
                        }
                    });
                }
            }
        }).start();*/


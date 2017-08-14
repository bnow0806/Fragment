package com.example.mureung.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.example.mureung.fragment.WorkerThread;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
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
    private ProgressBar mProgress;
    Handler handler;
    public WorkerThread thread=null;
    TextView progress;
    EditText eidtsrc;
    String srcdata;
    public int oldsrcdata=0;
   //progressbar 변수 및 초기값 선언

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragmentb2, container, false);

        //inflate 로 fragment layout 설정

        TextView fuel1=(TextView)view.findViewById(R.id.fuel1);
        progress=(TextView)view.findViewById(R.id.progress);
       /* thread= new WorkerTread(handler, srcdata, oldsrcdata);
        thread.what=1;*/

        //handler class를 이용한 ui스레드 제어
        handler=new Handler(){
            public void handleMessage(Message msg){     //thread로 부터 메세지 받아옴

                mProgress.setProgress(msg.arg1);
                progress.setText((double)msg.arg1/10+"%");
                Log.e("Handler is running","444");
            }
        };

        //layout 값들 선언
        thread=  new WorkerThread (handler, null);          //oldsrc는 1개의 스레드 일시 계속 주입해줄 필요 없어서 없앴음-i로 대체
        thread.start();
        View.OnClickListener listener=new View.OnClickListener(){

            public void onClick(View v){

                thread.what=1;      //i증감 반복 중지
                oldsrcdata=thread.endsrcdata;

                eidtsrc=(EditText)view.findViewById(R.id.edit_src);
                srcdata = eidtsrc.getText().toString();
                Log.e("editsrc-srcdata :",srcdata);

               /* thread=  new WorkerThread(handler, srcdata, oldsrcdata);*/    //여기가 문제!!!!- 하나의 스레드 연속생성

                thread.src= Integer.parseInt(srcdata);      //src에 직접 할당
                thread.i= oldsrcdata;                       //i에 직접 할당
                thread.what=0;      //i증감 반복 시작

                Log.e("onClick last","999");

                }

        };
        Button button=(Button)view.findViewById(R.id.button);
        button.setOnClickListener(listener);

        View.OnClickListener listener2=new View.OnClickListener(){      //reset button 으로 제어하는 방법
            public void onClick(View v){
                thread.what=1;                  //살아있음에도 계속 break 되는것!!!
                oldsrcdata=thread.endsrcdata;
            }
        };
                Button button2=(Button)view.findViewById(R.id.button2);
                button2.setOnClickListener(listener2);


        fuel1.setText(avgfuel+"원");
        //퍼센트값 text에 들어갈 값을 데이터로 설정
        mProgress=(ProgressBar) view.findViewById(R.id.progress_bar);
        mProgress.setProgress(0);
        progress.setText(0.0+"%");//progressbar 옆 숫자 초기값 지정

        return view;
}
}






//timer 로 일정시간후 thread 반복 동작을 멈추게함

               /* new Timer().schedule(new TimerTask() { public void run() {
                    thread.what=1;
                    oldsrcdata=thread.endsrcdata;
                    Log.e("777",String.valueOf(oldsrcdata));
                } }, 3000);*/


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


package com.example.mureung.fragment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;


/**
 * Created by HyunJe on 2017-07-14.
 */
//작업 스레드(handler 클래스를 이용)-progressbar

public class WorkerThread extends Thread {
    Handler handler;
    static int endsrcdata=0;
    String srcdata = null;
    int oldsrcdata=0;
    int src;
    //thread 입력 인자값 선언

    int what = 0;// 현재값

    WorkerThread(Handler handler, String srcdata, int oldsrcdata) {
        this.handler = handler;
        this.srcdata = srcdata;
        this.oldsrcdata = oldsrcdata;}  // thread 입력 인자값 할당

    public void run() {
        if(this.srcdata==null){src=0;}
        else{src = Integer.parseInt(srcdata);}    //형변환

        int i=this.oldsrcdata;
        Log.e("src:", String.valueOf(src));
        Log.e("i:", String.valueOf(i));
/*        while (what==0) {*/
        Log.e("thread is running", "888");
        if (i == src) {
           // 유지코드
        }
        if (i < src) {
            while (i < src) {
                try {
                    Thread.sleep(10);//기다리는 함수
                } catch (Exception e) {
                }

                i = i + 1; // i값을 증가시켜 src에 가깝게 바꿔감
                Message msg = new Message();
                msg.arg1 = i;
                handler.sendMessage(msg); //handler을 통해 fragment에 정보전달
                endsrcdata = i; // 마지막 srcdata 값을 저장함-스레드 리셋 시 oldsrcdata=endsrcdata함

                if (this.what == 1) {   //thread 소멸 조건 부합시 소멸함
                    break;}

            }} else if (i > src) {
                while (i > src) {
                    try {
                        Thread.sleep(10);//기다리는 함수
                    } catch (Exception e) {
                    }

                    i = i - 1;
                    Message msg = new Message();
                    msg.arg1 = i;
                    handler.sendMessage(msg);
                    endsrcdata = i;

                    if (this.what == 1) {
                        break;}
                }
            }
        }
    }

/*}*/






//i를 0~1000, 1000~0, 0~1000 시뮬레이터
   /*for(int i=0;i<1001;i++){
        try{
            Thread.sleep(10);//기다리는 함수
        }catch(Exception e){}
        Message msg=new Message();
        msg.arg1=i;
        handler.sendMessage(msg);}

    for(int j=1001;j>0;j--){
        try{
            Thread.sleep(10);
        }catch(Exception e){}
        Message msg=new Message();
        msg.arg1=j;
        handler.sendMessage(msg);}
    for(int k=0;k<1001;k++){
        try{
            Thread.sleep(10);
        }catch(Exception e){}
        Message msg=new Message();
        msg.arg1=k;
        handler.sendMessage(msg);}*/

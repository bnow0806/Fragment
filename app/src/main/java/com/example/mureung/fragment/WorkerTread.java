package com.example.mureung.fragment;
import android.os.Handler;
import android.os.Message;



/**
 * Created by HyunJe on 2017-07-14.
 */
//작업 스레드(handler 클래스를 이용)-progressbar

public class WorkerTread extends Thread {
Handler handler;

    WorkerTread(Handler handler){
        this.handler=handler;
    }
public void run(){

//i를 0~1000, 1000~0, 0~1000 시뮬레이터
    for(int i=0;i<1001;i++){
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
        handler.sendMessage(msg);}
}}
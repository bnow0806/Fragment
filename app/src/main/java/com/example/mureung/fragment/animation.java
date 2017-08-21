package com.example.mureung.fragment;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Mureung on 2017-08-21.
 */

public class animation extends Fragment {
    private ProgressBar progressBar,progressBar2;
    private Handler h,h2;
    TextView text,text2;
    int progress=0;
    int progress2=0;
    EditText editsrc,editsrc2;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.animation_test, container, false);


        progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        progressBar.setProgress(0);
        h = new Handler();

        progressBar2 = (ProgressBar) view.findViewById(R.id.progress_bar2);
        progressBar2.setProgress(0);
        h2 = new Handler();


        text=(TextView)view.findViewById(R.id.progress);
        text.setText(0.0+"%");
        editsrc=(EditText)view.findViewById(R.id.edit_src);

        text2=(TextView)view.findViewById(R.id.progress2);
        text2.setText(0.0+"%");
        editsrc2=(EditText)view.findViewById(R.id.edit_src2);


        View.OnClickListener listener=new View.OnClickListener(){
            public void onClick(View v){

                progress = Integer.parseInt(editsrc.getText().toString());
                Log.e("progress!!!!!",""+progress);

                h.post(myRunnable);
            }

        };

        View.OnClickListener listener2=new View.OnClickListener(){
            public void onClick(View v){

                progress2 = Integer.parseInt(editsrc2.getText().toString());
                h2.post(myRunnable2);
        }

        };

        Button button=(Button)view.findViewById(R.id.button);
        button.setOnClickListener(listener);

        Button button2=(Button)view.findViewById(R.id.button2);
        button2.setOnClickListener(listener2);

        return view;
    }


    private Runnable myRunnable = new Runnable() {
        public void run() {

            if (progressBar.getProgress() < progress) {
                progressBar.incrementProgressBy(1);
                progressBar.invalidate();
                text.setText(String.valueOf((double)progressBar.getProgress()/10)+"%");
                h.postDelayed(myRunnable, 5);
            }
            if (progressBar.getProgress() > progress) {
                progressBar.incrementProgressBy(-1);
                progressBar.invalidate();
                text.setText(String.valueOf((double)progressBar.getProgress()/10)+"%");
                h.postDelayed(myRunnable, 5);
            }
           Log.e("alive1","run");
        }
};

    private Runnable myRunnable2 = new Runnable() {
        public void run() {

            if (progressBar2.getProgress() < progress2) {
                progressBar2.incrementProgressBy(1);
                progressBar2.invalidate();
                text2.setText(String.valueOf((double)progressBar2.getProgress()/10)+"%");
                h2.postDelayed(myRunnable2, 5);
            }
            if (progressBar2.getProgress() > progress2) {
                progressBar2.incrementProgressBy(-1);
                progressBar2.invalidate();
                text2.setText(String.valueOf((double)progressBar2.getProgress()/10)+"%");
                h2.postDelayed(myRunnable2, 5);
            }
            Log.e("alive2","run");
        }
    };

 /*   private Runnable myRunnable2 = new Runnable() {
        public void run() {
            Log.e("alive2","run");
            h2.postDelayed(myRunnable2, 5);
        }
    };*/

}


package com.example.mureung.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ViewFlipper;

/**
 * Created by HyunJe on 2017-07-26.
 */
public class test extends Activity implements View.OnTouchListener{

    ViewFlipper flipper;
    int counter=1;

    // 터치 이벤트 발생 지점의 x좌표 저장
    float xAtDown;
    float xAtUp;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        flipper.setOnTouchListener(this);

        TextView view1=(TextView) findViewById(R.id.view1);
        view1.setText(String.valueOf(counter));
    }


    // flipper 터치 이벤트 리스너
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        TextView view1=(TextView) findViewById(R.id.view1);
        // 터치 이벤트가 일어난 뷰가 ViewFlipper가 아니면 return
        if (v != flipper)
            return false;

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            xAtDown = event.getX(); // 터치 시작지점 x좌표 저장
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            xAtUp = event.getX(); // 터치 끝난지점 x좌표 저장

            if (xAtUp < xAtDown) {
                // 다음 view 보여줌
               /* flipper.showNext();*/

               counter=counter+1;
                view1.setText(String.valueOf(counter));

            } else if (xAtUp > xAtDown) {
                // 전 view 보여줌
                /*flipper.showPrevious();*/

                counter=counter-1;
                view1.setText(String.valueOf(counter));
            }
        }
        return true;
    }
}

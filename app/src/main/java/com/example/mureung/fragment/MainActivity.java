package com.example.mureung.fragment;

import android.os.Process;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;


/**
 * Created by HyunJe on 2017-07-21.
 */

public class MainActivity extends AppCompatActivity{


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
        android.os.Process.killProcess(Process.myPid());
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       /* vp = (ViewPager)findViewById(R.id.vp);                                    //viewpager 이용방법- 중심이동 어떻게???
        vp.setAdapter(new pagerAdapter(getSupportFragmentManager()));

        vp.setCurrentItem(1);*/

    }


    /*private class pagerAdapter extends FragmentStatePagerAdapter
    {
        public pagerAdapter(android.support.v4.app.FragmentManager fm)
        {
            super(fm);
        }
        @Override
        public android.support.v4.app.Fragment getItem(int position)
        {
            switch(position)
            {

                case 0:
                    vp.setCurrentItem(position-1,true);
                    return new first_view();
                case 1:
                    return new second_view();
                case 2:
                    vp.setCurrentItem(position+1,true);
                    return new third_view();
                default:
                    return null;
            }
        }
        @Override
        public int getCount()
        {
            return 3;
        }
    }
*/
}

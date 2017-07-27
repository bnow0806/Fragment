package com.example.mureung.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Mureung on 2017-07-27.
 */

public class third_view extends Fragment
{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.view2, container, false);

        TextView text2=(TextView) layout.findViewById(R.id.text2);
        second_view secondView=new second_view();
        text2.setText(String.valueOf(secondView.center+1));
        return layout;
    }
}

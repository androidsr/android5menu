package com.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by sirui on 2016/7/22.
 */
public class TwoFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.custom_tab, container, false);
        TextView tv = (TextView) view.findViewById(R.id.id_tv);
        tv.setText("TwoFragment");
        return view;
    }
}

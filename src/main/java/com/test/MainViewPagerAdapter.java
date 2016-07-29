package com.test;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    private Drawable[] selectedIcon;
    private Fragment[] fmt;
    private String[] mTitles;
    private Context context;

    public MainViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        mTitles = context.getResources().getStringArray(R.array.main_m_titles);
        fmt = new Fragment[]{new OneFragment(), new TwoFragment(), new ThreeFragment(), new FourFragment()};
        selectedIcon = new Drawable[]{ContextCompat.getDrawable(context, R.drawable.main_m_item1),
                ContextCompat.getDrawable(context, R.drawable.main_m_item2),
                ContextCompat.getDrawable(context, R.drawable.main_m_item3),
                ContextCompat.getDrawable(context, R.drawable.main_m_item4)};
    }

    @Override
    public Fragment getItem(int position) {
        return fmt[position];
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    public View getTabView(int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.tab_item, null);
        TextView tv = (TextView) view.findViewById(R.id.textView);
        tv.setText(mTitles[position]);
        ImageView img = (ImageView) view.findViewById(R.id.imageView);
        img.setImageDrawable(selectedIcon[position]);
        return view;
    }
}
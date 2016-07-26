package com.test;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private String[] mTitles;
    private Drawable[] defaultIcon;
    private Drawable[] selectedIcon;
    private TabLayout mTablayout;
    private ViewPager mViewPager;
    private Toolbar toolbar;
    private Menu menu;
    private int[] menus = new int[]{
            R.menu.menu_one,
            R.menu.menu_two,
            R.menu.menu_three,
            R.menu.menu_four
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initEvents();
    }

    private void initEvents() {
        mTablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.setIcon(selectedIcon[tab.getPosition()]);
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setIcon(defaultIcon[tab.getPosition()]);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                toolbar.setTitle(mTitles[position]);
                menu.clear();
                getMenuInflater().inflate(menus[position], menu);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initViews() {

        mTitles = new String[]{"主页", "动态", "发现", "我的"};

        defaultIcon = new Drawable[]{ContextCompat.getDrawable(getBaseContext(), R.mipmap.tab_my_normal),
                ContextCompat.getDrawable(getBaseContext(), R.mipmap.tab_channel_normal),
                ContextCompat.getDrawable(getBaseContext(), R.mipmap.tab_message_normal),
                ContextCompat.getDrawable(getBaseContext(), R.mipmap.tab_better_normal)};

        selectedIcon = new Drawable[]{ContextCompat.getDrawable(getBaseContext(), R.mipmap.tab_my_pressed),
                ContextCompat.getDrawable(getBaseContext(), R.mipmap.tab_channel_pressed),
                ContextCompat.getDrawable(getBaseContext(), R.mipmap.tab_message_pressed),
                ContextCompat.getDrawable(getBaseContext(), R.mipmap.tab_better_pressed)};

        mTablayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(mTitles[0]);
        setSupportActionBar(toolbar);

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                if (position == 1) {
                    return new TwoFragment();
                } else if (position == 2) {
                    return new ThreeFragment();
                } else if (position == 3) {
                    return new FourFragment();
                }
                return new OneFragment();
            }

            @Override
            public int getCount() {
                return mTitles.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles[position];
            }
        });

        mTablayout.setupWithViewPager(mViewPager);
        int index = 0;
        mTablayout.getTabAt(index).setIcon(selectedIcon[index]);
        index++;
        mTablayout.getTabAt(index).setIcon(defaultIcon[index]);
        index++;
        mTablayout.getTabAt(index).setIcon(defaultIcon[index]);
        index++;
        mTablayout.getTabAt(index).setIcon(defaultIcon[index]);
        mViewPager.setOffscreenPageLimit(index);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        menu.clear();
        getMenuInflater().inflate(R.menu.menu_one, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_exit:
                System.exit(0);
                break;
            case R.id.action_exit2:
                System.out.println("进入了。");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}

package com.test;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
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

    //切换时菜单同步切换
    private void initEvents() {
        mViewPager.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                toolbar.setTitle(mTablayout.getTabAt(position).getText());
                menu.clear();
                getMenuInflater().inflate(menus[position], menu);
            }
        });
    }

    //初始化控件。
    private void initViews() {
        mTablayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        MainViewPagerAdapter adapter = new MainViewPagerAdapter(getSupportFragmentManager(), getBaseContext());
        mViewPager.setAdapter(adapter);
        mTablayout.setupWithViewPager(mViewPager);
        for (int i = 0; i < mTablayout.getTabCount(); i++) {
            TabLayout.Tab tab = mTablayout.getTabAt(i);
            tab.setCustomView(adapter.getTabView(i));
        }

        mTablayout.getTabAt(0).getCustomView().setSelected(true);
        getSupportActionBar().setTitle(mTablayout.getTabAt(0).getText());
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

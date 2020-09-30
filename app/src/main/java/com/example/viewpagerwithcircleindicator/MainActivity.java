package com.example.viewpagerwithcircleindicator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.widget.RelativeLayout;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout mRelative;
    private ViewPager mPager;
    private CirclePageIndicator indicator;
    private int currentPage = 0;
    private int NUM_PAGES = 0;
    private int delay = 2000, period = 1000;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        mPager = findViewById(R.id.pager);
        indicator = findViewById(R.id.indicator1);
        mRelative = findViewById(R.id.relativeLayout);

        slider();
    }

    private void slider() {
        mPager.setAdapter(new TestSlidingAdapter(mContext));
        indicator.setViewPager(mPager);
        final float density = getResources().getDisplayMetrics().density;

        //Set circle indicator radius
        indicator.setRadius(5 * density);
        NUM_PAGES = 10;

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, delay, period);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });
    }
}
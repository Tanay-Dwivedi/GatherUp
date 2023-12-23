package com.event.gatherup.OnBoardingFiles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.event.gatherup.LoginScreen;
import com.event.gatherup.R;

public class OnBoarding extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout linearLayout;
    Button skip_button;

    TextView [] dots;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        skip_button = findViewById(R.id.skipButton);
        viewPager = (ViewPager) findViewById(R.id.onBoardingView);
        linearLayout = findViewById(R.id.pageIndicator);
        viewPagerAdapter = new ViewPagerAdapter(this);

        viewPager.setAdapter(viewPagerAdapter);

        skip_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnBoarding.this, LoginScreen.class);
                startActivity(intent);
                finish();
            }
        });

        setPageIndicator(0);
        viewPager.addOnPageChangeListener(viewListener);

    }

    public void setPageIndicator(int position) {
        dots = new TextView[4];
        linearLayout.removeAllViews();

        for(int i=0; i<dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText("⦿");
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.inactive, getApplicationContext().getTheme()));
            linearLayout.addView(dots[i]);
        }

        dots[position].setTextColor(getResources().getColor(R.color.active, getApplicationContext().getTheme()));

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            setPageIndicator(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

}
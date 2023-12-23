package com.event.gatherup.OnBoardingFiles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.event.gatherup.R;

public class ViewPagerAdapter extends PagerAdapter {

    Context context;
    int[] desc = {
            R.string.sc1,
            R.string.sc2,
            R.string.sc3,
            R.string.sc4
    };

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

//    int [] images = {
//            R.drawable.img1,
//            R.drawable.img1,
//            R.drawable.img1,
//            R.drawable.img1,
//    };

    @Override
    public int getCount() {
        return desc.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.on_boarding_screen_1, container, false);

        TextView screen_text = (TextView) view.findViewById(R.id.screen_text);

        screen_text.setText(desc[position]);

        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }
}

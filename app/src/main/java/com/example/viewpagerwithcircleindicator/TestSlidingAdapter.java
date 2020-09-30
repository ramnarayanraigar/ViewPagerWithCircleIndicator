package com.example.viewpagerwithcircleindicator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

public class TestSlidingAdapter extends PagerAdapter {
    private static final String TAG = TestSlidingAdapter.class.getSimpleName();
    private Context mContext;

    public TestSlidingAdapter(Context context) {
        mContext = context;
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return 10;
    }


    @NonNull
    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = LayoutInflater.from(view.getContext()).inflate(R.layout.item_image, view, false);

        assert imageLayout != null;

        MyViewHolder holder = new MyViewHolder(imageLayout);


        Picasso
                .get()
                .load("http://i.imgur.com/DvpvklR.png")
                .resize((int) mContext.getResources().getDimension(R.dimen._315sdp), (int) mContext.getResources().getDimension(R.dimen._150sdp))
                .into(holder.mImageViewSlider);

        view.addView(imageLayout, 0);

        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageViewSlider;

        public MyViewHolder(View view) {
            super(view);
            mImageViewSlider = view.findViewById(R.id.image_slider);
        }
    }
}


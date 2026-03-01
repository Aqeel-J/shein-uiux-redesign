package com.shein.sheinapplication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.material.tabs.TabLayout;
import com.shein.sheinapplication.adapters.FlashSaleVPAdapter;
import com.shein.sheinapplication.fragments.ComingLaterFragment;
import com.shein.sheinapplication.fragments.ComingSoonFragment;
import com.shein.sheinapplication.fragments.FilterFragment;
import com.shein.sheinapplication.fragments.OnSaleNowFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FlashSaleActivity extends AppCompatActivity {

    public FrameLayout filterFrameLayout;

    public ToggleButton btnLayoutManager;
    ImageButton btnReturnHome, btnOpenFilter;
    TextView onSaleNowDateView, comingLaterDateView, comingSoonDateView;
    FrameLayout onSaleNowTabLayout, comingLaterTabLayout, comingSoonTabLayout;
    View tabIndicator1, tabIndicator2, tabIndicator3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_sale);
        getSupportActionBar().hide();

        ImplementingUIElements();
        //FlashSaleTabManager();
        TabItemLayout();

        btnReturnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FlashSaleActivity.this, HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .add(R.id.filterFragmentFrameLayout, new FilterFragment(), "FilterFragment")
                .commit();

        btnOpenFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterFrameLayout.setVisibility(View.VISIBLE);
                Animation aniSlide = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
                filterFrameLayout.startAnimation(aniSlide);
            }
        });
    }

    private void TabItemLayout() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM.dd");
        String today = simpleDateFormat.format(calendar.getTime());

        calendar.add(Calendar.DAY_OF_YEAR, 1);
        String tomorrow = String.valueOf(simpleDateFormat.format(calendar.getTime()));

        calendar.add(Calendar.DAY_OF_YEAR, 1);
        String dayAfterTomorrow = String.valueOf(simpleDateFormat.format(calendar.getTime()));

        onSaleNowDateView.setText(today);
        comingLaterDateView.setText(tomorrow);
        comingSoonDateView.setText(dayAfterTomorrow);

        FragmentManager fragmentManager = getSupportFragmentManager();

        onSaleNowTabLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tabIndicator1.setVisibility(View.VISIBLE);
                tabIndicator2.setVisibility(View.INVISIBLE);
                tabIndicator3.setVisibility(View.INVISIBLE);
                tabIndicator1.animate().x(0).setDuration(500);

                if (fragmentManager.findFragmentByTag("OnSaleNowFragment") != null) {
                    fragmentManager
                            .beginTransaction()
                            .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_left)
                            .replace(R.id.fragmentViewPageLayout, new OnSaleNowFragment(), "OnSaleNowFragment")
                            .addToBackStack(null)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .commit();
                }
            }
        });

        comingLaterTabLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tabIndicator1.setVisibility(View.INVISIBLE);
                tabIndicator2.setVisibility(View.VISIBLE);
                tabIndicator3.setVisibility(View.INVISIBLE);
                tabIndicator2.animate().x(0).setDuration(500);

                fragmentManager
                        .beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left)
                        .replace(R.id.fragmentViewPageLayout, new ComingLaterFragment(), "ComingLaterFragment")
                        .addToBackStack(null)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();
            }
        });

        comingSoonTabLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tabIndicator1.setVisibility(View.INVISIBLE);
                tabIndicator2.setVisibility(View.INVISIBLE);
                tabIndicator3.setVisibility(View.VISIBLE);
                tabIndicator3.animate().x(0).setDuration(500);

                fragmentManager
                        .beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_right)
                        .replace(R.id.fragmentViewPageLayout, new ComingSoonFragment(), "ComingSoonFragment")
                        .addToBackStack(null)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();
            }
        });

        fragmentManager
                .beginTransaction()
                .add(R.id.fragmentViewPageLayout, new OnSaleNowFragment(), "OnSaleNowFragment")
                .commit();
    }

    private void ImplementingUIElements() {
        btnReturnHome = findViewById(R.id.btnReturnHome);

        onSaleNowTabLayout = findViewById(R.id.onSaleLayout);
        comingLaterTabLayout = findViewById(R.id.comingLaterLayout);
        comingSoonTabLayout = findViewById(R.id.comingSoonLayout);

        onSaleNowDateView = findViewById(R.id.lblOnSaleDate);
        comingLaterDateView = findViewById(R.id.lblComingLaterDate);
        comingSoonDateView = findViewById(R.id.lblComingSoonDate);

        tabIndicator1 = findViewById(R.id.tabIndicator1);
        tabIndicator2 = findViewById(R.id.tabIndicator2);
        tabIndicator3 = findViewById(R.id.tabIndicator3);

        btnOpenFilter = findViewById(R.id.btnOpenFilter);
        filterFrameLayout = findViewById(R.id.filterFragmentFrameLayout);

        btnLayoutManager = findViewById(R.id.btnLayoutManager);
    }
}
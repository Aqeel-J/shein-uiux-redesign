package com.shein.sheinapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.shein.sheinapplication.adapters.ImageVPAdapter;

public class SingleProductDetailsActivity extends AppCompatActivity {

    ViewPager swipeImageViewPage;

    // images array
    int[] images = {
            R.drawable.white_crop_top_1,
            R.drawable.white_crop_top_2,
            R.drawable.white_crop_top_3,
            R.drawable.white_crop_top_4,
            R.drawable.white_crop_top_5,
            R.drawable.white_crop_top_6
    };

    // Creating Object of ViewPagerAdapter
    ImageVPAdapter imageVPAdapter;
    ImageButton btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_product_details);
        getSupportActionBar().hide();

        // Initializing the ViewPager Object
        swipeImageViewPage = (ViewPager) findViewById(R.id.imageViewPager);

        // Initializing the ViewPagerAdapter
        imageVPAdapter = new ImageVPAdapter(SingleProductDetailsActivity.this, images);

        // Adding the Adapter to the ViewPager
        swipeImageViewPage.setAdapter(imageVPAdapter);

        btnBack = (ImageButton) findViewById(R.id.btnCloseSingleProductDetails);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
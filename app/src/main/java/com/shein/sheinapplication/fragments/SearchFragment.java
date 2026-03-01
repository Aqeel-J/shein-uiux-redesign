package com.shein.sheinapplication.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.shein.sheinapplication.CategoryActivity;
import com.shein.sheinapplication.R;

public class SearchFragment extends Fragment {

    ImageButton btnBack;
    FrameLayout searchFragmentLayout;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnBack = (ImageButton) view.findViewById(R.id.btnBack);

        CategoryActivity categoryActivity = (CategoryActivity) getActivity();
        searchFragmentLayout = categoryActivity.searchFragmentLayout;

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchFragmentLayout.setVisibility(View.INVISIBLE);
                Animation aniSlide = AnimationUtils.loadAnimation(categoryActivity.getApplicationContext(),R.anim.slide_out_down);
                searchFragmentLayout.startAnimation(aniSlide);
            }
        });
    }
}
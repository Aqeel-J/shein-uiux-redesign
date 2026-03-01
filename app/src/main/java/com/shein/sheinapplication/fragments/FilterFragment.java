package com.shein.sheinapplication.fragments;

import static com.shein.sheinapplication.R.layout.category_dropdown_list_item;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.shein.sheinapplication.FlashSaleActivity;
import com.shein.sheinapplication.R;
import com.shein.sheinapplication.classes.Category;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilterFragment extends Fragment {
    String item[] = {"Accessories", "Curve Plus", "Home Appliances", "Men", "Sports", "Women"};
    AutoCompleteTextView autoCompleteTextView;
    ImageButton btnCloseFilter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_filter, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImplementUIElements(view);

        FlashSaleActivity flashSaleActivity = (FlashSaleActivity) getActivity();
        FrameLayout filterFrameLayout = flashSaleActivity.filterFrameLayout;

        btnCloseFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterFrameLayout.setVisibility(View.INVISIBLE);
                Animation aniSlide = AnimationUtils.loadAnimation(flashSaleActivity.getApplicationContext(), R.anim.slide_out_right);
                filterFrameLayout.startAnimation(aniSlide);
            }
        });

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(requireContext(), category_dropdown_list_item, item);
        autoCompleteTextView.setAdapter(stringArrayAdapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
            }
        });

    }

    private void ImplementUIElements(View view) {
        btnCloseFilter = (ImageButton) view.findViewById(R.id.btnCloseFilter);
        autoCompleteTextView = (AutoCompleteTextView) view.findViewById(R.id.autoCompleteCategoryList);
    }


}
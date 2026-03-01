package com.shein.sheinapplication.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.shein.sheinapplication.FlashSaleActivity;
import com.shein.sheinapplication.R;
import com.shein.sheinapplication.adapters.OnSaleProductGridAdapter;
import com.shein.sheinapplication.adapters.OnSaleProductListAdapter;
import com.shein.sheinapplication.classes.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class OnSaleNowFragment extends Fragment {

    List<Product> products = new ArrayList<Product>();
    RecyclerView onSaleRecycleView;
    TextView lblHoursRemaining, lblMinutesRemaining, lblSecondsRemaining;
    ToggleButton btnLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_on_sale_now, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImplementUIElements(view);
        CountDownClock();

        FlashSaleActivity flashSaleActivity = (FlashSaleActivity) getActivity();
        btnLayoutManager = flashSaleActivity.btnLayoutManager;

        populateOnSaleProductList();
        onSaleRecycleView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        OnSaleProductGridAdapter onSaleProductGridAdapter = new OnSaleProductGridAdapter(products, this);
        onSaleRecycleView.setAdapter(onSaleProductGridAdapter);

        btnLayoutManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnLayoutManager.isChecked()) {
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    onSaleRecycleView.setLayoutManager(linearLayoutManager);
                    OnSaleProductListAdapter onSaleProductListAdapter = new OnSaleProductListAdapter(products, new OnSaleNowFragment());
                    onSaleRecycleView.setAdapter(onSaleProductListAdapter);
                } else {
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
                    gridLayoutManager.setOrientation(gridLayoutManager.VERTICAL);
                    onSaleRecycleView.setLayoutManager(gridLayoutManager);
                    OnSaleProductGridAdapter onSaleProductGridAdapter = new OnSaleProductGridAdapter(products, new OnSaleNowFragment());
                    onSaleRecycleView.setAdapter(onSaleProductGridAdapter);;
                }
            }
        });
    }

    private void populateOnSaleProductList() {
        products.add(new Product(
                "SHEIN Crop Top",
                R.drawable.white_crop_top_1,
                11.00,
                70.00
        ));

        products.add(new Product(
                "SHEIN Crop Top",
                R.drawable.black_crop_top_2,
                11.00,
                45.00
        ));

        products.add(new Product(
                "Knitted Crop Top",
                R.drawable.knitted_crop_top,
                15.00,
                60.00
        ));
    }

    private void ImplementUIElements(View view) {
        lblHoursRemaining = (TextView) view.findViewById(R.id.lblHoursRemaining);
        lblMinutesRemaining = (TextView) view.findViewById(R.id.lblMinutesRemaining);
        lblSecondsRemaining = (TextView) view.findViewById(R.id.lblSecondsRemaining);

        onSaleRecycleView = (RecyclerView) view.findViewById(R.id.onSaleRecycleView);
    }

    private void CountDownClock() {
        // Get Today's Date
        Calendar calendar = Calendar.getInstance();

        // Date format to get Date & Time
        SimpleDateFormat simpleDateTimeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        // Date format to get Hours, Minutes & Seconds
        SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("HH:mm:ss");

        // Date for mat to get Day, Month & Year
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        // Getting Today's Date in Milli Seconds
        long todayMilliSe = calendar.getTimeInMillis();

        // Getting Tomorrows Date
        Calendar calendarTomorrow = Calendar.getInstance();
        calendarTomorrow.add(calendarTomorrow.DAY_OF_YEAR, 1);

        // Appending 7.30 AM to the Tomorrow Date String
        String tomorrowDateTime = simpleDateFormat.format(calendarTomorrow.getTime()) + " 7:30:00";
        Date date;
        try {
            date = simpleDateTimeFormat.parse(tomorrowDateTime);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        // Getting Tomorrow's Date in Milli Seconds
        long tomorrowMilliSe = date.getTime();

        // Getting the difference between today and tomorrow
        long countdown = tomorrowMilliSe - todayMilliSe;

        new CountDownTimer(countdown, 1000) {
            public void onTick(long countdown) {

                // decompose difference into hours, minutes and seconds
                int days = (int) ((countdown / 1000) / 86400);
                int hours = (int) ((countdown / (1000 * 60 * 60)) % 24);
                int minutes = (int) ((countdown / (1000 * 60)) % 60);
                int seconds = (int) ((countdown / 1000) % 60);

                lblHoursRemaining.setText(String.format("%02d", hours));
                lblMinutesRemaining.setText(String.format("%02d", minutes));
                lblSecondsRemaining.setText(String.format("%02d", seconds));
            }

            public void onFinish() {
            }
        }.start();

    }


}
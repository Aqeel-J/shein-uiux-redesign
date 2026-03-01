package com.shein.sheinapplication.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shein.sheinapplication.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ComingSoonFragment extends Fragment {
    TextView lblDaysRemaining, lblHoursRemaining, lblMinutesRemaining, lblSecondsRemaining;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coming_soon, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lblDaysRemaining = (TextView) view.findViewById(R.id.lblDaysRemaining);
        lblHoursRemaining = (TextView) view.findViewById(R.id.lblHoursRemaining);
        lblMinutesRemaining = (TextView) view.findViewById(R.id.lblMinutesRemaining);
        lblSecondsRemaining = (TextView) view.findViewById(R.id.lblSecondsRemaining);

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

        // Getting Day After Tomorrows Date
        Calendar calendarTomorrow = Calendar.getInstance();
        calendarTomorrow.add(calendarTomorrow.DAY_OF_YEAR, 2);

        // Appending 7.30 AM to Day After Tomorrow Date String
        String tomorrowDateTime = simpleDateFormat.format(calendarTomorrow.getTime()) + " 7:30:00";
        Date date;
        try {
            date = simpleDateTimeFormat.parse(tomorrowDateTime);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        // Getting Day After Tomorrow's Date in Milli Seconds
        long tomorrowMilliSe = date.getTime();

        // Getting the difference between today and day after tomorrow
        long countdown = tomorrowMilliSe - todayMilliSe;

        new CountDownTimer(countdown, 1000) {
            public void onTick(long countdown) {

                // decompose difference into days, hours, minutes and seconds
                int days = (int) ((countdown / 1000) / 86400);
                int hours = (int) ((countdown / (1000 * 60 * 60)) % 24);
                int minutes = (int) ((countdown / (1000 * 60)) % 60);
                int seconds = (int) ((countdown / 1000) % 60);

                lblDaysRemaining.setText(String.format("%02d", days));
                lblHoursRemaining.setText(String.format("%02d", hours));
                lblMinutesRemaining.setText(String.format("%02d", minutes));
                lblSecondsRemaining.setText(String.format("%02d", seconds));
            }

            public void onFinish() {
            }
        }.start();
    }
}
package com.shein.sheinapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.net.Inet4Address;

public class ShippingInfoActivity extends AppCompatActivity {

    ImageButton btnReturnHome, btnShoppingBag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_info);
        getSupportActionBar().hide();

        ImplementingUIElements();

        btnReturnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShippingInfoActivity.this, HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        btnShoppingBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShippingInfoActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void ImplementingUIElements(){
        btnReturnHome = findViewById(R.id.btnReturnHome);
        btnShoppingBag = findViewById(R.id.btnShoppingBag);
    }
}
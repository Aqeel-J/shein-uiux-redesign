package com.shein.sheinapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PointsActivity extends AppCompatActivity {

    ImageButton btnReturnAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points);
        getSupportActionBar().hide();
        ImplementUIElements();

        btnReturnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PointsActivity.this, AccountActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

            }
        });
    }

    private void ImplementUIElements() {
        btnReturnAccount = findViewById(R.id.btnReturnAccount);
    }
}
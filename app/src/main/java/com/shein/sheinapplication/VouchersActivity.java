package com.shein.sheinapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.tabs.TabLayout;
import com.shein.sheinapplication.adapters.FlashSaleVPAdapter;
import com.shein.sheinapplication.fragments.ComingLaterFragment;
import com.shein.sheinapplication.fragments.ComingSoonFragment;
import com.shein.sheinapplication.fragments.ExpiredVouchersFragment;
import com.shein.sheinapplication.fragments.OnSaleNowFragment;
import com.shein.sheinapplication.fragments.UnusedVouchersFragment;

public class VouchersActivity extends AppCompatActivity {

    ImageButton btnReturnAccount;
    TabLayout myVouchersTabLayout;
    ViewPager myVouchersViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vouchers);
        getSupportActionBar().hide();
        ImplementUIElements();
        MyVouchersTabManager();

        btnReturnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VouchersActivity.this, AccountActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }

    private void MyVouchersTabManager() {
        myVouchersTabLayout.setupWithViewPager(myVouchersViewPager);
        FlashSaleVPAdapter flashSaleVPAdapter = new FlashSaleVPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        flashSaleVPAdapter.addFragment(new UnusedVouchersFragment(), "Unused Vouchers");
        flashSaleVPAdapter.addFragment(new ExpiredVouchersFragment(), "Expired Vouchers");
        myVouchersViewPager.setAdapter(flashSaleVPAdapter);
    }

    private void ImplementUIElements() {
        btnReturnAccount = findViewById(R.id.btnReturnAccount);
        myVouchersTabLayout = findViewById(R.id.my_voucher_tab_layout);
        myVouchersViewPager = findViewById(R.id.my_voucher_view_pager);
    }
}
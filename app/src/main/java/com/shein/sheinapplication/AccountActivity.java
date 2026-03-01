package com.shein.sheinapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.shein.sheinapplication.adapters.FlashSaleVPAdapter;
import com.shein.sheinapplication.fragments.RecentlyViewedFragment;
import com.shein.sheinapplication.fragments.RegisterFragment;
import com.shein.sheinapplication.fragments.SignInFragment;
import com.shein.sheinapplication.fragments.WishlistFragment;

import org.intellij.lang.annotations.JdkConstants;

public class AccountActivity extends AppCompatActivity {
    public FrameLayout forgotPasswordLayout;
    public ImageButton btnCloseForgotPassword;
    ImageButton btnHome, btnCategory, btnNewProducts, btnShoppingBag, btnSettings, btnCloseSignInRegister;
    Button btnSignInRegister;
    TextView txtBtnResetViaPhone, txtBtnResetViaEmail;
    TabLayout accountTabLayout, signInRegisterTabLayout;
    ViewPager accountViewPager, signInRegisterViewPager;
    LinearLayout forgotPasswordViaEmailLayout, forgotPasswordViaPhoneLayout, btnVouchers, btnPoints, btnWallet;
    FrameLayout signInRegisterFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        getSupportActionBar().hide();
        ImplementingUIElements();
        AccountTabManager();
        SignInRegisterTabManager();
        ButtonClickEvents();
    }

    // Implementing UI Elements
    private void ImplementingUIElements() {
        btnHome = findViewById(R.id.btnHome);
        btnCategory = findViewById(R.id.btnCategory);
        btnNewProducts = findViewById(R.id.btnNewProducts);
        btnShoppingBag = findViewById(R.id.btnShoppingBag);

        btnSignInRegister = findViewById(R.id.btnSignInRegister);
        btnSettings = findViewById(R.id.btnSettings);

        accountTabLayout = findViewById(R.id.account_tabLayout);
        accountViewPager = findViewById(R.id.account_viewPager);

        btnVouchers = findViewById(R.id.btnVouchers);
        btnPoints = findViewById(R.id.btnPoints);
        btnWallet = findViewById(R.id.btnWallet);

        signInRegisterFrameLayout = findViewById(R.id.signInRegister_frameLayout);
        btnCloseSignInRegister = findViewById(R.id.btnCloseSignInRegister);

        signInRegisterTabLayout = findViewById(R.id.signInRegister_tabLayout);
        signInRegisterViewPager = findViewById(R.id.signInRegister_viewPager);

        forgotPasswordLayout = findViewById(R.id.ForgotPasswordLayout);
        btnCloseForgotPassword = findViewById(R.id.btnCloseForgotPassword);

        forgotPasswordViaEmailLayout = findViewById(R.id.EmailLayout);
        forgotPasswordViaPhoneLayout = findViewById(R.id.PhoneLayout);
        txtBtnResetViaPhone = findViewById(R.id.txtResetViaPhone);
        txtBtnResetViaEmail = findViewById(R.id.txtResetViaEmail);
    }

    // Adding Wishlist & Recently Viewed Fragments to Tab Item
    private void AccountTabManager() {
        accountTabLayout.setupWithViewPager(accountViewPager);
        FlashSaleVPAdapter flashSaleVPAdapter = new FlashSaleVPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        flashSaleVPAdapter.addFragment(new WishlistFragment(), "Wishlist");
        flashSaleVPAdapter.addFragment(new RecentlyViewedFragment(), "Recently Viewed");
        accountViewPager.setAdapter(flashSaleVPAdapter);
    }

    // Adding Sign In & Register Fragments to Tab Item
    private void SignInRegisterTabManager() {
        signInRegisterTabLayout.setupWithViewPager(signInRegisterViewPager);
        FlashSaleVPAdapter flashSaleVPAdapter = new FlashSaleVPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        flashSaleVPAdapter.addFragment(new SignInFragment(), "Sign In");
        flashSaleVPAdapter.addFragment(new RegisterFragment(), "Register");
        signInRegisterViewPager.setAdapter(flashSaleVPAdapter);
    }

    // Functions for Button Click Events
    private void ButtonClickEvents() {
        // Button to open Bottom Navigation Home Activity
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountActivity.this, HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        // Button to open Bottom Navigation Category Activity
        btnCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountActivity.this, CategoryActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        // Button to open Bottom Navigation New Products Activity
        btnNewProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountActivity.this, NewProductsActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        // Button to open Bottom Navigation Shopping Bag Activity
        btnShoppingBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountActivity.this, BagActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        // Button to open Settings Activity
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountActivity.this, SettingsActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        btnVouchers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountActivity.this, VouchersActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        // Button to open Points Activity
        btnPoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountActivity.this, PointsActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        // Button to open Wallet Activity
        btnWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountActivity.this, WalletActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        // Button to open Sign In & Register Bottom Sheet
        btnSignInRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInRegisterFrameLayout.setVisibility(View.VISIBLE);
                TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, signInRegisterFrameLayout.getHeight(), 0);
                translateAnimation.setDuration(500);
                translateAnimation.setFillAfter(true);
                signInRegisterFrameLayout.startAnimation(translateAnimation);
            }
        });

        // Close Button for Sign In & Register Bottom Sheet
        btnCloseSignInRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInRegisterFrameLayout.setVisibility(View.INVISIBLE);
                TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, 0, signInRegisterFrameLayout.getHeight());
                translateAnimation.setDuration(500);
                signInRegisterFrameLayout.startAnimation(translateAnimation);
            }
        });

        // TextView Onclick event for forgot password via phone number
        SpannableString resetViaPhoneString = new SpannableString("Reset password via phone number");
        ClickableSpan clickablePhoneSpan = new ClickableSpan() {
            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }

            @Override
            public void onClick(@NonNull View widget) {
                forgotPasswordViaEmailLayout.setVisibility(View.GONE);
                forgotPasswordViaPhoneLayout.setVisibility(View.VISIBLE);
            }
        };

        resetViaPhoneString.setSpan(clickablePhoneSpan, 0, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        txtBtnResetViaPhone.setText(resetViaPhoneString);
        txtBtnResetViaPhone.setMovementMethod(LinkMovementMethod.getInstance());

        // TextView Onclick event for forgot password via email
        SpannableString resetViaEmailString = new SpannableString("Reset password through email");
        ClickableSpan clickableEmailSpan = new ClickableSpan() {
            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }

            @Override
            public void onClick(@NonNull View widget) {
                forgotPasswordViaPhoneLayout.setVisibility(View.GONE);
                forgotPasswordViaEmailLayout.setVisibility(View.VISIBLE);
            }
        };

        resetViaEmailString.setSpan(clickableEmailSpan, 0, 28, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        txtBtnResetViaEmail.setText(resetViaEmailString);
        txtBtnResetViaEmail.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
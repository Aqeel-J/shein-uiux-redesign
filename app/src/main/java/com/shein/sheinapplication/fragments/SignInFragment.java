package com.shein.sheinapplication.fragments;

import android.accounts.Account;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shein.sheinapplication.AccountActivity;
import com.shein.sheinapplication.R;


public class SignInFragment extends Fragment {
    FrameLayout forgotPasswordLayout;
    TextView btnForgotPassword, txtSignInPolicy;
    ImageButton btnCloseForgotPassword;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImplementUIElements(view);

        // TextView Click Event for Sign In Privacy & Cookie Policy and Terms & Conditions
        SpannableString signInPolicyString = new SpannableString("By signing in to your account, you agree to our Privacy & Cookie Policy and Terms & Conditions.");
        ClickableSpan clickableSignInTermsAndConditions = new ClickableSpan() {
            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }

            @Override
            public void onClick(View textView) {
            }
        };

        ClickableSpan clickableSignInPrivacyPolicy = new ClickableSpan() {
            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }

            @Override
            public void onClick(View textView) {
            }
        };

        signInPolicyString.setSpan(clickableSignInTermsAndConditions, 76, 94, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        signInPolicyString.setSpan(clickableSignInPrivacyPolicy, 48, 71, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        txtSignInPolicy.setText(signInPolicyString);
        txtSignInPolicy.setMovementMethod(LinkMovementMethod.getInstance());
        // -- END -- of Sign In Privacy & Cookie Policy and Terms & Conditions Text Click Event

        // Getting Account Activity Variables
        AccountActivity accountActivity = (AccountActivity) getActivity();
        forgotPasswordLayout = accountActivity.forgotPasswordLayout;
        btnCloseForgotPassword = accountActivity.btnCloseForgotPassword;

        // Click Event for Forgot Password TextView Clickable to open Forgot Password Layout.
        btnForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgotPasswordLayout.setVisibility(View.VISIBLE);
                TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, forgotPasswordLayout.getHeight(), 0);
                translateAnimation.setDuration(500);
                translateAnimation.setFillAfter(true);
                forgotPasswordLayout.startAnimation(translateAnimation);

            }
        });

        // Forgot Password Layout Close Click Event.
        btnCloseForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgotPasswordLayout.setVisibility(View.INVISIBLE);
                TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, 0, forgotPasswordLayout.getHeight());
                translateAnimation.setDuration(500);
                forgotPasswordLayout.startAnimation(translateAnimation);
            }
        });
    }

    // Implementing UI Elements
    private void ImplementUIElements(View view) {
        txtSignInPolicy = (TextView) view.findViewById(R.id.txtSignInPolicy);
        btnForgotPassword = (TextView) view.findViewById(R.id.btnForgotPassword);
    }


}
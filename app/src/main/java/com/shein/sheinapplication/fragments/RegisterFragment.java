package com.shein.sheinapplication.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.shein.sheinapplication.R;

public class RegisterFragment extends Fragment {

    TextInputEditText txtPassword;
    TextView lblMinCharacters, lblMinLetters, lblMinNumbers, txtRegistrationPolicy;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtPassword = (TextInputEditText) view.findViewById(R.id.txtPassword);
        txtRegistrationPolicy = (TextView) view.findViewById(R.id.txtRegistrationTC);

        lblMinCharacters = (TextView) view.findViewById(R.id.min_characters);
        lblMinLetters = (TextView) view.findViewById(R.id.min_letters);
        lblMinNumbers = (TextView) view.findViewById(R.id.min_numbers);

        txtPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    lblMinCharacters.setVisibility(View.VISIBLE);
                    lblMinLetters.setVisibility(View.VISIBLE);
                    lblMinNumbers.setVisibility(View.VISIBLE);
                } else {
                    lblMinCharacters.setVisibility(View.GONE);
                    lblMinLetters.setVisibility(View.GONE);
                    lblMinNumbers.setVisibility(View.GONE);
                }
            }
        });

        txtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (txtPassword.length() == 0) {
                    lblMinCharacters.setTextColor(getResources().getColor(R.color.gray_600));
                    lblMinLetters.setTextColor(getResources().getColor(R.color.gray_600));
                    lblMinNumbers.setTextColor(getResources().getColor(R.color.gray_600));
                } else {
                    if (txtPassword.length() > 7) {
                        lblMinCharacters.setTextColor(getResources().getColor(R.color.success));
                    } else {
                        lblMinCharacters.setTextColor(getResources().getColor(R.color.danger));
                    }

                    if (txtPassword.getText().toString().matches("^.*[a-zA-Z]+.*$")) {
                        lblMinLetters.setTextColor(getResources().getColor(R.color.success));
                    } else {
                        lblMinLetters.setTextColor(getResources().getColor(R.color.danger));
                    }

                    if (txtPassword.getText().toString().matches("^.*[0-9]+.*$")) {
                        lblMinNumbers.setTextColor(getResources().getColor(R.color.success));
                    } else {
                        lblMinNumbers.setTextColor(getResources().getColor(R.color.danger));
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        SpannableString registrationPolicyString = new SpannableString("By registering, you agree to our Privacy & Cookie Policy and Terms & Conditions.");
        ClickableSpan clickableTermsAndConditions = new ClickableSpan() {
            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }

            @Override
            public void onClick(View textView) {
            }
        };

        ClickableSpan clickablePrivacyPolicy = new ClickableSpan() {
            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }

            @Override
            public void onClick(View textView) {
            }
        };
        registrationPolicyString.setSpan(clickableTermsAndConditions, 33, 56, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        registrationPolicyString.setSpan(clickablePrivacyPolicy, 61, 80, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        txtRegistrationPolicy.setText(registrationPolicyString);
        txtRegistrationPolicy.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
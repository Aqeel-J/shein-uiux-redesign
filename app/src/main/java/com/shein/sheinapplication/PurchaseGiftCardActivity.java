package com.shein.sheinapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class PurchaseGiftCardActivity extends AppCompatActivity {

    Button btn800, btn500, btn400, btn300, btn200, btn100, btn80, btnGiftCardCheckout;
    CardView btnGiftCard1, btnGiftCard2, btnGiftCard3, btnGiftCard4;
    ImageView displayGiftCard, btnGiftCardHelp;
    ImageButton btnReturnHome;
    TextView discountPrice, originalPrice, txtTermsAndConditions, txtGiftCardInfo;
    CheckBox chkTermsAndConditions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_gift_card);
        getSupportActionBar().hide();

        ImplementUIElements();
        GiftCardTermsConditions();

        btnReturnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PurchaseGiftCardActivity.this, HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        btnGiftCardHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PurchaseGiftCardActivity.this, GiftCardTermsConditionsActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        btnGiftCard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayGiftCard.setImageResource(R.drawable.gift_card_1);

                btnGiftCard1.setCardBackgroundColor(getResources().getColor(R.color.gray_600));
                btnGiftCard2.setCardBackgroundColor(getResources().getColor(R.color.gray_400));
                btnGiftCard3.setCardBackgroundColor(getResources().getColor(R.color.gray_400));
                btnGiftCard4.setCardBackgroundColor(getResources().getColor(R.color.gray_400));
            }
        });

        btnGiftCard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayGiftCard.setImageResource(R.drawable.gift_card_2);

                btnGiftCard1.setCardBackgroundColor(getResources().getColor(R.color.gray_400));
                btnGiftCard2.setCardBackgroundColor(getResources().getColor(R.color.gray_600));
                btnGiftCard3.setCardBackgroundColor(getResources().getColor(R.color.gray_400));
                btnGiftCard4.setCardBackgroundColor(getResources().getColor(R.color.gray_400));
            }
        });

        btnGiftCard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayGiftCard.setImageResource(R.drawable.gift_card_3);

                btnGiftCard1.setCardBackgroundColor(getResources().getColor(R.color.gray_400));
                btnGiftCard2.setCardBackgroundColor(getResources().getColor(R.color.gray_400));
                btnGiftCard3.setCardBackgroundColor(getResources().getColor(R.color.gray_600));
                btnGiftCard4.setCardBackgroundColor(getResources().getColor(R.color.gray_400));
            }
        });

        btnGiftCard4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayGiftCard.setImageResource(R.drawable.gift_card_4);

                btnGiftCard1.setCardBackgroundColor(getResources().getColor(R.color.gray_400));
                btnGiftCard2.setCardBackgroundColor(getResources().getColor(R.color.gray_400));
                btnGiftCard3.setCardBackgroundColor(getResources().getColor(R.color.gray_400));
                btnGiftCard4.setCardBackgroundColor(getResources().getColor(R.color.gray_600));
            }
        });

        btn800.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                originalPrice.setText("$800.00");
                discountPrice.setText("$650.00");

                btn800.setBackgroundResource(R.drawable.black_border_button);
                btn500.setBackgroundResource(R.drawable.grey_border_button);
                btn400.setBackgroundResource(R.drawable.grey_border_button);
                btn300.setBackgroundResource(R.drawable.grey_border_button);
                btn200.setBackgroundResource(R.drawable.grey_border_button);
                btn100.setBackgroundResource(R.drawable.grey_border_button);
                btn80.setBackgroundResource(R.drawable.grey_border_button);
            }
        });

        btn500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                originalPrice.setText("$500.00");
                discountPrice.setText("$420.00");

                btn800.setBackgroundResource(R.drawable.grey_border_button);
                btn500.setBackgroundResource(R.drawable.black_border_button);
                btn400.setBackgroundResource(R.drawable.grey_border_button);
                btn300.setBackgroundResource(R.drawable.grey_border_button);
                btn200.setBackgroundResource(R.drawable.grey_border_button);
                btn100.setBackgroundResource(R.drawable.grey_border_button);
                btn80.setBackgroundResource(R.drawable.grey_border_button);
            }
        });

        btn400.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                originalPrice.setText("$400.00");
                discountPrice.setText("$340.00");

                btn800.setBackgroundResource(R.drawable.grey_border_button);
                btn500.setBackgroundResource(R.drawable.grey_border_button);
                btn400.setBackgroundResource(R.drawable.black_border_button);
                btn300.setBackgroundResource(R.drawable.grey_border_button);
                btn200.setBackgroundResource(R.drawable.grey_border_button);
                btn100.setBackgroundResource(R.drawable.grey_border_button);
                btn80.setBackgroundResource(R.drawable.grey_border_button);
            }
        });

        btn300.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                originalPrice.setText("300.00");
                discountPrice.setText("$255.00");

                btn800.setBackgroundResource(R.drawable.grey_border_button);
                btn500.setBackgroundResource(R.drawable.grey_border_button);
                btn400.setBackgroundResource(R.drawable.grey_border_button);
                btn300.setBackgroundResource(R.drawable.black_border_button);
                btn200.setBackgroundResource(R.drawable.grey_border_button);
                btn100.setBackgroundResource(R.drawable.grey_border_button);
                btn80.setBackgroundResource(R.drawable.grey_border_button);
            }
        });

        btn200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                originalPrice.setText("$200.00");
                discountPrice.setText("$175.00");

                btn800.setBackgroundResource(R.drawable.grey_border_button);
                btn500.setBackgroundResource(R.drawable.grey_border_button);
                btn400.setBackgroundResource(R.drawable.grey_border_button);
                btn300.setBackgroundResource(R.drawable.grey_border_button);
                btn200.setBackgroundResource(R.drawable.black_border_button);
                btn100.setBackgroundResource(R.drawable.grey_border_button);
                btn80.setBackgroundResource(R.drawable.grey_border_button);
            }
        });

        btn100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                originalPrice.setText("$100.00");
                discountPrice.setText("$90.00");

                btn800.setBackgroundResource(R.drawable.grey_border_button);
                btn500.setBackgroundResource(R.drawable.grey_border_button);
                btn400.setBackgroundResource(R.drawable.grey_border_button);
                btn300.setBackgroundResource(R.drawable.grey_border_button);
                btn200.setBackgroundResource(R.drawable.grey_border_button);
                btn100.setBackgroundResource(R.drawable.black_border_button);
                btn80.setBackgroundResource(R.drawable.grey_border_button);
            }
        });

        btn80.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                originalPrice.setText("$80.00");
                discountPrice.setText("$75.00");

                btn800.setBackgroundResource(R.drawable.grey_border_button);
                btn500.setBackgroundResource(R.drawable.grey_border_button);
                btn400.setBackgroundResource(R.drawable.grey_border_button);
                btn300.setBackgroundResource(R.drawable.grey_border_button);
                btn200.setBackgroundResource(R.drawable.grey_border_button);
                btn100.setBackgroundResource(R.drawable.grey_border_button);
                btn80.setBackgroundResource(R.drawable.black_border_button);
            }
        });

        chkTermsAndConditions.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (chkTermsAndConditions.isChecked()) {
                    btnGiftCardCheckout.setEnabled(true);
                } else {
                    btnGiftCardCheckout.setEnabled(false);
                }
            }
        });
    }

    private void GiftCardTermsConditions() {
        //Terms and Conditions
        SpannableString spannableString = new SpannableString("By placing this order, I agree that I have read and understood the Terms and Conditions.");
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }

            @Override
            public void onClick(View textView) {
                Intent intent = new Intent(PurchaseGiftCardActivity.this, GiftCardTermsConditionsActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        };
        spannableString.setSpan(clickableSpan, 67, 87, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        txtTermsAndConditions.setText(spannableString);
        txtTermsAndConditions.setMovementMethod(LinkMovementMethod.getInstance());

        // Help
        SpannableString helpString = new SpannableString("Give the gift that never goes out of style! " +
                "No matter who you're celebrating, SHEINE E-Gift Cards are a super quick and easy way for you " +
                "and your favorite SHEIN babes to shop. Plus, you'll save on each E-Gift Card purchase! Click here " +
                "for more information on E-Gift Cards.");
        ClickableSpan clickableHelp = new ClickableSpan() {
            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }

            @Override
            public void onClick(View textView) {
                Intent intent = new Intent(PurchaseGiftCardActivity.this, GiftCardTermsConditionsActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        };
        helpString.setSpan(clickableHelp, 230, 235, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        txtGiftCardInfo.setText(helpString);
        txtGiftCardInfo.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void ImplementUIElements() {
        btnReturnHome = findViewById(R.id.btnReturnHome);
        btnGiftCardHelp = findViewById(R.id.btnGiftCardHelp);

        btnGiftCard1 = findViewById(R.id.btnGiftCard1);
        btnGiftCard2 = findViewById(R.id.btnGiftCard2);
        btnGiftCard3 = findViewById(R.id.btnGiftCard3);
        btnGiftCard4 = findViewById(R.id.btnGiftCard4);

        displayGiftCard = findViewById(R.id.displayGiftCard);

        btn800 = findViewById(R.id.btn800);
        btn500 = findViewById(R.id.btn500);
        btn400 = findViewById(R.id.btn400);
        btn300 = findViewById(R.id.btn300);
        btn200 = findViewById(R.id.btn200);
        btn100 = findViewById(R.id.btn100);
        btn80 = findViewById(R.id.btn80);

        originalPrice = findViewById(R.id.original_price);
        discountPrice = findViewById(R.id.discount_price);

        btnGiftCardCheckout = findViewById(R.id.btn_gift_card_checkout);
        chkTermsAndConditions = findViewById(R.id.chkTermsConditions);
        txtTermsAndConditions = findViewById(R.id.txtTermsConditions);
        txtGiftCardInfo = findViewById(R.id.txtGiftCardInfo);
    }


}
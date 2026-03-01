package com.shein.sheinapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.BulletSpan;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class GiftCardTermsConditionsActivity extends AppCompatActivity {

    ImageButton btnReturnPurchaseGiftCard;
    TextView txtGiftCardNotReceived, txtGiftCardViewBalance;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gift_card_terms_conditions);
        getSupportActionBar().hide();
        ImplementUIElements();

        btnReturnPurchaseGiftCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GiftCardTermsConditionsActivity.this, PurchaseGiftCardActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        // Bullet
        SpannableString string = new SpannableString("After the gift card has been purchased successfully, it will be sent to the email address on file (or such alternative methods that SHEIN may identify). If you did not receive your gift card number and PIN number, it may be because:\n" +
                "You entered the wrong email address when purchasing the gift card. Please contact Customer Support to confirm and change the email address.\n" +
                "Your inbox is full. Please ensure you have sufficient space in your inbox, then contact Customer Support to resend.\n" +
                "Our emails have been blocked by your mailbox. Please add SHEIN.com to your whitelist, then contact Customer Support to resend.");
        string.setSpan(new BulletSpan(40, R.color.black_400, 10), 233, 372, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        string.setSpan(new BulletSpan(40, R.color.black_400, 10), 373, 489, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        string.setSpan(new BulletSpan(40, R.color.black_400, 10), 489, 615, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        txtGiftCardNotReceived.setText(string);

        // Gift Card Balance
        SpannableString helpString = new SpannableString("You may check your gift card balance in your account.\n" +
                "The balance in your gift card may be used on SHEIN to purchase products and services. The gift card balance cannot be withdrawn for cash.");
        ClickableSpan clickableHelp = new ClickableSpan() {
            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }

            @Override
            public void onClick(View textView) {
            }
        };
        helpString.setSpan(clickableHelp, 19, 36, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        txtGiftCardViewBalance.setText(helpString);
        txtGiftCardViewBalance.setMovementMethod(LinkMovementMethod.getInstance());

    }

    private void ImplementUIElements() {
        btnReturnPurchaseGiftCard = findViewById(R.id.btnReturnPurchaseGiftCard);
        txtGiftCardNotReceived = findViewById(R.id.txtGiftCardNotReceived);
        txtGiftCardViewBalance = findViewById(R.id.txtGiftCardViewBalance);
    }
}
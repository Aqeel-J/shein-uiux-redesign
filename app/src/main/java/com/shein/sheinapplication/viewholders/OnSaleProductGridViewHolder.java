package com.shein.sheinapplication.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.shein.sheinapplication.R;

public class OnSaleProductGridViewHolder extends RecyclerView.ViewHolder {

    public TextView lblDiscount;
    public TextView productPrice;
    public TextView productDiscountPrice;
    public TextView productTitle;
    public ImageView productImg;

    public CardView productCard;

    public OnSaleProductGridViewHolder(@NonNull View itemView) {
        super(itemView);

        lblDiscount = (TextView) itemView.findViewById(R.id.offer_percent);
        productPrice = (TextView) itemView.findViewById(R.id.product_price);
        productDiscountPrice = (TextView) itemView.findViewById(R.id.product_discount_price);
        productTitle = (TextView) itemView.findViewById(R.id.product_title);
        productImg = (ImageView) itemView.findViewById(R.id.product_image);
        productCard = (CardView) itemView.findViewById(R.id.product_card);
    }
}

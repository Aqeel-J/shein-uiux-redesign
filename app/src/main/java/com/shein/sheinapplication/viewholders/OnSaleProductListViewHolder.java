package com.shein.sheinapplication.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shein.sheinapplication.R;

public class OnSaleProductListViewHolder extends RecyclerView.ViewHolder {

    public TextView lblDiscountList;
    public TextView productPriceList;
    public TextView productDiscountPriceList;
    public TextView productTitleList;
    public ImageView productImgList;

    public OnSaleProductListViewHolder(@NonNull View itemView) {
        super(itemView);

        lblDiscountList = (TextView) itemView.findViewById(R.id.list_offer_percent);
        productPriceList = (TextView) itemView.findViewById(R.id.list_product_price);
        productDiscountPriceList = (TextView) itemView.findViewById(R.id.list_product_discount_price);
        productTitleList = (TextView) itemView.findViewById(R.id.list_product_title);
        productImgList = (ImageView) itemView.findViewById(R.id.list_product_image);
    }
}

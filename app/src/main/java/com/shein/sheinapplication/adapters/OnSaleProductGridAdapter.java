package com.shein.sheinapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.shein.sheinapplication.SingleProductDetailsActivity;
import com.shein.sheinapplication.viewholders.OnSaleProductGridViewHolder;
import com.shein.sheinapplication.R;
import com.shein.sheinapplication.classes.Product;

import java.util.List;

public class OnSaleProductGridAdapter extends RecyclerView.Adapter<OnSaleProductGridViewHolder> {
    List<Product> productList;
    // To hold reference to the main activity;
    Fragment fragment;
    Context context;

    public OnSaleProductGridAdapter(List<Product> productList, Fragment fragment) {
        this.productList = productList;
        this.fragment = fragment;
        this.context = fragment.getContext();
    }

    @NonNull
    @Override
    public OnSaleProductGridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.on_sale_item_grid_view, parent, false);

        OnSaleProductGridViewHolder onSaleProductViewHolder = new OnSaleProductGridViewHolder(itemView);

        return onSaleProductViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OnSaleProductGridViewHolder holder, int position) {
        //Get the product object from the list
        Product product = this.productList.get(position);

        // Get a reference to the view holder;
        OnSaleProductGridViewHolder viewHolder = holder;

        //Bind the UI elements with the dats og the category object
        viewHolder.lblDiscount.setText(String.format("-%.0f%%", product.getProductDiscount()));
        viewHolder.productPrice.setText(String.format("%.2f", product.getProductPrice()));
        viewHolder.productTitle.setText(product.getProductName());
        viewHolder.productImg.setImageResource(product.getProductImg());

        double discountPrice = product.getProductPrice() - (product.getProductPrice() * (product.getProductDiscount() / 100));
        viewHolder.productDiscountPrice.setText(String.format("$%.2f", discountPrice));

        viewHolder.productCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,SingleProductDetailsActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}

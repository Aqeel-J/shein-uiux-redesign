package com.shein.sheinapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.shein.sheinapplication.viewholders.OnSaleProductListViewHolder;
import com.shein.sheinapplication.R;
import com.shein.sheinapplication.classes.Product;

import java.util.List;

public class OnSaleProductListAdapter extends RecyclerView.Adapter<OnSaleProductListViewHolder> {
    List<Product> productList;
    // To hold reference to the main activity;
    Fragment fragment;
    public OnSaleProductListAdapter(List<Product> productList, Fragment fragment) {
        this.productList = productList;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public OnSaleProductListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.on_sale_item_list_view, parent, false);

        OnSaleProductListViewHolder onSaleProductListViewHolder = new OnSaleProductListViewHolder(itemView);

        return onSaleProductListViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OnSaleProductListViewHolder holder, int position) {
        //Get the product object from the list
        Product product = this.productList.get(position);

        // Get a reference to the view holder;
        OnSaleProductListViewHolder viewHolder = holder;

        //Bind the UI elements with the dats og the category object
        viewHolder.lblDiscountList.setText(String.format("-%.0f%%", product.getProductDiscount()));
        viewHolder.productPriceList.setText(String.format("%.2f", product.getProductPrice()));
        viewHolder.productTitleList.setText(product.getProductName());
        viewHolder.productImgList.setImageResource(product.getProductImg());

        double discountPrice = product.getProductPrice() - (product.getProductPrice() * (product.getProductDiscount() / 100));
        viewHolder.productDiscountPriceList.setText(String.format("$%.2f", discountPrice));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}

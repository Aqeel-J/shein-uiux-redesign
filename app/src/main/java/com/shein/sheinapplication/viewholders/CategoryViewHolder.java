package com.shein.sheinapplication.viewholders;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shein.sheinapplication.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    public ImageView categoryImg;
    public TextView categoryName;
    public ImageButton btnSubCategory;
    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);

        categoryImg = itemView.findViewById(R.id.categoryImg);
        categoryName = itemView.findViewById(R.id.categoryName);
        btnSubCategory = itemView.findViewById(R.id.btnSubCategory);
    }
}
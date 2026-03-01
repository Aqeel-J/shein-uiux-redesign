package com.shein.sheinapplication.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shein.sheinapplication.classes.Category;
import com.shein.sheinapplication.R;
import com.shein.sheinapplication.viewholders.CategoryViewHolder;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    List<Category> categoryList;
    // To hold reference to the main activity;
    Activity activity;

    public CategoryAdapter(List<Category> categoryList, Activity activity) {
        this.categoryList = categoryList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View itemView = inflater.inflate(R.layout.category_item, parent, false);

        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(itemView);

        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        //Get the category object from the list
        Category category = this.categoryList.get(position);

        // Get a reference to the view holder;
        CategoryViewHolder viewHolder = holder;

        //Bind the UI elements with the dats og the category object
        viewHolder.categoryImg.setImageResource(category.getCategoryImg());
        viewHolder.categoryName.setText(category.getCategoryName());

        viewHolder.btnSubCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity.getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
//                //viewHolder.itemView.setBackground();
//                //Intent intent = new Intent(Intent.ACTION_VIEW, HeroDescriptionActivity.class)
//
                if (category.getCategoryName().equals("Accessories")) {
//                    Intent intent = new Intent(Intent.ACTION_VIEW);
//                    intent.setData(Uri.parse("https://en.wikipedia.org/wiki/Spider-Man"));
                } else if (category.getCategoryName().equals("Curve Plus")) {

                } else if (category.getCategoryName().equals("Electronics")) {

                } else if (category.getCategoryName().equals("Home & Living")) {

                } else if (category.getCategoryName().equals("Men")) {

                } else if (category.getCategoryName().equals("Women")) {

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}




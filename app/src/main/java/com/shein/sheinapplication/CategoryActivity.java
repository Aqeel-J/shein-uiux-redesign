package com.shein.sheinapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.shein.sheinapplication.adapters.CategoryAdapter;
import com.shein.sheinapplication.classes.Category;
import com.shein.sheinapplication.fragments.SearchFragment;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    List<Category> categories = new ArrayList<Category>();
    RecyclerView recyclerView;
    ImageButton btnHome, btnNewProducts, btnShoppingBag, btnAccount;
    EditText txtSearch;
    public FrameLayout searchFragmentLayout;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportActionBar().hide();
        ImplementUIElements();

        populateCategoryList();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CategoryAdapter categoryAdapter = new CategoryAdapter(categories, this);
        recyclerView.setAdapter(categoryAdapter);

        // Button Home Click Event
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

            }
        });

        btnShoppingBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, BagActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, AccountActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        btnNewProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, NewProductsActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .add(R.id.SearchFragmentLayout, new SearchFragment(), "SearchFragment")
                .commit();

        txtSearch.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                searchFragmentLayout.setVisibility(View.VISIBLE);
                Animation aniSlide = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_up);
                searchFragmentLayout.startAnimation(aniSlide);
            }
        });
    }

    private void ImplementUIElements() {
        btnHome = findViewById(R.id.btnHome);
        btnNewProducts = findViewById(R.id.btnNewProducts);
        btnShoppingBag = findViewById(R.id.btnShoppingBag);
        btnAccount = findViewById(R.id.btnAccount);

        recyclerView = findViewById(R.id.categoryRecyclerView);

        txtSearch = findViewById(R.id.txtSearch);
        searchFragmentLayout = findViewById(R.id.SearchFragmentLayout);
    }

    private void populateCategoryList() {
        categories.add(new Category(
                "Accessories",
                R.drawable.accessories
        ));

        categories.add(new Category(
                "Curve Plus",
                R.drawable.curve_plus
        ));

        categories.add(new Category(
                "Electronics",
                R.drawable.home_model
        ));

        categories.add(new Category(
                "Home & Living",
                R.drawable.home_model
        ));

        categories.add(new Category(
                "Men",
                R.drawable.men_model
        ));

        categories.add(new Category(
                "Women",
                R.drawable.women_modeling
        ));
    }
}
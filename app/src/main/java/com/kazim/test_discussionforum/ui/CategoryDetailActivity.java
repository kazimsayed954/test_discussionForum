package com.kazim.test_discussionforum.ui;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.firebase.client.Firebase;
import com.kazim.test_discussionforum.R;
import com.kazim.test_discussionforum.adapters.CategoryPagerAdapter;
import com.kazim.test_discussionforum.models.Category;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryDetailActivity extends AppCompatActivity {
    ViewPager mViewPager;
    private CategoryPagerAdapter adapterViewPager;
    ArrayList<Category> mCategories = new ArrayList<>();
    private Category mCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);
        ButterKnife.bind(this);
        Firebase.setAndroidContext(getApplicationContext());


        mCategories = Parcels.unwrap(getIntent().getParcelableExtra("categories"));
        int startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));
        adapterViewPager = new CategoryPagerAdapter(getSupportFragmentManager(), mCategories);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);

    }
}

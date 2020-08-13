package com.kazim.test_discussionforum.adapters;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.kazim.test_discussionforum.models.Category;
import com.kazim.test_discussionforum.ui.CategoryDetailFragment;

import java.util.ArrayList;


public class CategoryPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Category> mCategories;

    public CategoryPagerAdapter(FragmentManager fm, ArrayList<Category> categories) {
        super(fm);
        mCategories = categories;
    }

    @Override
    public Fragment getItem(int position) {
        return CategoryDetailFragment.newInstance(mCategories.get(position));
    }

    @Override
    public int getCount() {
        return mCategories.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mCategories.get(position).getName();
    }
}

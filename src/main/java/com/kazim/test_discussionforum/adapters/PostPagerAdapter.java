package com.kazim.test_discussionforum.adapters;



import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.kazim.test_discussionforum.models.Post;
import com.kazim.test_discussionforum.ui.PostDetailFragment;

import java.util.ArrayList;


public class PostPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Post> mPosts;

    public PostPagerAdapter(FragmentManager fm, ArrayList<Post> posts) {
        super(fm);
        mPosts = posts;
    }

    @Override
    public Fragment getItem(int position) {
        return PostDetailFragment.newInstance(mPosts.get(position));
    }

    @Override
    public int getCount() {
        return mPosts.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mPosts.get(position).getTitle();
    }
}
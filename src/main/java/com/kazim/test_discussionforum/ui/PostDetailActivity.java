package com.kazim.test_discussionforum.ui;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.kazim.test_discussionforum.R;
import com.kazim.test_discussionforum.adapters.PostPagerAdapter;

import com.kazim.test_discussionforum.models.Post;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostDetailActivity extends AppCompatActivity {
    ViewPager mViewPager;
    private PostPagerAdapter adapterViewPager;
    ArrayList<Post> mPosts = new ArrayList<>();
    private Post mPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        ButterKnife.bind(this);

        mPosts = Parcels.unwrap(getIntent().getParcelableExtra("posts"));
        int startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));
        adapterViewPager = new PostPagerAdapter(getSupportFragmentManager(), mPosts);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);

    }
}

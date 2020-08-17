package com.kazim.test_discussionforum.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kazim.test_discussionforum.Constants;
import com.kazim.test_discussionforum.R;
import com.kazim.test_discussionforum.adapters.FirebasePostListAdapter;
import com.kazim.test_discussionforum.models.Category;
import com.kazim.test_discussionforum.models.Post;
import com.firebase.client.Firebase;
import com.firebase.client.Query;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PostListFragment extends Fragment {
    private SharedPreferences mSharedPreferences;
    private String mRecentCategory;
    private Category mCategory;

    private Query mQuery;
    private Firebase mFirebasePostsRef;
    RecyclerView mRecyclerView;
    private FirebasePostListAdapter mAdapter;


    public PostListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_post_list, container, false);
        ButterKnife.bind(this, view);

        //mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        //mRecentCategory = mSharedPreferences.getString(Constants.PREFERENCES_CATEGORY_KEY, null);

        mCategory = Parcels.unwrap(getArguments().getParcelable("category"));


        mFirebasePostsRef = new Firebase(Constants.FIREBASE_URL_POSTS);

        setUpFirebaseQuery(mCategory);
        setUpRecyclerView();

        return view;
    }

    private void setUpFirebaseQuery(Category category) {
        String post = mFirebasePostsRef.toString();
        Firebase ref = new Firebase(post);
        mQuery = ref.orderByChild(category.getName());
    }

    private void setUpRecyclerView() {
        mAdapter = new FirebasePostListAdapter(mQuery, Post.class);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);
    }
}

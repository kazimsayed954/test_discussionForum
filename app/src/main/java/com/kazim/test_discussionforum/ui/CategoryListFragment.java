package com.kazim.test_discussionforum.ui;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kazim.test_discussionforum.Constants;
import com.kazim.test_discussionforum.R;
import com.kazim.test_discussionforum.adapters.FirebaseCategoryListAdapter;
import com.kazim.test_discussionforum.models.Category;
import com.firebase.client.Firebase;
import com.firebase.client.Query;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CategoryListFragment extends Fragment {
    private Query mQuery;
    private Firebase mFirebaseCategoriesRef;
    RecyclerView mRecyclerView;
    private FirebaseCategoryListAdapter mAdapter;


    public CategoryListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_category_list, container, false);
        ButterKnife.bind(this, view);
        mFirebaseCategoriesRef = new Firebase(Constants.FIREBASE_URL_CATEGORIES);

        setUpFirebaseQuery();
        setUpRecyclerView();

        return view;
    }

    private void setUpFirebaseQuery() {
        String category = mFirebaseCategoriesRef.toString();
        mQuery = new Firebase(category);
    }

    private void setUpRecyclerView() {
        mAdapter = new FirebaseCategoryListAdapter(mQuery, Category.class);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);
    }
}

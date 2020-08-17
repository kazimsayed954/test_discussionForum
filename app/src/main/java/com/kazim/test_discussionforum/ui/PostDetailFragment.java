package com.kazim.test_discussionforum.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.kazim.test_discussionforum.R;
import com.kazim.test_discussionforum.models.Post;

import org.parceler.Parcels;

import butterknife.ButterKnife;


public class PostDetailFragment extends Fragment {
    private Post mPost;

    public static PostDetailFragment newInstance(Post post) {
        PostDetailFragment postDetailFragment = new PostDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("post", Parcels.wrap(post));
        postDetailFragment.setArguments(args);
        return postDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPost = Parcels.unwrap(getArguments().getParcelable("post"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post_detail, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}

package com.kazim.test_discussionforum.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kazim.test_discussionforum.R;
import com.kazim.test_discussionforum.models.Post;
import com.kazim.test_discussionforum.util.FirebaseRecyclerAdapter;
import com.firebase.client.Query;


public class FirebasePostListAdapter extends FirebaseRecyclerAdapter<PostViewHolder, Post> {

    public FirebasePostListAdapter(Query query, Class<Post> itemClass) {
        super(query, itemClass);
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_list_item, parent, false);
        return new PostViewHolder(view, getItems());
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        holder.bindPost(getItem(position));
    }

    @Override
    protected void itemAdded(Post item, String key, int position) {}

    @Override
    protected void itemChanged(Post oldItem, Post newItem, String key, int position) {}

    @Override
    protected void itemRemoved(Post item, String key, int position) {}

    @Override
    protected void itemMoved(Post item, String key, int oldPosition, int newPosition) {}
}
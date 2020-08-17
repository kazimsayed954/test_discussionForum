package com.kazim.test_discussionforum.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.kazim.test_discussionforum.R;
import com.kazim.test_discussionforum.models.Post;
import com.kazim.test_discussionforum.ui.PostDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PostViewHolder extends RecyclerView.ViewHolder {
    private List<Post> mPosts = new ArrayList<>();
    @BindView(R.id.postTitleTextView) TextView mPostNameTextView;
    private Context mContext;

    public PostViewHolder(View itemView, ArrayList<Post> posts) {
        super(itemView);
        mContext = itemView.getContext();
        ButterKnife.bind(this, itemView);
        mPosts = posts;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, PostDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("posts", Parcels.wrap(mPosts));
                mContext.startActivity(intent);
            }
        });
    }

    public void bindPost(Post post) {
        mPostNameTextView.setText(post.getTitle());
    }
}

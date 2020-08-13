package com.kazim.test_discussionforum.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.kazim.test_discussionforum.R;
import com.kazim.test_discussionforum.models.Category;
import com.kazim.test_discussionforum.ui.CategoryDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CategoryViewHolder extends RecyclerView.ViewHolder {
    private List<Category> mCategories = new ArrayList<>();
    @BindView(R.id.categoryNameTextView) TextView mCategoryNameTextView;
    private Context mContext;

    public CategoryViewHolder(View itemView, ArrayList<Category> categories) {
        super(itemView);
        mContext = itemView.getContext();
        ButterKnife.bind(this, itemView);
        mCategories = categories;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, CategoryDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("categories", Parcels.wrap(mCategories));
                mContext.startActivity(intent);
            }
        });
    }

    public void bindCategory(Category category) {
        mCategoryNameTextView.setText(category.getName());
    }
}

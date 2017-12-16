package com.recipe.recipe.app.ui.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.recipe.recipe.R;
import com.recipe.recipe.app.widget.CircleTransformation;
import com.recipe.recipe.domain.model.Recipe;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by luis on 15/12/17.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Recipe> mData;
    private Context mContext;

    public RecipeAdapter(Context context, ArrayList list) {
        this.mContext = context;
        this.mData = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recipe_layout, parent, false);
        viewHolder = new RecipeAdapter.RecipeViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Recipe recipe = mData.get(position);

        if (!TextUtils.isEmpty(recipe.getThumbnail())) {
            Picasso.with(mContext)
                    .load(recipe.getThumbnail())
                    .transform(new CircleTransformation())
                    .into(((RecipeViewHolder) holder).image);
            ((RecipeViewHolder) holder).image.setVisibility(View.VISIBLE);
        } else {
            ((RecipeViewHolder) holder).image.setVisibility(View.INVISIBLE);
        }

        ((RecipeViewHolder) holder).recipeTitle.setText(recipe.getTitle());
        ((RecipeViewHolder) holder).recipeIngredients.setText(recipe.getIngredients());


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void updateData(ArrayList<Recipe> data) {
        if (mData != null) {
            mData.clear();
        }
        mData.addAll(data);
        notifyDataSetChanged();
    }

    public void updateData() {
        if (mData != null) {
            mData.clear();
        }
        notifyDataSetChanged();
    }


    class RecipeViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView recipeTitle, recipeIngredients;

        public RecipeViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            recipeTitle = (TextView) itemView.findViewById(R.id.recipe_name);
            recipeIngredients = (TextView) itemView.findViewById(R.id.recipe_ingredients);
        }
    }
}

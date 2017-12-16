package com.recipe.recipe.app.ui.home.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.recipe.recipe.R;
import com.recipe.recipe.app.base.RecipeApplication;
import com.recipe.recipe.app.ui.home.adapter.RecipeAdapter;
import com.recipe.recipe.domain.model.Recipe;
import com.recipe.recipe.presentation.home.HomePresenterImpl;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements HomePresenterImpl.View, TextWatcher {

    Unbinder mUnbinder;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.edit_text)
    EditText mEditText;
    @BindView(R.id.empty_view)
    View mEmptyView;

    @Inject
    HomePresenterImpl mPresenter;

    private RecipeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeDagger();
        setContentView(R.layout.activity_main);
        initializePresenter();

        mUnbinder = ButterKnife.bind(this);
        mPresenter.create();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mPresenter.destroy();
        mUnbinder.unbind();
    }

    private void initializeDagger() {
        RecipeApplication app = (RecipeApplication) getApplication();
        app.getMainComponent().inject(this);
    }

    private void initializePresenter() {
        mPresenter.setView(this);
    }

    @Override
    public void configureView() {
        mEditText.addTextChangedListener(this);
        mAdapter = new RecipeAdapter(this, new ArrayList());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showHideEmptyView(boolean show) {
        mEmptyView.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showErrorView() {
        Toast.makeText(this, getString(R.string.error_text), Toast.LENGTH_SHORT);
    }

    @Override
    public void updateRecipes(ArrayList<Recipe> recipes) {
        mAdapter.updateData(recipes);
    }

    @Override
    public void clearData() {
        mAdapter.updateData();
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        mPresenter.textChanged(s.toString());
    }

    @Override
    public void afterTextChanged(Editable s) {

    }


}

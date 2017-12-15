package com.recipe.recipe.app.ui.home;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.recipe.recipe.R;
import com.recipe.recipe.app.base.RecipeApplication;
import com.recipe.recipe.presentation.home.HomePresenterImpl;

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

    @Inject
    HomePresenterImpl mPresenter;

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

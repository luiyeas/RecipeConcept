package com.recipe.recipe.domain.model.server;

import com.recipe.recipe.domain.model.Recipe;

import java.util.ArrayList;

/**
 * Created by luis on 15/12/17.
 */

public class RecipeResponse {

    private String title;

    private double version;

    private String href;

    private ArrayList<Recipe> results;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public ArrayList<Recipe> getResults() {
        return results;
    }

    public void setResults(ArrayList<Recipe> results) {
        this.results = results;
    }
}

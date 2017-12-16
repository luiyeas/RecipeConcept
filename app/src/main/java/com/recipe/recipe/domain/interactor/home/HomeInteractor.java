package com.recipe.recipe.domain.interactor.home;

import com.recipe.recipe.domain.interactor.Interactor;
import com.recipe.recipe.domain.model.Recipe;

import java.util.ArrayList;

/**
 * Created by luis on 15/12/17.
 */

public interface HomeInteractor extends Interactor {

    interface Callback {
        void onRecipesReceived(ArrayList<Recipe> listRecipes);
        void onRecipesError();
    }
}

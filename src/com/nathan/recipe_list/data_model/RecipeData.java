package com.nathan.recipe_list.data_model;

import java.util.List;

public class RecipeData {

        private static RecipeData instance = new RecipeData();
        private static String filename = "recipe_description.txt";

        private List<RecipeItem> recipeItems;
        private List<IngredientItem>  ingredientItems;

        public static RecipeData getInstance() {
            return instance;
        }

        private RecipeData() {
        }

    public List<RecipeItem> getRecipeItems() {
        return recipeItems;
    }

    public void setRecipeItems(List<RecipeItem> recipeItems) {
        this.recipeItems = recipeItems;
    }

    public void setIngredientItems(List<IngredientItem> ingredientItems) {
        this.ingredientItems = ingredientItems;
    }

    public List<IngredientItem> getIngredientItems() {
        return ingredientItems;
    }
}

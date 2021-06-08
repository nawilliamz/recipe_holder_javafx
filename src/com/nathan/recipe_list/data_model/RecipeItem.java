package com.nathan.recipe_list.data_model;

import java.time.LocalDate;
import java.util.List;

public class RecipeItem {
    private String name;
    private String ingredients;
    private String instructions;


    public RecipeItem(String name, String ingredients, String instructions) {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;

    }

    public String getName() {
        return name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    @Override
    public String toString() {
        return name;
    }
}

package com.nathan.recipe_list;

import com.nathan.recipe_list.data_model.IngredientItem;
import com.nathan.recipe_list.data_model.RecipeData;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class IngredientController {

        @FXML
        private TextArea ingredientName;
        @FXML
        private TextArea ingredientAmount;
    //Need to add place the code here for collecting the new recipe elements from newInstructionDialog
    //and adding them into a List<Ingredient> observable list (this method, you can call
    //processIngredientResults() is called in the DialogController in the showNewIngredientDialog()
    // method

    public IngredientItem processIngredientResults () {

        String name = ingredientName.getText().trim();
        String amount = ingredientAmount.getText().trim();

        IngredientItem newIngredient = new IngredientItem(name, amount);
        return newIngredient;
    }
}

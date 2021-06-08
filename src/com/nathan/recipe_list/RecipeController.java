package com.nathan.recipe_list;

import com.nathan.recipe_list.data_model.IngredientItem;
import com.nathan.recipe_list.data_model.RecipeData;
import com.nathan.recipe_list.data_model.RecipeItem;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class RecipeController {

    //Header, Graphic, Content, Buttons
    @FXML
    private TextArea recipeTitle;
    @FXML
    private Button addIngredient;
    @FXML
    private TextArea ingredientName;
    @FXML
    private TextArea ingredientAmount;
    @FXML
    private TextArea instructionList;
    @FXML
    private Button addInstruction;
    @FXML
    private TextArea stepNumber;
    @FXML
    private TextArea stepInstruction;


    //showNewIngredientDialog() is initiated from the addIngredient button from New Ingredient button
    //in recipeItemDialog window
    public void showNewIngredientDialog() {
        Dialog<ButtonType> dialog = new Dialog();
        dialog.initOwner(addIngredient.getScene().getWindow());      //the owner of the window should be the root layout where the popup originates
//        FXMLLoader fxmlLoader = new FXMLLoader();
//        fxmlLoader.setLocation(getClass().getResource("newIngredientDiolog.fxml"));
        try {
            //Note: You can load from different sources here (web address for ex)
            Parent root = FXMLLoader.load(getClass().getResource("newIngredientDialog.fxml"));
            dialog.getDialogPane().setContent(root);
//            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            System.out.println("Okay, pressed");
        } else {
            System.out.println("Cancel pressed");
        }
    }

    //Need to add place the code here for collecting the new recipe elements from recipeItemDialog
    //and adding them into List<RecipeItem> observable list (this method, you can call
    //processRecipeResults() is called in the Controller in the showNewRecipeDialog() method
    public RecipeItem processRecipeResults() {

        String title = recipeTitle.getText().trim();
        String ingredient = ingredientName.getText().trim();
        String instructions = instructionList.getText().trim();

        RecipeItem newRecipe = new RecipeItem(title, ingredient, instructions);
        return newRecipe;

    }

    public void showNewInstructionDialog () {

        Dialog<ButtonType> dialog = new Dialog();
        dialog.initOwner(addInstruction.getScene().getWindow());      //the owner of the window should be the root layout where the popup originates
//        FXMLLoader fxmlLoader = new FXMLLoader();
//        fxmlLoader.setLocation(getClass().getResource("newIngredientDiolog.fxml"));
        try {
            //Note: You can load from different sources here (web address for ex)
            Parent root = FXMLLoader.load(getClass().getResource("newInstructionDialog.fxml"));
            dialog.getDialogPane().setContent(root);
//            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            System.out.println("Okay, pressed");
        } else {
            System.out.println("Cancel pressed");
        }


    }

}

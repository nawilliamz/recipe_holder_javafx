package com.nathan.recipe_list;

import com.nathan.recipe_list.data_model.RecipeData;
import com.nathan.recipe_list.data_model.RecipeItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.SetChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Controller {

    private List<RecipeItem> recipeItems;

    @FXML
    private ListView<RecipeItem> recipeListView;
    @FXML
    private TextArea ingredientsTextArea;
    @FXML
    private TextArea instructionsTextArea;
    @FXML
    private Label recipeTitleLabel;
    @FXML
    private BorderPane mainBorderPane;


    public void initialize () {

        RecipeItem casserole = new RecipeItem("Casserole", "Casserole Ingredients", "Casserole Instructions");
        RecipeItem burger = new RecipeItem("Burger", "Burger Ingredients", "Burger Instructions");
        RecipeItem taco = new RecipeItem("Taco", "Taco Ingredients", "Taco Instructions");
        RecipeItem pizza = new RecipeItem("Pizza", "Pizza Ingredients", "Pizza Instructions");
        RecipeItem meatloaf = new RecipeItem("Meatloaf", "Meatloaf Ingredients", "Meatloaf Instructions");

        recipeItems = new ArrayList<RecipeItem>();
        recipeItems.add(casserole);
        recipeItems.add(burger);
        recipeItems.add(taco);
        recipeItems.add(pizza);
        recipeItems.add(meatloaf);


        recipeListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<RecipeItem>() {
            @Override
            public void changed(ObservableValue<? extends RecipeItem> observableValue, RecipeItem oldRecipeItem, RecipeItem newRecipeItem) {
                if (newRecipeItem != null) {
                    RecipeItem item = recipeListView.getSelectionModel().getSelectedItem();
                        ingredientsTextArea.setText(item.getIngredients());
                        instructionsTextArea.setText(item.getInstructions());

                }
            }
        });


        recipeListView.getItems().setAll(recipeItems);
        recipeListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        recipeListView.getSelectionModel().selectFirst();
        }



    //showNewRecipeDialog() is activated by clicking New in menu bar of mainwindow
    @FXML
    public void showNewRecipeDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        //the load method can throw an IO exception
        try {
            //Note: You can load from different sources here (web address for ex)
            Parent root = FXMLLoader.load(getClass().getResource("recipeItemDialog.fxml"));
            dialog.getDialogPane().setContent(root);

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



    @FXML
    public void handleClickRecipeListView () {

        //returns the item selected in the ListView
        RecipeItem item = recipeListView.getSelectionModel().getSelectedItem();

        recipeTitleLabel.setText(item.getName());

//        System.out.println("The selected item is " + item);

//        StringBuilder sb = new StringBuilder();
//        sb.append(" ");
//        sb.append("Recipe Name:  ");
//        sb.append(item.getName());


        ingredientsTextArea.setText(item.getIngredients());
        instructionsTextArea.setText(item.getInstructions());

//        recipeTitleLabel.setText(sb.toString());

    }

    public void handleClickRecipeLabel() {

    }

}

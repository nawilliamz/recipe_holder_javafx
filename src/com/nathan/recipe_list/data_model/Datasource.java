package com.nathan.recipe_list.data_model;

import java.sql.*;


public class Datasource {

    public static final String DB_NAME = "recipe.db";

    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\RecipeHolderProject\\" + DB_NAME;
    public static final String TABLE_RECIPES = "recipes";
    public static final String COLUMN_INGREDIENT_ID = "_id";
    public static final String COLUMN_INGREDIENT_NAME = "name";
    public static final String COLUMN_INGREDIENT_AMOUNT = "amount";
    public static final String COLUMN_INSTRUCTIONS_ID = "instruction_id";
    public static final int INDEX_INGREDIENT_ID = 1;
    public static final int INDEX_INGREDIENT_NAME = 2;
    public static final int INDEX_INGREDIENT_AMOUNT = 3;
    public static final int INDEX_INSTRUCTIONS_ID = 4;


    public static final String TABLE_INSTRUCTIONS = "instructions";
    public static final String COLUMN_INSTRUCTION_ID = "_id";
    public static final String COLUMN_STEP_NUMBER = "step_number";
    public static final String COLUMN_INGREDIENT = "ingredient";
    public static final int INDEX_INSTRUCTION_ID = 1;
    public static final int INDEX_STEP_NUMBER = 2;
    public static final int INDEX_INGREDIENT = 3;

    public static final String CREATE_TABLE_INGREDIENTS = "CREATE TABLE IF NOT EXISTS " +
            TABLE_RECIPES + " (" + COLUMN_INGREDIENT_ID + " integer, " + COLUMN_INGREDIENT_NAME +
            " text, "+ COLUMN_INGREDIENT_AMOUNT + " text, " + COLUMN_INSTRUCTIONS_ID + " integer" + ")";

    public static final String CREATE_TABLE_INSTRUCTIONS = "CREATE TABLE IF NOT EXISTS " +
            TABLE_INSTRUCTIONS + "(" + COLUMN_INSTRUCTION_ID + " integer " + ", " + COLUMN_STEP_NUMBER +
            " text "  +  ", " + COLUMN_INGREDIENT + " integer " + ")";


    private Connection conn;

    private static Datasource instance = new Datasource();

    private PreparedStatement createTableIngredients;
    private PreparedStatement createTableInstructions;

    public Datasource() {

    }

    public static Datasource getInstance() {
        return instance;
    }

    public boolean open() {

        try {

            conn = DriverManager.getConnection(CONNECTION_STRING);
            createTableIngredients = conn.prepareStatement(CREATE_TABLE_INGREDIENTS);
            //must use the execute method here because it will handle creation of a new table
            createTableIngredients.execute();

            createTableInstructions = conn.prepareStatement(CREATE_TABLE_INSTRUCTIONS);
            createTableInstructions.execute();

            return true;

        } catch (SQLException e) {
            System.out.println("Unable to open DB connection. " + e.getMessage());
            return false;
        }

    }

    public boolean close() {
        try {

            if (createTableIngredients != null) {
                createTableIngredients.close();
            }

            if (createTableInstructions != null) {
                createTableInstructions.close();
            }

            if (conn != null) {
                System.out.println("Database is closed");
                conn.close();
            }

            return true;

        } catch (SQLException e) {
            System.out.println("Couldn't close the connection" + e.getMessage());
            return false;
        }


    }



}

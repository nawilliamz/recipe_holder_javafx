package com.nathan.recipe_list;

import com.nathan.recipe_list.data_model.IngredientItem;
import com.nathan.recipe_list.data_model.InstructionItem;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class InstructionController {

    @FXML
    private TextArea stepNumber;
    @FXML
    private TextArea stepInstruction;

    public InstructionItem processInstructionResults () {

        String step = stepNumber.getText().trim();
        String instruction = stepInstruction.getText().trim();

        InstructionItem newInstruction = new InstructionItem(step, instruction);
        return newInstruction;
    }

}

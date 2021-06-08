package com.nathan.recipe_list.data_model;

public class InstructionItem {

    String stepNumber;
    String stepInstruction;

    public InstructionItem(String stepNumber, String stepInstruction) {
        this.stepNumber = stepNumber;
        this.stepInstruction = stepInstruction;
    }

    public String getStepNumber() {
        return stepNumber;
    }

    public String getStepInstruction() {
        return stepInstruction;
    }
}

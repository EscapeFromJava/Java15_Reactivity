package com.example.java15_reactivity;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class HelloController {
    @FXML
    Label lblResultA, lblResultB;
    @FXML
    TextArea textAreaA, textAreaB;
    int lengthAreaA = 0, lengthAreaB = 0, count = 0;
    String textA = "", textB = "";

    public void initialize() {
        textAreaA.lengthProperty().addListener((observableValue, number, t1) -> {
            lengthAreaA = (int) t1;
            lengthСomparison();
        });
        textAreaB.lengthProperty().addListener((observableValue, number, t1) -> {
            lengthAreaB = (int) t1;
            lengthСomparison();
        });
        textAreaA.textProperty().addListener((observableValue, s, t1) -> {
            textA = t1;
            lblResultB.setText(quantityOfSubstring(count));
        });
        textAreaB.textProperty().addListener((observableValue, s, t1) -> {
            textB = t1;
            lblResultB.setText(quantityOfSubstring(count));
        });
    }
    private String quantityOfSubstring(int count) {
        if (textA.length() > 0 && textB.length() > 0) {
            for (int i = 0; i < textB.length() - textA.length() + 1; i++) {
                if (textB.substring(i, i + textA.length()).equals(textA)) {
                    count++;
                }
            }
        }
        return String.valueOf(count);
    }

    private void lengthСomparison() {
        if (lengthAreaA > lengthAreaB) {
            lblResultA.setText("A.length > B.length by " + (lengthAreaA - lengthAreaB));
        } else if (lengthAreaB > lengthAreaA) {
            lblResultA.setText("A.length < B.length by " + (lengthAreaB - lengthAreaA));
        } else
            lblResultA.setText("A.length equal B.length");
    }
}
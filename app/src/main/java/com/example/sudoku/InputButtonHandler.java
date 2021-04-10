package com.example.sudoku;

import java.util.List;
import java.util.ArrayList;

import android.view.View;
import android.widget.Button;
import android.graphics.Color;

public class InputButtonHandler {

    private InputButtonHandler() {}

    private static String ACTIVE_VALUE;

    public static String getActiveValue() {
        return ACTIVE_VALUE;
    }

    public static void initiate(List<Button> buttonsNumbers, Button buttonDelete) {
        List<Button> allButtons = new ArrayList<>(buttonsNumbers);
        allButtons.add(buttonDelete);

        for (Button button : allButtons) {
            button.setOnClickListener(view -> handleClick(view, allButtons));
        }

        // Start-up with delete selected.
        buttonDelete.callOnClick();
    }

    private static void handleClick(View view, List<Button> allButtons) {
        Button button = (Button) view;
        String text = button.getText().toString();
        ACTIVE_VALUE = text.equals("Delete") ? "" : text;

        for (Button aButton : allButtons) {
            boolean activated = aButton.getId() != button.getId();
            aButton.setClickable(activated);
            aButton.setTextColor(activated ? Color.WHITE : Color.RED);
        }
    }

}

package com.example.sudoku;

import java.util.List;

import android.graphics.Color;
import android.widget.TextView;

import de.sfuhrm.sudoku.Riddle;
import de.sfuhrm.sudoku.Solver;
import de.sfuhrm.sudoku.Creator;
import de.sfuhrm.sudoku.GameMatrix;

public class GameHandler {

    private static final int COLOR_LOCKED = Color.rgb(141, 50, 168);

    private static List<List<TextView>> textCells;

    private static Riddle riddle;
    private static List<GameMatrix> solutions;

    private GameHandler() {}

    public static void initiate(MainActivity mainActivity, List<List<TextView>> textCells) {
        GameHandler.textCells = textCells;

        for (List<TextView> rowData : textCells) {
            for (TextView textView : rowData) {
                textView.setOnClickListener(view -> {
                    writeToDisplay((TextView) view, InputButtonHandler.getActiveValue());
                    saveToData();

                    // Check if user won.
                    boolean isComplete = false;
                    for (GameMatrix solution : solutions) {
                        if (!solution.equals(riddle)) continue;
                        isComplete = true;
                        break;
                    }
                    if (!isComplete) return;
                    WinDialog.display(mainActivity);
                });
            }
        }

        createNewGame();
    }

    public static void createNewGame() {
        riddle = Creator.createRiddle(Creator.createFull());
        solutions = new Solver(riddle).solve();
        saveToDisplay();
    }

    private static void saveToData() {
        for (int row = 0; row < textCells.size(); row++) {
            List<TextView> rowData = textCells.get(row);
            for (int column = 0; column < rowData.size(); column++) {
                String text = rowData.get(column).getText().toString();
                byte value = text.isEmpty() ? 0 : Byte.parseByte(text);
                riddle.set(row, column, value);
            }
        }
    }

    private static void saveToDisplay() {
        byte[][] array = riddle.getArray();
        for (int row = 0; row < array.length; row++) {
            byte[] rowData = array[row];
            for (int column = 0; column < rowData.length; column++) {
                String value = rowData[column] + "";
                TextView cell = textCells.get(row).get(column);
                writeToDisplay(cell, value, true);
                cell.setClickable(value.equals("0"));
            }
        }
    }

    public static void fillSolution() {
        if (solutions.isEmpty()) return;
        GameMatrix solution = solutions.get(0);
        byte[][] array = solution.getArray();
        for (int row = 0; row < array.length; row++) {
            byte[] rowData = array[row];
            for (int column = 0; column < rowData.length; column++) {
                TextView cell = textCells.get(row).get(column);
                String value = rowData[column] + "";
                if (!value.equals("0")) continue;
                writeToDisplay(cell, value);
            }
        }
    }

    private static void writeToDisplay(TextView cell, String value) {
        writeToDisplay(cell, value, false);
    }

    private static void writeToDisplay(TextView cell, String value, boolean isFixed) {
        cell.setText(value);
        boolean isWritable = value.equals("0");
        cell.setTextColor(isWritable ? Color.WHITE : isFixed ? COLOR_LOCKED : Color.BLACK);
    }

}

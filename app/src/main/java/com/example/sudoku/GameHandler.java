package com.example.sudoku;

import java.util.List;

import de.sfuhrm.sudoku.Riddle;
import de.sfuhrm.sudoku.Solver;
import de.sfuhrm.sudoku.Creator;
import de.sfuhrm.sudoku.GameMatrix;

import android.graphics.Color;
import android.widget.TextView;
import android.annotation.SuppressLint;

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
                    TextView cell = (TextView) view;
                    String value = InputButtonHandler.getActiveValue();

                    cell.setText(value);
                    cell.setTextColor(value.equals("0") ? Color.WHITE : Color.BLACK);

                    saveToData();

                    boolean isComplete = false;
                    for (GameMatrix solution : solutions) {
                        if (!solution.equals(riddle)) continue;
                        isComplete = true;
                    }
                    if (!isComplete) return;
                    WinDialog.display(mainActivity);
                });
            }
        }

        createNewGame();
    }

    @SuppressLint("SetTextI18n")
    public static void createNewGame() {
        riddle = Creator.createRiddle(Creator.createFull());
        solutions = new Solver(riddle).solve();

        // Apply data to display.
        byte[][] array = riddle.getArray();
        for (int row = 0; row < array.length; row++) {
            byte[] rowData = array[row];
            for (int column = 0; column < rowData.length; column++) {
                byte value = rowData[column];
                TextView cell = textCells.get(row).get(column);
                boolean isWritable = value == 0;
                cell.setText(value + "");
                cell.setClickable(isWritable);
                cell.setTextColor(isWritable ? Color.WHITE : COLOR_LOCKED);
            }
        }
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

    @SuppressLint("SetTextI18n")
    public static void fillSolution() {
        if (solutions.isEmpty()) return;
        GameMatrix solution = solutions.get(0);
        byte[][] array = solution.getArray();
        for (int row = 0; row < array.length; row++) {
            byte[] rowData = array[row];
            for (int column = 0; column < rowData.length; column++) {
                byte value = rowData[column];
                TextView cell = textCells.get(row).get(column);
                if (!cell.getText().equals("0")) continue;
                cell.setText(value + "");
                cell.setTextColor(Color.BLACK);
            }
        }
    }

}

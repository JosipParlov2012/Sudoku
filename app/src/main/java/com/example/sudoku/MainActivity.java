package com.example.sudoku;

import android.os.Bundle;

import de.sfuhrm.sudoku.Riddle;
import de.sfuhrm.sudoku.Creator;
import de.sfuhrm.sudoku.GameMatrix;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Example code.
		GameMatrix matrix = Creator.createFull();
		Riddle riddle = Creator.createRiddle(matrix);
	}

}

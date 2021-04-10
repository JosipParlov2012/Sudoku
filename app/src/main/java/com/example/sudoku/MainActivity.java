package com.example.sudoku;

import java.util.List;
import java.util.ArrayList;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.annotation.SuppressLint;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	private static final int[] ID_CELLS = new int[] {
			R.id.Row1Column1, R.id.Row1Column2, R.id.Row1Column3, R.id.Row1Column4, R.id.Row1Column5, R.id.Row1Column6, R.id.Row1Column7, R.id.Row1Column8, R.id.Row1Column9,
			R.id.Row2Column1, R.id.Row2Column2, R.id.Row2Column3, R.id.Row2Column4, R.id.Row2Column5, R.id.Row2Column6, R.id.Row2Column7, R.id.Row2Column8, R.id.Row2Column9,
			R.id.Row3Column1, R.id.Row3Column2, R.id.Row3Column3, R.id.Row3Column4, R.id.Row3Column5, R.id.Row3Column6, R.id.Row3Column7, R.id.Row3Column8, R.id.Row3Column9,
			R.id.Row4Column1, R.id.Row4Column2, R.id.Row4Column3, R.id.Row4Column4, R.id.Row4Column5, R.id.Row4Column6, R.id.Row4Column7, R.id.Row4Column8, R.id.Row4Column9,
			R.id.Row5Column1, R.id.Row5Column2, R.id.Row5Column3, R.id.Row5Column4, R.id.Row5Column5, R.id.Row5Column6, R.id.Row5Column7, R.id.Row5Column8, R.id.Row5Column9,
			R.id.Row6Column1, R.id.Row6Column2, R.id.Row6Column3, R.id.Row6Column4, R.id.Row6Column5, R.id.Row6Column6, R.id.Row6Column7, R.id.Row6Column8, R.id.Row6Column9,
			R.id.Row7Column1, R.id.Row7Column2, R.id.Row7Column3, R.id.Row7Column4, R.id.Row7Column5, R.id.Row7Column6, R.id.Row7Column7, R.id.Row7Column8, R.id.Row7Column9,
			R.id.Row8Column1, R.id.Row8Column2, R.id.Row8Column3, R.id.Row8Column4, R.id.Row8Column5, R.id.Row8Column6, R.id.Row8Column7, R.id.Row8Column8, R.id.Row8Column9,
			R.id.Row9Column1, R.id.Row9Column2, R.id.Row9Column3, R.id.Row9Column4, R.id.Row9Column5, R.id.Row9Column6, R.id.Row9Column7, R.id.Row9Column8, R.id.Row9Column9
	};
	private static final int[] ID_NUMBERS = new int[] {
			R.id.Number0,
			R.id.Number1,
			R.id.Number2,
			R.id.Number3,
			R.id.Number4,
			R.id.Number5,
			R.id.Number6,
			R.id.Number7,
			R.id.Number8,
			R.id.Number9
	};

	private List<TextView> textCells;
	private List<Button> buttonsNumbers;
	private Button buttonDelete;
	private Button buttonRestart;

	@SuppressLint("SetTextI18n")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initiateWidgets();
	}

	private void initiateWidgets() {
		textCells = new ArrayList<>();
		for (int ID : ID_CELLS) {
			textCells.add(findViewById(ID));
		}

		buttonsNumbers = new ArrayList<>();
		for (int ID : ID_NUMBERS) {
			buttonsNumbers.add(findViewById(ID));
		}

		buttonDelete = findViewById(R.id.Delete);
		buttonRestart = findViewById(R.id.Restart);
	}

}

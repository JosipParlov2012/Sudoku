package com.example.sudoku;

import android.os.Bundle;
import android.widget.TextView;
import android.annotation.SuppressLint;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	@SuppressLint("SetTextI18n")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Test code.
		TextView textView = findViewById(R.id.Row1Column1);
		textView.setOnClickListener(view -> {
			TextView textVar = (TextView) view;
			String text = textVar.getText().toString();
			int num = Integer.parseInt(text);
			textVar.setText((num + 1) + "");
		});
	}

}

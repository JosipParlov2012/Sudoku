package com.example.sudoku;

import android.os.Bundle;
import android.app.Dialog;
import android.app.AlertDialog;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class WinDialog extends DialogFragment {

    public static void display(MainActivity mainActivity) {
        new WinDialog().show(mainActivity.getSupportFragmentManager(), "Izlazni Dijalog");
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIconAttribute(android.R.attr.alertDialogIcon);
        builder.setTitle("Pobjedili ste!");
        builder.setMessage("Želite li ponovno igrati?");
        builder.setPositiveButton("Zatvori", (dialog, which) -> dismiss());
        builder.setNegativeButton("Nova igra", (dialog, which) -> GameHandler.createNewGame());
        return builder.create();
    }

}

package com.app.customdialogsendinginformationtoactivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class ExampleDialog extends AppCompatDialogFragment {
    EditText dialog_name, dialog_lastname;

    //lister for dialog
    private ExampleDialogListner listner;

    //Ctrl+o (implent onCreateDialog
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        //we need alert dialog builder
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());

        //layout Inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        //Bulid view of this layout inflater and paste your layout
        View view = inflater.inflate(R.layout.layout_dialog, null);

        dialog_name = (EditText) view.findViewById(R.id.dialog_name);
        dialog_lastname = (EditText) view.findViewById(R.id.dialog_lastname);

        //build the dialog
        dialog.setView(view)
                .setTitle("Country Name")//Set Tilte to Dialog Box
                //Set Negative Button and onClickListner
                .setNegativeButton("cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //here we don't do anything bcz when we click on this the dialog box should be dissmissed
                    }
                })
                // Set Positive Button
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //here we have to pull out text from our edit text
                        String name = dialog_name.getText().toString();
                        String last_name = dialog_lastname.getText().toString();//now we have to send to our activit
                                                                                 //so create a listner for this dialog
                        //main activity will get this two string in applyTExts method
                        listner.applyText(name,last_name);


                    }
                });

        return dialog.create();
    }

    //Ctrl+o implemt onAttach

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listner = (ExampleDialogListner) context;
        } catch (ClassCastException e) {
            //this exception will come whe we donot implement ExampleDialogListner in our main Activity;
            throw new ClassCastException("must implment ExampleDialog Listner");
        }
    }

    //Crfeate Interface to send data from dialog to Activity
    public interface ExampleDialogListner {
        //create a method and pass two String first one is our Name and Second is Lastname
        void applyText(String name, String last_name);
    }
}

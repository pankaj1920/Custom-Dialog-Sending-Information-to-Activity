package com.app.customdialogsendinginformationtoactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ExampleDialog.ExampleDialogListner {
    //after implent implement applyText method


    private TextView textView_name,textView_lastname;
    private Button dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_name = (TextView) findViewById(R.id.textView_name);
        textView_lastname =(TextView)findViewById(R.id.textView_lastname);
        dialog = (Button)findViewById(R.id.dialog);

        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                OpenDialog();
            }
        });
    }
    public void OpenDialog(){

        //Create instance of dialog
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(),"Example Dialog");

    }

    @Override
    public void applyText(String name, String last_name) {
    textView_name.setText(name);
    textView_lastname.setText(last_name);

    }
}

package com.example.keyboradposition;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
  EditText editText;
    Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,buttondelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button0=findViewById(R.id.button0);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        editText=findViewById(R.id.Edittext);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
        View view=getLayoutInflater().inflate(R.layout.custom_keyboard,null);
        builder.setView(view);
        builder.show();





    }
}
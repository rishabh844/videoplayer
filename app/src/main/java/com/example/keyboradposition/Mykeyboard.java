package com.example.keyboradposition;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mykeyboard extends LinearLayout implements View.OnClickListener {
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, buttonok, buttondelete;
    SparseArray<String> keyvalue = new SparseArray<>();
    InputConnection inputConnection;

    public Mykeyboard(Context context) {
        this(context, null, 0);
    }

    public Mykeyboard(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Mykeyboard(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.custom_keyboard, this, true);
        button0 = findViewById(R.id.button0);
        button0.setOnClickListener(this);
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(this);
        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(this);
        button6 = findViewById(R.id.button6);
        button6.setOnClickListener(this);
        button7 = findViewById(R.id.button7);
        button7.setOnClickListener(this);
        button8 = findViewById(R.id.button8);
        button8.setOnClickListener(this);
        button9 = findViewById(R.id.button9);
        button9.setOnClickListener(this);
        buttonok = findViewById(R.id.buttonok);
        buttonok.setOnClickListener(this);
        buttondelete = findViewById(R.id.buttondelete);
        buttondelete.setOnClickListener(this);

        ArrayList<Integer> object = new ArrayList<>();
        object.add(0);
        object.add(1);
        object.add(2);
        object.add(3);
        object.add(4);
        object.add(5);
        object.add(6);
        object.add(7);
        object.add(8);
        object.add(9);

//        keyvalue.put(R.id.button0, "0");
//        keyvalue.put(R.id.button1, "1");
//        keyvalue.put(R.id.button2, "2");
//        keyvalue.put(R.id.button3, "3");
//        keyvalue.put(R.id.button4, "4");
//        keyvalue.put(R.id.button5, "5");
//        keyvalue.put(R.id.button6, "6");
//        keyvalue.put(R.id.button7, "7");
//        keyvalue.put(R.id.button8, "8");
//        keyvalue.put(R.id.button9, "9");
        keyvalue.put(R.id.buttonok, "\n");

        Collections.shuffle(object);
        ArrayList<Button> buttonArrayList = new ArrayList<>();
        buttonArrayList.add(findViewById(R.id.button0));
        buttonArrayList.add(findViewById(R.id.button1));
        buttonArrayList.add(findViewById(R.id.button2));
        buttonArrayList.add(findViewById(R.id.button3));
        buttonArrayList.add(findViewById(R.id.button4));
        buttonArrayList.add(findViewById(R.id.button5));
        buttonArrayList.add(findViewById(R.id.button6));
        buttonArrayList.add(findViewById(R.id.button7));
        buttonArrayList.add(findViewById(R.id.button8));
        buttonArrayList.add(findViewById(R.id.button9));

        for (int i = 0; i < object.size(); i++) {
            buttonArrayList.get(i).setText(object.get(i).toString());
            keyvalue.put(buttonArrayList.get(i).getId(), object.get(i).toString());
        }

    }


    @Override
    public void onClick(View view) {
        if (inputConnection == null)
            return;

        if (view.getId() == R.id.buttondelete) {
            CharSequence selectedText = inputConnection.getSelectedText(0);

            if (TextUtils.isEmpty(selectedText)) {
                inputConnection.deleteSurroundingText(1, 0);
            } else {
                inputConnection.commitText("", 1);
            }
        } else {
            String value = keyvalue.get(view.getId());
            inputConnection.commitText(value, 1);
        }

    }

    public void setInputConnection(InputConnection ic) {
        inputConnection = ic;

    }
}

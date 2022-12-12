package com.hfad.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TextContentActivity extends AppCompatActivity {
    private TextView text_content;
    private int category;
    private int position;
    private final int[] arraySection1 = {R.string.chapter1_text,R.string.chapter2,R.string.chapter3};
    private final int[] arraySection2 ={R.string.chapter4};
    private final int[] arraySection3={};
    private final int[] arraySection4={};
    private final int[] arraySection5={};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        text_content=findViewById(R.id.textView);
        recieveIntent();
    }
    private void recieveIntent()
    {
        Intent i=getIntent();
        if(i!=null)
        {
            category=i.getIntExtra("category",0);
            position=i.getIntExtra("position",0);
        }
        switch (category){
            case 0:
                text_content.setText(arraySection1[position]);
                break;
            case 1:
                text_content.setText(arraySection2[position]);
                break;
            case 2:
                break;
        }
    }
}

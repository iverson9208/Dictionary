package com.hfad.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TextContentActivity extends AppCompatActivity {
    private TextView text_content;
    private ImageView iContent;
    private Typeface typeface;
    private int category;
    private int position;
    private final int[] arraySection1 = {R.string.chapter1_text,R.string.chapter2,R.string.chapter3};
    private final int[] arraySection2 ={R.string.chapter4};
    private final int[] arraySection3={};
    private final int[] arraySection4={};
    private final int[] arraySection5={};
    private final int[] imageSection1 ={R.drawable.chapter1,R.drawable.chapter2,R.drawable.chapter3};
    private final int[] imageSection2 ={R.drawable.chapter4,R.drawable.chapter5,R.drawable.chapter6,R.drawable.chapter7,R.drawable.chapter8,R.drawable.chapter9,
            R.drawable.chapter10,R.drawable.chapter11,R.drawable.chapter12,R.drawable.chapter13,R.drawable.chapter14,};
    private final int[] imageSection3 = {R.drawable.chapter15,R.drawable.chapter16,R.drawable.chapter17};
    private final int[] imageSection4 = {R.drawable.chapter18};
    private final int[] imageSection5 = {R.drawable.chapter19,R.drawable.chapter20,R.drawable.chapter21,R.drawable.chapter22};
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        text_content=findViewById(R.id.textView);
       iContent=findViewById(R.id.imageContent);
        typeface=Typeface.createFromAsset(this.getAssets(),"fonts/Rubik-Regular.ttf");
        text_content.setTypeface(typeface);
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
               iContent.setImageResource(imageSection1[position]);
                text_content.setText(arraySection1[position]);
                break;
            case 1:
                text_content.setText(arraySection2[position]);
                iContent.setImageResource(imageSection1[position]);
                break;
            case 2:
                break;
        }
    }
}

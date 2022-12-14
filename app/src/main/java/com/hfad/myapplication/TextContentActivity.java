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
    private final int[] arraySection2 ={R.string.chapter4,R.string.chapter5,R.string.chapter6,R.string.chapter7,R.string.chapter8,R.string.chapter9,R.string.chapter10,R.string.chapter11,R.string.chapter12,R.string.chapter13,R.string.chapter14};
    private final int[] arraySection3={R.string.chapter15,R.string.chapter16,R.string.chapter17};
    private final int[] arraySection4={R.string.chapter18};
    private final int[] arraySection5={R.string.chapter19,R.string.chapter20,R.string.chapter21,R.string.chapter22};
    private final int[] ConclusionSection={R.string.ConclusionText};
    private final int[] ApplicationText={R.string.Application1,R.string.Application2,R.string.Application3};
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
                iContent.setImageResource(imageSection2[position]);
                break;
            case 2:
                text_content.setText(arraySection3[position]);
                iContent.setImageResource(imageSection3[position]);
                break;
            case 3:
                text_content.setText(arraySection4[position]);
                iContent.setImageResource(imageSection4[position]);
                break;
            case 4:
                text_content.setText(arraySection5[position]);
                iContent.setImageResource(imageSection5[position]);
                break;
            case 5:
                text_content.setText(ConclusionSection[position]);
                iContent.setImageResource(imageSection1[position]);
                break;
            case 6:
                text_content.setText(ApplicationText[position]);
                iContent.setImageResource(imageSection1[position]);
                break;
        }
    }
}

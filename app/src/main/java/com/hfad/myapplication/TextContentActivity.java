package com.hfad.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class TextContentActivity extends AppCompatActivity {
    private TextView text_content;
    private ImageView iContent;
    private Typeface typeface;
    private int category;
    private int position;
    private ActionBar  actionBar;
    private SharedPreferences def_pref;
    private final int[] arraySection1 = {R.string.chapter1_text,R.string.chapter2,R.string.chapter3};
    private final int[] arraySection2 ={R.string.chapter4,R.string.chapter5,R.string.chapter6,R.string.chapter7ch6,R.string.chapter8,R.string.chapter9,R.string.chapter10,R.string.chapter11,R.string.chapter12,R.string.chapter13,R.string.chapter14};
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
    private final String[] textToolBarSection1={"Глава 1","Глава 2","Глава 3"};
    private final String[] textToolBarSection2={"Глава 4","Глава 5","Глава 6","Глава 7","Глава 8","Глава 9",
            "Глава 10","Глава 11","Глава 12","Глава 13","Глава 14"};
    private final String[] textToolBarSection3={"Глава 15","Глава 16","Глава 17",};
    private final String[] textToolBarSection4={"Глава 18"};
    private final String[] textToolBarSection5={"Глава 19","Глава 20", "Глава 21","Глава 22"};
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        actionBar=getSupportActionBar();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        text_content=findViewById(R.id.textView);
       iContent=findViewById(R.id.imageContent);
        typeface=Typeface.createFromAsset(this.getAssets(),"fonts/Rubik-Regular.ttf");
        text_content.setTypeface(typeface);
        recieveIntent();
init();

    }
private void init(){
    def_pref= PreferenceManager.getDefaultSharedPreferences(this);
    String text=def_pref.getString("main_text_size","Средний текст");
    switch (text)
    {
        case "Большой текст":text_content.setTextSize(24);
        break;
        case "Средний текст":text_content.setTextSize(18);
            break;
        case "Маленький текст":text_content.setTextSize(14);
            break;
    }
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
                actionBar.setTitle(textToolBarSection1[position]);
                text_content.setText(arraySection1[position]);
                iContent.setImageResource(imageSection1[position]);
                break;
            case 1:
                actionBar.setTitle(textToolBarSection2[position]);
                if(position==3){
                    text_content.setText(getString(R.string.chapter7ch1)+getString(R.string.chapter7ch1ch2)
                    +getString(
                    R.string.chapter7ch1ch3) +getString(
                    R.string.chapter7ch1ch4) +getString(
                    R.string.chapter7ch5) +getString(
                    (R.string.chapter7ch6)));

                }else
                    if(position==4){
                        text_content.setText(getString(R.string.chapter8)+getString(R.string.chapter8ch1));
                    }else
                        if(position==5)
                        {
                            text_content.setText(getString(R.string.chapter9)+getString(R.string.chapter9ch1)
                                    +getString(R.string.chapter9ch2)+getString(R.string.chapter9ch3));
                        }else
                            if(position==7)
                            {
                                text_content.setText(getString(R.string.chapter11)+getString(R.string.chapter11ch1));
                            }else
                text_content.setText(arraySection2[position]);
                iContent.setImageResource(imageSection2[position]);
                break;
            case 2:
                actionBar.setTitle(textToolBarSection3[position]);
                if(position==0)
                {
                    text_content.setText(getString(R.string.chapter15)+getString(R.string.chapter15ch1));
                }else
                    if(position==1)
                    {
                        text_content.setText(Html.fromHtml(getString(R.string.chapter16))+getString(R.string.chapter16ch1));
                    }
                text_content.setText(arraySection3[position]);
                iContent.setImageResource(imageSection3[position]);
                break;
            case 3:
                actionBar.setTitle(textToolBarSection4[position]);
                text_content.setText(arraySection4[position]);
                iContent.setImageResource(imageSection4[position]);
                break;
            case 4:
                actionBar.setTitle(textToolBarSection5[position]);
                if(position==0)
                {
                    text_content.setText(getString(R.string.chapter19)+getString(R.string.chapter19ch1));
                }
                text_content.setText(arraySection5[position]);
                iContent.setImageResource(imageSection5[position]);
                break;
            case 5:
                actionBar.setTitle("Заключение");
                text_content.setText(ConclusionSection[position]);
                iContent.setImageResource(imageSection1[position]);
                break;
            case 6:
                actionBar.setTitle("Приложения");
                actionBar.isShowing();
                text_content.setText(ApplicationText[position]);
                iContent.setImageResource(imageSection1[position]);
                break;
        }
    }
}

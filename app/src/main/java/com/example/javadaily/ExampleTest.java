package com.example.javadaily;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;

public class ExampleTest extends AppCompatActivity {
    String[] questionsArray;//array with our questions
    String[] answersArray;//array with answers to questions that described above
    ImageView[] questionPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_test);

        //Getting bundle
        Bundle extras = getIntent().getExtras();
        questionsArray=extras.getStringArray("PHOTOS");//questions
        answersArray=extras.getStringArray("ANSWERS");//answers

        questionPic=new ImageView[questionsArray.length];

        questionPic[0]=(ImageView) findViewById(R.id.question0);questionPic[1]=(ImageView) findViewById(R.id.question1);
        questionPic[2]=(ImageView) findViewById(R.id.question2);questionPic[3]=(ImageView) findViewById(R.id.question3);
        questionPic[4]=(ImageView) findViewById(R.id.question4);



        for(int i=0;i<questionsArray.length;i++){
            questionPic[i].setImageResource(getImageId(this,questionsArray[i]));
        }
        Log.v("123",(Arrays.toString(answersArray)));

    }

    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }
}

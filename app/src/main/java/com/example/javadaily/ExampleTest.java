package com.example.javadaily;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Arrays;

public class ExampleTest extends AppCompatActivity {
    String[] questionsArray;
    ImageView questionPic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_test);

        //Getting bundle
        Bundle extras = getIntent().getExtras();
        questionsArray=extras.getStringArray("STRING");
//        final String[] data = extras.getStringArray("STRING");
//        final int list_id = extras.getInt("LIST_ID");
        System.out.println(Arrays.toString(questionsArray));

        questionPic=(ImageView) findViewById(R.id.question);
        questionPic.setImageResource(getImageId(this,questionsArray[0]));

    }

    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }
}

package com.example.javadaily;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Tests extends Fragment{
    private DBHelper mDBHelper;
    private SQLiteDatabase mDb;
    ListView t_list;
    ImageView Romko;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_tests, container, false);


        mDBHelper = new DBHelper(getContext());
        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }
        mDb = mDBHelper.getWritableDatabase();

        ImageView romko = (ImageView) rootView.findViewById(R.id.Romko);



        Log.v("Hi,Gryga",Arrays.toString(mDBHelper.getPhotoIDbyTopic(mDb,"static")));

        String testsViewArray[] = mDBHelper.getTopics(mDb);



        //mDBHelper.getPhotoIDbyTopic(mDb,"static");




        ArrayAdapter<String> testAdapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,testsViewArray);
        ListView t_list =(ListView) rootView.findViewById(R.id.testslist);
        t_list.setAdapter(testAdapter);






        //weatherIcon.setImageResource(getImageId(getContext(),output));

        return rootView;
    }

    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }
}

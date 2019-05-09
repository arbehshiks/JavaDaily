package com.example.javadaily;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.io.IOException;
import java.util.ArrayList;

public class Tests extends Fragment{
    private DBHelper mDBHelper;
    private SQLiteDatabase mDb;
    ListView t_list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_tests, container, false);



        ArrayList<String> testsArray=new ArrayList<>();
        testsArray.add("Serg");testsArray.add("Denys");testsArray.add("Sanya");testsArray.add("Romko");
        ArrayAdapter<String> testAdapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,testsArray);
        ListView t_list =(ListView) rootView.findViewById(R.id.testslist);
        t_list.setAdapter(testAdapter);


        mDBHelper = new DBHelper(getContext());
        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }
        mDb = mDBHelper.getWritableDatabase();

        mDBHelper.LogDB(mDb);



        return rootView;



    }
}

package com.woori.moim.Testcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.woori.moim.R;

public class getfromfirebase extends AppCompatActivity {

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getfromfirebase);

        context=this;
        //ManagePayHistory.getInstance().startParsing(context);

    }


}
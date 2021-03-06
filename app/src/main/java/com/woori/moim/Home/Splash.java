package com.woori.moim.Home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.woori.moim.MakeMoim.MoimInfo;
import com.woori.moim.singleton.ManagePeopleItem;
import com.woori.moim.R;

import java.util.HashMap;
import java.util.Map;

public class Splash extends AppCompatActivity {

    String id;
    String name;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    DatabaseReference mDBReference = null;
    HashMap<String, Object> childUpdates = null;
    Map<String, Object> userValue = null;
    UserInfo userInfo = null;

    Map<String, Object> moimValue = null;
    MoimInfo moimInfo = null;

    String token;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        EditText edit_id = (EditText) findViewById(R.id.id);
        EditText edit_name = (EditText) findViewById(R.id.name);
        Button button2 = (Button) findViewById(R.id.button2);
        ManagePeopleItem.getInstance().startParsing();

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                id = edit_id.getText().toString();
                id = id.replaceAll(" ", "");

                name = edit_name.getText().toString();
                name = name.replaceAll(" ", "");


                sharedPreferences = getSharedPreferences("mine", MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putString("id", id);
                editor.putString("name", name);
                //editor.putString("token", "eaO54Q75Q_G0ghOmcV9EXv:APA91bF_Wwx5TgzsNZIii6OgwB9aXkplPHNzFWMfFaAL2UAhiT-xUfd3SeUPTZ4HOvxpCNCZinFCHhwAcQBqyaX70JBwb909hFShx3zqJ61u1ocWFTbJnPPVuQwoFgu5BzZzoS2MsqwN");
                //editor.commit();


                getToken(id,name);

            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences sharedPreferences = getSharedPreferences("mine", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("id", id);
        editor.putString("name", name);
        editor.putString("token", token);
        editor.commit();

    }

    public void getToken(String id,String name) {
        //???????????? ???????????????.
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            return;
                        }
                        ////////////////////????????? ?????? ???????????? ??????????????? sharedPreferences??? ???????????? ????????? ??????////////////////////
                        //sharedPreferences = getSharedPreferences("mine", MODE_PRIVATE);
                        //SharedPreferences.Editor editor = sharedPreferences.edit();
                        token = task.getResult().getToken(); // ???????????? ????????? ????????? ?????????
                        //editor.putString("token", token); // key, value??? ???????????? ???????????? ??????
                        //editor.commit();
                        ////////////////////????????? ?????? ???????????? ??????????????? sharedPreferences??? ???????????? ????????? ??????////////////////////


                        mDBReference = FirebaseDatabase.getInstance().getReference();
                        childUpdates = new HashMap<>();
                        userInfo = new UserInfo(id, name, token);
                        userValue = userInfo.toMap();
                        childUpdates.put("/user/" + id, userValue);
                        mDBReference.updateChildren(childUpdates);

                        editor.putString("token", token);
                        editor.commit();

                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        intent.putExtra("name", name);
                        intent.putExtra("id", id);
                        startActivity(intent);


                    }
                });
    }


    public void InputData() {


    }


}
package com.example.uberclone.providers;

import android.util.Log;

import com.example.uberclone.BuildConfig;
import com.example.uberclone.models.Token;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import java.util.HashMap;
import java.util.Map;

public class TokenProvider {


    DatabaseReference mDataBase;

    public TokenProvider() {

        mDataBase = FirebaseDatabase.getInstance().getReference().child(BuildConfig.PROPERTY).child("Tokens");


    }


    public void create(final String idUser){

        if(idUser==null){
            return;
        }


        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult) {

                Map<String,Object> map = new HashMap<>();
                map.put("token",instanceIdResult.getToken());
                mDataBase.child(idUser).setValue(map);
            }
        });

    }

    public DatabaseReference getToken(String idUser){

        return mDataBase.child(idUser);


    }


}

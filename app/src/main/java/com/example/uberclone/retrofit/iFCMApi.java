package com.example.uberclone.retrofit;

import com.example.uberclone.models.FCMBody;
import com.example.uberclone.models.FCMResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface iFCMApi {

    @Headers({
            "Content-Type:application/json",
            "Authorization:key=AAAAktoL73c:APA91bF7tPOI4KqvIKQ-MScqPTeYx55mDw4ADw1Wme5SiZHzAeHuFEQTlW7pyeq3VxFlfmli93h4tOj8YwabijYAtqXXbjdL6_mPhIaYEgHRRkt40TarAuS9da5snTpFU8Sb6v7z2GTQ"
    })

    @POST("fcm/send")
    Call<FCMResponse> send(@Body FCMBody body);
}

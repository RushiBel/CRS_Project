package com.orendasoftware.crs.domain.deps.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.orendasoftware.crs.domain.NetworkConfig;
import com.orendasoftware.crs.domain.data.networking.GsonDateDeSerializer;

import java.util.Date;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class NetworkModule {

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new GsonDateDeSerializer())
                .setLenient()
                .create();

        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(NetworkConfig.BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}

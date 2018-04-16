package com.gmail.runkevich8.data.net;


import com.gmail.runkevich8.data.entity.DataNet;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface RestApi {

    @GET("/v1/gifs/trending")
    @Headers("api_key: "+ Constants.API_KEY)

    Observable<DataNet> getData();

    @GET("/v1/gifs/search")
    @Headers("api_key: "+ Constants.API_KEY)

    Observable<DataNet> getSearch(@Query("q") String search);
}

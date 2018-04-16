package com.gmail.runkevich8.injection;


import android.content.Context;

import com.gmail.runkevich8.data.net.RestApi;
import com.gmail.runkevich8.data.net.RestService;
import com.gmail.runkevich8.data.repository.GifRepositoryImp;
import com.gmail.runkevich8.domain.executor.PostExecutionThread;
import com.gmail.runkevich8.domain.repository.GifRepository;
import com.gmail.runkevich8.executor.UIThread;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {
    Context context;
    Retrofit retrofit;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context getContext() {
        return context;
    }

    @Provides
    @Singleton
    public GifRepository getUserProfileRepository(RestService restService) {

        return new GifRepositoryImp(restService);
    }

    @Provides
    @Singleton
    public PostExecutionThread getUiThread() {
        return new UIThread();
    }

@Provides
@Singleton
public RestService getRestService(RestApi restAPI) {
    return new RestService(restAPI);
}

    @Provides
    @Singleton//будет создан объект ретрофит на базен нашего интерфейса(т.е. с нашей реализацией)
    public RestApi getRestApi(Retrofit retrofit) {
        return retrofit.create(RestApi.class);
    }

    @Provides
    @Singleton
    public Retrofit getRetrofit(Gson gson) {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("http://api.giphy.com")
                .build();
    }

    @Provides
    @Singleton
    public Gson getGson() {
        return new GsonBuilder()
                .create();}

}

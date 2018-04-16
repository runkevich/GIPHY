package com.gmail.runkevich8.data.net;

import com.gmail.runkevich8.data.entity.DataNet;
import com.gmail.runkevich8.data.entity.GifNet;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.functions.Function;


@Singleton
public class RestService {

    private RestApi restAPI;//исп паттерн композиция(могли и сразу реализовать интерфейс)

    @Inject
    public RestService(RestApi restAPI) {
        this.restAPI = restAPI;
    }

    public Observable<List<GifNet>> getData() {
        return restAPI.getData()
                .map(new Function<DataNet, List<GifNet>>() {
                    @Override
                    public List<GifNet> apply(DataNet dataNet) throws Exception {
                        return dataNet.getData();
                    }
                });
    }

    public Observable<List<GifNet>> getSearch(String search) {
        return restAPI.getSearch(search)
                .map(new Function<DataNet, List<GifNet>>() {
                    @Override
                    public List<GifNet> apply(DataNet dataNet) throws Exception {
                        return dataNet.getData();
                    }
                });
    }

//   private RestApi restApi;
//
//    @Inject
//    public RestService(RestApi restApi) {
//        this.restApi = restApi;
//    }
//
//    public Observable<List<GifNet>> searchImages(String search){
//
//        return restApi.searchGifs(search)
//                .map(new Function<DataNet, List<GifNet>>() {
//                    @Override
//                    public List<GifNet> apply(DataNet giphySearch) throws Exception {
//                        return data.getData();
//                    }
//                });
//
//    }
//
//    public Observable<List<GifNet>> trendingImages(){
//
//        return restApi
//                .trendingImages()
//                .map(new Function<DataNet, List<GifNet>>() {
//                    @Override
//                    public List<GifNet> apply(DataNet giphySearch) throws Exception {
//                        return data.getData();
//                    }
//                });
//
//    }

}

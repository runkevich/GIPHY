package com.gmail.runkevich8.data.repository;


import com.gmail.runkevich8.data.entity.GifNet;
import com.gmail.runkevich8.data.net.RestService;
import com.gmail.runkevich8.domain.entity.Gif;
import com.gmail.runkevich8.domain.repository.GifRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;


public class GifRepositoryImp implements GifRepository {

    private RestService restServise;

    @Inject
    public GifRepositoryImp(RestService restServise) {
        this.restServise = restServise;
    }

    @Override
    public Observable<List<Gif>> search(String search) {
        return restServise
                .getSearch(search).map(new Function<List<GifNet>, List<Gif>>() {
            @Override
            public List<Gif> apply(List<GifNet> gifNets) throws Exception {
                List<Gif> list = new ArrayList<>();
                for (GifNet gifNet : gifNets) {
                    list.add(new Gif(gifNet.getImages().getFixed_width_small().getUrl()));
                }
                return list;
            }
        });
    }

    @Override
    public Observable<List<Gif>> trending() {
        return restServise

                .getData().map(new Function<List<GifNet>, List<Gif>>() {
            @Override
            public List<Gif> apply(List<GifNet> gifNets) throws Exception {
                List<Gif> list = new ArrayList<>();
                for (GifNet gifNet : gifNets) {
                    list.add(new Gif(gifNet.getImages().getFixed_width_small().getUrl()));
                }
                return list;
            }
        });
    }
}

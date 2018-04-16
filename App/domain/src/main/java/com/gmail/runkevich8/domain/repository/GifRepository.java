package com.gmail.runkevich8.domain.repository;



import com.gmail.runkevich8.domain.entity.Gif;

import java.util.List;

import io.reactivex.Observable;

public interface GifRepository {

    Observable<List<Gif>> search(String search);

    Observable<List<Gif>> trending();

}

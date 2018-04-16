package com.gmail.runkevich8.domain.interactor;


import com.gmail.runkevich8.domain.entity.Gif;
import com.gmail.runkevich8.domain.executor.PostExecutionThread;
import com.gmail.runkevich8.domain.repository.GifRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetSearchUseCase extends BaseUseCase {
    private GifRepository repository;

    @Inject
    public GetSearchUseCase(PostExecutionThread postExecutionThread, GifRepository repository) {
        super(postExecutionThread);
        this.repository = repository;
    }

    public Observable<List<Gif>> getSearch(String search) {
        return repository.search(search)
                .subscribeOn(threadExecuteion)
                .observeOn(postExecuteionThread);
    }
}

package com.gmail.runkevich8.screen;


import android.databinding.ObservableField;
import android.text.Editable;

import com.gmail.runkevich8.app.App;
import com.gmail.runkevich8.base.BaseViewModel;
import com.gmail.runkevich8.domain.entity.Gif;
import com.gmail.runkevich8.domain.interactor.GetDataUseCase;
import com.gmail.runkevich8.domain.interactor.GetSearchUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivityViewModel extends BaseViewModel {

    @Inject
    public GetDataUseCase getDataUseCase;
    @Inject
    public GetSearchUseCase getSearchUseCase;

    public final ObservableField<List<Gif>> gifs = new ObservableField<>();

    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    public MainActivityViewModel() {
        //App.getAppComponent().inject(this);
        getData();
    }

    public void searchGif(Editable s) {
        if (s == null || s.length() == 0){
            getData();
        }
        getSearchUseCase.getSearch(s.toString()).subscribe(new Observer<List<Gif>>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(List<Gif> gif) {
                gifs.set(gif);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void getData() {
        getDataUseCase.getData().subscribe(new Observer<List<Gif>>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(List<Gif> gif) {
                gifs.set(gif);
            }

            @Override
            public void onError(Throwable e) {

                //Crashlytics.logException(e); - корректная ошибка(оработка в фабрике)
            }

            @Override
            public void onComplete() {

            }
        });
    }
}

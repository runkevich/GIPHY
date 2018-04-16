package com.gmail.runkevich8.base;


import android.arch.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel extends ViewModel{
    //может всё внутри отписать, как массив disposable
    protected CompositeDisposable compositeDisposable = new CompositeDisposable();
//
//    public BaseViewModel(){
//        super();
//       // createInject();
//    }
public abstract void createInject();
    public BaseViewModel() {
        createInject();
    }

    //  public abstract void createInject();
  public void onCreate() {

  }
    public void onStart(){

    }
    public void onResume() {

    }

    public void onPause(){

    }
    public void onStop(){

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }
}

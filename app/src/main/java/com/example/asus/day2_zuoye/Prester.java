package com.example.asus.day2_zuoye;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Prester {
    public void presterServer(final Decide decide){
        Model model = new Model();
        Observable<Zhihu> server = model.modelServer();
        server.subscribe(new Observer<Zhihu>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Zhihu zhihu) {
                if (decide!=null){
                    decide.onSucceed(zhihu);
                }
            }

            @Override
            public void onError(Throwable e) {
                if (decide!=null){
                    decide.onFailure(e);
                }
            }

            @Override
            public void onComplete() {

            }
        });
    }
}

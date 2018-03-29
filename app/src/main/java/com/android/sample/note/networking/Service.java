package com.android.sample.note.networking;


import com.android.sample.note.Model.NoteListResponse;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Ramesh on 29/03/18.
 */
public class Service {
    private final NetworkService networkService;

    public Service(NetworkService networkService) {
        this.networkService = networkService;
    }

    public Subscription getNoteList(final GetNoteListCallback callback) {

        return networkService.getNoteList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends NoteListResponse>>() {
                    @Override
                    public Observable<? extends NoteListResponse> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<NoteListResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));

                    }

                    @Override
                    public void onNext(NoteListResponse noteListResponse) {
                        callback.onSuccess(noteListResponse);

                    }
                });
    }

    public interface GetNoteListCallback{
        void onSuccess(NoteListResponse noteListResponse);

        void onError(NetworkError networkError);
    }
}

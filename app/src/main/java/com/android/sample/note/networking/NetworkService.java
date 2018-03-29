package com.android.sample.note.networking;


import com.android.sample.note.Model.NoteListResponse;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Ramesh on 29/03/18.
 */
public interface NetworkService {

    @GET("v1/note")
    Observable<NoteListResponse> getNoteList();

}

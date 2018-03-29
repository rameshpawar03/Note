package com.android.sample.note.deps;


import com.android.sample.note.networking.NetworkModule;
import com.android.sample.note.view.NoteActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Ramesh on 29/03/18.
 */

@Singleton
@Component(modules = {NetworkModule.class,})
public interface Deps {
    void inject(NoteActivity noteActivity);
}

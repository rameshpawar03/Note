package com.android.sample.note;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.sample.note.deps.DaggerDeps;
import com.android.sample.note.deps.Deps;
import com.android.sample.note.networking.NetworkModule;

import java.io.File;

/**
 * Created by Ramesh on 29/03/18.
 */
public class BaseApp extends AppCompatActivity{
    Deps deps;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File cacheFile = new File(getCacheDir(), "responses");
        deps = DaggerDeps.builder().networkModule(new NetworkModule(cacheFile)).build();

    }

    public Deps getDeps() {
        return deps;
    }
}

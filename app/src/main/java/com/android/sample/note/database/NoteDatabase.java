package com.android.sample.note.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.android.sample.note.Model.NoteModel;
import com.android.sample.note.Model.NoteModelDao;

/**
 * Created by Ramesh on 29/03/18.
 */
@Database(entities = NoteModel.class, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase INSTANCE;

    public static NoteDatabase getDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabase.class, "notes_db")
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstances(){
        INSTANCE = null;
    }

    public abstract NoteModelDao noteItemAndNotesModel();

}

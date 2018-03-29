package com.android.sample.note.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.android.sample.note.database.NoteDatabase;
import com.android.sample.note.Model.NoteModel;


/**
 * Created by Ramesh on 29/03/18.
 */
public class AddNoteViewModel extends AndroidViewModel {

    private NoteDatabase noteDatabase;

    public AddNoteViewModel(@NonNull Application application) {
        super(application);
        noteDatabase = NoteDatabase.getDatabase(this.getApplication());
    }

    public void addNote(final NoteModel noteModel){
        new addAsyncTask(noteDatabase).execute(noteModel);
    }

    private static class addAsyncTask extends AsyncTask<NoteModel, Void, Void>{

        private NoteDatabase db;

        public addAsyncTask(NoteDatabase noteDatabase) {
            db = noteDatabase;
        }

        @Override
        protected Void doInBackground(final NoteModel... noteModels) {
            db.noteItemAndNotesModel().insertNote(noteModels[0]);
            return null;
        }
    }
}

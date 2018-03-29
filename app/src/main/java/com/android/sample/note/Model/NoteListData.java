package com.android.sample.note.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ramesh on 29/03/18.
 */


public class NoteListData {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("noteTitle")
    @Expose
    private String noteTitle;
    @SerializedName("noteDescription")
    @Expose
    private String noteDescription;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteDescription() {
        return noteDescription;
    }

    public void setNoteDescription(String noteDescription) {
        this.noteDescription = noteDescription;
    }
}

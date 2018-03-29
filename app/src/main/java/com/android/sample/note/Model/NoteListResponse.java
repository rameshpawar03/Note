package com.android.sample.note.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

/**
 * Created by Ramesh on 29/03/18.
 */

@Generated("org.jsonschema2pojo")
public class NoteListResponse {
    @SerializedName("data")
    @Expose
    private List<NoteListData> data = new ArrayList<NoteListData>();
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private int status;

    /**     *
     * @return
     * The data
     */
    public List<NoteListData> getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(List<NoteListData> data) {
        this.data = data;
    }

    /**
     *
     * @return
     * The message
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     * The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     * The status
     */
    public int getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(int status) {
        this.status = status;
    }

}

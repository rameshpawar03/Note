package com.android.sample.note.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.android.sample.note.BaseApp;
import com.android.sample.note.Model.NoteModel;
import com.android.sample.note.R;
import com.android.sample.note.networking.Service;
import com.android.sample.note.viewmodel.NoteAdapter;
import com.android.sample.note.viewmodel.NotesListViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Ramesh on 29/03/18.
 */

public class NoteActivity extends BaseApp implements View.OnLongClickListener{

    private NotesListViewModel viewModel;
    private RecyclerView mNotesRecyclerView;
    private NoteAdapter mAdapter;
    @Inject
    public Service service;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton note = findViewById(R.id.fab);

        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent addnote = new Intent(NoteActivity.this, AddNoteActivity.class);
             startActivity(addnote);
            }
        });


        mNotesRecyclerView = findViewById(R.id.recyclerView);
        mAdapter = new NoteAdapter(new ArrayList<NoteModel>(), this);
        mNotesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mNotesRecyclerView.setAdapter(mAdapter);

        //View model
        viewModel = ViewModelProviders.of(this).get(NotesListViewModel.class);
        viewModel.getNoteList().observe(NoteActivity.this, new Observer<List<NoteModel>>() {
            @Override
            public void onChanged(@Nullable List<NoteModel> noteModels) {
                mAdapter.addNote(noteModels);
            }
        });


    }

    @Override
    public boolean onLongClick(View view) {
        NoteModel noteModel = (NoteModel)view.getTag();
        viewModel.deleteNote(noteModel);
        Toast.makeText(this, noteModel.getNoteTitle()+"->Just deleted", Toast.LENGTH_SHORT).show();
        return true;
    }
}

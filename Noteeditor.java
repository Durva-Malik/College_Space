package com.example.ikgptulite;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashSet;

public class Noteeditor extends AppCompatActivity {
    int noteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noteeditor);

        EditText editText = findViewById(R.id.editText);

        // Fetch data that is passed from MainActivity
        Intent za = getIntent();

        // Accessing the data using key and value
        noteId = za.getIntExtra("noteId", -1);
        if (noteId != -1) {
            editText.setText(Notesfront.notes.get(noteId));
        } else {

            Notesfront.notes.add("");
            noteId = Notesfront.notes.size() - 1;
            Notesfront.arrayAdapter.notifyDataSetChanged();

        }

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // add your code here
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Notesfront.notes.set(noteId, String.valueOf(charSequence));
                Notesfront.arrayAdapter.notifyDataSetChanged();
                // Creating Object of SharedPreferences to store data in the phone
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.notes", Context.MODE_PRIVATE);
                HashSet<String> set = new HashSet(Notesfront.notes);
                sharedPreferences.edit().putStringSet("notes", set).apply();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // add your code here
            }
        });
    }
}
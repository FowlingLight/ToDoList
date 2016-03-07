package com.griffith.horiot.assignment1.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.griffith.horiot.assignment1.objs.CustomArrayAdapter;
import com.griffith.horiot.assignment1.R;
import com.griffith.horiot.assignment1.objs.ToDoItem;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private EditText editText;
    private CustomArrayAdapter customArrayAdapter;
    private SharedPreferences pref;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.add_task_button);

        this.listView = (ListView) findViewById(R.id.todo_list);
        this.editText = (EditText) findViewById(R.id.add_task_name);

        this.pref = getApplicationContext().getSharedPreferences("mySavedToDoList", 0);

        this.gson = new Gson();

        if(!this.pref.getString("list", "").equals("")) {
            ToDoItem[] tab = this.gson.fromJson(this.pref.getString("list", ""), ToDoItem[].class);
            this.customArrayAdapter = new CustomArrayAdapter(this, new ArrayList<>(Arrays.asList(tab)));
        } else {
            this.customArrayAdapter = new CustomArrayAdapter(this);
        }

        this.listView.setAdapter(this.customArrayAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editText.getText().toString().isEmpty()) {
                    customArrayAdapter.addItem(new ToDoItem(editText.getText().toString()));
                    customArrayAdapter.notifyDataSetChanged();
                    editText.setText("");
                    listView.setSelection(customArrayAdapter.getCount() - 1);

                }
            }
        });

        this.listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterview, View view, int pos, long id) {
                customArrayAdapter.removeItem(pos);
                customArrayAdapter.notifyDataSetChanged();
                return true;
            }
        });

    }

    @Override
    public void onStop() {
        SharedPreferences.Editor editor = this.pref.edit();
        editor.putString("list", gson.toJson(this.customArrayAdapter.getAllItems()));
        editor.apply();
        super.onStop();
    }
}

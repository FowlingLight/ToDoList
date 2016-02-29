package com.griffith.horiot.assignment1.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.griffith.horiot.assignment1.Objects.CustomArrayAdapter;
import com.griffith.horiot.assignment1.Objects.ToDoItem;
import com.griffith.horiot.assignment1.R;

public class MainActivity extends AppCompatActivity {

    // private fields of the class
    private TextView textView;
    private ListView listView;
    private EditText editText;
    private CheckBox checkBox;
    private Button button;
    private CustomArrayAdapter customArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.textView = (TextView) findViewById(R.id.item_text);
        this.listView = (ListView) findViewById(R.id.todo_list);
        this.editText = (EditText) findViewById(R.id.add_task_name);
        this.button = (Button) findViewById(R.id.add_task_button);
        this.checkBox = (CheckBox) findViewById(R.id.item_checkbox);

        this.customArrayAdapter = new CustomArrayAdapter(this);
        this.listView.setAdapter(this.customArrayAdapter);

        this.button.setOnClickListener(new View.OnClickListener() {
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
}

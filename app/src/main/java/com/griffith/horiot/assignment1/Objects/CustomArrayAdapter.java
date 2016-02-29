package com.griffith.horiot.assignment1.Objects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.griffith.horiot.assignment1.R;

import java.util.ArrayList;

/**
 * Created by horiot_b_to_chage on 29/02/2016 for Code and Learn
 */
public class CustomArrayAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ToDoItem> al_items;

    static class ViewHolder {
        public CheckBox checkBox;
        public TextView textView;
    }

    public CustomArrayAdapter(Context c) {
        this.context = c;
        this.al_items = new ArrayList<>();
    }

    public View getView(final int position, View convert_view, ViewGroup parent) {
        ViewHolder holder;

        if (convert_view == null) {
            holder = new ViewHolder();

            LayoutInflater inflator = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convert_view = inflator.inflate(R.layout.list_item, parent, false);
            holder.checkBox = (CheckBox) convert_view.findViewById(R.id.item_checkbox);
            holder.textView = (TextView) convert_view.findViewById(R.id.item_text);

            convert_view.setTag(holder);
        } else {
            holder = (ViewHolder) convert_view.getTag();
        }

        holder.checkBox.setChecked(al_items.get(position).isChecked());
        holder.textView.setText(al_items.get(position).getTaskName());
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                al_items.get(position).setChecked(isChecked);
            }
        });

        return convert_view;
    }

    public void addItem(ToDoItem item) {
        this.al_items.add(item);
    }

    public void removeItem(int pos) {
        this.al_items.remove(pos);
    }

    public int getCount() {
        return al_items.size();
    }

    public long getItemId(int position) {
        return position;
    }

    public Object getItem(int position) {
        return al_items.get(position);
    }
}

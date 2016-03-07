package com.griffith.horiot.assignment1.objs;

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

    public CustomArrayAdapter(Context c, ArrayList<ToDoItem> list) {
        this.context = c;
        this.al_items = list;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();

            LayoutInflater inflator = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflator.inflate(R.layout.list_item, parent, false);
            holder.checkBox = (CheckBox) convertView.findViewById(R.id.item_checkbox);
            holder.textView = (TextView) convertView.findViewById(R.id.item_text);

            holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    int pos = (Integer) buttonView.getTag();
                    al_items.get(pos).setChecked(buttonView.isChecked());
                }
            });

            convertView.setTag(holder);
            convertView.setTag(R.id.item_text, holder.textView);
            convertView.setTag(R.id.item_checkbox, holder.checkBox);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.checkBox.setTag(position);

        holder.checkBox.setChecked(al_items.get(position).isChecked());
        holder.textView.setText(al_items.get(position).getTaskName());

        return convertView;
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

    public ArrayList<ToDoItem> getAllItems() {
        return al_items;
    }
}

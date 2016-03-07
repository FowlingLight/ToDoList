package com.griffith.horiot.assignment1.objs;

/**
 * Created by horiot_b_to_chage on 29/02/2016 for Code and Learn
 */
public class ToDoItem {
    private boolean checked;
    private String taskName;

    public ToDoItem(String taskName) {
        this.taskName = taskName;
        this.checked = false;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String toString() {
        return "ToDoItem{" +
                "checked=" + this.checked +
                ", taskName='" + this.taskName + '\'' +
                '}';
    }
}

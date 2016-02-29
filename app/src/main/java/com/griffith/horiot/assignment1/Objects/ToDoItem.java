package com.griffith.horiot.assignment1.Objects;

/**
 * Created by horiot_b_to_chage on 29/02/2016 for Code and Learn
 */
public class ToDoItem {
    private boolean checkedState;
    private String taskName;

    public ToDoItem(String taskName) {
        this.taskName = taskName;
        this.checkedState = false;
    }

    public boolean isCheckedState() {
        return this.checkedState;
    }

    public void setCheckedState(boolean checkedState) {
        this.checkedState = checkedState;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}

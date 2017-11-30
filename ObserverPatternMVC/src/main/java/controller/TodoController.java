package controller;

import javafx.scene.control.CheckBox;
import model.TodosModel;
import view.TodoView;

public class TodoController
{
    private TodosModel model;
    private TodoView view;

    public TodoController(TodoView view)
    {
        this.view = view;

        if (model == null)
        {
            model = new TodosModel(view);
        }
    }

    public void removeTask(CheckBox box, int index)
    {
        model.deleteTask(box.getText(), index);
    }

    public void addNewTask(String message)
    {
        model.addTask(message);
    }

    public int getTasksAmount()
    {
        return model.getSize();
    }
}

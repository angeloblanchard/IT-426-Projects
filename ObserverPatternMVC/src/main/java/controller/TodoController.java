package controller;

import model.TodosModel;
import view.TodoView;

public class TodoController
{
    private TodosModel model;
    private TodoView view;

    public TodoController()
    {
        if (model == null)
        {
            model = new TodosModel();
        }

        if (view == null)
        {
            view = new TodoView();
        }
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

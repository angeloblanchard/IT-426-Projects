package controller;

import model.TodosModel;
import view.TodoView;

/**
 * @author Angelo Blanchard
 * @version 1.0
 * Controller between TodosModel and TodosView
 */
public class TodoController
{
    private TodosModel model;

    /**
     * Lazy initiation of todosModel
     * @param view GUI of TodoView
     */
    public TodoController(TodoView view)
    {
        if (model == null)
        {
            model = new TodosModel(view);
        }
    }

    /**
     * Sends request to remove a task to TodosModel
     * @param index index to be deleted
     */
    public void removeTask(int index)
    {
        model.deleteTask(index);
    }

    /**
     * Sends request to add task to TodosModel
     * @param message message to be added to task
     */
    public void addNewTask(String message)
    {
        model.addTask(message);
    }

    /**
     * Sends request for size of TodosModel
     * @return size of model
     */
    public int getTasksAmount()
    {
        return model.getSize();
    }
}

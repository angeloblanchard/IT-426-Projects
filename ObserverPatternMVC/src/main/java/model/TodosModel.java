package model;

import view.TodoView;

import java.util.*;

/**
 * @author Angelo Blanchard
 * @version 1.0
 * This model holds all the data of the Todos project.
 */
public class TodosModel extends Observable
{
    private List<Todo> todoList;
    private int size;
    private JavaExporter javaExporter;
    private JavaImporter javaImporter;

    /**
     * Constructs TodosModel, and imports the Java object from todos.dat
     * @param view TodoView is the Observer
     */
    public TodosModel(TodoView view)
    {
        if (todoList == null)
        {
            todoList = new ArrayList<>();
            size = 0;
            this.addObserver(view);
            javaImporter = new JavaImporter(this);
            javaImporter.importTodos();

            this.setChanged();
            this.notifyObservers(todoList);
        }
    }

    /**
     * Adds a task to the todoList, and updates the file
     * @param message task to be done
     */
    public void addTask(String message)
    {
        UUID id = UUID.randomUUID();
        Todo todo = new Todo(id, message);
        for (Todo todoItem: todoList)
        {
            if (todoItem == todo)
            {
                try
                {
                    throw new ExistingRecordException();
                } catch (ExistingRecordException e)
                {
                    e.printStackTrace();
                }
            }
        }
        todoList.add(todo);
        size++;
        updateTaskFile();
    }


    /**
     * Updates the task file using a Java exporter, file is todos.dat
     */
    public void updateTaskFile()
    {
        javaExporter = new JavaExporter(this);
        javaExporter.exportTodos();
        this.setChanged();
        this.notifyObservers(todoList);
    }

    /**
     * Deletes a task from todosList, and updates the file
     * @param index index to be deleted in list
     */
    public void deleteTask(int index)
    {
        if (!todoList.contains(todoList.get(index)))
        {
            try
            {
                throw new MissingRecordException();
            } catch (MissingRecordException e)
            {
                e.printStackTrace();
            }
        }
        todoList.remove(index);
        updateTaskFile();
        size--;
    }

    /**
     * Returns the size of the list of Todos
     * @return size of todosList
     */
    public int getSize()
    {
        return size;
    }

    /**
     * Returns the List of Todos
     * @return list of Todos
     */
    public List<Todo> getTodoList()
    {
        return todoList;
    }

    /**
     * Adds entire Todo List to todoList
     * @param list list pulled from import
     */
    public void setTodoList(ArrayList<Todo> list)
    {
        this.todoList = list;
        size = list.size();
    }

    private class ExistingRecordException extends Throwable
    {
    }

    private class MissingRecordException extends Throwable
    {
    }
}

package model;

import controller.TodoController;
import view.TodoView;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.UUID;

public class TodosModel extends Observable
{
    private List<Todo> todoList;
    private int size;
    private JavaExporter javaExporter;
    private JavaImporter javaImporter;

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

    public void addTask(String message)
    {
        UUID id = UUID.randomUUID();
        Todo todo = new Todo(id, message);
        todoList.add(todo);
        size++;
        updateTaskFile();
    }


    public void updateTaskFile()
    {
        javaExporter = new JavaExporter(this);
        javaExporter.exportTodos();
        this.setChanged();
        this.notifyObservers(todoList);
    }

    public void deleteTask(String message, int index)
    {
        todoList.remove(index);
        updateTaskFile();
        size--;
    }

    public int getSize()
    {
        return size;
    }

    public List<Todo> getTodoList()
    {
        return todoList;
    }

    public void setTodoList(ArrayList<Todo> list)
    {
        this.todoList = list;
        size = list.size();
    }
}

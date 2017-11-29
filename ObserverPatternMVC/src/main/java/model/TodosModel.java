package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.UUID;

public class TodosModel extends Observable
{
    private List<Todo> todoList;
    private int size;

    public TodosModel()
    {
        if (todoList == null)
        {
            todoList = new ArrayList<>();
            size = 0;
        }
    }

    public void addTask(String message)
    {
        UUID id = UUID.randomUUID();
        Todo todo = new Todo(id, message);
        todoList.add(todo);
    }

    public int getSize()
    {
        return size;
    }
}

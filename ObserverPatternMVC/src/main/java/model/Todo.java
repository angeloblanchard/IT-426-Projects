package model;

import java.util.UUID;

public class Todo
{
    private UUID id;
    private String message;

    public Todo(UUID id, String message)
    {
        this.id = id;
        this.message = message;
    }

    public UUID getId()
    {
        return id;
    }

    public String getMessage()
    {
        return message;
    }
}

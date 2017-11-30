package model;

import java.io.Serializable;
import java.util.UUID;

public class Todo implements Serializable
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

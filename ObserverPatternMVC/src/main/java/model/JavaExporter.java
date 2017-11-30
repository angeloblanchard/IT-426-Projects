package model;


import java.io.*;

/**
 * Exports a Todo object into a DAT file
 *
 * @author Angelo Blanchard
 * @version 1.0
 */
public class JavaExporter
{
    TodosModel model;

    public JavaExporter(TodosModel model)
    {
        this.model = model;
    }

    /**
     * exports Todo object into todos.dat
     * @return true if input is added, false otherwise
     */

    public boolean exportTodos()
    {
        try
        {

            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("todos.dat"));
            outputStream.writeObject(model.getTodoList());

            outputStream.close();
            return true;
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return false;
    }
}

package model;

import java.io.*;
import java.util.ArrayList;

/**
 * Imports in a DAT file to be converted to a TodosModel object
 *
 * @author Angelo Blanchard
 * @version 1.0
 */
public class JavaImporter
{
    TodosModel model;

    public JavaImporter(TodosModel model)
    {
        this.model = model;
    }

    /**
     * imports file from todos.dat
     * @return false if file is empty, true otherwise
     */

    public boolean importTodos()
    {
        File todosFile = new File("todos.dat");
        if (todosFile.exists() || todosFile.length() != 0)
        {
            try
            {
                FileInputStream fileInputStream = new FileInputStream(todosFile);
                ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);

                ArrayList<Todo> todoList = (ArrayList) inputStream.readObject();
                model.setTodoList(todoList);

                inputStream.close();

            } catch (StreamCorruptedException e)
            {
                e.printStackTrace();
            }catch (EOFException e)
            {
                e.printStackTrace();
            } catch (IOException e)

            {
                e.printStackTrace();
            } catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
}

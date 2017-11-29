package launcher;

import javafx.application.Application;
import view.TodoView;

public class Launcher
{
    public static void main(String[] args)
    {
        Application.launch(TodoView.class, args);
    }
}

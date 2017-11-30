package view;

import controller.TodoController;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Todo;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Angelo Blanchard
 * @version 1.0
 * This is the GUI for adding and deleting tasks from a todos list.
 */
public class TodoView extends Application implements Observer
{
    private static final double SCENE_WIDTH = 400;
    private static final double SCENE_HEIGHT = 450;
    private Stage stage;
    private CheckBox[] todoBox;
    private TodoController controller;
    private VBox tasksBox;
    private BorderPane root;

    /**
     * Sets initial stage to the welcome scene
     * @param stage Primary stage of GUI
     */
    @Override
    public void start(Stage stage)
    {
        this.stage = stage;

        stage.setTitle("Task List");
        try
        {
            stage.setScene(getWelcomeScene());
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        stage.show();
    }

    private Scene getWelcomeScene() throws MalformedURLException
    {
        BorderPane root = new BorderPane();

        VBox vbox = new VBox();
        root.setCenter(vbox);

        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setPadding(new Insets(15));
        vbox.setSpacing(10);

        Text title = new Text("Welcome");
        title.setFont(Font.font("Tahoma", FontWeight.BOLD,28));

        controller = new TodoController(this);
        int taskSize = controller.getTasksAmount();

        Text text = new Text("You have " + taskSize + " unfinished tasks");
        text.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));

        Button button = new Button("View");
        button.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {
                    stage.setScene(getTasksScene());
                } catch (MalformedURLException e)
                {
                    e.printStackTrace();
                }
            }
        });


        Image image = new Image("file:todos.png");
        ImageView imageView = new ImageView();
        imageView.setImage(image);


        vbox.getChildren().add(title);
        vbox.getChildren().add(text);
        vbox.getChildren().add(button);
        vbox.getChildren().add(imageView);



        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        scene.getStylesheets().clear();
        scene.getStylesheets().add(new File("src/styles/styles.css").toURI().toURL().toExternalForm());
        return scene;
    }

    private Scene getTasksScene() throws MalformedURLException
    {
        root = new BorderPane();
        tasksBox = new VBox();
        HBox hbox = new HBox();

        root.setTop(hbox);
        root.setCenter(tasksBox);
        root.setPrefWidth(SCENE_WIDTH);

        tasksBox.setPrefWidth(SCENE_WIDTH);

        hbox.setPrefWidth(SCENE_WIDTH);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(10, 20, 10, 110));
        hbox.setSpacing(50);

        hbox.setAlignment(Pos.CENTER_LEFT);
        Text task = new Text("Tasks");
        task.setFont(Font.font("Tahoma", FontWeight.BOLD, 28));

        if (controller.getTasksAmount() == 0)
        {
            Label text = new Label("There are no tasks currently. Add a task by clicking the + above");
            text.setFont(Font.font("Tahoma", 18));
            text.setWrapText(true);
            tasksBox.getChildren().add(text);
        }
        else
        {
            tasksBox.getChildren().addAll(createCheckBox());
        }

        tasksBox.setAlignment(Pos.TOP_CENTER);
        tasksBox.setPadding(new Insets(20));

        Button addTask = new Button("+");
        addTask.setPrefWidth(60);
        addTask.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {
                    stage.setScene(getAddTaskScene());
                } catch (MalformedURLException e)
                {
                    e.printStackTrace();
                }
            }
        });

        hbox.getChildren().add(task);
        hbox.getChildren().add(addTask);

        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        scene.getStylesheets().clear();
        scene.getStylesheets().add(new File("src/styles/styles.css").toURI().toURL().toExternalForm());
        return scene;
    }

    public Scene getAddTaskScene() throws MalformedURLException
    {
        BorderPane root = new BorderPane();

        VBox vbox = new VBox();
        vbox.setPrefWidth(SCENE_WIDTH);
        vbox.setPrefHeight(SCENE_HEIGHT - 100);
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);
        root.setTop(vbox);

        Label title = new Label("Add New Task");
        title.setFont(Font.font("Tahoma", FontWeight.BOLD, 28));

        TextArea field = new TextArea();
        field.setWrapText(true);
        field.setPrefHeight(SCENE_HEIGHT - 100);

        Button finish = new Button("Finish");
        finish.setFont(Font.font("Tahoma", 18));
        finish.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                controller.addNewTask(field.getText());
                try
                {
                    stage.setScene(getTasksScene());
                } catch (MalformedURLException e)
                {
                    e.printStackTrace();
                }
            }
        });

        vbox.getChildren().add(title);
        vbox.getChildren().add(field);

        root.setCenter(finish);

        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        scene.getStylesheets().clear();
        scene.getStylesheets().add(new File("src/styles/styles.css").toURI().toURL().toExternalForm());
        return scene;
    }

    private CheckBox[] createCheckBox()
    {
        CheckBox[] checkBox = todoBox;

        for (int i = 0; i < checkBox.length; i++)
        {
            final CheckBox box = checkBox[i];

            int finalI = i;
            box.selectedProperty().addListener(new ChangeListener<Boolean>()
            {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable,
                                    Boolean oldValue, Boolean newValue)
                {
                    controller.removeTask(finalI);
                    try
                    {
                        stage.setScene(getTasksScene());
                    } catch (MalformedURLException e)
                    {
                        e.printStackTrace();
                    }
                }
            });
        }

        return checkBox;
    }

    /**
     * Observer method to update the GUI checkbox
     * @param todoModel data of project
     * @param todoList list to be updated
     */
    @Override
    public void update(Observable todoModel, Object todoList)
    {
        ArrayList list = (ArrayList) todoList;
        todoBox = new CheckBox[list.size()];
        int count = 0;
        for (Object o : (ArrayList)todoList)
        {
            Todo todo = (Todo) o;
            CheckBox box = new CheckBox(todo.getMessage());
            box.setPrefWidth(350);
            todoBox[count] = box;
            count++;
        }
    }
}

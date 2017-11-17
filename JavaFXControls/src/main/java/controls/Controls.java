package controls;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

public class Controls extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setScene(createCheckBoxes());
        stage.setTitle("Practicing with controls!");
        stage.show();
    }

    public Scene createButtons()
    {
        VBox vbox = new VBox();

        // create a button, style it
        Button button = new Button("Click me!");
        button.setAlignment(Pos.CENTER_RIGHT);
        button.setPrefHeight(50);
        button.setPrefWidth(150);

        button.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                button.setText("You clicked me!");
            }
        });

        vbox.getChildren().add(button);
        vbox.setAlignment(Pos.CENTER);



        return new Scene(vbox, 300, 300);
    }

    // text, label, textfield, textarea
    public Scene createText()
    {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));

//        Text header = TextBuilder.create().text("Enter Information")
//                .font(Font.font("Century Gothic", FontWeight.MEDIUM, 30))
//                .underline(true)
//                .build();

        Text header = new Text("Enter information");
        header.setFont(Font.font("Century Gothic",
                FontWeight.MEDIUM, 30));
        header.setUnderline(true);
        //header.setTextAlignment(TextAlignment.CENTER);

        vBox.getChildren().add(header);

        // add form controls
        HBox row1 = new HBox();
        row1.setSpacing(10);

        Label nameLabel = new Label("Name: ");
        nameLabel.setPrefWidth(90);
        nameLabel.setAlignment(Pos.CENTER_RIGHT);

        TextField field = new TextField();
        field.setPrefWidth(180);

        row1.getChildren().addAll(nameLabel, field);
        vBox.getChildren().add(row1);

        //  add more form controls
        HBox row2 = new HBox();
        row2.setSpacing(10);

        Label bioLabel = new Label("Bio: ");
        bioLabel.setPrefWidth(90);
        bioLabel.setAlignment(Pos.CENTER_RIGHT);

        TextArea area = new TextArea();
        area.setPrefWidth(180);

        row2.getChildren().addAll(bioLabel, area);
        vBox.getChildren().add(row2);

        return new Scene(vBox, 300, 300);
    }

    // checkboxes
    public Scene createCheckBoxes()
    {
        String[] hobbies = {"Comic Collecting", "Drawing", "Video Games",
                            "Underwater Basket Weaving", "Kayaking", "Hiking"};
        CheckBox[] boxes = new CheckBox[hobbies.length];

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);

        for (int i = 0; i < hobbies.length; i++)
        {
            CheckBox box = new CheckBox(hobbies[i]);
            boxes[i] = box;
            box.setPrefWidth(200);
        }
        vbox.getChildren().addAll(boxes);

        // add event handlers
        for (int i = 0; i < boxes.length; i++)
        {
            final CheckBox box = boxes[i];
            final String hobby = hobbies[i];

            box.selectedProperty().addListener(new ChangeListener<Boolean>()
            {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable,
                                    Boolean oldValue, Boolean newValue)
                {
                    if (newValue == true)
                    {
                        // do something with the checkbox we're clicking on
                        box.setText("You clicked me: " + newValue);
                    }
                    else
                    {
                        box.setText(hobby);
                    }

                }
            });
        }



        return new Scene(vbox, 300, 300);
    }

    // radio buttons, images

    // drop down lists
    public Scene createDropDowns()
    {
        // create layout and controls
        VBox box = new VBox();
        ComboBox combo = new ComboBox();

        box.setSpacing(10);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(10));

        // add items to my dropdown
        ObservableList<String> options = FXCollections.observableArrayList(
                "blue", "purple", "green", "yellow", "pink");



        combo.getItems().addAll(options);
        box.getChildren().add(combo);

        // select a default
        combo.getSelectionModel().select(1);
        // combo.getSelectionModel().select("green"); -- another way

        // respond to selection
        combo.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Alert alert = new Alert(AlertType.INFORMATION,
                                    "You clicked " + combo.getValue());
                alert.show();
            }
        });

        // other types of dropdown lists
        DatePicker picker = new DatePicker();
        box.getChildren().add(picker);

        ColorPicker colors = new ColorPicker();
        box.getChildren().add(colors);

        return new Scene (box, 300, 300);
    }

    // lists
    public Scene createLists()
    {
        VBox box =  new VBox();
        ListView view = new ListView();

        // add a few items
        ObservableList<String> items = FXCollections.observableArrayList(
                            "Robyn", "Five Finger Death Punch",
                                   "Slayer", "William Hung"
        );
        view.getItems().addAll(items);
        box.getChildren().add(view);

        return new Scene(box, 300, 300);
    }
}

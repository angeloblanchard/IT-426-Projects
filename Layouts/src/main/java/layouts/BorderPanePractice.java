package layouts;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BorderPanePractice extends Application
{
    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Practicing with Border Pane");
        stage.setScene(getScene());
        stage.show();
    }

    private Scene getScene()
    {
        BorderPane parentPanel = new BorderPane();

        // topButtons to the top
        HBox topButtons = new HBox(); // nested panel
        topButtons.setAlignment(Pos.CENTER);
        parentPanel.setTop(topButtons);

        topButtons.getChildren().addAll(new Button("Click"),
                new Button ("Me"), new Button ("Now!"));

        // text on the left
        VBox leftPanel = new VBox();
        parentPanel.setLeft(leftPanel);

        String[] sayings = {"If I don't push the limits!!!",
                "Lasagna, lasagna, lasagna...",
                "Don't let your dreams, be dreams",
                "Some people dream of greatness, others work hard for it!"};



        for (int i = 0; i < sayings.length; i++)
        {
            leftPanel.getChildren().addAll(getTextControl(sayings[i]));
        }


        // list on the right
        ListView list = new ListView();
        list.getItems().addAll(FXCollections.observableArrayList(
                "I'll follow you down", "The Room", "Running Man",
                "Wonder Woman", "Lego Batman", "Despicable Me 3"));
        parentPanel.setRight(list);


        // image in the middle
        Image image = new Image("images/squirrel.jpg");
        ImageView imageControl = new ImageView(image);
        imageControl.setFitHeight(200);
        imageControl.setFitWidth(200);
        parentPanel.setCenter(imageControl);

        // paragraph on the bottom
        Text bottomParagraph = new Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
                "Quisque ultrices in mauris id aliquet. Morbi sed lacus ut purus malesuada dignissim." +
                "Nullam placerat luctus eleifend. Sed vel dui pretium, sodales urna non, sodales quam." +
                "Donec tempus non nisl at pellentesque. Vestibulum gravida tortor sit amet libero maximus," +
                " id ullamcorper nisi tristique. Vivamus venenatis nulla vel pretium varius. Nulla ante mi," +
                "volutpat vitae libero in, posuere fermentum metus.");
        bottomParagraph.setWrappingWidth(500);
        parentPanel.setBottom(bottomParagraph);

        return new Scene(parentPanel, 400, 400);
    }

    private Text getTextControl(String message)
    {
        Text control = new Text(message);
        control.setWrappingWidth(120);
        return control;
    }
}

package layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Random;

public class FlowPanePractice extends Application
{
    @Override
    public void start(Stage stage)
    {
        stage.setScene(getScene());
        stage.setTitle("Practicing with FlowPane!");
        stage.show();
    }

    private Scene getScene()
    {
        // create flowpane and set
        FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(10));
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(10);
        pane.setHgap(10);

        // add a few random elements
        Random random = new Random();
        for (int i = 1; i < 42; i++)
        {
            Rectangle rect = new Rectangle();
            rect.setHeight(30);
            rect.setWidth(random.nextInt(90) + 10); // 10-100

            pane.getChildren().add(rect);
        }


        return new Scene (pane, 300, 300);
    }
}

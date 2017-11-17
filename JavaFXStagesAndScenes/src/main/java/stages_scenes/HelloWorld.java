package stages_scenes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloWorld extends Application
{

    private static final int WIN_WIDTH = 300;
    private static final int WIN_HEIGHT = 300;
    private static final int PANEL_PADDING = 10;
    private static final int TITLE_FONT_SIZE = 24;

    public static void main(String[]args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage)
        {
            stage.setTitle("Hello world this is Java FX");
            stage.setScene(getScene());
            stage.show();

        }

        private Scene getScene()
        {
            VBox vBox = new VBox();
            Text text = new Text("Hello world!");
            vBox.getChildren().add(text);

            //center the vbox and add some padding
            vBox.setAlignment(Pos.CENTER);
            vBox.setPadding(new Insets(PANEL_PADDING));

            //set a new font for out text element
            text.setFont(Font.font("impact", FontWeight.BOLD, TITLE_FONT_SIZE));

            return new Scene(vBox, WIN_WIDTH, WIN_HEIGHT);
        }
}

package ui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculatorUI extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setScene(createCalculator());
        stage.setTitle("Calculator");
        stage.show();
    }

    public Scene createCalculator()
    {
        VBox vBox = new VBox();

        // Calculator buttons

        // Row One
        HBox row1 = new HBox();

        Button seven = new Button("7");
        seven.setAlignment(Pos.CENTER_RIGHT);
        seven.setPrefHeight(50);
        seven.setPrefWidth(50);

        Button eight = new Button("8");
        eight.setAlignment(Pos.CENTER_RIGHT);
        eight.setPrefHeight(50);
        eight.setPrefWidth(50);

        Button nine = new Button("9");
        nine.setAlignment(Pos.CENTER_RIGHT);
        nine.setPrefHeight(50);
        nine.setPrefWidth(50);

        Button plus = new Button("+");
        plus.setAlignment(Pos.CENTER_RIGHT);
        plus.setPrefHeight(50);
        plus.setPrefWidth(50);


        Button zero = new Button("0");
        zero.setAlignment(Pos.CENTER_RIGHT);
        zero.setPrefHeight(50);
        zero.setPrefWidth(50);

        Button one = new Button("1");
        one.setAlignment(Pos.CENTER_RIGHT);
        one.setPrefHeight(50);
        one.setPrefWidth(50);

        Button two = new Button("2");
        two.setAlignment(Pos.CENTER_RIGHT);
        two.setPrefHeight(50);
        two.setPrefWidth(50);

        Button three = new Button("3");
        three.setAlignment(Pos.CENTER_RIGHT);
        three.setPrefHeight(50);
        three.setPrefWidth(50);

        Button four = new Button("4");
        four.setAlignment(Pos.CENTER_RIGHT);
        four.setPrefHeight(50);
        four.setPrefWidth(50);

        Button five = new Button("5");
        five.setAlignment(Pos.CENTER_RIGHT);
        five.setPrefHeight(50);
        five.setPrefWidth(50);

        Button six = new Button("6");
        six.setAlignment(Pos.CENTER_RIGHT);
        six.setPrefHeight(50);
        six.setPrefWidth(50);

        Button minus = new Button("9");
        minus.setAlignment(Pos.CENTER_RIGHT);
        minus.setPrefHeight(50);
        minus.setPrefWidth(50);

        Button multiply = new Button("9");
        multiply.setAlignment(Pos.CENTER_RIGHT);
        multiply.setPrefHeight(50);
        multiply.setPrefWidth(50);

        Button divide = new Button("9");
        divide.setAlignment(Pos.CENTER_RIGHT);
        divide.setPrefHeight(50);
        divide.setPrefWidth(50);

        Button enter = new Button("9");
        enter.setAlignment(Pos.CENTER_RIGHT);
        enter.setPrefHeight(50);
        enter.setPrefWidth(50);

        return new Scene(vBox, 300, 300);
    }
}

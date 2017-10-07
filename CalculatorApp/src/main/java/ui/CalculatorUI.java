package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
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

    private Scene createCalculator()
    {
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(70));

        // Calculator buttons

        // Row One
        HBox row1 = new HBox();

        Button seven = new Button("7");
        seven.setAlignment(Pos.CENTER);
        seven.setPrefHeight(30);
        seven.setPrefWidth(30);
        seven.setPadding(new Insets (5));

        Button eight = new Button("8");
        eight.setAlignment(Pos.CENTER);
        eight.setPrefHeight(30);
        eight.setPrefWidth(30);

        Button nine = new Button("9");
        nine.setAlignment(Pos.CENTER);
        nine.setPrefHeight(30);
        nine.setPrefWidth(30);

        Button plus = new Button("+");
        plus.setAlignment(Pos.CENTER);
        plus.setPrefHeight(30);
        plus.setPrefWidth(30);

        row1.getChildren().addAll(seven, eight, nine, plus);
        vBox.getChildren().add(row1);

        // Row Two
        HBox row2 = new HBox();

        Button four = new Button("4");
        four.setAlignment(Pos.CENTER);
        four.setPrefHeight(30);
        four.setPrefWidth(30);

        Button five = new Button("5");
        five.setAlignment(Pos.CENTER);
        five.setPrefHeight(30);
        five.setPrefWidth(30);

        Button six = new Button("6");
        six.setAlignment(Pos.CENTER);
        six.setPrefHeight(30);
        six.setPrefWidth(30);

        Button minus = new Button("-");
        minus.setAlignment(Pos.CENTER);
        minus.setPrefHeight(30);
        minus.setPrefWidth(30);

        row2.getChildren().addAll(four, five, six, minus);
        vBox.getChildren().add(row2);

        // Row Three
        HBox row3 = new HBox();

        Button one = new Button("1");
        one.setAlignment(Pos.CENTER);
        one.setPrefHeight(30);
        one.setPrefWidth(30);

        Button two = new Button("2");
        two.setAlignment(Pos.CENTER);
        two.setPrefHeight(30);
        two.setPrefWidth(30);

        Button three = new Button("3");
        three.setAlignment(Pos.CENTER);
        three.setPrefHeight(30);
        three.setPrefWidth(30);

        Button multiply = new Button("9");
        multiply.setAlignment(Pos.CENTER);
        multiply.setPrefHeight(30);
        multiply.setPrefWidth(30);

        row3.getChildren().addAll(one, two, three, multiply);
        vBox.getChildren().add(row3);

        // Row Four
        HBox row4 = new HBox();

        Button zero = new Button("0");
        zero.setAlignment(Pos.CENTER);
        zero.setPrefHeight(30);
        zero.setPrefWidth(30);

        Button enter = new Button("Enter");
        enter.setAlignment(Pos.CENTER);
        enter.setPrefHeight(30);
        enter.setPrefWidth(60);

        Button divide = new Button("/");
        divide.setAlignment(Pos.CENTER);
        divide.setPrefHeight(30);
        divide.setPrefWidth(30);

        row4.getChildren().addAll(zero, enter, divide);
        vBox.getChildren().add(row4);

        // Row Five
        HBox row5 = new HBox();
        row5.setPadding(new Insets (10));
        row5.setBorder(new Border(new BorderStroke(Color.GRAY,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        row5.setAlignment(Pos.CENTER_RIGHT);

        Label output = new Label("73");
        output.setPrefWidth(120);

        row5.getChildren().addAll(output);
        vBox.getChildren().add(row5);


        return new Scene(vBox, 300, 300);
    }
}

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

/**
 * @Author Angelo Blanchard
 * @Version 1.0
 * @Date 6 October 2017
 * This is the gui for a calculator app built using JavaFX / Maven / IntelliJ.
 */
public class CalculatorUI extends Application
{
    /**
     * This launches the method that creates scene of the calculator gui and calls the gui.
     * @param args the launcher of the gui
     */
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

    /**
     * This method creates the calculator Scene.
     * @return the vbox of the calculator scene
     */
    private Scene createCalculator()
    {
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(20, 70, 0, 70));

        // Calculator buttons

        // Row One
        HBox row1 = new HBox();
        row1.setSpacing(11);
        row1.setPadding(new Insets(6, 0, 6, 0));

        Button seven = new Button("7");
        seven.setAlignment(Pos.CENTER);
        seven.setPrefHeight(27);
        seven.setPrefWidth(30);
        seven.setPadding(new Insets(3));

        Button eight = new Button("8");
        eight.setAlignment(Pos.CENTER);
        eight.setPrefHeight(27);
        eight.setPrefWidth(31);
        eight.setPadding(new Insets(3));

        Button nine = new Button("9");
        nine.setAlignment(Pos.CENTER);
        nine.setPrefHeight(27);
        nine.setPrefWidth(31);
        nine.setPadding(new Insets(3));

        Button plus = new Button("+");
        plus.setAlignment(Pos.CENTER);
        plus.setPrefHeight(27);
        plus.setPrefWidth(29);
        plus.setPadding(new Insets(3));

        row1.getChildren().addAll(seven, eight, nine, plus);
        vBox.getChildren().add(row1);

        // Row Two
        HBox row2 = new HBox();
        row2.setSpacing(11);
        row2.setPadding(new Insets(6, 0, 6, 0));

        Button four = new Button("4");
        four.setAlignment(Pos.CENTER);
        four.setPrefHeight(27);
        four.setPrefWidth(30);
        four.setPadding(new Insets(3));

        Button five = new Button("5");
        five.setAlignment(Pos.CENTER);
        five.setPrefHeight(27);
        five.setPrefWidth(31);
        five.setPadding(new Insets(3));

        Button six = new Button("6");
        six.setAlignment(Pos.CENTER);
        six.setPrefHeight(27);
        six.setPrefWidth(31);
        six.setPadding(new Insets(3));

        Button minus = new Button("-");
        minus.setAlignment(Pos.CENTER);
        minus.setPrefHeight(27);
        minus.setPrefWidth(29);
        minus.setPadding(new Insets(3));

        row2.getChildren().addAll(four, five, six, minus);
        vBox.getChildren().add(row2);

        // Row Three
        HBox row3 = new HBox();
        row3.setSpacing(11);
        row3.setPadding(new Insets(6, 0, 6, 0));

        Button one = new Button("1");
        one.setAlignment(Pos.CENTER);
        one.setPrefHeight(27);
        one.setPrefWidth(30);
        one.setPadding(new Insets(3));

        Button two = new Button("2");
        two.setAlignment(Pos.CENTER);
        two.setPrefHeight(27);
        two.setPrefWidth(31);
        two.setPadding(new Insets(3));

        Button three = new Button("3");
        three.setAlignment(Pos.CENTER);
        three.setPrefHeight(27);
        three.setPrefWidth(31);
        three.setPadding(new Insets(3));

        Button multiply = new Button("*");
        multiply.setAlignment(Pos.CENTER);
        multiply.setPrefHeight(27);
        multiply.setPrefWidth(29);
        multiply.setPadding(new Insets(3));

        row3.getChildren().addAll(one, two, three, multiply);
        vBox.getChildren().add(row3);

        // Row Four
        HBox row4 = new HBox();
        row4.setSpacing(11);
        row4.setPadding(new Insets(6, 0, 10, 0));

        Button zero = new Button("0");
        zero.setAlignment(Pos.CENTER);
        zero.setPrefHeight(27);
        zero.setPrefWidth(30);
        zero.setPadding(new Insets(3));

        Button enter = new Button("Enter");
        enter.setAlignment(Pos.CENTER);
        enter.setPrefHeight(27);
        enter.setPrefWidth(73);
        enter.setPadding(new Insets(3));

        Button divide = new Button("/");
        divide.setAlignment(Pos.CENTER);
        divide.setPrefHeight(27);
        divide.setPrefWidth(29);
        divide.setPadding(new Insets(3));

        row4.getChildren().addAll(zero, enter, divide);
        vBox.getChildren().add(row4);

        // Row Five
        HBox row5 = new HBox();
        row5.setMaxWidth(154);
        row5.setPadding(new Insets (0, 10, 0, 0));
        row5.setAlignment(Pos.CENTER_RIGHT);
        row5.setBorder(new Border(new BorderStroke(Color.GRAY,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2, 2, 2, 2))));

        Label output = new Label("73");


        row5.getChildren().addAll(output);
        vBox.getChildren().add(row5);


        return new Scene(vBox, 300, 250);
    }
}

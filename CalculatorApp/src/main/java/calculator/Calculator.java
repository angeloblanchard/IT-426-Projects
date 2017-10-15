package calculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import ui.CalculatorUI;

public class Calculator
{
    private int operandOne;
    private int operandTwo;
    private String operator;
    private EventHandler<KeyEvent> buttonHandler = new EventHandler<KeyEvent>()
    {
        @Override
        public void handle(KeyEvent event)
        {
        String keyPressed = event.getText();
            System.out.println(keyPressed);
        }
    };


    public int calculate()
    {
        int answer = 0;

        switch (operator) {
            case "+" : answer = operandOne + operandTwo;
            break;
            case "-" : answer = operandOne - operandTwo;
            break;
            case "*" : answer = operandOne - operandTwo;
            break;
            case "/" : if (operandTwo == 0)
            {
                answer = 0;
                break;
            }
            else
            {
                answer = operandOne / operandTwo;
                break;
            }
        }

        operandOne = answer;
        return answer;
    }

    public static void activeKeys(Button[] buttons, Label output)
    {
        for (int i = 0; i < buttons.length; i++)
        {
            final Button button = buttons[i];
            button.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event)
                {
//                    button.setText("You clicked me!");
                    String currentText = output.getText();
                    output.setText(currentText + button.getText());
                }
            });
        }
    }



    public void refactorToNum()
    {
        String keyPress;
    }

}

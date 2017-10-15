package calculator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

public class Calculator
{
    private static String operandOneString;
    private static String operandTwoString;
    private static String operator;
//    private EventHandler<KeyEvent> buttonHandler = new EventHandler<KeyEvent>()
//    {
//        @Override
//        public void handle(KeyEvent event)
//        {
//        String keyPressed = event.getText();
//            System.out.println(keyPressed);
//        }
//    };


    private static int calculate()
    {
        int answer = 0;
        int operand1 = refactorToNum(operandOneString);
        int operand2 = refactorToNum(operandTwoString);

        switch (operator) {
            case "+" : answer = operand1 + operand2;
            break;
            case "-" : answer = operand1 - operand2;
            break;
            case "*" : answer = operand1 - operand2;
            break;
            case "/" : if (operand2 == 0)
            {
                answer = 0;
                break;
            }
            else
            {
                answer = operand1 / operand2;
                break;
            }
        }
        return answer;
    }

    public static void activeKeys(Button[] buttons, Label output)
    {
        for (Button button : buttons)
        {
            String key = button.getText();
            button.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    if (output.getText() == "0")
                    {
                        output.setText("");
                    }
                    boolean flagEnter = false;
                    boolean flagOperator = false;
                    switch (key) {
                        case "0" : case "1" : case "2" : case "3" : case "4" : case "5" :
                        case "6" : case "7" : case "8" : case "9" :
                            operandOneString += key;
                        break;

                        case "+" : case "-" : case "*" : case "/" :
                            operator = key;
                            flagOperator = true;
                            break;

                        case "Enter" : flagEnter = true;
                        break;
                    }
                    if (flagEnter)
                    {
                        int answer = calculate();
                        output.setText("error2");
                        output.setText(String.valueOf(answer));
                    }
                    else if (flagOperator)
                    {
                        output.setText("");
                    }
                    else
                    {
                        output.setText(output.getText() + key);
                    }
                }
            });
        }
    }



    private static int refactorToNum(String number)
    {
        return Integer.parseInt(number);
    }

}

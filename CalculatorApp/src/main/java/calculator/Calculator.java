package calculator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

public class Calculator
{
    private static String operandOneString = "";
    private static String operandTwoString = "";
    private static String operator = "";
    private static boolean flagEnter;
    private static boolean flagOperator;
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
        int operand1 = Integer.parseInt(operandOneString);
        int operand2 = Integer.parseInt(operandTwoString);

        switch (operator) {
            case "+" : answer = operand1 + operand2;
            break;
            case "-" : answer = operand1 - operand2;
            break;
            case "*" : answer = operand1 * operand2;
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
                    switch (key)
                    {
                        case "0" : case "1" : case "2" : case "3" : case "4" : case "5" :
                        case "6" : case "7" : case "8" : case "9" :
                            if (flagOperator)
                            {
                                if (operandTwoString.isEmpty())
                                {
                                    operandTwoString = key;
                                }
                                else
                                {
                                    operandTwoString += key;
                                }
                            }
                            else
                            {
                                if (operandOneString.isEmpty())
                                {
                                    operandOneString = key;
                                }
                                else
                                {
                                    operandOneString += key;
                                }
                            }
                            flagEnter = false;
                        break;

                        case "+" : case "-" : case "*" : case "/" :
                            operator = key;
                            flagOperator = true;
                            flagEnter = false;
                            break;
                        case "Enter" :
                            if (operandTwoString.isEmpty())
                            {
                                flagEnter = false;
                                break;
                            }
                            else
                            {
                                flagEnter = true;
                            }
                        break;

                        default :
                            flagEnter = false;
                            flagOperator = false;
                    }

                    if (flagEnter)
                    {
                        int answer = calculate();
                        output.setText(String.valueOf(answer));
                        operandTwoString = "";
                        operandOneString = String.valueOf(answer);
                    }
                    else if (flagOperator && operandTwoString.isEmpty())
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
}

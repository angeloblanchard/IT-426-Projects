package calculator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

/**
 * @Author Angelo Blanchard
 * @Date October 13 2017
 * @Version 1.0
 */
public class Calculator
{
    private static String operandOneString = "";
    private static String operandTwoString = "";
    private static String operator = "";
    private static boolean flagEnter;
    private static boolean flagOperator;
    private static String keyPress;


    /**
     * This method calculates the total using both operands and the operator and returns it.
     * @return The answer total to be displayed on the label.
     */
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

    /**
     * This method handles all the inputs selected by the Calculator UI. When operands,
     * operators, or enter is pressed, calculates and displays the current operand or answer.
     * @param buttons Array of all buttons on Calculator UI
     * @param output Output label that displays operators and answer
     */
    public static void activeKeys(Button[] buttons, Label output)
    {
        for (Button button : buttons)
        {
            String key = button.getText();

            // When keys are pressed
            button.setOnKeyPressed(new EventHandler<KeyEvent>()
            {
                @Override
                public void handle(KeyEvent event)
                {
                    switch (event.getCode())
                    {
                        case ENTER:
                            keyPress = "Enter";
                            break;
                        case ADD:
                            keyPress = "+";
                            break;
                        case SUBTRACT:
                            keyPress = "-";
                            break;
                        case DIVIDE:
                            keyPress = "/";
                            break;
                        case MULTIPLY:
                            keyPress = "*";
                            break;
                        case NUMPAD0:
                            keyPress = "0";
                            break;
                        case NUMPAD9:
                            keyPress = "9";
                            break;
                        case NUMPAD8:
                            keyPress = "8";
                            break;
                        case NUMPAD7:
                            keyPress = "7";
                            break;
                        case NUMPAD6:
                            keyPress = "6";
                            break;
                        case NUMPAD5:
                            keyPress = "5";
                            break;
                        case NUMPAD4:
                            keyPress = "4";
                            break;
                        case NUMPAD3:
                            keyPress = "3";
                            break;
                        case NUMPAD2:
                            keyPress = "2";
                            break;
                        case NUMPAD1:
                            keyPress = "1";
                            break;
                    }
                }
            });

            //String key = keyPress;
            // When clicking the UI buttons
            button.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    if (output.getText().equals("0"))
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
                                output.setText("0");
                                operandOneString = "";
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
                        if (operandTwoString.isEmpty())
                        {
                            return;
                        }
                        else
                        {
                            int answer = calculate();
                            output.setText(String.valueOf(answer));
                            operandTwoString = "";
                            operandOneString = String.valueOf(answer);
                        }
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

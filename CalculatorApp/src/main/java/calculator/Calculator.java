package calculator;

import javafx.application.Application;
import javafx.stage.Stage;
import ui.CalculatorUI;

public class Calculator
{
    private int operandOne;
    private int operandTwo;
    private String operator;


    public static void main(String[] args)
    {
        
    }

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

    public void refactorToNum()
    {

    }

}

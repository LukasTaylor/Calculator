/**
 * @author Lukas Taylor
 * Lab 3
 * 10/30/18
 * This lab does basic arithmetic using addition, subtraction, division, multiplication, and exponentiation
 */
package Calculator;

import java.net.URL;
import java.util.EmptyStackException;
import java.util.ResourceBundle;
import java.util.Stack;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


public class FXMLDocumentController implements Initializable 
{
    //declare all buttons
    @FXML
    private Button btnZero;
    @FXML
    private Button btnOne;
    @FXML
    private Button btnTwo;
    @FXML
    private Button btnThree;
    @FXML
    private Button btnFour;
    @FXML
    private Button btnFive;
    @FXML
    private Button btnSix;
    @FXML
    private Button btnSeven;
    @FXML
    private Button btnEight;
    @FXML
    private Button btnNine;
    @FXML
    private Button btnPlus;
    @FXML
    private Button btnSubtract;
    @FXML
    private Button btnDivide;
    @FXML
    private Button btnMultiply;
    @FXML
    private Button btnExponentiate;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnAddSpace;
    @FXML
    private Button btnLeftParentheses;
    @FXML
    private Button btnRightParentheses;
    @FXML
    private Button btnEqual;
    
    //declare labels 
    @FXML
    private Label lblException;
    @FXML
    private Label lblArithmeticSolution; 
    @FXML
    private Label lblWelcome;
    
    //declare text field to be used to gather user input
    @FXML
    private TextArea txtField;
    
    //declare string for user input from GUI
    private String input = "";
    //used to convert user input to a char array
    private char[] charArray = null;
    //used to hold the solution after expression has been evaluated
    private double arithmeticSolution = 0.0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    
    //button functions set string to respective number
    @FXML
    private void handleButtonZero(ActionEvent event)
    {
        input += "0";
        txtField.setText(input);
    }

    @FXML
    private void handleButtonOne(ActionEvent event) 
    {
        input += "1";
        txtField.setText(input);
    }

    @FXML
    private void handleButtonTwo(ActionEvent event) 
    {
        input += "2";
        txtField.setText(input);
    }

    @FXML
    private void handleButtonThree(ActionEvent event) 
    {
        input += "3";
        txtField.setText(input);
    }

    @FXML
    private void handleButtonFour(ActionEvent event) 
    {
        input += "4";
        txtField.setText(input);
    }

    @FXML
    private void handleButtonFive(ActionEvent event) 
    {
        input += "5";
        txtField.setText(input);
       
    }

    @FXML
    private void handleButtonSix(ActionEvent event) 
    {
        input += "6";
        txtField.setText(input);
    }

    @FXML
    private void handleButtonSeven(ActionEvent event)
    {
        input += "7";
        txtField.setText(input);
    }

    @FXML
    private void handleButtonEight(ActionEvent event) 
    {
        input += "8";
        txtField.setText(input);
    }

    @FXML
    private void handleButtonNine(ActionEvent event)
    {
        input += "9";
        txtField.setText(input);
    }

    @FXML
    private void handleButtonPlus(ActionEvent event)
    {
        input += "+";
        txtField.setText(input);
    }

    @FXML
    private void handleButtonSubtract(ActionEvent event)
    {
        input += "-";
        txtField.setText(input);
    }

    @FXML
    private void handleButtonDivide(ActionEvent event)
    {
        input += "/";
        txtField.setText(input);
    }

    @FXML
    private void handleButtonMultiply(ActionEvent event) 
    {
       input += "*";
        txtField.setText(input);
    }

    @FXML
    private void handleButtonExponentiate(ActionEvent event) 
    {
        input += "^";
        txtField.setText(input);
    }
    
    @FXML
    private void handleButtonLeftParentheses(ActionEvent event) 
    {
        input += "(";
        txtField.setText(input);
    }

    @FXML
    private void handleButtonRightParentheses(ActionEvent event)
    {
        input += ")";
        txtField.setText(input);
    }
    @FXML
    private void handleButtonSpace(ActionEvent event)
    {
       input += " ";
       txtField.setText(input);
    }
    //clears text field, labels, and outputs clear to console
    @FXML
    private void handleButtonClear(ActionEvent event) 
    {
        txtField.clear();
        input = "";
        this.lblArithmeticSolution.setText("");
        this.lblException.setText("");
        System.out.println("CLEARED\n\n");
        this.arithmeticSolution = 0.0;
    }
    //calls evaluate to evaluate expression
    @FXML
    private void handleButtonEqual(ActionEvent event) 
    {   
        String solution = "";
        try
        {
            //calls evaluate function which does the work of evaluating the expression
            solution = Double.toString(evaluate(input));
            System.out.println(evaluate(input));
            //display solution to label in GUI
            this.lblArithmeticSolution.setText(solution);
        }
        catch(EmptyStackException e)
        {
            this.lblException.setText("\tERROR: Clear Expression");
            //txtField.clear();
        }  
    }
    private double evaluate(String expression) 
    { 
        //converts string to char array
        char[] charArray = expression.toCharArray(); 
  
        // Stack for numbers 
        Stack<Double> numberStack = new Stack<>(); 
  
        // Stack for operators
        Stack<Character> operatorStack = new Stack<>(); 
  
        for (int i = 0; i < charArray.length; i++) 
        { 
             //current index is a whitespace, skip it 
            if (charArray[i] == ' ')
            {
                continue; 
            }
            //current index is a number, push it to stack of numbers
            if (charArray[i] >= '0' && charArray[i] <= '9') 
            { 
                StringBuffer strBuff = new StringBuffer(); 
                //check if there is more than one digit in the number 
                while (i < charArray.length && charArray[i] >= '0' && charArray[i] <= '9')
                {
                    //append number to the StringBuffer
                    strBuff.append(charArray[i++]);
                }
                try
                {
                    //convert number in StringBuffer(String to int conversion) and push to numberStack
                    numberStack.push(Double.parseDouble(strBuff.toString()));
                }
                catch (NumberFormatException e)
                {
                    this.lblException.setText("\tERROR: Clear Expression");
                    System.out.println("Error");
                }
                 
            }
            //current index is an opening parentheses, push it to operatorStack 
            else if (charArray[i] == '(')
            {
                operatorStack.push(charArray[i]); 
            }
            //closing parenteses found, solve what's within the brace
            else if (charArray[i] == ')') 
            {
                //top of the operatorStack isn't equal to opening brace
                while (operatorStack.peek() != '(')
                {
                  //calls operator method passing the operator and operands from the top of their respective stacks
                  //does the arithmetic and pushes that values onto the stack
                  numberStack.push(applyOperator(operatorStack.pop(), numberStack.pop(), numberStack.pop())); 
                }
                //pops the ')' off the stack
                operatorStack.pop(); 
            } 
            // Current index of charArray is an operator. 
            else if (charArray[i] == '+' || charArray[i] == '-' || 
                     charArray[i] == '*' || charArray[i] == '/' || 
                     charArray[i] == '^') 
            { 
                // While the operator at the top of the operatorStack has the same or greater precedence to current 
                // index of charArray(is an operator). Apply operator on top of the operatorStack 
                // to top two elements in the numberStack
                while (!operatorStack.empty() && hasPrecedence(charArray[i], operatorStack.peek()))
                {
                    numberStack.push(applyOperator(operatorStack.pop(), numberStack.pop(), numberStack.pop())); 
                }
                // Push current token to operatorStack 
                operatorStack.push(charArray[i]); 
            } 
        }
        try
        {
            //while stack isn't empty
            while (!operatorStack.empty())
            {
                //pop operators and number off their respective stack
                //call operator function that applies operator precedence and push the number to the number stack
                numberStack.push(applyOperator(operatorStack.pop(), numberStack.pop(), numberStack.pop())); 
            }
        }
        catch(EmptyStackException e)
        {
            this.lblException.setText("");
            this.input = "";
            return 0;
        }
        // Top of the numbersStack contains result, return it 
        return numberStack.pop(); 
    } 
    /**
     * Returns true if op2 has higher or same precedence as op1, 
     * otherwise returns false. 
     * @param op1
     * @param op2
     * @return 
     */
    private boolean hasPrecedence(char op1, char op2) 
    { 
        if (op2 == '(' || op2 == ')')
        {
            return false; 
        }
        if ((op1 == '*' || op1 == '/' || op1 == '^') && (op2 == '+' || op2 == '-' || op2 == '^')) 
        {
            return false;
        }
        else
        {
            return true; 
        }
    } 
    /**
     * function to apply an operator op on operands a and b
     * Return the result.
     * @param operator
     * @param b
     * @param a
     * @return 
     */
    private double applyOperator(char operator, double b, double a) 
    { 
        switch (operator) 
        { 
        case '+': 
            return a + b; 
        case '-': 
            return a - b; 
        case '*': 
            return a * b; 
        case '/':
            //try-catch block to catch exception if divide by zero occurs
            try
            {
                if (b == 0);
            }
            catch(UnsupportedOperationException e)
            {
                this.lblException.setText("\tERROR: Clear Expression");         
            }
            return a / b;
        case '^':
            double result = Math.pow(a, b);
            return result;
        } 
        return 0; 
    } 
}

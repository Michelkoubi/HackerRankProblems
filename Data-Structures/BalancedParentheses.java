import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*Given a sequence consisting of parentheses, determine whether the expression is balanced.
A sequence of parentheses is balanced if every open parentheses can be paired uniquely with
a closed parentheses that occurs after the former. Also, the interval between them must be balanced.
You will be given three types of parentheses: (, {, and [.
{[()]} - This is a balanced parentheses.
{[(])} - This is not a balanced parentheses.*/

public class BalancedParentheses {

    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        //Iterate through tests
        for(int i=0;i<t;i++)
        {
             Stack stack = new Stack();
             boolean balanced=false;
             String sequence =in.next();
             String stackChar="";
            
             for(int j=0;j<sequence.length();j++)
             {
                if(openParentheses(sequence.substring(j,j+1))){
                    stack.push(sequence.substring(j,j+1));
                    
                    //Cannot finish in an open parentheses
                    if(j==sequence.length()-1)
                    {
                        balanced=false;
                        break;
                    }
                    
                }else{
                    
                    String sequenceChar = sequence.substring(j,j+1);                
                    if(!stack.empty())
                        stackChar = stack.pop().toString();
                    else{
                        balanced=false;
                        break;
                    }

                    if(isContrary(stackChar,sequenceChar)){
                      balanced=true;
                    }
                    else{
                      balanced=false;
                      break;
                    }
                }    
             }  
            if(balanced)
                System.out.println("YES");
            else
                System.out.println("NO");     
        }       
    }
    
    private static boolean isContrary(String p1,String p2)
    {
        if(p1.equals("(") && p2.equals(")"))
            return true;
        else if(p1.equals("[") && p2.equals("]"))
            return true;
        else if(p1.equals("{") && p2.equals("}"))
            return true;
        else
            return false;
    }
    
    private static boolean openParentheses(String p1)
    {
        if(p1.equals("(") || p1.equals("[") || p1.equals("{"))
            return true;
        else
            return false;
    }
}

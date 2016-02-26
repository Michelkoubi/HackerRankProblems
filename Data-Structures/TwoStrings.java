import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
* You are given two strings, AA and BB. Find if there is a substring that appears in both AA and BB.
*/
public class TwoStrings{

    public static void main(String[] args) {
        
        boolean exists=false;
        char[] abc= "abcdefghijklmnopqrstuvwxyz".toCharArray();
        
        Scanner in= new Scanner(System.in);
        int numCases= in.nextInt();
        
        //Iterate through all the test cases
        for(int i=0; i< numCases; i++){
            
            String string1= in.next();
            String string2 = in.next();
            
            for(int j=0; j< abc.length; j++){
                String check=String.valueOf(abc[j]);
                if(string1.indexOf(check)>-1 && string2.indexOf(check)>-1){
                    exists=true;
                    break;
                }
            }
            
            if(exists)
                System.out.println("YES");
            else
                System.out.println("NO");
            
            exists=false;
            }
        }
    }

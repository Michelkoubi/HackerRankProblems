import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
/**
* Flipping pancakes problem GoogleCodeJam Qualification Round 2016
* The Infinite House of Pancakes has just introduced a new kind of pancake! It has a happy face made of chocolate chips on one side (the "happy side"), and nothing on the other side (the "blank side").
* You are the head waiter on duty, and the kitchen has just given you a stack of pancakes to serve to a customer. Like any good pancake server, you have X-ray pancake vision, and you can see whether each pancake in the stack has the happy side up or the blank side up. You think the customer will be happiest if every pancake is happy side up when you serve them.
* You know the following maneuver: carefully lift up some number of pancakes (possibly all of them) from the top of the stack, flip that entire group over, and then put the group back down on top of any pancakes that you did not lift up. When flipping a group of pancakes, you flip the entire group in one motion; you do not individually flip each pancake. Formally: if we number the pancakes 1, 2, ..., N from top to bottom, you choose the top i pancakes to flip. Then, after the flip, the stack is i, i-1, ..., 2, 1, i+1, i+2, ..., N. Pancakes 1, 2, ..., i now have the opposite side up, whereas pancakes i+1, i+2, ..., N have the same side up that they had up before.
* For example, let's denote the happy side as + and the blank side as -. Suppose that the stack, starting from the top, is --+-. One valid way to execute the maneuver would be to pick up the top three, flip the entire group, and put them back down on the remaining fourth pancake (which would stay where it is and remain unchanged). The new state of the stack would then be -++-. The other valid ways would be to pick up and flip the top one, the top two, or all four. It would not be valid to choose and flip the middle two or the bottom one, for example; you can only take some number off the top.
* You will not serve the customer until every pancake is happy side up, but you don't want the pancakes to get cold, so you have to act fast! What is the smallest number of times you will need to execute the maneuver to get all the pancakes happy side up, if you make optimal choices?
*/
public class Problema2 {

	static char[] stack;
	static int countFlip=0;
	
	public static void main(String[] args){	
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases=sc.nextInt();

		for(int i=0;i<=testCases;i++){
			int caso=i+1;
			String pancakeStack=sc.next();
			stack=pancakeStack.toCharArray();
			int position=0;
			
			int j=stack.length-1;
			while(j>=0){
				int count=0;
				//encuentro el ultimo que es -
				if(stack[j]=='-')
				{
					position=j;
					if(stack[0]=='-'){
						flip(j);
						j--;
					}
					else{
						while(stack[count]=='+')
							count++;
						
						flip(count-1);
					}
				}else{
					j--;
				}
			}
			printResult(caso,countFlip);
			countFlip=0;
		}
	}
	
	public static void flip(int high){
		countFlip++;
		char temp;
		
	    int mid =high/2;
		
		for(int i=0;i<=mid;i++){
			temp=stack[i];
			stack[i]=stack[high-i];
			stack[high-i]=temp;
		}	
	
		for(int i=0;i<high+1;i++)
			stack[i]=change(stack[i]);
	}
	
	public static char change(char pancake){
		if(pancake=='-')
			return '+';
		else
			return '-';
	}
	
	public static void printResult(int caseNum, int s){
		System.out.println("Case #"+caseNum+": "+s);
	}
}

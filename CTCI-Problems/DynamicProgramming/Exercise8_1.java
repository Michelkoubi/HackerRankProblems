package CTCInterview;

//EXERCISE 8.1	
/**
 * A child is running up a staircase with n steps and can hop either 1,2 or 3 steps at a time.
 * Implement a method to count how many possible ways the child can run up the stairs
 */
public class DynamicProgrammingExercises {

	static int finalCount=0;
	public static int countWays(int n){
		finalCount=0;
		countWays(n,0);
		return finalCount;
	}
	
	//LIKE A BOTTOM-UP
	private static void countWays(int n, int count){
		if(count==n){
			finalCount++;
			return;
		}
		if (count>n)
			return;
		
		countWays(n,count+1);
		countWays(n,count+2);
		countWays(n,count+3);
	}
	
	//TOP-BOTTOM
	public static int countWays2(int n){
		
		if(n==0)
			return 1;
		if(n<0)
			return 0;
		
		return countWays2(n-1)+countWays2(n-2)+countWays2(n-3);
	}
	
	public static int countWays3(int n){
		int[] memo = new int[n+1];// because in the first iteration you check for memo of n
		
		//Init the array to -1
		for(int i=0;i<memo.length;i++){
			memo[i]=-1;
		}
		
		return countWays3(n,memo);
	}
	
	//DYNAMIC PROGRAMMING, MEMOIZATION, TOP BOTTOM
	private static int countWays3(int n, int[] memo){
		if(n==0)
			return 1;
		if(n<0)
			return 0;
		
		if(memo[n]==-1){
			memo[n] = countWays2(n-1)+countWays2(n-2)+countWays2(n-3);
			return memo[n];
		}else
			return memo[n];	
	} 
	
	//Testing purposes
	public static void main(String[] args){
	  int numSteps= 7;
		System.out.println(countWays(numSteps));
		System.out.println(countWays2(numSteps));
		System.out.println(countWays3(numSteps));
	}
}

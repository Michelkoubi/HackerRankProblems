package GoogleCodeJam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
* Counting sheep problem of GoogleCodeJam 2016 Qualification Round
*/
public class GoogleCodeJam1 {
	
	static boolean[] numbersSeen;
	static boolean finish=false;
	
	public static void main(String[] args){	
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases=sc.nextInt();
		
		for(int i=0;i<=testCases;i++){
			int caso=i+1;
			int N=sc.nextInt();
			int next=N;
			numbersSeen= new boolean[10];
			
			if(N==0){
				printResult("INSOMNIA",caso);
			}else{
				
				int counter=2;
				while(!finish){
					String result=getNumbers(next);
					switch(result){
					
						case "":
							next=N*counter;
						break;
						
						//it returns a number
						default:
							printResult(result,caso);
						break;
					}
					counter++;
				}
			}
			finish=false;
		}
	}
	
	public static String getNumbers(int N){
		String calcLength=String.valueOf(N);
		String result="";
		int counter=calcLength.length();
		
		//to obtain the different numbers from N
		while(counter>0){
			int number=N%10;
			
			numbersSeen[number]=true;
			
			N=N/10;
			counter--;
		}
		
		//To see if I have already found all the numbers
		for(int i=0;i<numbersSeen.length;i++){
			if(numbersSeen[i]==false)
				break;
			else if(i==numbersSeen.length-1){
				finish=true;
				result=calcLength;
			}
		}
			
		return result;
	}
	
	public static void printResult(String s, int caseNum){
		System.out.println("Case #"+caseNum+": "+s);
	}
	
}

package GoogleCodeJam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
* Counting sheep problem of GoogleCodeJam 2016 Qualification Round
* Bleatrix Trotter the sheep has devised a strategy that helps her fall asleep faster. First, she picks a number N. Then she starts naming N, 2 × N, 3 × N, and so on. Whenever she names a number, she thinks about all of the digits in that number. She keeps track of which digits (0, 1, 2, 3, 4, 5, 6, 7, 8, and 9) she has seen at least once so far as part of any number she has named. Once she has seen each of the ten digits at least once, she will fall asleep.
* Bleatrix must start with N and must always name (i + 1) × N directly after i × N. For example, suppose that Bleatrix picks N = 1692. She would count as follows:
* N = 1692. Now she has seen the digits 1, 2, 6, and 9.
* 2N = 3384. Now she has seen the digits 1, 2, 3, 4, 6, 8, and 9.
* 3N = 5076. Now she has seen all ten digits, and falls asleep.
* What is the last number that she will name before falling asleep? If she will count forever, print INSOMNIA instead.
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

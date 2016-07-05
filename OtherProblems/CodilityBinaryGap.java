/*
A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap of length 2.
The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3.
The number 20 has binary representation 10100 and contains one binary gap of length 1.
The number 15 has binary representation 1111 and has no binary gaps.

Write a function:
class Solution { public int solution(int N); }
that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.

Complexity:

expected worst-case time complexity is O(log(N));
expected worst-case space complexity is O(1).
*/

class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        int pow = 0;
        int max = 0;
        int before = 0;
        boolean first = true;
        
        while(N>0){
            pow = getPow(N);
            //System.out.println(pow);
            if(first){
                first=false;
            }else{
                if((before - pow) > max){
                    max = before - pow;
                    max -=1;
                }
            }
            before = pow;
            N -= Math.pow(2,pow);
        }
        return max;
    }
    
    public int getPow(int N){
        int before=0;
        int i = 0;
        while(N>0){
            if(N-Math.pow(2,i)>=0){
                before = i;
            }else{
               break;
            }
            i++;
        }
        return before; 
    }
}

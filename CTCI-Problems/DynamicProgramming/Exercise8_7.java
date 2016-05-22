/*
* Write a method to compute all the permutations of a string with unique characters. 
*/
//EXERCISE 8.7
	
	public static void printPermutation(String s){
		ArrayList<String> result = new ArrayList<String>();
		result=createPermutation(s,s.length()-1);
		for(int i=0; i<result.size();i++){
			System.out.println(result.get(i));
		}
		
	}
	
	private static ArrayList<String> createPermutation(String s, int pos){
		
		ArrayList<String> array = new ArrayList<String>();
		
		if(pos<0)
			return null;
		
		char letter = s.charAt(pos);
		
		array= createPermutation(s.substring(0,pos),pos-1);
		
		ArrayList<String> newArray = new ArrayList<String>();
		
		if(array != null){
			for(int i=0; i<array.size();i++){
				String letters = array.get(i);
				for(int j=0; j<=letters.length(); j++){
					String permutation = letters.substring(0, j)+letter+letters.substring(j,letters.length());
					newArray.add(permutation);
				}
						
			}
			
		}else{
			newArray.add(s);
		}
		
		return newArray;	
	}
	
	//testing purposes
	public static void main(String[] args){

		printPermutation("abcd");
		
	}
}

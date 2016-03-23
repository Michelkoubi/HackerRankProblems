/**
* Implementation of a function that checks if a LinkedList is a palindrome
*/
public class PalindromeLinkedList
{
	private static class Node<String>{
		String value;
		Node next=null;
		
		public Node(){}
		
		public Node(String value){
			this.value=value;
		}
		
		void appendToTail(String d){
			Node end = new Node(d);
			Node n = this;
			while(n.next !=null){
				n=n.next;
			}
			n.next=end;
		}
	}
	
	/**
	 * Function that checks if a LinkedList is palindrome
	 * @param node
	 * @return
	 */
	public boolean IsPalindrome(Node node){
		Node p1=new Node();
		Node p2=new Node();
		StackLinkedList<String> firstHalf=new StackLinkedList<String>();

		int count=0;

		//Assign pointers to the root node
		p1=node;
		p2=node;
		
		//I use two pointers so that when one of the is at the end, the other is at the middle
		while(p1.next!=null){
			if(p1.next.next==null)
				p1=p1.next;
			else
				p1=p1.next.next;
			
			//Store first half in stack
			firstHalf.push((String)p2.value);
			p2=p2.next;
			count++;

		}
		
		//If the count was even I am at the half element and the length of the linkedList is odd
		//So I have to skip one element
		if(count%2==0){
			p2=p2.next;
		}

		while(p2!=null){
			
			String s1=(String)p2.value;
			String s2=firstHalf.pop();
			
			if(!(s1.equals(s2)))
				return false;
			p2=p2.next;
		}
		
		return true;
	}
	  //For testing purposes
    public static void main(String[] args) {
    	Node n = new Node("a");
    	n.appendToTail("b");
    	n.appendToTail("c");
    	n.appendToTail("b");
    	n.appendToTail("a");
    	
    	PalindromeLinkedList pll= new PalindromeLinkedList();
    	System.out.println(pll.IsPalindrome(n));
    }
}

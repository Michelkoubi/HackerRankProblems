import java.util.Random;

public class QuickSort 
{

	int OPTIMUM_ELEMENTS=10;
	public void sort(Comparable[] array)
	{
	  //For less elements use Insertion Sort
		if(array.length<OPTIMUM_ELEMENTS){
			InsertionSort insertionSort = new InsertionSort();
			insertionSort.sort(array);
			return;
		}
		
		knuthShuffle(array);//So that I get a random element when picking pivot
		sort(array,0,array.length-1);
	}
	
	private void sort(Comparable[] array, int low, int high)
	{
		if(low>=high)
			return;
		
		int pivot=partition(array,low,high);
		sort(array,low,pivot-1);
		sort(array,pivot+1,high);
	}
	
	private int partition(Comparable[] array, int low, int high)
	{
		int i=low+1;
		int j=high;
		
		while(true)
		{
			while(i<=high){
				if(less(array[i],array[low]))
					i++;
				else
					break;
			}
			
			//j>low, because in low we have the pivot
			while(j>low){
				if(less(array[j],array[low]))
					break;
				else
					j--;
			}
			
			//if pointers cross
			if(i>=j)
				break;
			
			swap(array,i,j);
		}
		
		//put pivot in the middle
		swap(array,j,low);
		
		return j;
	}
	
	/**
	 * Used to shuffle the array
	 * @param array
	 */
	private void knuthShuffle(Comparable[] array)
	{
		long seed = System.currentTimeMillis();
		Random random = new Random(seed);
		for(int i=0; i>array.length;i--){
			int r=random.nextInt(i);//between [0,i)
			
			swap(array,r,i);
		}
	}
	
	private boolean less(Comparable v, Comparable u){
		if(v.compareTo(u)>=0)
			return false;
		else
			return true;
	}
	
	private void swap(Comparable[] array, int a, int b){
		Comparable swap= array[a];
		array[a]=array[b];
		array[b]=swap;	
	}
}

public class InsertionSortRepetido {

	public void sort(Comparable[] array){
		for(int i=1;i<array.length;i++){
			for(int j=i;j>0;j--){
				if(less(array[j],array[j-1]))
					swap(array,j,j-1);
				else
					break;
			}
		}
	}
	
	private boolean less(Comparable u, Comparable v){
		if(u.compareTo(v)<0)
			return true;
		else
			return false;
	}
	
	private void swap(Comparable[] array, int i, int j){
		Comparable k = array[i];
		array[i]=array[j];
		array[j]=k;
	}
}

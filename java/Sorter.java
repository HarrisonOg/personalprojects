/*
Harrison Oglesby

Created: 4/4/16
Last modified: 4/5/16

I made this singleton sorting java class for int arrays.

*/

public class Sorter{

	private int[] array;
    private int[] tempMergArr;
    private int length;

	private static Sorter instance = new Sorter();
	
	private Sorter(){}

	public static Sorter getInstance(){
		return instance;
	}
	
	/*
	Bubble sort in both ascending and descending patterns
	*/
	public int[] bubbleSortAscendingOrder(int inputArr[]){
		int temp;
		this.array = inputArr;
		for(int i=0; i < array.length-1; i++){
			for(int j=1;j < array.length-i;j++){
				if(array[j-1] > array[j]){
					temp=array[j-1];
					array[j-1]=array[j];
					array[j]=temp;
				}
			}
		}
		private int[] result = array;
		array = null;
		return result;
		
	}
	
	public int[] bubbleSortDescendingOrder(int inputArr[]){
		int temp;
		this.array = inputArr;
		for(int i=0; i < array.length-1; i++){
			for(int j=1;j < array.length-i;j++){
				if(array[j-1] < array[j]){
					temp=array[j-1];
					array[j-1]=array[j];
					array[j]=temp;
				}
			}
		}
		private int[] result = array;
		array = null;
		return result;
		
	}
	
	
	public int[] mergeSort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
        private int[] result = array;
        array = null;
        
        return result;
    }
 
    private void doMergeSort(int lowerIndex, int higherIndex) {
         
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            //Sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            //Sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
 
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
 
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
 
    }

}
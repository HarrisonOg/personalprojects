

public class SortTest{
	public static void main(String[] args){
		String[] array = {"cat","top","bat","hop","rot","sat","food"};
		int ctr = 0;
		String[] result = new String[20];
		
		for(int i = 0; i < array.length; i++){
			if(array[i].charAt(1)=='a'){
				result[ctr] = array[i];
				ctr++;
			}
		}		
		for(int j = 0; j < array.length; j++){
			if(array[j].charAt(1)=='o' && array[j].charAt(2)!='o'){
				result[ctr] = array[j];
				ctr++;
			}
		}
		
		for(int c = 0; c < ctr; c++){
			System.out.print(result[c] + ", ");
		}
	}
}
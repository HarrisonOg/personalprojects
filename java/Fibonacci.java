/*
Harrison Oglesby

Created: 4/5/16

Recursively calculates Fibonacci numbers
*/
public class Fibonacci{

	public static Fibonacci instance = new Fibonacci();

	private Fibonacci(){}

	public static Fibonacci getInstance(){
		return instance;
	}
	
	
	//Returns an array of the fibonacci sequence up to that point
	public int[] getFibNumArray(int n){
		int x = 0, y = 1, z = 1;
		int[] result = new int[n+1];
		result[0] = 0;
		for(int i = 0; i < n; i++){
			x = y;
			y = z;
			z = x + y;
			result[i+1] = x;
		} 
		
		return result;
	}
	
	//Calculates nth value of fibonacci sequence recursively
	public int getNthFibRecursive(int n){
		if(n==0)
			return 0;
		else if(n==1)
			return 1;
		else
			return getNthFibRecursive(n-1) + getNthFibRecursive(n-2);
	}
	
	
	//Calculates nth value of fibonacci sequence iteratively
	public int getNthFibIterative(int n){
		int x = 0, y = 1, z = 1;
		for(int i = 0; i < n; i++){
			x = y;
			y = z;
			z = x + y;
		}
		return x;
	}
	
}
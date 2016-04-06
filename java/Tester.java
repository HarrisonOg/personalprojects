

public class Tester{


	public static void main(String[] args){
		Fibonacci fib = Fibonacci.getInstance();
		
		System.out.println("Fib sequence 5 rec: " + fib.getNthFibRecursive(5));
		System.out.println("Fib sequence 5 iteratively: " + fib.getNthFibIterative(5));
		System.out.println("Fib sequence 5 array:");
		int[] result = fib.getFibNumArray(5);
		for(int i = 0; i < result.length; i++){
			System.out.print(" "+ result[i]+ " ");
		}	
		System.out.println();
		
		
	}

}
import java.util.Scanner;


public class Tester{

	private static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args){
		System.out.println("******************************************************");
		System.out.println("               Welcome to the Calculator");
		System.out.println("******************************************************");
		System.out.println();
		
		//boolean running = true;
		//while(running){
			System.out.println("Choices: ");
			System.out.println("             1: Calculate Fibonacci");
			System.out.println();
			System.out.println("Select your choice: ");
		
			int choice = 0;
			try{
				choice = Integer.parseInt(keyboard.nextLine());
			} catch(NumberFormatException e){
				e.printStackTrace();
			}
			switch (choice) {
				case 1: testFib();
						break;
				default: System.out.println(Integer.toString(choice) + " is not a valid choice ");
						break;
		
			}
			// System.out.println();
// 			System.out.println("Would you like to do another calculation? (y/n)");
// 			String dump = keyboard.nextLine();
// 			String input = keyboard.nextLine();
// 			String ask = input.trim();
// 			if(ask=="y"||ask=="Y"){
// 				//yes
// 			}
// 			else if(ask=="n"||ask=="N"){
// 				//no
// 				running = false;
// 			}
		//}
		
		System.out.println();
		System.out.println("               Thank you!");
		System.out.println("******************************************************");

		
	}
	
	
	
	public static void testFib(){
		System.out.println("Enter number n to figure out the nth Fibonacci number: ");
		int input = keyboard.nextInt();
		
		Fibonacci fib = Fibonacci.getInstance();
		
		System.out.println();
		System.out.println("Fib sequence "+ input + " recursively: " + fib.getNthFibRecursive(input));
		System.out.println("Fib sequence "+ input + " iteratively: " + fib.getNthFibIterative(input));
		System.out.println("Fib sequence "+ input + " array:");
		int[] result = fib.getFibNumArray(input);
		for(int i = 0; i < result.length; i++){
			System.out.print(" "+ result[i]+ " ");
		}	
		System.out.println();
	}

}
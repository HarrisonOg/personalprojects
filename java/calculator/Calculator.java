import java.util.Scanner;


public class Calculator{

	private static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args){
		System.out.println("******************************************************");
		System.out.println("               Welcome to the Calculator");
		System.out.println("******************************************************");
		System.out.println();
		
		boolean running = true;
		while(running){
			System.out.println();
			System.out.println();
			System.out.println("******************************************************");
			System.out.println("Choices: ");
			System.out.println();
			System.out.println("             1: Calculate Fibonacci");
			System.out.println("             2: Test Sort");
			System.out.println();
			System.out.println("Select your choice: ");
		
			int choice = 0;
			//this try-catch will make sure that the choice is an int
			try{
				choice = Integer.parseInt(keyboard.nextLine());
			} catch(NumberFormatException e){
				System.out.println("Not a valid choice");
				e.printStackTrace();
			}
			
			
			switch (choice) {
				case 1: testFib();
						break;
				case 2: testSort();
						break;
				default: System.out.println(Integer.toString(choice) + " is not a valid choice ");
						break;
		
			}
			String dump = keyboard.nextLine();
			System.out.println();
			System.out.println("Would you like to do another calculation? (y/n)");
 			String input = keyboard.nextLine();
 			System.out.println();
 			if(input.equals("y")||input.equals("Y")){
				//yes
				//System.out.println("yes");
			}
 			else if(input.equals("n")||input.equals("N")){
 				//no
 				//System.out.println("no");
 				running = false;
 			}
 			else{
 				System.out.println("Sorry, " + input + " is not a correct choice.");
 				System.out.println("Calculator starting over from choice");
 			}
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("******************************************************");
		System.out.println("               Thank you!");
		System.out.println("******************************************************");

		
	}
		
	public static void testFib(){
		System.out.println();
		System.out.println();
		System.out.println("                Fibonacci Calculator selected");
		System.out.println();
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

	public static void testSort(){
		Sorter sorter = Sorter.getInstance();
		System.out.println();
		System.out.println();
		System.out.println("                Number Sorter selected");
		System.out.println();
		System.out.println("How many integers are we sorting?: ");
		int inlength = keyboard.nextInt();
		keyboard.nextLine();
		System.out.println("We're sorting " + inlength + " numbers");
		int[] inputArr = new int[inlength];
		System.out.print("Enter the numbers separated by spaces, like so: ");
		System.out.println("1 1 2 3 5 8 13");
		System.out.print("Input: ");
		Scanner numScanner = new Scanner(keyboard.nextLine());
		for(int i = 0; i < inlength; i++){
			if(numScanner.hasNextInt()){
				inputArr[i] = numScanner.nextInt();
			} else {
				System.out.println("You did not provide enough numbers");
				return;
			}
		}
		//keyboard.nextLine();
		System.out.println();
		System.out.println("Sort which way:");
		System.out.println("                1. Bubble sort");
		System.out.println("                2. Merge sort");
		int choice = 0;
		//this try-catch will make sure that the choice is an int
		try{
			choice = Integer.parseInt(keyboard.nextLine());
		} catch(NumberFormatException e){
			System.out.println("Not a valid choice");
			e.printStackTrace();
		}
		
		switch (choice) {
			case 1: int[] resultOne = sorter.bubbleSortAscendingOrder(inputArr);
					int[] resultTwo = sorter.bubbleSortDescendingOrder(inputArr);
					System.out.print("Input array: ");
					printArray(inputArr);
					System.out.println("Sorted with Bubble Sort");
					System.out.print("Ascending: ");
					printArray(resultOne);
					System.out.println();
					System.out.print("Descending: ");
					printArray(resultTwo);
					System.out.println();					
					break;
			case 2: int[] resultArr = sorter.mergeSort(inputArr);
					System.out.print("Input array: ");
					printArray(inputArr);
					System.out.println("Sorted with Merge Sort");
					System.out.print("Merge Sort: ");
					printArray(resultArr);
					break;
			default: System.out.println(Integer.toString(choice) + " is not a valid choice ");
					break;
		
		}
		System.out.println();
	
	}
	
	
	//simple print int array method
	public static void printArray(int[] array){
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
	}

}
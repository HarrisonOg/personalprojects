import java.util.Scanner;

public class SuperAnTester{
  public static void main(String[] args){
  Scanner scan = new Scanner(System.in);
  System.out.println("Enter a phrase:");
  String line1 = scan.nextLine();
  System.out.println("Enter another phrase:");
  String line2 = scan.nextLine();
  SuperAnagram ana = new SuperAnagram(line1,line2);
  System.out.println(ana.isSuperAnagram());
  }
}
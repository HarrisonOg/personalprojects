


public class Largest {
    public static void main(String[] args) {
        System.out.println("Hello, World");    
    }
        public static int largest(int[] list){
        int index;

        int max=Integer.MIN_VALUE;


        for (index=0; index < list.length; index++){
            if(list[index] > max){
                max = list[index];
            }
        }
        return max;
    }
}
public class SuperAnagram{
 
  private String first;
  private String second;
  
  //create SuperAnagram object to call methods
  public SuperAnagram(String line1, String line2){
    first=line1;
    second=line2;
  }
 
  //method to check for Super Anagram
  public boolean isSuperAnagram(){
    int[] ctr = new int[26];
    first = first.toLowerCase();
    second = second.toLowerCase();
    boolean result = true;
    
    for (int i=0; i<second.length(); i++){
      	char temp = second.charAt(i);
      	if(temp!=' '){
      		int loc = temp - 97;
      		ctr[loc]++;
      	}
    }
    for (int j=0; j<first.length(); j++){
      	char temp = first.charAt(j);
      	if(temp!=' '){
      		int loc = temp - 97;
      		ctr[loc]--;
      	}
    }
    
    for(int a = 0; a<ctr.length;a++){
    	if(ctr[a] < 0){
    		result = false;
    	}
    }
    
    return result;
  }
}
package exception;

public class CheckIsNumeric {
	public static boolean isNumeric(String str) { 
		  try {  
		    Long check = Long.parseLong(str);
		    if(check > 0) {
		    	return true;
		    }
		    else {
		    	return false;
		    }
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	
	public static void main(String args[ ]) {
		System.out.println(isNumeric("1012345122121121"));
	}
}

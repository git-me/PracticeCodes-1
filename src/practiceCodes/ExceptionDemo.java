package myCodes.testcode;

public class ExceptionDemo {

	public static void main(String[] args) {
		String s=show();
		System.out.println(s);
	}
public static String show() {
	int a=0;
	int b=3;
	try {
		int c=0/b;
		System.out.println("try");
		return "try return";
		
		
	}
	
catch(Exception e){
	System.out.println("catch");
	return "catch" ;
}
	finally {
		System.out.println("finally");
		//System.exit(0);
		return "finally";
		
	}
}
}

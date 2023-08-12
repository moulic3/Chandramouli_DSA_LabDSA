package com.dsa.assignment;

public class MainApp {

	public static void main(String[] args) {
		
		String[] testCases = {
	            "([[{}]])",
	            "([[{}]]))"
	        };
		
		
		BalancedBrackets bb = new BalancedBrackets();
		for (String string : testCases) {
			if(bb.isBalanced(string)) {
                System.out.println("Entered String " + string + " has Balanced Brackets.");

			} else {
                System.out.println("Entered String " + string + " do not contain balanced Brackets.");

			}
		}
		
	}

}

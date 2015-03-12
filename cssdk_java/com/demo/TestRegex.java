package com.demo;

public class TestRegex {
	public static void main (String[] args){
		String tst = "abcd12345";
		if(tst.matches(".*(78978|bc).*")){
			System.out.println("Match Worked");
			
		}
		else{
			System.out.println("NOT");
			
		}
		
	}

}

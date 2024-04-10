package com.sak;

import java.util.Arrays;
import java.util.List;

class MyString {

	 private char[] chars;
	 
	 public MyString(String S) {
		 this.chars= S.toCharArray();
	 }
	 
	 public int length() {
		return chars.length;
	 }
	 
	 @Override
	  public String toString() {
	        StringBuilder sb = new StringBuilder();
	        for (char c : chars) {
	            sb.append(c);
	        }
	        return sb.toString();
	    }

	public MyString toUppercase() {
		 char[] upperChars = new char[chars.length];
		 for(int i=0;i<chars.length;i++) {
			 upperChars[i]= Character.toUpperCase(chars[i]);
		 }
		return  new MyString(new String(upperChars));
	 }
	 public MyString toLowercase() {
		 char[] lowerChars = new char[chars.length];
		 for(int i=0;i<chars.length;i++) {
			 lowerChars[i]= Character.toLowerCase(chars[i]);
		 }
		return  new MyString(new String(lowerChars));
	 }
	 
	 public char indexAt(int index) {
		 if(index<0 || index>=chars.length) {
			 throw new ArrayIndexOutOfBoundsException(index);
		 }
		 return chars[index];
	 }
	 
	 public  List<Integer> patternExist(MyString pattern, MyString text) {
		 int count=0;
		 List<Integer> indexList = null;
		 for(int i=0;i<chars.length;i++) {
			 for(int j=0;j<pattern.length();j++) {
				 if(pattern.chars[j] == text.chars[i]){
					count++;
					if(count == pattern.length()) {
						 indexList.add(i);
					}
				 }else {
					 j=0;
				 }
				 
			 }
		 }
		 
		 return indexList;
	 }
}

 class MyStringTest {
	public static void main(String[] args) {
		MyString string = new MyString("Sakshi");
		System.out.println( string.toUppercase());
		System.out.println(string.toLowercase());
		
		System.out.println(string.indexAt(3));
		
		
		
	}
	
	
	
}

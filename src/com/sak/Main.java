package com.sak;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//

//public class Main {
//	public static void main(String[] args) throws InterruptedException {
//		Calculator cal = new Calculator();
//		long Start= System.nanoTime();
//		System.out.println(cal.add(10000));
//		Thread.sleep(3000);
//		
//		long duration = (System.nanoTime()-Start)/1000000;
//		System.out.println("Duration"+duration);
//		
//		long Start1= System.nanoTime();
//		System.out.println(cal.add(100000));
//		Thread.sleep(3000);
//		
//		long duration1 = (System.nanoTime()-Start1)/1000000;
//		System.out.println("Duration"+duration1);
//		
//		long Start2= System.nanoTime();
//		System.out.println(cal.add2(10000));
//		Thread.sleep(3000);
//		
//		long duration2 = (System.nanoTime()-Start2)/1000000;
//		System.out.println("Duration for formula"+duration2);
//		
//		long Start3= System.nanoTime();
//		System.out.println(cal.add2(100000));
//		Thread.sleep(3000);
//		
//		long duration3 = (System.nanoTime()-Start3)/1000000;
//		System.out.println("Duration for formula"+duration3);
//		
//		
//	}
//}
//
//class Calculator {
//	long sum = 0;
//
//	long add(long n) {
//
//		for (long i = 0; i <= n; i++) {
//			sum = sum + i;
//		}
//		return sum;
//	}
//
//	long add2(long n) {
//		return (n * (n + 1)) / 2;
//	}
//}

class Main {
	public static void main(String[] args) throws InterruptedException {
		int array[] = new int[100000000];
		for (int i = 0; i < 100000000; i++) {
			array[i] = i;
		}

//		long Start = System.nanoTime();
//		System.out.println(binarySearch(100000000, array));
//		// Thread.sleep(3000);
//
//		long duration = (System.nanoTime() - Start) / 1000000;
//		System.out.println("Duration of search" + duration);

//		long Start1 = System.nanoTime();
//		selectionSort(array);
//		// Thread.sleep(3000);
//
//		long duration1 = (System.nanoTime() - Start1) / 1000000;
//		System.out.println("Duration of sort" + duration1);

		// System.out.println(binaryNumber(9));

		// System.out.println(binaryGap(529));

		// System.out.println(factorial(4));

		// System.out.println(fib(4));
//
//		long Start1 = System.nanoTime();
		// Thread.sleep(3000);
//		System.out.println(fibonacci(40));
//		long duration1 = (System.nanoTime() - Start1) / 1000000;
//		System.out.println("Duration of fibonacci" + duration1);
//
//		long Start = System.nanoTime();
		// Thread.sleep(3000);
//		System.out.println(fib(40));
//		long duration = (System.nanoTime() - Start) / 1000000;
//		System.out.println("Duration of fib" + duration);

//		
//		long start1 = System.nanoTime();
//	       System.out.println(factorial2(BigInteger.valueOf(8888)));
//	        long duration1 = (System.nanoTime() - start1) / 1000000;
//	        System.out.println("Duration of search: " + duration + " milliseconds");
		
	
		
		int A[]= {3,4,4,6,1,4,4};
		solution(5, A);


	}

	private static int binaryNumber(int n) {
		int binarynumber = 0, i = 1, j = 0;
		int remainder = n;
		int arrayTemp[] = null;
		while (n != 0) {
			remainder = n % 2;
			n = n / 2;
			binarynumber = binarynumber + remainder * i;
			arrayTemp[j] = remainder;
			j++;
			i = i * 10;
		}
		return binarynumber;
	}

//	private static void binaryGap(int n) {
//		int binarynumber = 0,i = 1,j=0;
//		int remainder=n;
//		int arrayT[] = null;
//		int count;
//		 while(n!=0)
//		    {
//		        remainder = n % 2;
//		        n = n / 2;
//		        binarynumber = binarynumber+remainder * i;
//		        arrayT[j]=remainder;
//		        j++;
//		        i=i*10;
//		    }
//		 
//		 for(int i=0;)
//	}

	private static int binaryGap(int n) {
		int maxDifference = 0;
		String binaryString = Integer.toBinaryString(n);
		System.out.println(binaryString);

		List<Integer> oneslist = new ArrayList<>();
		for (int i = 0; i < binaryString.length(); i++) {
			if (binaryString.charAt(i) == '1') {
				oneslist.add(i);
			}
		}
		System.out.println(oneslist);
		for (int i = 1; i < oneslist.size(); i++) {
			int difference = oneslist.get(i) - oneslist.get(i - 1);
			if (difference > maxDifference) {
				maxDifference = difference;
			}
		}
		return maxDifference;
	}

	private static int binarySearch(int target, int array1[]) {
		int low = 0;
		int high = array1.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int val = array1[mid];

			if (val < target)
				low = mid + 1;
			else if (val > target)
				high = mid - 1;
			else
				return mid;
		}
		return -1;
	}

	private static void bubbleSort(int array[]) {

		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	private static void selectionSort(int array[]) {
		for (int i = 0; i < array.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[min] > array[j]) {
					min = j;
				}
			}
			int temp = array[min];
			array[min] = array[i];
			array[i] = temp;

		}
	}

	public static long factorial(int num) {
		if (num >= 1)
			return num * factorial(num - 1);
		else
			return 1;
	}

	public static int fib(int num) {
		if (num <= 1) {
			return num;
		} else {
			return fib(num - 1) + fib(num - 2);
		}
	}

	public static int fibonacci(int num) {

		if (num <= 1) {
			return num;
		}

		int F[] = new int[50];

		F[0] = 0;
		F[1] = 1;
		int i = 2;
		for (; i <= num; i++) {

			F[i] = F[i - 1] + F[i - 2];
			System.out.print("i" + F[i]);
		}

		return F[num];
	}

	private static BigInteger factorial2(BigInteger number) {
		if (number.compareTo(BigInteger.ZERO) == 0 || number.compareTo(BigInteger.ONE) == 0) {
			return BigInteger.ONE;
		} else {
			return number.multiply(factorial2(number.subtract(BigInteger.ONE)));
		}
	}

	private static int frogJump(int A[]) {
	    int n = A.length;
	    int pos=n+1;
	    int onesCount = 0;
	    int first,curr,jump=0;
	    
	    // Counting the number of 1s in A
	    for (int i = 0; i < A.length; i++) {
	        if (A[i] == 1) {
	            onesCount++;
	        }
	    }
	    
	    // Storing indices of 1s in A
	    int ones[] = new int[onesCount];
	    ones[0]=pos;
	    int j = 1;
	    for (int i = A.length - 1; i >= 0; i--) {
	        if (A[i] == 1) {
	            ones[j] = i+1;
	            j++;
	        }
	    }
	    
	    // Printing the indices of 1s
	    for (int i = 0; i < ones.length; i++) {
	        System.out.println("ones[" + i + "] = " + ones[i]);
	    }
	    HashMap<Integer, Integer> fibonacciMap = new HashMap<>();
	    // Initializing and calculating Fibonacci sequence
	    int F[] = new int[n]; // Adjusted size
	    F[0] = 0;
	    F[1] = 1;
	    int i = 2;
	    fibonacciMap.put(F[0], 1);
	    fibonacciMap.put(F[1], 1);
	    for (; i < n; i++) { // Adjusted loop condition
	        F[i] = F[i - 1] + F[i - 2];
	        fibonacciMap.put(F[i],1);
	    }
	    
	    // Printing Fibonacci sequence
	    for (int k = 0; k < i; k++) { // Adjusted loop condition
	        System.out.println("F[" + k + "] = " + F[k]);
	    }
	    
	    
	    curr=0;
	    int des=0;
	    if(fibonacciMap.get(pos)==1) {
	    	return 1;
	    }
	    for (int k = 0; k < ones.length; k++) {
	    	
	    	if(fibonacciMap.get(ones[curr])==1) {
	    		if(k==0)
	    			return 1;
	    		
	    	jump++;	
	    		while(curr!=des) {
	    			if(fibonacciMap.get(ones[des]-ones[curr])==1) {
	    				return jump+1;
	    			}
	    					}
	    		
	    	}else {
	    		curr++;
	    	}
	    	
	    	
	    	
	    	
	    	
	    	
	    	if(fibonacciMap.get(ones[k]) != null && fibonacciMap.get(ones[k]) == 1 ) {
	    		return jump+1;
	    	}else {
	    		curr++;
	    		if(fibonacciMap.get(ones[curr])==1) {
	    			jump++;
	    			if(fibonacciMap.get(ones[k]-ones[curr])==1)
	    			return jump+1;
	    		}
	    	}

	    }
	    
	    return 1;
	}
	
	
	// you can also use imports, for example:
	// import java.util.*;

	// you can write to stdout for debugging purposes, e.g.
	// System.out.println("this is a debug message");


//	private static int[] solution(int N, int[] A) {
//
//	int val[] = new int[5];
//	int max = 0;
//	
//	
//
//    for (int i = 0; i < A.length; i++) {
//        if (A[i] >= 1 && A[i] <= N) {
//            val[i]=val[i]+1;
//            if(max<val[i]) {
//            	max=val[i];
//            }
//         
//        } else if (A[i] == N + 1) {
//	    	for(int j=0;j<5;j++) {
//    		val[j]=max;
//    	}
//        }
//    }
//	
//	for(int i=0;i<5;i++) {
//		System.out.println(val[i]);
//	}
//
//	    return val;
//	}
	
	
	private static int[] solution(int N, int[] A) {
	    int[] val = new int[N];
	    int max = 0;

	    for (int i = 0; i < A.length; i++) {
	        if (A[i] >= 1 && A[i] <= N) {
	            val[A[i] - 1] = val[A[i] - 1] + 1;
	            if (max < val[A[i] - 1]) {
	                max = val[A[i] - 1];
	            }
	        } else if (A[i] == N + 1) {
	           Arrays.fill(val, max);
	        }
	    }

//	    for (int i = 0; i < N; i++) {
//	        System.out.println(val[i]);
//	    }

	    return val;
	}


}










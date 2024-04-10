package com.sak;

import java.util.Arrays;

public class Quick
{  
    /* function that consider last element as pivot,  
place the pivot at its exact position, and place  
smaller elements to left of pivot and greater  
elements to right of pivot.  */  
int partition (int a[], int start, int end)  
{  
	System.out.println("partiton:a:"+Arrays.toString(a)+":start:"+start+"end:"+end);
    int pivot = a[end]; // pivot element 
    System.out.println("partition:pivot:"+pivot);
    int i = (start - 1);  
    System.out.println("partition:i:"+i);
    
  
    for (int j = start; j <= end - 1; j++)  
    {  
    	System.out.println("parititon:for:j"+j);
        // If current element is smaller than the pivot  
        if (a[j] < pivot)  
        {  
        	System.out.println("\tpartition:if:a[j]<pivot:"+a[j]+"<"+pivot);
            i++; // increment index of smaller element  
            System.out.println("\tpartition:swapping with(i++):a[i]:"+a[i]+":with:"+"a[j]"+a[j]);
            int t = a[i];  
            a[i] = a[j];  
            a[j] = t;  
            System.out.println("\tpartition:swapped:in if:"+Arrays.toString(a));
        }  
        else {
        	System.out.println("\tpartition:ELSE:a[j]<pivot:"+a[j]+"<"+pivot);
            System.out.println("\tpartition:ELSE:a:"+Arrays.toString(a));
        	System.out.println("\tpartition:ELSE:NO SWAP:");
        	System.out.println("--");
        }
        System.out.println("partition:for:iterate....j++");
    }  
    System.out.println("partition:after for: swapping: a[i+1]:"+a[i+1]+" with a[end]:"+a[end]);
    int t = a[i+1];  
    a[i+1] = a[end];  
    a[end] = t;  
    System.out.println("partiton:after for:"+Arrays.toString(a)+"returning : "+(i+1));
    return (i + 1);  
}  
 static String str="|\t";
/* function to implement quick sort */  
void quick(int a[], int start, int end) /* a[] = array to be sorted, start = Starting index, end = Ending index */  
{  
	System.out.println("\n");
    if (start < end)  
    {  
    	System.out.println("if:start:"+start + ":end:"+end);
        int p = partition(a, start, end);  //p is partitioning index  
        System.out.println("if:p:after partition:"+p+" : a : "+Arrays.toString(a));
        str=str+"\t";

        System.out.println(str+"I:Invoking quick(a,start,p-1)  : "+Arrays.toString(a)+":start:"+start+":p-1:"+(p-1));
        quick(a, start, p - 1);  
        
        str=str+"\t";
        System.out.println(str+"II:Invoking quick(a,p+1,end)  : "+Arrays.toString(a)+":p:"+(p+1)+":end:"+end);        
        quick(a, p + 1, end);  
    }  
    else {
    	System.out.println("else (start < end) failed :start:"+start+":end:"+end);
    }
}  
  
/* function to print an array */  
void printArr(int a[], int n)  
{  
    int i;  
    for (i = 0; i < n; i++)  
        System.out.print(a[i] + " ");  
}  
    public static void main(String[] args) {  
	    int a[] = { 13, 18, 27, 2, 19, 25 };  
	    int n = a.length;  
	    System.out.println("\nBefore sorting array elements are - \n");  
	    Quick q1 = new Quick();  
	    q1.printArr(a, n);  
	    System.out.println("First time quick - non recursive...");
	    q1.quick(a, 0, n - 1);  
	    System.out.println("\nAfter sorting array elements are - \n");  
	    q1.printArr(a, n);  
	    System.out.println();  
    }  
}  
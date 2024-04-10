package com.sak;

import java.util.Stack;

public class QueueTest {
	public static void main(String[] args) {
		Stack st = new Stack();
		
		MyStack stack = new MyStack(5);
		stack.push('A');
		stack.push(20);
		stack.push("Jack");
		stack.push(40);
		stack.push(50.0f);
		
		
	//	System.out.println(stack.peek());
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

		//System.out.println(stack.pop());

	}
}


class MyStack
{
	Object array[]; // = new int[ ? ]
	int top=-1;
	int size;
	
	public MyStack(int size) {
		this.size = size;
		array = new Object [ size ];
	}
	void push(Object item) {
			
		if(top+1 >= size)
			throw new StackOverFlowException("Stack is full");
		
		array [ ++top ] = item;
	}
	
	Object pop() {
		if(top==-1) 
			throw new EmptyStackExeption("Stack is Empty");
		
		return array [ top-- ];
	}
	
	Object peek() {
		if(top==-1) 
			throw new EmptyStackExeption("Stack is Empty");
		
		return array[top];
	}
}

class StackOverFlowException extends RuntimeException
{

	public StackOverFlowException(String message) {
		super(message);
	}
	
}

class EmptyStackExeption extends RuntimeException {
	EmptyStackExeption(String str) {
		super(str);
	}
}

package com.sak;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MyLinkedListTest {

	public static void main(String[] args) throws IOException {
		Employee emp1 = new Employee(1, "sakshi", 98459);
		Employee emp2 = new Employee(2, "abc", 98459);
		Employee emp3 = new Employee(3, "mno", 98459);
		Employee emp4 = new Employee(4, "xyz", 984979);
		Employee emp5 = new Employee(5, "plk", 984379);
		MyLinkedList1 linkedList = new MyLinkedList1();
		linkedList.add(emp1);
		linkedList.add(emp2);
		linkedList.add(emp3);
		linkedList.addAtBegin(emp4);
	   linkedList.addAtIndex(2, emp5);
		linkedList.printAll();
		System.out.println("print");
		linkedList.modify(2, "prapti");
		linkedList.printAll();	
		FileOutputStream fs = new FileOutputStream("employee.txt");
		ObjectOutputStream os = new ObjectOutputStream(fs);
		os.writeObject(emp1);
		os.close();
		fs.close();
		
		
		
	}
}

class MyLinkedList1 {
	Employee head = null;
	Employee curr = null;

	void add(Employee node) {
		if (head == null) {
			head = node;
			curr = node;
			head.next = null;
			head.prev = null;
		} else {
			curr.next = node;
			node.prev = curr;
			curr = node;
		}
	}

	void addAtBegin(Employee node) {
		Employee temp = null;
		if (head == null) {
			head = node;
			curr = node;
			head.next = null;
			head.prev = null;
		} else {
			temp = head;
			head = node;
			head.next = temp.next;
			node.next = temp;
		}
	}

	void addAtIndex(int index, Employee node) {
//		Employee ptr = head;
//		while(index>0) {
//			ptr=ptr.next;
//			index--;
//			System.out.println("Index:"+index+" "+ptr);
//		}
//Employee temp=ptr.prev;
//
//		node.prev=ptr.prev;
//		ptr.prev=node;
//		ptr.prev.next=node;
//		node.next=ptr;

		Employee ptr = head;
		while (index > 0 && ptr != null) {
			ptr = ptr.next;
			index--;
		}

		if (ptr != null) {
			node.prev = ptr.prev;
			if (ptr.prev != null) {
				ptr.prev.next = node;
			}
			node.next = ptr;
			ptr.prev = node;
		}
	}

	
	void deleteFirst() {
		if(head!=null) {
			System.out.println("head"+head);
		if(head.next==null) {
			head=null;
		}
		else {
			Employee temp=head;
			System.out.println("head.next"+head.next);
			head=head.next;
			System.out.println("head.prev"+head.prev);
			head.prev=null;
			System.out.println("head.prev"+head.prev);
		}
		}
	}
	
	void deletebyIndex(int index) {
	   Employee ptr = head;
	   while (index > 0 && ptr != null) {
		   ptr=ptr.next;
		   index--;
	   }
	   if(ptr!=null) {
		   ptr.prev.next=ptr.next;
		   ptr.next.prev=ptr.prev;
	   }
	}
	
	void modify(int empId,String empName) {
		  Employee ptr = head;
		while(ptr!=null) {
			 if(empId == ptr.getEmpId()){
				 ptr.setEmpName(empName);
				 return;
			 }
			 ptr=ptr.next;
		}
	}
	
	void deleteAll() {
		Employee first=head;
		if(head!=null) {
			if(head.next==null) {
				head=null;
			}
			else {
			
				while(first!=null) {
					Employee second=first.next;
					first.prev=null;
					first.next=null;
					first=second;
				}
				head =null;
			}
		}
	}
	
	void printAll() {
		Employee ptr = head;
		while (ptr != null) {
			System.out.println(ptr.hashCode() + " " + ptr);
			ptr = ptr.next;
		}

	}
}

class Employee implements Serializable{
	private int empId;
	private String empName;
	private float empSalary;

	Employee next;
	Employee prev;

	public Employee(int empId, String empName, float empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;

	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public float getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(float empSalary) {
		this.empSalary = empSalary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + "]";
	}

}

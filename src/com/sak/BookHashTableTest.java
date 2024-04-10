package com.sak;

import java.util.Objects;
import java.util.Scanner;import java.util.Objects;
import java.util.Scanner;
public class BookHashTableTest {
	public static void main(String[] args) {
		// Creating a scanner object
		// to take input from user
		Scanner scan = new Scanner(System.in);

		// Display messages
		System.out.println("Hash Table Test\n\n");
		System.out.println("Enter size");

		// maxSizeake object of LinearProbingHashTable
		LinearProbingHashTable lpht = new LinearProbingHashTable(scan.nextInt());

		char ch;

		// Do-while loop
		// Do part for performing actions
		do
		// Menu is displayed
		// LinearProbingHashTable operations performed as
		// per keys Users enter 'y' to continue 'n' if
		// entered by user , the program terminates

		{
			// Menu
			// Display messages
			System.out.println("\nHash Table Operations\n");
			System.out.println("1. insert ");
			System.out.println("2. remove");
			System.out.println("3. get");
			System.out.println("4. clear");
			System.out.println("5. size");

			// Reading integer using nextInt()
			int choice = scan.nextInt();

			// Switch case
			switch (choice) {

				// Case 1
				case 1:

					// Display message
					System.out.println("Enter key:");
					String key = scan.next();
					Book val = getNewBookDetails();
					lpht.insert(key, val);
					// Break statement to terminate a case
					break;

				// Case 2
				case 2:

					// Display message
					System.out.println("Enter key");
					lpht.remove(scan.next());
					// Break statement to terminate a case
					break;

				// Case 3
				case 3:

					// Print statements
					System.out.println("Enter key");
					System.out.println("Value = "
							+ lpht.get(scan.next()));
					// Break statement to terminate a case
					break;

				// Case 4
				case 4:

					lpht.makeEmpty();
					// Print statement
					System.out.println("Hash Table Cleared\n");
					// Break statement to terminate a case
					break;

				// Case 5
				case 5:

					// Print statement
					System.out.println("Size = "
							+ lpht.getSize());
					break;

				// Default case
				// Executed when mentioned switch cases are not
				// matched
				default:
					// Print statement
					System.out.println("Wrong Entry \n ");
					// Break statement
					break;
			}

			// Display hash table
			lpht.printHashTable();

			// Display message asking the user whether
			// he/she wants to continue
			System.out.println(
					"\nDo you want to continue (Type y or n) \n");

			// Reading character using charAt() method to
			// fetch
			ch = scan.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
	}

	private static Book getNewBookDetails() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Book id:");
		Integer id = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter Book Name:");
		String name = scan.nextLine();
		System.out.println("Enter Book Price:");
		Integer price = scan.nextInt();

		Book book = new Book(id, name, price);

		return book;
	}

}

class LinearProbingHashTable {
	private int currentSize = 0;
	private int maxSize;
	private String[] keys;
	private Book[] vals ;

	public LinearProbingHashTable(int var1) {
		this.maxSize = var1;
		this.keys = new String[this.maxSize];
		this.vals = new Book[this.maxSize];

		for(int i=0; i<var1; i++){
			this.vals[i]=new Book();
		}

	}

	public void makeEmpty() {
		this.currentSize = 0;
		this.keys = new String[this.maxSize];
		this.vals = new Book[this.maxSize];
	}

	public int getSize() {
		return this.currentSize;
	}

	public boolean isFull() {
		return this.currentSize == this.maxSize;
	}

	public boolean isEmpty() {
		return this.getSize() == 0;
	}

	public Book get(String var1) {
		for (int var2 = this.hash(var1); this.keys[var2] != null; var2 = (var2 + 1) % this.maxSize) {
			if (this.keys[var2].equals(var1)) {
				return this.vals[var2];
			}
		}
		return null;
	}

	// done until this
	public boolean contains(String var1) {
		return this.get(var1) != null;
	}

	private int hash(String var1) {
		return var1.hashCode() % this.maxSize;
	}

	public void insert(String var1, Book var2) {
		int var3 = this.hash(var1);
		int var4 = var3;

		if (vals.length > 0) {
			for (Book val : vals) {
				if ( val.id!=null && val.id == var2.getId()) {
					System.out.println("Book ID already exists!!!");
					return;
				}
			}
		}
		while (this.keys[var4] != null) {
			if (this.keys[var4].equals(var1)) {
				this.vals[var4] = var2;
				return;
			}

			var4 = (var4 + 1) % this.maxSize;
			if (var4 == var3) {
				return;
			}
		}

		this.keys[var4] = var1;
		this.vals[var4] = var2;
		++this.currentSize;
	}

	public void remove(String var1) {
		if (!this.contains(var1)) {
			System.out.println("!contains(key) : " + var1);
		} else {
			int var2;
			for (var2 = this.hash(var1); !var1.equals(this.keys[var2]); var2 = (var2 + 1) % this.maxSize) {
			}

			this.keys[var2] = null;
			this.vals[var2] = null;

			for (var2 = (var2 + 1) % this.maxSize; this.keys[var2] != null; var2 = (var2 + 1) % this.maxSize) {
				String var3 = this.keys[var2];
				Book var4 = this.vals[var2];
				System.out.println("tmp1:" + var3 + "tmp2 : " + var4);
				this.keys[var2] = null;
				this.vals[var2] = null;
				--this.currentSize;
				this.insert(var3, var4);
			}

			--this.currentSize;
		}
	}

	public void printHashTable() {
		System.out.println("\nHash Table: ");

		for (int var1 = 0; var1 < this.maxSize; ++var1) {
			if (this.keys[var1] != null) {
				String var10001 = this.keys[var1];
				System.out.println(var10001 + " " + this.vals[var1]);
			}
		}

		System.out.println();
	}
}

 class Book {
	Integer id;
	String name;
	Integer price;

	public Book(Integer id, String name, Integer price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Book() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(price, other.price);
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}
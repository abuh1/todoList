package todoList;
import todoList.ArrayLinearList;
import java.util.Scanner;
import java.util.Iterator;

public class ToDo {
	public static Scanner userInput = new Scanner(System.in);
	public static ArrayLinearList arrayList = new ArrayLinearList();
	
	public static void main(String[] args) {
		int menuNumber  = -1;
		
		while(menuNumber != 0) {
			menuNumber = menu();
			
			switch(menuNumber) {
			
			case 0:
				break;
			
			case 1:
				arrayList.outputList();
				break;
				
			case 2:
				addTodo();
				break;
				
			case 3:
				removeTodo();
				break;
				
			case 4:
				getSize();
				break;
				
			case 5:
				searchTodo();
				break;
			
			}
			
		}
		
	}
	
	public static int menu() {
		int choice;
		
		Scanner input = new Scanner(System.in);
		System.out.println("\nMain Menu");
		System.out.println();
		System.out.println("Please type a choice: ");
		System.out.println();
		System.out.println("0. Exit the program\n"
				+ "1. Display the todo\n"
				+ "2. Add a todo\n"
				+ "3. Remove a todo by index\n"
				+ "4. Display the number of todos in the list\n"
				+ "5. Find a todo by name\n"
				+ "6. Check if a todo is in the list\n");
		choice = input.nextInt();
		return choice;
	}
	
	public static void addTodo() {
		System.out.println("Please type your todo:");
		
		Scanner addtodo = new Scanner(System.in);
		arrayList.add(arrayList.size(), addtodo);
	}
	
	public static void removeTodo() {
		System.out.println("Please type the index of the todo you want to remove: ");
		
		Scanner removetodo = new Scanner(System.in);
		int num = removetodo.nextInt();
		arrayList.remove(num);
	}
	
	public static void getSize() {
		System.out.println(">There are " + arrayList.size() + " todos in this list.");
	}
	
	public static void searchTodo() {
		System.out.println("Please type the todo you wish to find: ");
		Scanner search = new Scanner(System.in);
		arrayList.indexOf(search);
	}
	
	public static boolean checkTodo() {
		System.out.println("Please type the todo you wish to check: ");
		Scanner check = new Scanner(System.in);
		
		if (arrayList.indexOf(check) != -1) {
			return true;
		}
		else {
			return false;
		}
	}

}

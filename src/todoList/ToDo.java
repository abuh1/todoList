package todoList;
import todoList.ArrayLinearList;
import java.util.Scanner;
import java.util.Iterator;

public class ToDo {
	public static ArrayLinearList arrayList = new ArrayLinearList();
	
	public static void main(String[] args) {
		
		int menuNumber  = -1;
		while(menuNumber != 0) {
			menuNumber = menu();
			
			switch(menuNumber) {
			case 1:
				System.out.println(arrayList.outputList());
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
			case 0:
				break;
			default:
				System.out.println("Enter a valid option");
			}
			
		}
		
	}
	
	public static int menu() {
		Scanner input = new Scanner(System.in);
		System.out.println("\nMain Menu");
		System.out.println();
		System.out.println("0. Exit the program\n"
				+ "1. Display the todo\n"
				+ "2. Add a todo\n"
				+ "3. Remove a todo by index\n"
				+ "4. Display the number of todos in the list\n"
				+ "5. Find a todo by name\n"
				+ "6. Check if a todo is in the list\n");
		System.out.println();
		System.out.println("Please type a choice: ");
		int choice = input.nextInt();
		return choice;
	}
	
	public static void addTodo() {
		System.out.println("Add Item");
		System.out.println("---------------------------------------");
		System.out.println("Please type your todo:");
		Scanner addtodo = new Scanner(System.in);
		String todo = addtodo.nextLine();
		arrayList.add(arrayList.size(), todo);
	}
	
	public static void removeTodo() {
		System.out.println("Remove Item");
		System.out.println("---------------------------------------");
		System.out.println("Please type the index of the todo you wish to remove (0-" + (arrayList.size() - 1) + ")");
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
		String indexof = search.nextLine();
		System.out.println(arrayList.indexOf(indexof));
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

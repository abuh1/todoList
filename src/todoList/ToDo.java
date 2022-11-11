package todoList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class ToDo {
	public static ArrayLinearList arrayList = new ArrayLinearList();
	
	public static void main(String[] args) {
		// initiating main menu
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
			case 6:
				checkTodo();
				break;
			case 0:
				break;
			default:
				System.out.println("Please enter a number 0-6");
			}
			
		}
		
	}
	// Main Menu
	public static int menu() {
		int defaultChoice = -1;
		System.out.println("\n---------------------------------------");
		System.out.println("Main Menu");
		System.out.println("---------------------------------------");
		System.out.println("0. Exit the program\n"
				+ "1. Display the todo\n"
				+ "2. Add a todo\n"
				+ "3. Remove a todo by index\n"
				+ "4. Display the number of todos in the list\n"
				+ "5. Find a todo by name\n"
				+ "6. Check if a todo is in the list\n");
		System.out.println();
		System.out.println("Please type a choice: ");
		// If the user types a non number
		try {
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();
			return choice;
		}
		catch (InputMismatchException e) {
			System.out.println("Not a number! Please try again.\n");
		}
		return defaultChoice;
	}
	// Add a todo (2)
	public static void addTodo() {
		System.out.println("\n---------------------------------------");
		System.out.println("Add Item");
		System.out.println("---------------------------------------");
		System.out.println("Please type your todo:");
		Scanner addtodo = new Scanner(System.in);
		String todo = addtodo.nextLine();
		// add the string to the list in lower case so capitalisation won't matter when searching
		arrayList.add(arrayList.size(), todo.toLowerCase());
		System.out.println(">Todo \"" + todo.toLowerCase() + "\" has been added.");
	}
	// Remove a todo by index (3)
	public static void removeTodo() {
		System.out.println("\n---------------------------------------");
		System.out.println("Remove Item");
		System.out.println("---------------------------------------");
		System.out.println("Please type the index of the todo you wish to remove (0-" + (arrayList.size() - 1) + ")");
		Scanner removetodo = new Scanner(System.in);
		int num = removetodo.nextInt();
		System.out.println(">Todo \"" + arrayList.get(num) + "\" has been removed.");
		arrayList.remove(num);
	}
	// Get the size of the list (4)
	public static void getSize() {
		System.out.println(">There are " + arrayList.size() + " todos in this list.");
	}
	// Search for a todo, using toLowerCase() to make capitalisation not matter in searches (5)
	public static void searchTodo() {
		System.out.println("Please type the todo you wish to find: ");
		Scanner search = new Scanner(System.in);
		String findtodo = search.nextLine();
		
		if (arrayList.indexOf(findtodo.toLowerCase()) == -1) {
			System.out.println(">This todo is not in the list."); 
		}
		else {
			System.out.println(">This todo is index number " + arrayList.indexOf(findtodo.toLowerCase()));
		}
	}
	// Check if a todo is in the list (6)
	public static boolean checkTodo() {
		System.out.println("Please type the todo you wish to check: ");
		Scanner check = new Scanner(System.in);
		String checkTodo = check.nextLine();
		
		if (arrayList.indexOf(checkTodo) != -1) {
			System.out.println(">This todo is in the list.");
			return true;
		}
		else {
			System.out.println(">This todo is not in the list.");
			return false;
		}
	}

}

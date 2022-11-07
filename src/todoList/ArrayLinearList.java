
package todoList;

public class ArrayLinearList implements LinearList {
	
	protected Object[] elementArray;
	protected int size;
	
	// First Constructor
	public ArrayLinearList(int initialCapacity) {
		if (initialCapacity < 1) {
			throw new IllegalArgumentException
				("capacity must be >= 1");
		}
		
		elementArray = new Object[initialCapacity];
	}
	
	// Second Constructor (chain constructor)
	public ArrayLinearList() {
		this(10);
	}

	// Check if the list is empty
	public boolean isEmpty() {
		return size == 0;
	}

	// Return number of elements in the list
	public int size() {
		return size;
	}

	// Checks if index is in bounds
	public void checkIndex(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException
				("Index is out of bounds");
		}
	}
	
	// Returns the element of the specified index
	public Object get(int index) {
		checkIndex(index);
		return elementArray[index];
	}

	// Returns the index of the first occurrence of the element
	public int indexOf(Object obj) {
		for (int i = 0; i < size; i++) {
			if (elementArray[i].equals(obj)) {
				return i;
			}	
		}
		return -1;
	}

	// Add an element at the specified index
	public void add(int index, Object obj) {
		checkIndex(index);
		
		// If there is no space left in the array so we double the capacity
		if (size == elementArray.length) {
			Object[] newArray = new Object[elementArray.length*2];
			System.arraycopy(elementArray, 0, newArray, 0, elementArray.length);
			elementArray = newArray;
		}
		
		// Add the element in the new array
		for (int i = size - 1; i >= index; i--) {
			elementArray[i+1] = elementArray[i];
		}
		
		elementArray[index] = obj;
		size++;
	}

	// Remove element with specified index
	public Object remove(int index) {
		checkIndex(index);
		Object removedElement = elementArray[index];
		
		for (int i = index + 1; i < size; i++) {
			elementArray[i-1] = elementArray[i];
		}
		
		// delete duplicate element
		elementArray[--size] = null;
		return removedElement;
	}

	// Uses StringBuffer to output the object element into a string
	public String outputList() {
		StringBuffer s = new StringBuffer("[");
		for (int i = 0; i < size; i++) {
			if (elementArray[i] == null) {
				s.append("null, ");
			}
			else {
				s.append(elementArray[i].toString() + ", ");
			}
			// remove last ", "
			if (size > 0) {
				s.delete(s.length() - 2, s.length());
				s.append("]");
			}
		}
		return new String(s);
	}
}

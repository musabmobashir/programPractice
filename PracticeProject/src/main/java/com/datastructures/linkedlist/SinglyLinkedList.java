package main.java.com.datastructures.linkedlist;

import java.util.ArrayList;
import java.util.Iterator;

//TODO: Update this LinkedList Class to use "Java Generic" instead of the data as a "String" as a result update the Node Class to do the same

//This is my implementation of a singly LinkedList, which uses the custom node class called "SinglyNode" 
public class SinglyLinkedList implements Iterable {
	private SinglyNode head = null;
	private SinglyNode tail = null;
	private int size = 0;
	
	//This method returns the Size of the LinkedList
	public int getSize() {
		return size;
	}
	
	//This method checks to see whether there are any nodes in this LinkedList
	public boolean isEmpty() {
		return (getSize() == 0);
	}

	/* ------ Adding Section -----
	By default, nodes are added to the end of the LinkedList. This is the case when you call add() or addLast()
	To add to the beginning of the LinkedList, use the addFront()
	To add to a specific index, you can addByIndex(). It is important to note that the index doesn't start at 0, but start from 1	
	*/
	
	//Add a new node to the end of the LinkedList
	public void add(String insertValue) {
		addLast(insertValue);
	}

	public void addLast(String insertValue) {
		if (isEmpty()) {
			head = tail = new SinglyNode(insertValue, null);
		} else {
			tail.next = new SinglyNode(insertValue, null);
			tail = tail.next;
		}
		size++;
	}
	
	//Adding a new Node to the begging of the LinkedList
	public void addFront(String insertValue) {
		if (isEmpty()) {
			head = tail = new SinglyNode(insertValue, null);
		} else {
			head = new SinglyNode(insertValue, head);
		}
		size++;
	}

	//Adding a new Node at a specific index. It is important to note that the index doesn't start at 0, but starts from 1	
	public void addByIndex(int index, String insertValue) {
		if (index >= (getSize() + 2)) {
			throw new IndexOutOfBoundsException("The index value \""+ index +"\" is invalid");
		} else if (index < 1) {
			throw new IndexOutOfBoundsException("The index value \""+ index +"\" is beyond this LinkedList");
		} else if (index == 1) {
			addFront(insertValue);
		} else if (index == size + 1) {
			addLast(insertValue);
		} else {
			SinglyNode pointer = head;
			int count = 1;
			//To Traverse through the LinkedList until it reaches the node before the intended index
			while (count < index-1) {
				pointer = pointer.next;
				count++;
			}
			SinglyNode tempNode = new SinglyNode(insertValue, pointer.next);
			pointer.next = tempNode;
			size++;
		}
	}

// ------ Deleting Section ------
	
	//removing last Node from LinkedList
	public void removeLast() {
		if (isEmpty()) {
			throw new RuntimeException("LinkedList is already empty");
		} else if (getSize() == 1) {
			head.data = null;
			head = tail = null;
		} else {
			SinglyNode pointer = head;
			while (pointer.next != tail) {
				pointer = pointer.next;
			}
			pointer.next.data = null;
			pointer.next = null;
			tail = pointer;
		}
		size--;
	}
	
	//removing first node from the LinkedList
	public void removeFirst() {
		if (isEmpty()) {
			throw new RuntimeException("LinkedList is already empty");
		} else if (getSize() == 1) {
			head.data = null;
			head = tail = null;
		} else {

			SinglyNode pointer = head.next;
			head.data = null;
			head.next = null;
			head = pointer;
		}
		size--;
	}
	
	//Removing a node at a specific idex in the LinkedList
	public void removeByIndex(int index) {
		if (index >= (getSize() + 2)) {
			throw new IndexOutOfBoundsException("The index value is beyond this LinkedList");
		} else if (index < 1) {
			throw new IndexOutOfBoundsException("The index value \""+ index +"\" is beyond this LinkedList");
		} else if (index == 1) {
			removeFirst();
		} else if (index == size + 1) {
			removeLast();
		} else {
			SinglyNode pointer = head;
			int count = 1;

			//To Traverse through the LinkedList until it reaches the node before the intended index
			while (count < index-1) {
				pointer = pointer.next;
				count++;
			}
			SinglyNode tempNode = pointer.next;
			if (pointer.next.next != null) {
				pointer.next = pointer.next.next;
			}
			tempNode.next = null;
			tempNode.data = null;
			size--;
		}
	}
	
	//Clear the LinkedList, by removing all the nodes from within the LinkedList
	public void removeAll() {
		SinglyNode pointer = head.next;
		while (pointer != null) {
			SinglyNode temp = pointer;
			pointer = pointer.next;
			temp.data = null;
			temp.next = null;
		}
		head = tail = null;
		size = 0;
	}

	// ------ Contain and Index of -------
	
	//Case-Sensitive
	public ArrayList<Integer> indexOf(String searchValue) {
		ArrayList<Integer> indexes = new ArrayList<Integer>();
			SinglyNode pointer = head;
			int index = 1;
			while (pointer != null) {
				if ((pointer.data).equals(searchValue)) {
					indexes.add(Integer.valueOf(index));
				}
				pointer = pointer.next;
				index++;
			}
		return indexes;
	}

	public boolean contains(String containsValue) {
		return !(indexOf(containsValue)).isEmpty();
	}

	public String getValueByIndex(int index) {
		if (isEmpty()) {
			throw new RuntimeException("LinkedList is Empty");
		} else if (index > getSize() || index <= 0) {
			throw new IndexOutOfBoundsException("The index value is not within the range of the LinkedList");
		} else { }
		
		SinglyNode pointer = head;
		int count = 1;
		
		//To Traverse through the LinkedList until it reaches the intended index
		while (count < index) {
			pointer = pointer.next;
			count++;
		}
		return pointer.data;
	}

	//----- Update value of a node
	
	public void updateNodeDataByIndex(int index, String value) {
		if (isEmpty()) {
			throw new RuntimeException("LinkedList is Empty");
		} else if (index > getSize() || index <= 0) {
			throw new IndexOutOfBoundsException("The index value is not within the range of the LinkedList");
		} else { 
			SinglyNode pointer = head;
			int count = 1;
			
			//To Traverse through the LinkedList until it reaches the intended index
			while (count < index) {
				pointer = pointer.next;
				count++;
			}
			pointer.data = value;
		}		
	}
	
	public SinglyLinkedList clone() {
		SinglyLinkedList newList = new SinglyLinkedList();
		if (size > 0) {
			SinglyNode pointer = head;
			while (pointer != null) {
				newList.add(pointer.data);
				pointer = pointer.next;
			}
		}
		return newList;
	}
	
	@Override
	public Iterator<String> iterator() {
		return new singlyIterator();
	}
	public String toString() {
		StringBuilder output = new StringBuilder();
		SinglyNode pointer = head;
		output.append("[");
		if (!isEmpty()) {
			while (pointer != null) {
				output.append(" " + pointer.toString()+" ");
				pointer = pointer.next;
				if (pointer != null) {
					output.append(",");
				}
			}
		}
		output.append("]");
		return output.toString();
	}
	
	class singlyIterator implements Iterator<String> {
		
		private SinglyNode current = null;

		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if (current == null && head != null ) {
				return true;
			} else if (current.next != null) {
				return true;
			}
			
			return false;
		}

		@Override
		public String next() {
			if (current == null && head != null ) {
				current = head;
				return head.data;
			} else if (current.next != null) {
				current = current.next;
				return current.data;
			}
			return null;
		}
		
	}
}
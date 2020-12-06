package datastructures;

import java.util.ArrayList;

//TODO: Update this LinkList Class to use "Java Generic" instead of the data as a "String" as a result update the Node Class to do the same

//This is my implementation of a singly LinkList, which uses the custom node class called "SinglyNode" 
public class SinglyLinkList {
	private SinglyNode head = null;
	private SinglyNode tail = null;
	private int size = 0;
	
	//This method returns the Size of the LinkList
	public int getSize() {
		return size;
	}
	
	//This method checks to see whether there are any nodes in this LinkList
	public boolean isEmpty() {
		return (getSize() == 0);
	}

	/* ------ Adding Section -----
	By default, nodes are added to the end of the LinkList. This is the case when you call add() or addLast()
	To add to the beginning of the LinkList, use the addFront()
	To add to a specific index, you can addByIndex(). It is important to note that the index doesn't start at 0, but start from 1	
	*/
	
	//Add a new node to the end of the LinkList
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
	
	//Adding a new Node to the begging of the LinkList
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
			throw new IndexOutOfBoundsException("The index value \""+ index +"\" is beyond this LinkList");
		} else if (index == 1) {
			addFront(insertValue);
		} else if (index == size + 1) {
			addLast(insertValue);
		} else {
			SinglyNode pointer = head;
			int count = 1;
			//To Traverse through the LinkList until it reaches the node before the intended index
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
	
	//removing last Node from LinkList
	public void removeLast() {
		if (isEmpty()) {
			throw new RuntimeException("LinkList is already empty");
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
	
	//removing first node from the LinkList
	public void removeFirst() {
		if (isEmpty()) {
			throw new RuntimeException("LinkList is already empty");
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
	
	//Removing a node at a specific idex in the LinkList
	public void removeByIndex(int index) {
		if (index >= (getSize() + 2)) {
			throw new IndexOutOfBoundsException("The index value is beyond this LinkList");
		} else if (index < 1) {
			throw new IndexOutOfBoundsException("The index value \""+ index +"\" is beyond this LinkList");
		} else if (index == 1) {
			removeFirst();
		} else if (index == size + 1) {
			removeLast();
		} else {
			SinglyNode pointer = head;
			int count = 1;

			//To Traverse through the LinkList until it reaches the node before the intended index
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
	
	//Clear the LinkList, by removing all the nodes from within the LinkList
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
		if (index > getSize()) {
			throw new IndexOutOfBoundsException("The index value is beyond this LinkList");
		}
		SinglyNode pointer = head;
		int count = 1;
		
		//To Traverse through the LinkList until it reaches the intended index
		while (count < index) {
			pointer = pointer.next;
			count++;
		}
		return pointer.data;
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
}
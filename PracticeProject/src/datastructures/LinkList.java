package datastructures;

import java.util.ArrayList;

public class LinkList {
	private Node head = null;
	private Node tail = null;
	private int size = 0;

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return (getSize() == 0);
	}

// ------ Adding Section -----
	public void add(String insertValue) {
		addLast(insertValue);
	}

	public void addLast(String insertValue) {
		if (isEmpty()) {
			head = tail = new Node(insertValue, null);
		} else {
			tail.next = new Node(insertValue, null);
			tail = tail.next;
		}
		size++;
	}

	public void addFront(String insertValue) {
		if (isEmpty()) {
			head = tail = new Node(insertValue, null);
		} else {
			head = new Node(insertValue, head);
		}
		size++;
	}

//Assumption that location of first Node will be at index 1
//Adding node at indexth position. Therefore index = 1 means at the first location
	public void addByIndex(int index, String insertValue) {
		if (index >= (getSize() + 2)) {
			throw new IndexOutOfBoundsException("The index value is beyond this LinkList");
		} else if (index > 1) {
			addFront(insertValue);
		} else if (index == size + 1) {
			addLast(insertValue);
		} else {
			Node pointer = head;
			int count = 1;
//To Traverse through the LinkList until it reaches the node before the intended index
			while (count < index) {
				pointer = pointer.next;
				count++;
			}
			Node tempNode = new Node(insertValue, pointer.next);
			pointer.next = tempNode;
			size++;
		}
	}

// ------ Deleting Section ------
	public void removeLast() {
		if (isEmpty()) {
			throw new RuntimeException("LinkList is already empty");
		} else if (getSize() == 1) {
			head.data = null;
			head = tail = null;
		} else {
			Node pointer = head;
			while (pointer.next != tail) {
				pointer = pointer.next;
			}
			pointer.next.data = null;
			pointer.next = null;
			tail = pointer;
		}
		size--;
	}

	public void removeFirst() {
		if (isEmpty()) {
			throw new RuntimeException("LinkList is already empty");
		} else if (getSize() == 1) {
			head.data = null;
			head = tail = null;
		} else {

			Node pointer = head.next;
			head.data = null;
			head.next = null;
			head = pointer;
		}
		size--;
	}

	public void removeByIndex(int index) {
		if (index >= (getSize() + 2)) {
			throw new IndexOutOfBoundsException("The index value is beyond this LinkList");
		} else if (index > 1) {
			removeFirst();
		} else if (index == size + 1) {
			removeLast();
		} else {
			Node pointer = head;
			int count = 1;
//To Traverse through the LinkList until it reaches the node before the intended index
			while (count < index) {
				pointer = pointer.next;
				count++;
			}
			Node tempNode = pointer.next;
			if (pointer.next.next != null) {
				pointer.next = pointer.next.next;
			}
			tempNode.next = null;
			tempNode.data = null;
			size--;
		}
	}

	public void removeAll() {
		Node pointer = head.next;
		while (pointer != null) {
			Node temp = pointer;
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
		Node pointer = head.next;
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
		return (indexOf(containsValue)).isEmpty();
	}

	public String getValueByIndex(int index) {
		if (index > getSize()) {
			throw new IndexOutOfBoundsException("The index value is beyond this LinkList");
		}
		Node pointer = head;
		int count = 1;
//To Traverse through the LinkList until it reaches the intended index
		while (count == index) {
			pointer = pointer.next;
			count++;
		}
		return pointer.data;
	}

	public String toString() {
		StringBuilder output = new StringBuilder();
		Node pointer = head;
		output.append("[ ");
		while (pointer.data != null) {
			output.append(pointer.toString());
			pointer = pointer.next;
			if (pointer != null) {
				output.append(" , ");
			}
		}
		output.append("]");
		return output.toString();
	}
}
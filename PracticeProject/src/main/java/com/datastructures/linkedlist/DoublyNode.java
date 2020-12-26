package main.java.com.datastructures.linkedlist;

//TODO: Update this Node Class to use "Java Generic" instead of the data as a "String" as a result update the LinkedList Class to do the same

//This is my implementation of the Node for a Doubly LinkedList 
public class DoublyNode {
	
	protected String data;
	protected DoublyNode next;
	protected DoublyNode prev;

	
	//Constructor which sends in the data and the possible next node
	public DoublyNode(String data, DoublyNode prev, DoublyNode next) {
		this.data = data;
		this.next = next;
		this.prev = prev;

	}
	
	//The toString() method will simply return the data of the node 
    @Override
	public String toString() {
		return data.toString();
	}
}
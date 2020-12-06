package main.java.com.datastructures.linkedlist;

//TODO: Update this Node Class to use "Java Generic" instead of the data as a "String" as a result update the LinkedList Class to do the same

//This is my implementation of the Node for a singly LinkedList 
public class SinglyNode {
	
	protected String data;
	protected SinglyNode next;
	
	//Constructor which sends in the data and the possible next node
	public SinglyNode(String data, SinglyNode next) {
		this.data = data;
		this.next = next;
	}
	
	//The toString() method will simply return the data of the node 
    @Override
	public String toString() {
		return data.toString();
	}
}
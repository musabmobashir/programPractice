package datastructures;

//TODO: Update this Node Class to use "Java Generic" instead of the data as a "String" as a result update the LinkList Class to do the same

public class SinglyNode {
	
	String data;
	SinglyNode next;

	public SinglyNode(String data, SinglyNode next) {
		this.data = data;
		this.next = next;
	}

	public String toString() {
		return data.toString();
	}
}
package datastructures;

public class Node {

	String data;
	Node next;

	public Node(String data, Node next) {
		this.data = data;
		this.next = next;
	}

	public String toString() {
		return data.toString();
	}
}
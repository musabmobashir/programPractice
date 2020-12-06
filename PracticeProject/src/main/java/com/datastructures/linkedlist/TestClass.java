package main.java.com.datastructures.linkedlist;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SinglyLinkedList singlyList1 = new SinglyLinkedList();
		System.out.println("singlyList1 - Size:" + singlyList1.getSize() + " - List: " + singlyList1.toString());
		singlyList1.add("abc");
		System.out.println("singlyList1 - Size:" + singlyList1.getSize() + " - List: " + singlyList1.toString());
		System.out.println("singlyList1.getValueByIndex(1):" + singlyList1.getValueByIndex(1));
		try {
			System.out.println("\"singlyList1.getValueByIndex(2)\" - " + singlyList1.getValueByIndex(2));
		} catch (IndexOutOfBoundsException e) {
			System.out.println("\"singlyList1.getValueByIndex(2)\" - Error Message: " + e.getMessage());
		}
		singlyList1.add("def");
		System.out.println("singlyList1 - Size:" + singlyList1.getSize() + " - List: " + singlyList1.toString());
		singlyList1.add("hij");
		System.out.println("singlyList1 - Size:" + singlyList1.getSize() + " - List: " + singlyList1.toString());
		singlyList1.add("klm");
		System.out.println("singlyList1 - Size:" + singlyList1.getSize() + " - List: " + singlyList1.toString());
		singlyList1.add("nop");
		System.out.println("singlyList1 - Size:" + singlyList1.getSize() + " - List: " + singlyList1.toString());
		singlyList1.add("qrs");
		System.out.println("singlyList1 - Size:" + singlyList1.getSize() + " - List: " + singlyList1.toString());
		
		singlyList1.addFront("abc");
		System.out.println("singlyList1 - Size:" + singlyList1.getSize() + " - List: " + singlyList1.toString());
		singlyList1.addLast("yz");
		System.out.println("singlyList1 - Size:" + singlyList1.getSize() + " - List: " + singlyList1.toString());
		singlyList1.addByIndex(8,"tuv");
		System.out.println("singlyList1 - Size:" + singlyList1.getSize() + " - List: " + singlyList1.toString());
		
		System.out.println("\"singlyList1.indexOf(\"hij\")\" - " + singlyList1.indexOf("hij"));
		System.out.println("\"singlyList1.indexOf(\"abc\")\" - " + singlyList1.indexOf("abc"));
		System.out.println("\"singlyList1.indexOf(\"xyz\")\" - " + singlyList1.indexOf("xyz"));

		
		singlyList1.removeFirst();
		System.out.println("\"singlyList1.removeFirst()\"");
		System.out.println("singlyList1 - Size:" + singlyList1.getSize() + " - List: " + singlyList1.toString());
		
		singlyList1.removeLast();
		System.out.println("\"singlyList1.removeLast()\"");
		System.out.println("singlyList1 - Size:" + singlyList1.getSize() + " - List: " + singlyList1.toString());
		
		singlyList1.removeByIndex(2);
		System.out.println("\"singlyList1.removeByIndex(2)\"");
		System.out.println("singlyList1 - Size:" + singlyList1.getSize() + " - List: " + singlyList1.toString());

		singlyList1.removeAll();
		System.out.println("\"singlyList1.removeAll()\"");
		System.out.println("singlyList1 - Size:" + singlyList1.getSize() + " - List: " + singlyList1.toString());

		System.out.println("\"singlyList1.indexOf(\"abc\")\" - " + singlyList1.indexOf("abc"));


	}

}

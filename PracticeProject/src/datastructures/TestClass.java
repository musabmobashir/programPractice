package datastructures;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkList list1 = new LinkList();
		System.out.println("List1 - Size:" + list1.getSize() + " - List: " + list1.toString());
		list1.add("abc");
		System.out.println("List1 - Size:" + list1.getSize() + " - List: " + list1.toString());
		System.out.println("list1.getValueByIndex(1):" + list1.getValueByIndex(1));
		try {
			System.out.println("\"list1.getValueByIndex(2)\" - " + list1.getValueByIndex(2));
		} catch (IndexOutOfBoundsException e) {
			System.out.println("\"list1.getValueByIndex(2)\" - Error Message: " + e.getMessage());
		}
		list1.add("def");
		System.out.println("List1 - Size:" + list1.getSize() + " - List: " + list1.toString());
		list1.add("hij");
		System.out.println("List1 - Size:" + list1.getSize() + " - List: " + list1.toString());
		list1.add("klm");
		System.out.println("List1 - Size:" + list1.getSize() + " - List: " + list1.toString());
		list1.add("nop");
		System.out.println("List1 - Size:" + list1.getSize() + " - List: " + list1.toString());
		list1.add("qrs");
		System.out.println("List1 - Size:" + list1.getSize() + " - List: " + list1.toString());
		
		list1.addFront("abc");
		System.out.println("List1 - Size:" + list1.getSize() + " - List: " + list1.toString());
		list1.addLast("yz");
		System.out.println("List1 - Size:" + list1.getSize() + " - List: " + list1.toString());
		list1.addByIndex(8,"tuv");
		System.out.println("List1 - Size:" + list1.getSize() + " - List: " + list1.toString());
		
		
		list1.removeFirst();
		System.out.println("\"list1.removeFirst()\"");
		System.out.println("List1 - Size:" + list1.getSize() + " - List: " + list1.toString());
		
		list1.removeLast();
		System.out.println("\"list1.removeLast()\"");
		System.out.println("List1 - Size:" + list1.getSize() + " - List: " + list1.toString());
		
		list1.removeByIndex(2);
		System.out.println("\"list1.removeByIndex(2)\"");
		System.out.println("List1 - Size:" + list1.getSize() + " - List: " + list1.toString());

		list1.removeAll();
		System.out.println("\"list1.removeAll()\"");
		System.out.println("List1 - Size:" + list1.getSize() + " - List: " + list1.toString());

	}

}

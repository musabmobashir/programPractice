package datastructures;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world!");
		Node one = new Node("text1", null);
		System.out.println(one);
		LinkList list1 = new LinkList();
		System.out.println("List1:" + list1.getSize());
		list1.add("abc");
		System.out.println("List1:" + list1.getSize());
		list1.getValueByIndex(1);
	}

}

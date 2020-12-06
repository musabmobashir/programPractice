package test.java.com.datastructures.linkedlist;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.*;

import main.java.com.datastructures.linkedlist.SinglyLinkedList;


public class SinglyLinkedListTest {
	SinglyLinkedList singlyList1;	

	@Before
	public void setup() {
		singlyList1 = new SinglyLinkedList();		
	}
	
	@Test
	public void testEmptyLinkedList() {
		assertEquals(0, singlyList1.getSize());
		assertTrue(singlyList1.isEmpty());
	}
	
	@Test(expected = RuntimeException.class)
	public void removeFirstFromEmptyLinkList() {
		singlyList1.removeFirst();	
	}
	
	@Test(expected = RuntimeException.class)
	public void removeLastFromEmptyLinkList() {
		singlyList1.removeLast();	
	}
	
}

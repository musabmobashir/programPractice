package test.java.com.datastructures.linkedlist;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.*;

import main.java.com.datastructures.linkedlist.DoublyLinkedList;


public class DoublyLinkedListTest {
	DoublyLinkedList doublyList1;	

	@Before
	public void setup() {
		doublyList1 = new DoublyLinkedList();		
	}
	
	@Test
	public void testEmptyLinkedList() {
		assertEquals(0, doublyList1.getSize());
		assertTrue(doublyList1.isEmpty());
	}
	
	@Test(expected = RuntimeException.class)
	public void removeFirstFromEmptyLinkList() {
		doublyList1.removeFirst();	
	}
	
	@Test(expected = RuntimeException.class)
	public void removeLastFromEmptyLinkList() {
		doublyList1.removeLast();	
	}
	
	@Test(expected = RuntimeException.class)
	public void removeByIndexFromEmptyLinkList() {
		doublyList1.removeByIndex(1);	
	}
	
	@Test(expected = RuntimeException.class)
	public void getValueByIndexFromEmptyLinkList() {
		doublyList1.getValueByIndex(1);	
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void getValueByIndexOutOfIndexRange() {
		doublyList1.add("abc");
		doublyList1.add("qaz");
		doublyList1.getValueByIndex(10);	
	}
	
	@Test
	public void getValueByIndex() {
		doublyList1.add("abc");
		doublyList1.add("qaz");
		assertEquals("qaz", doublyList1.getValueByIndex(2));
	}
	
	@Test
	public void addToLinkedList() {
		assertTrue(doublyList1.isEmpty());
		doublyList1.add("abc");
		assertEquals(1, doublyList1.getSize());
		assertFalse(doublyList1.isEmpty());
		assertEquals("abc", doublyList1.getValueByIndex(1));
		doublyList1.add("qaz");
		assertEquals(2, doublyList1.getSize());
		assertEquals("qaz", doublyList1.getValueByIndex(2));
	}
	
	@Test
	public void addLastToLinkedList() {
		assertTrue(doublyList1.isEmpty());
		doublyList1.addLast("abc");
		assertEquals(1, doublyList1.getSize());
		assertFalse(doublyList1.isEmpty());
		assertEquals("abc", doublyList1.getValueByIndex(1));
		doublyList1.addLast("qaz");
		assertEquals(2, doublyList1.getSize());
		assertEquals("qaz", doublyList1.getValueByIndex(2));
	}
	
	@Test
	public void addFrontToLinkedList() {
		assertTrue(doublyList1.isEmpty());
		doublyList1.add("def");
		doublyList1.add("ghi");
		doublyList1.addFront("abc");
		assertEquals(3, doublyList1.getSize());
		assertFalse(doublyList1.isEmpty());
		assertEquals("abc", doublyList1.getValueByIndex(1));
	}
	
	@Test
	public void addByIndexToLinkedList() {
		assertTrue(doublyList1.isEmpty());
		doublyList1.add("def");
		doublyList1.add("jkl");
		doublyList1.addByIndex(1,"abc");
		assertEquals(3, doublyList1.getSize());
		assertFalse(doublyList1.isEmpty());
		assertEquals("abc", doublyList1.getValueByIndex(1));
		doublyList1.addByIndex(3,"ghi");
		assertEquals("ghi", doublyList1.getValueByIndex(3));
		assertEquals("jkl", doublyList1.getValueByIndex(4));
		assertEquals(4, doublyList1.getSize());
		doublyList1.addByIndex(5,"mno");
		assertEquals("mno", doublyList1.getValueByIndex(5));
		assertEquals("jkl", doublyList1.getValueByIndex(4));
		assertEquals(5, doublyList1.getSize());
	}
	@Test
	public void removeForLinkedList() {
		assertTrue(doublyList1.isEmpty());
		doublyList1.add("def");
		doublyList1.add("jkl");
		doublyList1.addByIndex(1,"abc");
		doublyList1.addByIndex(3,"ghi");
		doublyList1.addByIndex(5,"mno");
		doublyList1.removeFirst();
		assertEquals("def", doublyList1.getValueByIndex(1));
		doublyList1.removeLast();
		assertEquals("jkl", doublyList1.getValueByIndex(3));
		doublyList1.removeByIndex(2);
		assertEquals(2, doublyList1.getSize());
		assertEquals("jkl", doublyList1.getValueByIndex(2));
		doublyList1.removeAll();
		assertTrue(doublyList1.isEmpty());
	}

	@Test
	public void containsNodeForLinkedList() {
		assertTrue(doublyList1.isEmpty());
		doublyList1.add("abc");
		doublyList1.add("def");
		doublyList1.add("jkl");
		assertTrue(doublyList1.contains("def"));
	}
	
	@Test
	public void indexOfNodeForEmptyLinkedList() {
		assertTrue(doublyList1.isEmpty());
		ArrayList<Integer> indexValues = new ArrayList<Integer>();
		assertEquals(indexValues,doublyList1.indexOf("abc"));
	}
	
	@Test
	public void indexOfNodeForLinkedList_NodeDoesNotExist() {
		assertTrue(doublyList1.isEmpty());
		doublyList1.add("abc");
		doublyList1.add("def");
		doublyList1.add("jkl");
		doublyList1.add("abc");

		ArrayList<Integer> indexValues = new ArrayList<Integer>();
		assertEquals(indexValues,doublyList1.indexOf("xyz"));
	}
	
	@Test
	public void indexOfNodeForLinkedList() {
		assertTrue(doublyList1.isEmpty());
		doublyList1.add("abc");
		doublyList1.add("def");
		doublyList1.add("jkl");
		doublyList1.add("abc");

		ArrayList<Integer> indexValues = new ArrayList<Integer>();
		indexValues.add(1);
		indexValues.add(4);

		assertEquals(indexValues,doublyList1.indexOf("abc"));
	}

	@Test
	public void updateIndexValueForLinkedList() {
		assertTrue(doublyList1.isEmpty());
		doublyList1.add("abc");
		doublyList1.add("def");
		doublyList1.add("jkl");
		doublyList1.add("abc");
		doublyList1.updateNodeDataByIndex(4, "mno");
		assertTrue(doublyList1.contains("mno"));
		assertEquals("mno", doublyList1.getValueByIndex(4));		
	}

	@Test
	public void cloneLinkedList() {
		assertTrue(doublyList1.isEmpty());
		doublyList1.add("abc");
		doublyList1.add("def");
		doublyList1.add("jkl");
		doublyList1.add("abc");
		
		DoublyLinkedList newList = doublyList1.clone();	
		assertEquals(doublyList1.getSize(),newList.getSize());
		
		int count = 0;
		Iterator<String> testItr = newList.iterator();
		while(testItr.hasNext()) {
			String itrValue = testItr.next();		
			count++;
			assertEquals(itrValue,doublyList1.getValueByIndex(count));
		}	
		
		newList.updateNodeDataByIndex(4, "mno");
		
		count = 0;
		testItr = newList.iterator();
		while(testItr.hasNext()) {
			String itrValue = testItr.next();		
			count++;
			if (count == 4) {
				assertNotEquals(itrValue, doublyList1.getValueByIndex(count));
				assertEquals(itrValue,newList.getValueByIndex(count));
			} else {
				assertEquals(itrValue,doublyList1.getValueByIndex(count));
			}
		}
	}
	
	@Test
	public void iteratorForLinkedList() {
		assertTrue(doublyList1.isEmpty());
		doublyList1.add("abc");
		doublyList1.add("def");
		doublyList1.add("jkl");
		doublyList1.add("abc");
			
		int count = 0;
		Iterator<String> testItr = doublyList1.iterator();
		while(testItr.hasNext()) {
			String itrValue = testItr.next();		
			count++;
			assertEquals(itrValue,doublyList1.getValueByIndex(count));
		}
		
	}
	
}

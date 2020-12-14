package test.java.com.datastructures.linkedlist;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;

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
	
	@Test(expected = RuntimeException.class)
	public void removeByIndexFromEmptyLinkList() {
		singlyList1.removeByIndex(1);	
	}
	
	@Test(expected = RuntimeException.class)
	public void getValueByIndexFromEmptyLinkList() {
		singlyList1.getValueByIndex(1);	
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void getValueByIndexOutOfIndexRange() {
		singlyList1.add("abc");
		singlyList1.add("qaz");
		singlyList1.getValueByIndex(10);	
	}
	
	@Test
	public void getValueByIndex() {
		singlyList1.add("abc");
		singlyList1.add("qaz");
		assertEquals("qaz", singlyList1.getValueByIndex(2));
	}
	
	@Test
	public void addToLinkedList() {
		assertTrue(singlyList1.isEmpty());
		singlyList1.add("abc");
		assertEquals(1, singlyList1.getSize());
		assertFalse(singlyList1.isEmpty());
		assertEquals("abc", singlyList1.getValueByIndex(1));
		singlyList1.add("qaz");
		assertEquals(2, singlyList1.getSize());
		assertEquals("qaz", singlyList1.getValueByIndex(2));
	}
	
	@Test
	public void addLastToLinkedList() {
		assertTrue(singlyList1.isEmpty());
		singlyList1.addLast("abc");
		assertEquals(1, singlyList1.getSize());
		assertFalse(singlyList1.isEmpty());
		assertEquals("abc", singlyList1.getValueByIndex(1));
		singlyList1.addLast("qaz");
		assertEquals(2, singlyList1.getSize());
		assertEquals("qaz", singlyList1.getValueByIndex(2));
	}
	
	@Test
	public void addFrontToLinkedList() {
		assertTrue(singlyList1.isEmpty());
		singlyList1.add("def");
		singlyList1.add("ghi");
		singlyList1.addFront("abc");
		assertEquals(3, singlyList1.getSize());
		assertFalse(singlyList1.isEmpty());
		assertEquals("abc", singlyList1.getValueByIndex(1));
	}
	
	@Test
	public void addByIndexToLinkedList() {
		assertTrue(singlyList1.isEmpty());
		singlyList1.add("def");
		singlyList1.add("jkl");
		singlyList1.addByIndex(1,"abc");
		assertEquals(3, singlyList1.getSize());
		assertFalse(singlyList1.isEmpty());
		assertEquals("abc", singlyList1.getValueByIndex(1));
		singlyList1.addByIndex(3,"ghi");
		assertEquals("ghi", singlyList1.getValueByIndex(3));
		assertEquals("jkl", singlyList1.getValueByIndex(4));
		assertEquals(4, singlyList1.getSize());
		singlyList1.addByIndex(5,"mno");
		assertEquals("mno", singlyList1.getValueByIndex(5));
		assertEquals("jkl", singlyList1.getValueByIndex(4));
		assertEquals(5, singlyList1.getSize());
	}
	@Test
	public void removeForLinkedList() {
		assertTrue(singlyList1.isEmpty());
		singlyList1.add("def");
		singlyList1.add("jkl");
		singlyList1.addByIndex(1,"abc");
		singlyList1.addByIndex(3,"ghi");
		singlyList1.addByIndex(5,"mno");
		singlyList1.removeFirst();
		assertEquals("def", singlyList1.getValueByIndex(1));
		singlyList1.removeLast();
		assertEquals("jkl", singlyList1.getValueByIndex(3));
		singlyList1.removeByIndex(2);
		assertEquals(2, singlyList1.getSize());
		assertEquals("jkl", singlyList1.getValueByIndex(2));
		singlyList1.removeAll();
		assertTrue(singlyList1.isEmpty());
	}
	
	@Test
	public void containsNodeForLinkedList() {
		assertTrue(singlyList1.isEmpty());
		singlyList1.add("abc");
		singlyList1.add("def");
		singlyList1.add("jkl");
		assertTrue(singlyList1.contains("def"));
	}
	
	@Test
	public void indexOfNodeForEmptyLinkedList() {
		assertTrue(singlyList1.isEmpty());
		ArrayList<Integer> indexValues = new ArrayList<Integer>();
		assertEquals(indexValues,singlyList1.indexOf("abc"));
	}
	
	@Test
	public void indexOfNodeForLinkedList_NodeDoesNotExist() {
		assertTrue(singlyList1.isEmpty());
		singlyList1.add("abc");
		singlyList1.add("def");
		singlyList1.add("jkl");
		singlyList1.add("abc");

		ArrayList<Integer> indexValues = new ArrayList<Integer>();
		assertEquals(indexValues,singlyList1.indexOf("xyz"));
	}
	
	@Test
	public void indexOfNodeForLinkedList() {
		assertTrue(singlyList1.isEmpty());
		singlyList1.add("abc");
		singlyList1.add("def");
		singlyList1.add("jkl");
		singlyList1.add("abc");

		ArrayList<Integer> indexValues = new ArrayList<Integer>();
		indexValues.add(1);
		indexValues.add(4);

		assertEquals(indexValues,singlyList1.indexOf("abc"));
	}
	
	@Test
	public void updateIndexValueForLinkedList() {
		assertTrue(singlyList1.isEmpty());
		singlyList1.add("abc");
		singlyList1.add("def");
		singlyList1.add("jkl");
		singlyList1.add("abc");
		singlyList1.updateNodeDataByIndex(4, "mno");
		assertTrue(singlyList1.contains("mno"));
		assertEquals("mno", singlyList1.getValueByIndex(4));		
	}
	
	@Test
	public void cloneLinkedList() {
		assertTrue(singlyList1.isEmpty());
		singlyList1.add("abc");
		singlyList1.add("def");
		singlyList1.add("jkl");
		singlyList1.add("abc");
		
		SinglyLinkedList newList = singlyList1.clone();	
		assertEquals(singlyList1.getSize(),newList.getSize());
		
		int count = 0;
		Iterator<String> testItr = newList.iterator();
		while(testItr.hasNext()) {
			String itrValue = testItr.next();		
			count++;
			assertEquals(itrValue,singlyList1.getValueByIndex(count));
		}	
		
		newList.updateNodeDataByIndex(4, "mno");
		
		count = 0;
		testItr = newList.iterator();
		while(testItr.hasNext()) {
			String itrValue = testItr.next();		
			count++;
			if (count == 4) {
				assertNotEquals(itrValue, singlyList1.getValueByIndex(count));
				assertEquals(itrValue,newList.getValueByIndex(count));
			} else {
				assertEquals(itrValue,singlyList1.getValueByIndex(count));
			}
		}
	}
	
	@Test
	public void iteratorForLinkedList() {
		assertTrue(singlyList1.isEmpty());
		singlyList1.add("abc");
		singlyList1.add("def");
		singlyList1.add("jkl");
		singlyList1.add("abc");
			
		int count = 0;
		Iterator<String> testItr = singlyList1.iterator();
		while(testItr.hasNext()) {
			String itrValue = testItr.next();		
			count++;
			assertEquals(itrValue,singlyList1.getValueByIndex(count));
		}
		
	}
	
}

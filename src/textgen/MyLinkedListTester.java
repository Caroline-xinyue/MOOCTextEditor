/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
		try {
			list1.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			list1.remove(3);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			emptyList.remove(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		String s = shortList.remove(0);
		assertEquals("Remove: check s is correct ", "A", s);
		assertEquals("Remove: check element 0 is correct ", "B", shortList.get(0));
		assertEquals("Remove: check size is correct ", 1, shortList.size());
		
		try {
			shortList.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.remove(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.remove(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		list1.add(34);
		assertEquals("AddEnd: check the added element is correct ", (Integer)34, list1.get(list1.size() - 1));
		assertEquals("AddEnd: check size is correct: ", 4, list1.size());
		emptyList.add(4);
		assertEquals("AddEnd: check the added element is correct ", (Integer)4, emptyList.get(0));
		assertEquals("AddEnd: check the added element to an empty list is correct: ", (Integer)4, emptyList.get(0));
		longerList.add(50);
		assertEquals("AddEnd: check the added element is correct: ", (Integer)50, longerList.get(LONG_LIST_LENGTH));
		assertEquals("AddEnd: check size is correct: ", LONG_LIST_LENGTH + 1, longerList.size());
		shortList.add("C");
		assertEquals("AddEnd: check the added element is correct ", "C", shortList.get(shortList.size() - 1));
		assertEquals("AddEnd: check size is correct: ", 3, shortList.size());
		try {
			longerList.add(null);
			fail("Cannot add null elements");
		}
		catch (RuntimeException e) {
		
		}
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("Size: ", 0, emptyList.size());
		assertEquals("Size: ", 2, shortList.size());
		assertEquals("Size: ", 3, list1.size());
		assertEquals("Size: ", LONG_LIST_LENGTH, longerList.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		list1.add(0, 14);
		assertEquals("AddAtIndex: check the added element at index 0 is correct: ", (Integer)14, list1.get(0));
		assertEquals("AddAtIndex: check the next element at index 1 is correct: ", (Integer)65, list1.get(1));
		assertEquals("AddAtIndex: check size is correct: ", 4, list1.size());
		try {
			list1.add(-1, 14);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			list1.add(5, 45);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		emptyList.add(0, 16);
		assertEquals("AddAtIndex: check the added element at index 0 is correct: ", (Integer)16, emptyList.get(0));
		try {
			emptyList.add(2, 8);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		shortList.add(1, "C");
		assertEquals("AddAtIndex: check the added element at index 1 is correct: ", "C", shortList.get(1));
		assertEquals("AddAtIndex: check the next element at index 2 is correct: ", "B", shortList.get(2));
		assertEquals("AddAtIndex: check size is correct: ", 3, shortList.size());		
		try {
			shortList.add(-1, "P");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.add(4, "C");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}

		longerList.add(6, 53);
		assertEquals("AddAtIndex: check the added element at index 6 is correct: ", (Integer)53, longerList.get(6));
		assertEquals("AddAtIndex: check the next element at index 7 is correct: ", (Integer)6, longerList.get(7));
		assertEquals("AddAtIndex: check size is correct: ", LONG_LIST_LENGTH + 1, longerList.size());		
		
		try {
			longerList.add(-1, 48);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.add(LONG_LIST_LENGTH + 2, 3);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
		try {
			list1.add(1, null);
			fail("Cannot add null elements");
		}
		catch (RuntimeException e) {
		
		}
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
	    list1.set(0, 24);
	    assertEquals("Set: ", (Integer)24, list1.get(0));
	    assertEquals("Set: check the size: ", 3, list1.size());
		try {
			list1.set(3, 9);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			list1.set(-1, 7);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			emptyList.set(0, 8);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
	    longerList.set(8, 78);
	    assertEquals("Set: ", (Integer)78, longerList.get(8));
	    assertEquals("Set: check the size: ", LONG_LIST_LENGTH, longerList.size());
		try {
			longerList.set(LONG_LIST_LENGTH, 12);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
	    shortList.set(1, "D");
	    assertEquals("Set: ", "D", shortList.get(1));
	    assertEquals("Set: check the size: ", 2, shortList.size());
		try {
			shortList.set(2, "Z");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.set(-1, "Q");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			list1.set(1, null);
			fail("Cannot set null elements");
		}
		catch (RuntimeException e) {
		
		}
	}
	
	
	// TODO: Optionally add more test methods.
	
}

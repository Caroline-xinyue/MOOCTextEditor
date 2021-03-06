package textgen;

import java.util.AbstractList;

/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element) 
	{
		// TODO: Implement this method
		if(element == null) {throw new NullPointerException("Element cannot be null");}
		LLNode<E> addNode = new LLNode<E>(element);
		LLNode<E> last = tail.prev;
		last.next = addNode;
		addNode.prev = last;
		addNode.next = tail;
		tail.prev = addNode;
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("The index is out of bounds");
		}
		LLNode<E> temp = head.next;
		for(int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("The index is out of bounds");
		}
		if(element == null) {throw new NullPointerException("Element cannot be null");}
		LLNode<E> after = head.next;
		for(int i = 0; i < index; i++) {
			after = after.next;
		}
		LLNode<E> before = after.prev;
		LLNode<E> toAdd = new LLNode<E>(element);
		before.next = toAdd;
		toAdd.prev = before;
		toAdd.next = after;
		after.prev = toAdd;
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("The index is out of bounds");
		}
		LLNode<E> toRemove = head.next;
		for(int i = 0; i < index; i++) {
			toRemove = toRemove.next;
		}
		LLNode<E> before = toRemove.prev;
		LLNode<E> after = toRemove.next;
		before.next = after;
		after.prev = before;
		size--;
		return toRemove.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("The index is out of bounds");
		}
		if(element == null) {throw new NullPointerException("Element cannot be null");}
		LLNode<E> temp = head.next;
		for(int i = 0; i < index; i++) {
			temp = temp.next;
		}
		temp.data = element;
		return null;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}

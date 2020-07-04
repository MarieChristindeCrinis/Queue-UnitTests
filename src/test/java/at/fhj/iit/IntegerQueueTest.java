package at.fhj.iit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class IntegerQueueTest {

	/**
	 * Tests if an IntegerQueue can be created
	 */
	@Test
	void canCreateIntegerQueue() {
		
		IntegerQueue intQue = new IntegerQueue(5);
		assertNotNull(intQue);
		
	}
	
	/**
	 * Tests if method offer() returns true, while the maxSize is not reached
	 */
	@Test
	void offerReturnsTrueWhileMaxNotReached(){
		
		int maxSize = 5;
		IntegerQueue intQue = new IntegerQueue(maxSize);
		
		for(int i = 0; i < maxSize; i++) {
			assertTrue(intQue.offer(i));
		}
	}
	
	/**
	 * Tests if method offer() returns false, when the maxSize is reached
	 */
	@Test
	void offerReturnsFalseWhenMaxIsReached(){
		
		int maxSize = 0;
		IntegerQueue intQue = new IntegerQueue(maxSize);
		assertFalse(intQue.offer(1));
	}
	
	/**
	 * Tests if method poll() returns the first element and then removes it from Queue
	 */
	@Test
	void pollShouldReturnFirstElementAndRemovesItemFromQueue() {
		
		int ele = 1;
		IntegerQueue intQue = new IntegerQueue(5);
		intQue.offer(ele);
		intQue.offer(ele+1);
		
		assertEquals(ele, intQue.poll());
		
		assertNotEquals(ele, intQue.poll());
		
	}
	
	/**
	 * Tests if method poll() returns null if the queue is empty
	 */
	@Test
	void pollReturnsNullIfQueueIsEmpty() {
		
		IntegerQueue intQue = new IntegerQueue(5);
		
		assertNull(intQue.poll());
		
	}
	
	/**
	 * Tests if method remove() returns the Exception NoElementIsLeftException if no element is left
	 */
	@Test
	void removeReturnsExceptionIfNoElementIsLeft() {
		
		IntegerQueue intQue = new IntegerQueue(5);
		assertThrows(NoSuchElementException.class, () -> {intQue.remove();});
		
	}
	
	/**
	 * Tests if method remove() returns an element if there are elements to return
	 */
	@Test
	void removeReturnsElement() {
		int ele = 1;
		IntegerQueue intQue = new IntegerQueue(5);
		intQue.offer(ele);
		intQue.offer(ele+1);
		
		assertEquals(ele, intQue.remove());
		
		assertNotEquals(ele, intQue.remove());
		
	}
	
	/**
	 * Tests if method peek() returns the first element
	 */
	@Test
	void peekReturnsFirstElement() {
		int ele = 1;
		IntegerQueue intQue = new IntegerQueue(5);
		intQue.offer(ele);
		intQue.offer(ele+1);
		
		assertEquals(ele, intQue.peek());	
	}
	
	/**
	 * Tests if method peek() returns null if there is no element
	 */
	@Test
	void peekReturnsNull() {
		IntegerQueue intQue = new IntegerQueue(5);

		assertNull(intQue.peek());
	}
	
	/**
	 * Tests if method element() returns a NoElementIsLeftException if there is no element left 
	 */
	@Test
	void elementReturnsExceptionIfNoElementIsLeft() {
		IntegerQueue intQue = new IntegerQueue(5);
		assertThrows(NoSuchElementException.class, () -> {intQue.element();});
	}
	
	/**
	 * Tests if method element() returns an element
	 */
	@Test
	void elementReturnsElement() {
		int ele = 1;
		IntegerQueue intQue = new IntegerQueue(5);
		intQue.offer(ele);
		intQue.offer(ele+1);
		
		assertEquals(ele, intQue.element());
	}
}

package at.fhj.iit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class IntegerQueueTest {

	@Test
	void canCreateIntegerQueue() {
		
		IntegerQueue intQue = new IntegerQueue(5);
		assertNotNull(intQue);
		
	}
	
	@Test
	void offerReturnsTrueWhileMaxNotReached(){
		
		int maxSize = 5;
		IntegerQueue intQue = new IntegerQueue(maxSize);
		
		for(int i = 0; i < maxSize; i++) {
			assertTrue(intQue.offer(i));
		}
	}
	
	@Test
	void offerReturnsFalseWhenMaxIsReached(){
		
		int maxSize = 0;
		IntegerQueue intQue = new IntegerQueue(maxSize);
		assertFalse(intQue.offer(1));
	}
	
	@Test
	void pollShouldReturnFirstElementAndRemovesItemFromQueue() {
		
		int ele = 1;
		IntegerQueue intQue = new IntegerQueue(5);
		intQue.offer(ele);
		intQue.offer(ele+1);
		
		assertEquals(ele, intQue.poll());
		
		assertNotEquals(ele, intQue.poll());
		
	}
	
	@Test
	void pollReturnsNullIfQueueIsEmpty() {
		
		IntegerQueue intQue = new IntegerQueue(5);
		
		assertNull(intQue.poll());
		
	}
	
	@Test
	void removeReturnsExceptionIfNoElementIsLeft() {
		
		IntegerQueue intQue = new IntegerQueue(5);
		assertThrows(NoSuchElementException.class, () -> {intQue.remove();});
		
	}
	
	@Test
	void removeReturnsElement() {
		int ele = 1;
		IntegerQueue intQue = new IntegerQueue(5);
		intQue.offer(ele);
		intQue.offer(ele+1);
		
		assertEquals(ele, intQue.remove());
		
		assertNotEquals(ele, intQue.remove());
		
	}
	
	@Test
	void peekReturnsFirstElement() {
		int ele = 1;
		IntegerQueue intQue = new IntegerQueue(5);
		intQue.offer(ele);
		intQue.offer(ele+1);
		
		assertEquals(ele, intQue.peek());	
	}
	
	@Test
	void peekReturnsNull() {
		IntegerQueue intQue = new IntegerQueue(5);

		assertNull(intQue.peek());
	}
	
	@Test
	void elementReturnsExceptionIfNoElementIsLeft() {
		IntegerQueue intQue = new IntegerQueue(5);
		assertThrows(NoSuchElementException.class, () -> {intQue.element();});
	}
	
	@Test
	void elementReturnsElement() {
		int ele = 1;
		IntegerQueue intQue = new IntegerQueue(5);
		intQue.offer(ele);
		intQue.offer(ele+1);
		
		assertEquals(ele, intQue.element());
	}
}

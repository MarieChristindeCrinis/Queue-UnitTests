package at.fhj.iit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

class StringQueueTest {


    /**
     * Here we test the pool method of the StringQueue
     */
    @Test
    public void testStringQueuePool() {
        StringQueue queue = new StringQueue(5);
        String testString = "Nr. 1";
        queue.offer("Nr. 1");
        String test = queue.poll();
        assertEquals(testString, test);
    }

    /**
     * Here we test the remove method and it's exceptions of the StringQueue
     */
    @Test
    public void testStringQueueRemove() {
        StringQueue queue = new StringQueue(1);
        queue.offer("test");
        String test = queue.remove();
        assertEquals("test", test);
        try {
            queue.remove();
        } catch(NoSuchElementException ex) {
            assertEquals("there's no element any more", ex.getMessage());
        }
    }

    /**
     * Here we test the element method and it's exception of the StringQueue
     */
    @Test
    public void testStringQueueElement() {
        StringQueue queue = new StringQueue(1);
        try{
            queue.element();
        } catch (NoSuchElementException ex) {
            assertEquals("there's no element any more", ex.getMessage());
        }
        queue.offer("test");
        String test = queue.element();
        assertEquals("test", test);
    }

    /**
     * Here we test the offer method of the StringQueue
     */
    @Test
    public void testStringQueueOffer() {
        StringQueue queue = new StringQueue(1);
        boolean check = queue.offer("blabla");
        assertEquals(true,check);
        check = queue.offer("yikes");
        assertEquals(false,check);
    }
}
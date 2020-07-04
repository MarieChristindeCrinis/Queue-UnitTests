package at.fhj.iit;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class IntegerQueue implements IIntegerQueue{

	private List<Integer> elements = new ArrayList<Integer>();
	  private int maxSize = 5;

	  public IntegerQueue(int maxsize) {
	    maxSize = maxsize;
	  }

	  @Override
	  public boolean offer(int obj) {
	    if (elements.size() != maxSize)
	      elements.add(obj);
	    else
	      return false;

	    return true;
	  }

	  @Override
	  public Integer poll() {
	    Integer element = peek();

	    if (elements.size() > 0) {
	      elements.remove(0);
	    }

	    return element;
	  }

	  @Override
	  public Integer remove() {
	    Integer element = poll();
	   
	    if (element == null)
	      throw new NoSuchElementException("there's no element any more");

	    return element;
	  }

	  @Override
	  public Integer peek() {
	    Integer element;
	    if (elements.size() > 0)
	      element = elements.get(0);
	    else
	      element = null;

	    return element;
	  }

	  @Override
	  public Integer element() {
	    Integer element = peek();
	    if (element == null)
	      throw new NoSuchElementException("there's no element any more");

	    return element;
	  }
}

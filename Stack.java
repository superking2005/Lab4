// Lab 3 - Lists, Stacks, and Queues
// Alexander Mochizuki & Saranya Kolachana
// Demonstrates the linked list, stack, and queue ADTs.

package lab4;

public class Stack extends SinglyLinkedList {
	public Stack() {
		super();
	}
	
	// Adds a LinkNode to the top of the stack.
	public void push(Currency toPush) {
		try {
		super.addCurrency(toPush, 0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// Removes a LinkNode from the top of the stack and returns its Currency.
	public Currency pop() {
		Currency headData = getStart().getData();
		try {
		super.removeCurrency(0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return headData;
	}
	
	// Returns the Currency of the LinkNode at the top of the stack without removing it.
	public Currency peek() {
		Currency top = getStart().getData();
		return top;
	}
			
	// Returns a string signifying contents, top-bottom, tab-spaced.
	public String printStack() {
		LinkNode currNode = getStart();
		String toReturn = "";
		// Am I allowed to use getCount()? Should i go until hitting null, instead?
		for (int i = 0; i < getCount() - 1; i++) {
			toReturn += currNode.getData().print() + "\t";
			currNode = currNode.getNext();
		}
		toReturn += currNode.getData().print();
		return toReturn;
	}
	
	// TODO: Destructor?
	
	// I've overrriden methods that shouldn't be used.
	@Override
	public void addCurrency(Currency toAdd, int index) throws Exception {
		throw new Exception("You shouldn't be able to use addCurrency() on a Stack.");
	}
	
	@Override
	public Currency removeCurrency(Currency toRemove) throws Exception {
		try {
			throw new Exception("You shouldn't be able to use removeCurrency() on a Stack.");
		} catch (Exception disallowedMethod) {
			throw disallowedMethod;
		}
	}
	
	@Override
	public Currency removeCurrency(int index) throws Exception {
		throw new Exception("You shouldn't be able to use removeCurrency() on a Stack.");
	}
	
	@Override
	public int findCurrency(Currency toFind) throws Exception {
		throw new Exception("You shouldn't be able to use findCurrency() on a Stack.");
	}
	
	@Override
	public Currency getCurrency(int index) throws Exception {
		throw new Exception("You shouldn't be able to use getCurrency() on a Stack.");
	}

	
	

}

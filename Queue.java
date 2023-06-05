// Lab 4 - Binary Search Trees
// Alexander Mochizuki & Saranya Kolachana
// Demonstrates a BST with user interactivity.

package lab4;

public class Queue extends SinglyLinkedList {
	public Queue() {
		super();
	}
	// Adds a LinkNode to the back of the line.
	// TODO: create a template version
	// CHANGED: enqueues BSTNode obj instead of Currency obj.
	public void enqueue(Currency toEnqueue) {
		// Add to end of queue;
		try {
			super.addCurrency(toEnqueue, this.getCount());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// Removes a LinkNode from the front of the line and returns its Currency.
	public Currency dequeue() throws Exception {
		try {
			Currency front = super.removeCurrency(0);
			// Remove front
			return front;
		} catch (Exception e) {
			throw e;
		}
	}

	// Returns the front's Currency without removing it.
	public Currency peekFront() {
		Currency front = getStart().getData();
		return front;
	}

	// Returns the rear's Currency.
	public Currency peekRear() {
		Currency toReturn = this.getEnd().getData();
		return toReturn;
	}

	// Returns the Queue's LinkNodes as a string.
	public String printQueue() {
		String toReturn = "";
		LinkNode currNode = this.getStart();
		for (int i = 0; i < this.getCount() - 1; i++) {
			toReturn += currNode.getData().print() + "\t";
			currNode = currNode.getNext();
		}
		toReturn += currNode.getData().print();
		return toReturn;
	}

	@Override
	public void addCurrency(Currency toAdd, int index) throws Exception {
		throw new Exception("You shouldn't be able to use addCurrency() on a Queue.");
	}

	@Override 
	public Currency removeCurrency(Currency toRemove) throws Exception {
		throw new Exception("You shouldn't be able to use removeCurrency on a Queue.");
	}
	
	@Override 
	public Currency removeCurrency(int index) throws Exception {
		throw new Exception("You shouldn't be able to use removeCurrency on a Queue.");
	}
	
	@Override
	public int findCurrency(Currency toFind) throws Exception {
		throw new Exception("You shouldn't be able to use findCurrency() on a Queue.");
	}
	
	@Override
	public Currency getCurrency(int index) throws Exception {
		throw new Exception("You shouldn't be able to use getCurrency() on a Queue.");
	}
	
}



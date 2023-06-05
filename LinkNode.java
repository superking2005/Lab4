// Lab 3 - Lists, Stacks, and Queues
// Alexander Mochizuki & Saranya Kolachana
// Demonstrates the linked list, stack, and queue ADTs.

package lab4;

public class LinkNode {
	private Currency data;
	private LinkNode next;
	// private int pseudoIndex;
	
	public LinkNode() {
		data = null;
		next = null;
	}
	
	public LinkNode(Currency data, LinkNode next) {
		this.data = data;
		this.next = next;
	}
	
	public LinkNode(LinkNode toCopy) {
		data = toCopy.getData();
		next = toCopy.getNext();
	}

	public Currency getData() {
		return data;
	}

	public LinkNode getNext() {
		return next;
	}

	public void setData(Currency data) {
		this.data = data;
	}

	public void setNext(LinkNode next) {
		this.next = next;
	}
	
	// Sets this info to another LinkNode's info at a moment.
	// Pre: toCopy - a LinkNode.
	// Post: this's data is toCopy's.
	// Return: void.
	public void copy(LinkNode toCopy) {
		data = toCopy.getData();
		next = toCopy.getNext();
	}
	
}

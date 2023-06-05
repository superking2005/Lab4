// Lab 3 - Lists, Stacks, and Queues
// Alexander Mochizuki & Saranya Kolachana
// Demonstrates the linked list, stack, and queue ADTs.

package lab4;

public class SinglyLinkedList {
	private int count;
	private LinkNode start;
	private LinkNode end;
	
	public SinglyLinkedList() {
		count = 0;
		start = null;
		end = null;
	}
	
	public SinglyLinkedList(int count, LinkNode start, LinkNode end) {
		this.count = count;
		this.start = start;
		this.end = end;
	}
	
	public SinglyLinkedList(SinglyLinkedList toCopy) {
		count = toCopy.getCount();
		start = toCopy.getStart();
		end = toCopy.getEnd();
	}
	
	public int getCount() {
		return count;
	}
	public LinkNode getStart() {
		return start;
	}
	public LinkNode getEnd() {
		return end;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	public void setStart(LinkNode start) {
		this.start = start;
	}
	public void setEnd(LinkNode end) {
		this.end = end;
	}
	
	// Add the currency to the list at index. 
	// Pre: toAdd - Currency object to the list
	//	index - The "index" of the node to add toAdd to.
	// Post: New node inserted. count is incremented.
	// Return: void.
	public void addCurrency(Currency toAdd, int index) throws Exception { // TODO: Add 'throws'.
		// Turn the currency into a node, then insert node.
		LinkNode newNode = new LinkNode(toAdd, null);
		// int currIndex = 0;
		// LinkNode prevNode
		LinkNode currNode = start;
		// LinkNode nextNode
		
		// Insufficient items for index
		if (index > count || index < 0) {
			// TODO: throw except.
			throw new Exception("There isn't a index " + index);
		}
		
		// Special case: index is 0.
		if (index == 0) {
			// TODO: Verify that this doesn't end up referencing itself.
			newNode.setNext(start);
			// this.setStart(newNode)
			start = newNode;
			// System.out.println("start is now " + start.getData().print());
		} else {
			// This should get the LinkNode before the index.
			for (int i = 0; (currNode != null) && i < index - 1; i++) {
				currNode = currNode.getNext();
			}
			newNode.setNext(currNode.getNext()); // Might be null, but that's ok.
			currNode.setNext(newNode);
		}
		// Update tail if needed.
		if (index == count) {
			end = newNode;
		}
		count++;
		// System.out.println("count is now: " + count);
	}
	
	// Removes the first LinkNode that has data equal to toRemove, if existent.
	// Pre: toRemove - a Currency of the same type as that of the list.
	// Post: The first LinkNode that matched is removed. Any relevant ptrs updated.
	// Return: A Currency obj matching toRemove, or null.
	public Currency removeCurrency(Currency toRemove) throws Exception {
		LinkNode currNode = start;
		LinkNode toReturn;
		
		// Special case: remove the first LinkNode
		if (start.getData().isEqual(toRemove)) {
			// I see 3 ways to remove the first LinkNode.
			toReturn = start; // TODO: Reference changes. If I use copyConstructor, 
			// TORETURN = new LinkNode(start)
			// TORETURN.copy(start)
			start = start.getNext(); // Will this make toRurn = start.getNext()?
		} else {
			// Should keep going until cN is just before tR.
			while (!(currNode.getNext().getData().isEqual(toRemove))) {
				currNode = currNode.getNext();
			}
			toReturn = currNode.getNext();
			currNode.setNext(currNode.getNext().getNext());
			}
		// TODO: Clean up the deleted node.
		if (toReturn.getData() != null) {
			count--;
		}
		return toReturn.getData();
	}
	
	// Removes a LinkNode at the pseudo "index" and returns the Currency obj.
	// Pre: index - a non-neg int 0 - count-1.
	// Post: The LinkNode at the pseudo "index", if exists, is removed.
	// Return: The Currency of the LinkNode, or null.
	public Currency removeCurrency(int index) throws Exception {
		LinkNode currNode = start;
		LinkNode toReturn; //TODO: convert to Currency.
		// Special case: Remove index 0.
		if (index == 0) {
			toReturn = new LinkNode(start);
			start = start.getNext();
		} else {
			for (int i = 0; (currNode != null) && i < index - 1; i++) { //TODO: verify that this works.
				currNode = currNode.getNext();
			}
			toReturn = currNode.getNext(); // TODO: Verify PbR DN cause problems.
			currNode.setNext(currNode.getNext().getNext());
			
		}
		if (toReturn.getData() != null) {
			count--;
		}
		return toReturn.getData();
	}
	
	// Returns index of first LinkNode with matching Currency.
	// Pre: toFind - a Currency to search the list for.
	// Post: none.
	// Return: int representing "index" of item, or -1 if item is not found,
	public int findCurrency(Currency toFind) throws Exception {
		int toReturn = 0;
		LinkNode currNode = start;
		// TODO: Tidy up the try/catch.
		try {
			while (currNode != null && !(currNode.getData().isEqual(toFind))) {
				currNode = currNode.getNext();
				toReturn++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return index of
		// 
		if (currNode == null) {
			return -1;
		} else {
			// count--;
			return toReturn;
		}
	}
	
	// Returns the Currency at the given index.
	// Pre: index: int less than or equal to count.
	// Post: none.
	// Return: a Currency object, or maybe an Exception.
	public Currency getCurrency(int index) throws Exception {
		if (index >= count) {
			// System.out.println("TODO: Throw. index DNE.");
		}
		LinkNode currNode = start;
		for (int i = 0; i < index; i++) {
			currNode = currNode.getNext();
		}
		return currNode.getData();
	}
	
	// Returns a String with all Currency object values.
	// Pre: none.
	// Post: none.
	// Return: String with List's LinkNodes' Currency
	public String printList() {
		LinkNode currNode = start;
		String toReturn = "";
		// boolean isCurrNodeNull;
		// System.out.println("Count" + count);
		for (int i = 0; i < count - 1; i++) {
			// isCurrNodeNull = (currNode == null);
			// System.out.println("currNode == null: " + isCurrNodeNull + i);
			// System.out.println(currNode.getData().print());
			toReturn += (currNode.getData().print() + "\t");
			currNode = currNode.getNext();
		}
		// Now on the Tail.
		toReturn += currNode.getData().print();
		return toReturn;
	}
	
	// Returns true if 0 LinkNodes in list.
	// Pre: none.
	// Post: none.
	// Return: true or false.
	public boolean isListEmpty() {
		// countCurrency() // May need to refresh.
		if (count == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	// Counts number of LinkNodes in the list.
	// pre: none.
	// post: none.
	// Return: int number of LinkNodes.
	public int countCurrency() {
		int toReturn = 0;
		LinkNode currNode = start;
		while (currNode != null) {
			toReturn++;
			currNode = currNode.getNext();
		}
		return toReturn;
	}

}

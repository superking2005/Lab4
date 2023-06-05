// Lab 4 - Binary Search Trees
// Alexander Mochizuki & Saranya Kolachana
// Demonstrates a BST with user interactivity.

package lab4;

public class BST {
	private BSTNode root;
	private int height;

	public BSTNode getRoot() {
		return root;
	}

	public int getHeight() {
		return height;
	}

	public void setRoot(BSTNode root) {
		this.root = root;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String breadthFirst() throws Exception {
		return breadthFirst(root);
	}
	
	public String breadthFirst(BSTNode node) throws Exception {
		BSTNode curNode = node;
		String toReturn = "";
		// TODO: add queues.
		Queue bfQueue = new Queue(); // TODO: FIX the fact that queue takes currencies
		while (curNode != null) {
			toReturn += node.getData().print() + " ";
			if (curNode.getLeftChild() != null) {
				bfQueue.enqueue(curNode.getLeftChild().getData());
			}
			if (curNode.getRightChild() != null) {
				bfQueue.enqueue(curNode.getRightChild().getData());
			}
			if (!(bfQueue.isListEmpty())) {
				curNode = this.searchRecur(root, bfQueue.dequeue());
			} else {
				curNode = null;
			}
		}
		return toReturn;
	}

	// Trav bi Tree in LNR seq
	public String inOrder(BSTNode node) {
		String toReturn = "";
		if (node != null) {
			toReturn += inOrder(node.getLeftChild());
			// DOES NOT actually print
			toReturn += node.getData().print() + " ";
			toReturn += inOrder(node.getRightChild());
		}
		return toReturn;
	}
	
	public String inOrder() {
		return inOrder(root);
	}
	
	// Travers binary tree in NLR seq
	public String preOrder(BSTNode node) {
		String toReturn = "";
		if (node != null) {
			// TODO: Figure out how to process node
			toReturn = node.getData().print() + " ";
			toReturn += preOrder(node.getLeftChild());
			toReturn += preOrder(node.getRightChild());
		}
		return toReturn;
	}
	
	public String preOrder() {
		return preOrder(root);
	}

	// Trav bi tree in LRN seq
	public String postOrder(BSTNode node) {
		String toReturn = "";
		if (node != null) {
			toReturn += postOrder(node.getLeftChild());
			toReturn += postOrder(node.getRightChild());
			toReturn += node.getData().print() + " ";
		}
		return toReturn;
	}
	
	public String postOrder() {
		return postOrder(root);
	}

	public BSTNode searchIter(Currency key) throws Exception {
		BSTNode cur = root;
		while (cur != null) {
			if (key.isEqual(cur.getData())) {
				return cur;
			} else if (cur.getData().isGreater(key)) {
				cur = cur.getLeftChild();
			} else {
				cur = cur.getRightChild();
			}
		}
		return null;
	}

	public BSTNode searchRecur(BSTNode currentNode, Currency searchKey) throws Exception {
		if (currentNode == null) {
			return null;
		} else if (currentNode.getData().isEqual(searchKey)) {
			return currentNode;
		} else if (currentNode.getData().isGreater(searchKey)) {
			return searchRecur(currentNode.getLeftChild(), searchKey);
		} else if (searchKey.isGreater(currentNode.getData())) {
			return searchRecur(currentNode.getRightChild(), searchKey);
		}
		return null;
	}
	
	public BSTNode searchRecur(BSTNode currentNode, double searchVal) throws Exception {
		return searchRecur(currentNode, new Krone(searchVal));
	}

	public void insert(BSTNode newNode) throws Exception {
		if (root == null) {
			root = newNode;
		} else {
			BSTNode curN = root;
			while (curN != null) {
				if (curN.getData().isGreater(newNode.getData())) {
					if (curN.getLeftChild() == null) {
						curN.setLeftChild(newNode);
						curN = null;
					} else {
						curN = curN.getLeftChild();
					}
				} else {
					if (curN.getRightChild() == null) {
						curN.setRightChild(newNode);
						curN = null;
					} else {
						curN = curN.getRightChild();
					}
				}
			}
		}
	}
	
	public void insert(double amt) throws Exception {
		BSTNode newNode = new BSTNode(amt);
		insert(newNode);
	}
	
	public void insert(Currency currencyToIns) throws Exception {
		BSTNode newNode = new BSTNode(currencyToIns);
		insert(newNode);
	}

	public void delete(Currency toRemove) throws Exception {
		BSTNode par = null;
		BSTNode cur = root;
		// Search for node
		while (cur != null) {
			// If node found
			if (cur.getData().isEqual(toRemove)) {
				// 0 children (node is leaf)
				if (cur.getLeftChild() == null && cur.getRightChild() == null) {
					// If node is root
					if (par == null) {
						root = null;
					} else {
						// Node is NOT root
						if (par.getLeftChild() == cur) {
							par.setLeftChild(null);
						} else {
							par.setRightChild(null);
						}
					}
				} else if (cur.getRightChild() == null) {
				// Node has 1 child (left)
				if (par == null) {
					// Node is root
					root = cur.getLeftChild();
				} else {
					if (par.getLeftChild() == cur) {
						par.setLeftChild(cur.getLeftChild());
					} else {
						par.setRightChild(cur.getLeftChild());
					}
				}
			} else if (cur.getLeftChild() == null) {
				// Node has only right child
				if (par == null) {
					// Node is root
					root = cur.getRightChild();
				} else {
					if (par.getLeftChild() == cur) {
						par.setLeftChild(cur.getRightChild());
					} else {
						par.setRightChild(cur.getRightChild());
					}
				}
			} else {
				// The node to be removed has 2 children
				// Find successor (or maybe use predecessor?)
				BSTNode suc = cur.getRightChild();
				while (suc.getLeftChild() != null) {
					suc = suc.getLeftChild();
				}
				Currency sucData = suc.getData();
				delete(suc.getData());
				cur.setData(sucData);
			}
			// Node found and removed
			return;
			} else {
				// Node NOT YET found
				par = cur;
				if (cur.getData().isGreater(toRemove)) {
					// Search left subtree
					cur = cur.getLeftChild();
				} else {
					// Search right subtree
					cur = cur.getRightChild();
					

			}
				
			}
		}  
	}
	
	public void delete(double toRemove) throws Exception {
		delete(new Krone(toRemove));
	}
	
	// 
	public String printTree(BSTNode node) {
		String output = "";
		// TODO: Handle null roots.
		//TODO: handle spacing
		output += node.getData().print();
		if (node.getLeftChild() != null || node.getRightChild() != null) {
			output += "(";
			// LeftC & RightChild are independent, so structure is messy.
			if (node.getLeftChild() != null) {
				printTree(node.getLeftChild());
			}
			if (node.getRightChild() != null) {
				if (node.getLeftChild() != null) {
					output += " ";
				}
				printTree(node.getRightChild());
			}
			output += ")";
		}
		return output;
	}
	
	public String print(BSTNode node) {
		int travMtd;
		System.out.println("Select traversal method:");
		System.out.println("\t1: Breadth-first");
		System.out.println("\t2: In-order");
		System.out.println("\t3: Pre-order");
		System.out.println("\t4: Post-order");
		System.out.println("\t5: All of the above");
		return null;
	}

	public int count() {
		int count = 0;
		BSTNode cur = root;
		// TODO: Traverse BST
		return count(cur);
	}
	
	private int count(BSTNode node) {
		if (node != null) {
			return (1 + count(node.getLeftChild()) + count(node.getRightChild()));
		} else {
			return 0;
		}
	}

	public boolean isEmpty() {
		return (count() == 0);

	}

	public void empty() {
		root = null;
		height = 0;
	}
}

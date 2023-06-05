package lab4;

public class BSTNode {
	private Currency data;
	private BSTNode leftChild;
	private BSTNode rightChild;
	
	public BSTNode() {
		
	}
	
	public BSTNode(Currency data) {
		this.data = data;
	}
	public BSTNode(Currency data, BSTNode leftChild, BSTNode rightChild) {
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	// Pre: amt is non-negative.
	public BSTNode(double amt) throws Exception {
		data = new Krone(amt);
	}
	
	public Currency getData() {
		return data;
	}
	public BSTNode getLeftChild() {
		return leftChild;
	}
	public BSTNode getRightChild() {
		return rightChild;
	}
	public void setData(Currency data) {
		this.data = data;
	}
	public void setLeftChild(BSTNode leftChild) {
		this.leftChild = leftChild;
	}
	public void setRightChild(BSTNode rightChild) {
		this.rightChild = rightChild;
	}

}

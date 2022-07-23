package Assign2;

public class Pair<L, R> {
	  
	private L left;
	private R right;

	public Pair() {
		this.left = null;
	    this.right = null;
	}

	public Pair(L left, R right) {
		this.left = left;
	    this.right = right;
	}

	public L getLeft() {
		return left;
	}

	public R getRight() {
		return right;
	}

	public void setLeft(L left) {
		this.left = left;
	}

	public void setRight(R right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return String.format("(%s, %s)", getLeft().toString(), getRight().toString());
	}
}

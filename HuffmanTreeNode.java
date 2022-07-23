package Assign2;

/**
 * HuffmanTreeNode
 */
public class HuffmanTreeNode implements Comparable<HuffmanTreeNode> {

	private Character character;
	private Integer frequency;
	private HuffmanTreeNode left, right;
	
	public HuffmanTreeNode() {
		this.character = '\0';
		this.frequency = 0;
		this.left = null;
		this.right = null;
	}

	public HuffmanTreeNode(Character character, Integer frequency) {
		this.character = character;
		this.frequency = frequency;
		this.left = null;
		this.right = null;
	}

	public Character getCharacter() {
		return character;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public HuffmanTreeNode getLeft() {
		return left;
	}

	public HuffmanTreeNode getRight() {
		return right;
	}

	public void setCharacter(char character) {
		this.character = character;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public void setLeft(HuffmanTreeNode left) {
		this.left = left;
	}

	public void setRight(HuffmanTreeNode right) {
		this.right = right;
	}

	public int compareTo(HuffmanTreeNode other) {
		if (other == null) {
		return -1;
		}
	return this.frequency - other.getFrequency();
	}

	@Override
	public String toString() {
		return String.format("(%s, %s)", character.toString(), frequency.toString());
	}
}
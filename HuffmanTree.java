package Assign2;

public class HuffmanTree {
	  
	private HuffmanTreeNode root;

	public HuffmanTree() {
		this.root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public HuffmanTreeNode getRoot() {
		return root;
	}

	public void buildTree(PriorityQueue<HuffmanTreeNode> q) {
		while (q.getSize() > 1) {
			HuffmanTreeNode leftSubTree, rightSubTree, newNode;
			leftSubTree = q.removeNext();
			rightSubTree = q.removeNext();
			newNode = new HuffmanTreeNode(null, leftSubTree.getFrequency() + rightSubTree.getFrequency());
			newNode.setLeft(leftSubTree);
			newNode.setRight(rightSubTree);
			q.addElement(newNode);
		}
		this.root = q.removeNext();
	}

	public void getHuffmanCodes(HuffmanFrequencyTable huffmanFrequencyTable) {
		getCodes(huffmanFrequencyTable, root, "");
	}

	private void getCodes(HuffmanFrequencyTable huffmanFrequencyTable, HuffmanTreeNode node, String code) {
		if (node.getLeft() == null && node.getRight() == null) {
			huffmanFrequencyTable.setCode(node.getCharacter(), code);
			return;
		}
		getCodes(huffmanFrequencyTable, node.getLeft(), code.concat("0"));
		getCodes(huffmanFrequencyTable, node.getRight(), code.concat("1"));
	}
}

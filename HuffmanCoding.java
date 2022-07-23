package Assign2;

public class HuffmanCoding {
	private String text;
	private HuffmanFrequencyTable huffmanFrequencyTable;
	private HuffmanTree huffmanTree;

	public HuffmanCoding(String text) {
		this.text = text;
	    huffmanFrequencyTable = new HuffmanFrequencyTable(text);

	// Creating PriorityQueue for characters
	    PriorityQueue<HuffmanTreeNode> q = new PriorityQueue<>();
	    for (Character character : huffmanFrequencyTable.getCharacterOrderList()) {
	    	q.addElement(new HuffmanTreeNode(character, huffmanFrequencyTable.getFrequencyCodePair(character).getLeft()));
	    }
    
    // Creating HuffmanTree
    huffmanTree = new HuffmanTree();
    huffmanTree.buildTree(q);
    huffmanTree.getHuffmanCodes(huffmanFrequencyTable);
	}

	public HuffmanFrequencyTable getHuffmanFrequencyTable() {
		return huffmanFrequencyTable;
	}

	public HuffmanTree getHuffmanTree() {
		return huffmanTree;
	}

	public static String encode(String text) {
		HuffmanCoding huffmanCoding = new HuffmanCoding(text);
		HuffmanFrequencyTable huffmanFrequencyTable = huffmanCoding.getHuffmanFrequencyTable();
		StringBuilder encodedText = new StringBuilder();
		for (Character character : text.toCharArray()) {
			encodedText.append(huffmanFrequencyTable.getCode(character));
		}
		return encodedText.toString();
	}

	public static String encode(String text, HuffmanCoding huffmanCoding) {
		if (huffmanCoding == null) {
			huffmanCoding = new HuffmanCoding(text);
		}
		HuffmanFrequencyTable huffmanFrequencyTable = huffmanCoding.getHuffmanFrequencyTable();
		StringBuilder encodedText = new StringBuilder();
		for (Character character : text.toCharArray()) {
			encodedText.append(huffmanFrequencyTable.getCode(character));
		}
		return encodedText.toString();
	}

	public static String decode(String encodedStream, HuffmanCoding huffmanCoding) {
		HuffmanTree huffmanTree = huffmanCoding.getHuffmanTree();
		HuffmanTreeNode node = huffmanTree.getRoot();
		StringBuilder decodedStream = new StringBuilder();

		while (encodedStream.length() > 0) {
			char character = encodedStream.charAt(0);
			switch (character) {
			case '0':
				node = node.getLeft();
				break;
			case '1':
				node = node.getRight();
				break;
			}

			if (node.getLeft() == null && node.getRight() == null) {
				decodedStream.append(node.getCharacter());
				node = huffmanTree.getRoot();
			}
			encodedStream = encodedStream.substring(1);
		}
		return decodedStream.toString();
	}
}

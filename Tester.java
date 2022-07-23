package Assign2;
public class Tester {
	  
	public static void main(String[] args) {
		
		if (args.length < 1) {
			System.err.println("One argument is needed to run this program.");
			return;
		}
		
		String text = args[0];
		
	
		
		//String 
   
		// Testing HuffmanFrequencyTable

		// Creating HuffmanCoding object
		HuffmanCoding huffmanCoding = new HuffmanCoding(text);  
		HuffmanFrequencyTable huffmanFrequencyTable = huffmanCoding.getHuffmanFrequencyTable();
		System.out.println("% java Tester "+ "'" + text + "'");
		System.out.println("=======================================================");
		System.out.println(String.format("%-15s%-20s%-20s", "char", "frequency", "code"));
		System.out.println("-------------------------------------------------------");
		for (Character character : huffmanFrequencyTable.getCharacterOrderList()) {
			Pair<Integer, String> frequencyCodePair = huffmanFrequencyTable.getFrequencyCodePair(character);
			System.out.println(String.format("%-15s%-20s%-20s", character.toString(), frequencyCodePair.getLeft().toString(), frequencyCodePair.getRight().toString()));
		}
	System.out.println("=======================================================");
	System.out.println("Encoded bit stream:");
	String encodedStream = HuffmanCoding.encode(text, huffmanCoding);
	System.out.println(encodedStream);
	System.out.println(String.format("Total number of bits without Huffman coding (8-bits per character): %d", text.length() * 8));
	System.out.println(String.format("Total number of bits with Huffman coding: %d", encodedStream.length()));
	System.out.println(String.format("Compression ratio: %.2f", (double)(text.length() * 8) / encodedStream.length()));
	System.out.println(String.format("Decoded String: %s", HuffmanCoding.decode(encodedStream, huffmanCoding)));	  
	}
}

package Assign2;

import java.util.ArrayList;
import java.util.HashMap;

public class HuffmanFrequencyTable {

	ArrayList<Character> characterOrderList;
	private HashMap<Character, Pair<Integer, String>> table;

	public HuffmanFrequencyTable() {
		characterOrderList = new ArrayList<>();
		table = new HashMap<>();
	}

	public HuffmanFrequencyTable(String text) {
		characterOrderList = new ArrayList<>();
		table = new HashMap<>();
		createHuffmanTable(text);
	}

	public void createHuffmanTable(String text) {
		Pair<Integer, String> pair;
		for (Character character : text.toCharArray()) {
			if (table.containsKey(character)) {
				pair = table.get(character);
				pair.setLeft(pair.getLeft() + 1);
      } else {
    	  pair = new Pair<>(1, "");
    	  table.put(character, pair);
    	  characterOrderList.add(character);
			}
		}
	}

	public HashMap<Character, Pair<Integer, String>> getTable() {
		return table;
	}

	public ArrayList<Character> getCharacterOrderList() {
		return characterOrderList;
	}

	public Pair<Integer, String> getFrequencyCodePair(Character character) {
		return table.getOrDefault(character, null);
	}
  
	public String getCode(Character character) {
		return table.get(character).getRight();
	}

	public void setCode(Character character, String code) {
		table.get(character).setRight(code);
	}
}

package com.example.gofish;

import java.util.ArrayList;
import java.util.Random;

public class Deck implements Constants {

	public ArrayList<Card> deck;

	public Deck(String size) {
		deck = new ArrayList<Card>();
		for (int i = 1; i < 5; i++) {
			if (size.equals("Big")) {
				for (int j = 2; j < 15; j++) {
					deck.add(new Card(i, j));
				}
			}
			else {
				for (int j = 10; j < 15; j++) {
					deck.add(new Card(i, j));
				}
			}
		}
	}
	
	public Card removeCard(int index){
		
		return deck.remove(index);
		
	}
	
	public Card nextCard(){
		Random rand = new Random();
		if(deck.size()>1){
		return deck.remove(rand.nextInt(deck.size()-1));
		}
		else if(deck.size() == 1) return deck.remove(0);
		else return null;
	}
	
	public String toString(){
		StringBuilder ret = new StringBuilder();
		for( Card card : deck){
			ret.append(card.toString()).append("\n");			
		}
		return ret.toString();
	}

}

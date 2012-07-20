package com.example.gofish;

import java.util.ArrayList;

public class Deck implements Constants {

	public ArrayList<Card> deck;

	public Deck(String size) {
		deck = new ArrayList<Card>();
		for (int i = 0; i < 3; i++) {
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

}

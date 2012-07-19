package com.example.gofish;

import java.util.ArrayList;

public class Deck implements Constants{
	
	ArrayList<Card> deck;
	
	
	public Deck(String size){
		if(size.equals("Big")){
			for(int i = 0; i<4; i++){
				for(int j = 0; j<12; i++){
					Card card = new Card(i, j);
					deck.add(card);
				}
				
			}
		}
	}
	

}

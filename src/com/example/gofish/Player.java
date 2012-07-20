package com.example.gofish;

import java.util.ArrayList;

public class Player implements Constants {
	
	ArrayList<Card> hand;
	String name;
	Boolean isTurn=false;
	
	public Player(String name){
		hand = new ArrayList<Card>();
		this.name = name;
	}
	
	public void addCard(Card card){
		hand.add(card);
	}
	
	public String toString(){
		StringBuilder ret = new StringBuilder().append(name).append(" has (");
		for(Card card : hand){
			ret.append(card.toString()).append(", ");
		}
		//get rid of trailing ", "
		ret.deleteCharAt(ret.length()-1);
		ret.deleteCharAt(ret.length()-1);
		ret.append(")");
			
		return ret.toString();
	}

}

package com.example.gofish;

import java.util.ArrayList;

public class Player implements Constants {
	
	public static boolean emptyHand = false;
	
	public ArrayList<Card> hand;
	public String name;
	public Boolean isTurn=false;
	public ArrayList<Player> otherPlayers;
	
	public Player(String name){
		hand = new ArrayList<Card>();
		this.name = name;
	}
	
	public void addCard(Card card){
		hand.add(card);
	}
	
	public void addOtherPlayers(ArrayList<Player> players){
		otherPlayers = (ArrayList<Player>) players.clone();
		otherPlayers.remove(this);
	}
	
	public Card hasCard(int number){
		Card card = null;
		for(int i = 0; i<hand.size(); i++){
			card = hand.get(i);
			if(card.number == number){
				card = hand.remove(i);
			}
		}
		return card;
		
	}
	
	public void takeTurn(){
		//find multiples of any card
		int number = findMultiples();
		
		//ask random player for one of those cards
		
		//if they give you a card, go again
		
		//else, draw a card
		
	}
	
	public int findMultiples(){
		int[13][1] counts;
		for(Card card : hand){
			number = card.number;
		}
		
		return number;
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

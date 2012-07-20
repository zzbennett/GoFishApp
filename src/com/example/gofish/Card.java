package com.example.gofish;

public class Card implements Constants {
	
	public int suit;
	public int number;
	
	public Card(int suit, int number){
		this.suit = suit;
		this.number = number;
	}
	
	public String toString(){
		StringBuilder ret = new StringBuilder();
			switch (number) {
			case 11:
				ret.append("Jack");
				break;
			case 12:
				ret.append("Queen");
				break;
			case 13:
				ret.append("King");
				break;
			case 14:
				ret.append("Ace");
				break;

			default:
				ret.append(number);
				break;
		}
		switch (suit) {
		case HEARTS:
			ret.append(" of Hearts");	
			break;
		case SPADES:
			ret.append(" of Spades");	
			break;
		case CLUBS:
			ret.append(" of Clubs");	
			break;
		case DIAMONDS:
			ret.append(" of Diamonds");	
			break;

		default:
			break;
		}
		
		return ret.toString();
	}
}
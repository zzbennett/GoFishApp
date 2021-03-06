package com.example.gofish;

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class GameRoomActivity extends Activity {
	
	private static Random rand = new Random();

	private static final int REQUEST_CODE = 10;
	private static int num_players = 1;
	private static String player_name = "Liz";
	
	private static ArrayList<Player> players;
	private static Player curPlayer;
	private static String deck_size = "Big";
	
	private static Deck deck;

	protected void onCreate(Bundle savedInstanceState) {
		// Be sure to call the super class.
		super.onCreate(savedInstanceState);

		setContentView(R.layout.game_room);

		Intent intent = null;
		intent = new Intent(this, NewGameDialogActivity.class);
		startActivityForResult(intent, REQUEST_CODE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
			// build the game as per the user specifications
			if (data != null) {
				if (data.hasExtra("Player Name")
						&& data.hasExtra("Num Players")) {
					player_name = data.getExtras().getString("Player Name");
					num_players = data.getExtras().getInt("Num Players");
					Toast.makeText(
							this,
							"Playing as " + player_name + " with "
									+ num_players + " computer players.",
							Toast.LENGTH_SHORT).show();
				}
			}
		}
		
		/*once the new game dialog is exited, begin setting up the game room*/
		setUpGameRoom();
		setUpDeck();
		beginGamePlay();
	}
	public void setUpGameRoom(){
		players = new ArrayList<Player>();
		players.add(new Player(player_name));
		for(int i = 0; i<num_players; i++){
			players.add(new Player(new StringBuilder().append("Player ").append(i).toString() ) );
		}
	}
	public void setUpDeck(){
		//Replace Big with deck_size variable eventually
		deck = new Deck("Big");
		System.out.println("There are "+players.size()+" players.");
		for( Player player : players){
			for(int i = 0; i<7; i++){
				try{
				player.addCard(deck.nextCard());
				}
				catch(IndexOutOfBoundsException e){
					Toast.makeText(
							this,
							"Cannot play with this size deck and this many players!",
							Toast.LENGTH_SHORT).show();
				}
			}
		}
	}
	public void beginGamePlay(){
		//choose first player
		curPlayer = players.get(rand.nextInt(players.size()-1));
		curPlayer.isTurn = true;
		
		//initialize list of other players for each player
		for(Player player : players )
			player.addOtherPlayers(players);
		
		while(!(deck.deck.isEmpty()) || !(players.get(0).emptyHand)){
			//let game play ensue!
			curPlayer.takeTurn();
			if( deck.nextCard() == null) break;
		}
	}
	/*Please don't break, eclipse!!*/
}

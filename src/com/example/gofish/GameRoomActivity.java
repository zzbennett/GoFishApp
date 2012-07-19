package com.example.gofish;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class GameRoomActivity extends Activity {

	private static final int REQUEST_CODE = 10;
	private static int num_players = 1;
	private static String player_name = "Liz";
	private static String deck_size = "Big";
	
	private static Deck deck;

	protected void onCreate(Bundle savedInstanceState) {
		// Be sure to call the super class.
		super.onCreate(savedInstanceState);

		setContentView(R.layout.game_room);

		Intent intent = null;
		intent = new Intent(this, NewGameDialogActivity.class);
		startActivityForResult(intent, REQUEST_CODE);
		// need to set up the game room here
		setUpGameRoom();
		buildDeck();
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
					deck_size = data.getExtras().getString("Deck Size");
					Toast.makeText(
							this,
							"Playing as " + player_name + " with "
									+ num_players + " computer players.",
							Toast.LENGTH_SHORT).show();
				}
			}
		}
	}
	private void setUpGameRoom() {
		//need cards		
	}
	private void buildDeck(){
		if(deck_size == "Big"){
			
		}
		else{
			
		}
		
	}
	/*Please don't break, eclipse!!*/
}
package com.example.gofish;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class GameRoomActivity extends Activity {

	private static final int REQUEST_CODE = 10;

	protected void onCreate(Bundle savedInstanceState) {
		// Be sure to call the super class.
		super.onCreate(savedInstanceState);

		setContentView(R.layout.game_room);

		Intent intent = null;
		try {
			intent = new Intent(this, NewGameDialogActivity.class);
		} catch (Exception e) {
			System.out.println("WELL THAT DIDN'T WORK 2");
		}
		try {
			startActivityForResult(intent, REQUEST_CODE);
		} catch (Exception e) {

			System.out.println("WELL THAT DIDN'T WORK 1");

		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
			// build the game as per the user specifications
			if (data != null) {
				if (data.hasExtra("Player Name") && data.hasExtra("Num Players")) {
					String player_name = data.getExtras().getString(
							"Player Name");
					int num_players = data.getExtras().getInt( "Num Players");
					Toast.makeText(this, "Playing as " + player_name+" with "+num_players+" computer players.",
							Toast.LENGTH_SHORT).show();
				}
			}
		}
	}
}

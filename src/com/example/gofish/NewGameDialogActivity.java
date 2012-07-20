package com.example.gofish;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;

public class NewGameDialogActivity extends Activity {

	private static int num_players;
	private static String player_name;
	private static TextView text_num_players;
	private static SeekBar seekbar; 
	private static String deck_size;

	protected void onCreate(Bundle savedInstanceState) {
		// Be sure to call the super class.
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);

		// See assets/res/any/layout/dialog_activity.xml for this
		// view layout definition, which is being set here as
		// the content of our screen.
		setContentView(R.layout.dialog_activity);

		/*
		 * getWindow().setFeatureDrawableResource(Window.FEATURE_LEFT_ICON,
		 * android.R.drawable.star_big_on);
		 */

		/***************************/
		/* GET PLAYER NAME SPINNER */
		/***************************/
		Spinner player_name_spinner = (Spinner) findViewById(R.id.select_player_spinner);
		// This will be database query eventually
		String[] players = new String[] { "Liz", "Luke", "Melanie", "Annie" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.spinner_layout, R.id.label, players);
		try {
			player_name_spinner.setAdapter(adapter);
		} catch (Exception e) {
			System.out.println("THAT DIDN'T WORK 3");
		}

		try {
			player_name_spinner
					.setOnItemSelectedListener(new OnItemSelectedListener() {
						public void onItemSelected(AdapterView<?> av, View v,
								int position, long id) {
							switch (position) {
							case 0:
								player_name = "Liz";
								break;
							case 1:
								player_name = "Luke";
								break;
							case 2:
								player_name = "Melanie";
								break;
							case 3:
								player_name = "Annie";
								break;
							default:
								break;
							}
						}

						public void onNothingSelected(AdapterView<?> av) {
							// do nothing?
						}
					});
		} catch (Exception e) {
			System.out.println("THAT DIDN'T WORK 4");
		}

		/***************************/
		/* Num Players Seekbar */
		/***************************/
		text_num_players= (TextView) findViewById(R.id.text_num_players);
		seekbar = (SeekBar) findViewById(R.id.numplayers_seekbar);

		seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				//Set the number of players
				text_num_players.setText(progress+" players");
				num_players = progress;
			}

			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}

			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}
		});
		
		/***************************/
		/* Create Game Button (and deck size radio) */
		/***************************/

		final RadioGroup radioDeckSize = (RadioGroup) findViewById(R.id.radio_deck_size);
		Button btn_create_game = (Button) findViewById(R.id.btn_start_game);
		btn_create_game.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int selectedId = radioDeckSize.getCheckedRadioButtonId();
			    RadioButton selectedRadio = (RadioButton) findViewById(selectedId);
			    if(selectedRadio.getText().toString().contains("face")){
			    	deck_size = "Small";
			    }
			    else{
			    	deck_size = "Big";
			    }
				finish();
			}
		});
	}

	@Override
	public void finish() {
		Intent data = new Intent();
		try {
			data.putExtra("Player Name", player_name);
			data.putExtra("Num Players", num_players);
			data.putExtra("Deck Size", deck_size);
		} catch (Exception e) {
			System.out.println("THAT DIDN'T WORK 7");
		}
		setResult(RESULT_OK, data);
		super.finish();
	}
}

package com.example.gofish;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
	
	String[] values = new String[] { "Start New Game", "Save Current Game", "Resume Old Game", "Preferences","Quit"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>(this, R.layout.rowlayout, R.id.label, values);
        //ListView listView = (ListView) getListView();
        //listView.setAdapter(myArrayAdapter);
        setListAdapter(myArrayAdapter);
        
    }
    
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	String selection = values[position];
    	if(!selection.startsWith("Start New Game")){
        		Toast.makeText(getApplicationContext(),
        			"You have clicked " + selection, Toast.LENGTH_SHORT)
        			.show();
    	}
    	else{
    		
    		Intent intent = new Intent(this, GameRoomActivity.class);
    		startActivity(intent);
    	
    	}
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}

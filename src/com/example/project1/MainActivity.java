package com.example.project1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;


/*the start of the program and has all the menu opitons
 * the start
 * rules 
 * and exit
 */
public class MainActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);// set the content view for from the layout
	}

	public void onClick(View view){
		switch(view.getId())
		{
		case R.id.button1:
			startActivity(new Intent("com.example.Maze"));//starting the game
			break;
		case R.id.button2:
			startActivity(new Intent("com.example.Rules"));// rules for the game
			break;
		case R.id.button3:
			finish();// leaving the game
			break;
		}
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
}

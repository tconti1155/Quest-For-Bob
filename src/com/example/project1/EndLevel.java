package com.example.project1;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/*the ending screen for the game
 * has choces of main menu
 * restarting 
 * or exiting
 */
public class EndLevel extends Activity{
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.endlevel);
	}	
	
	public void onClick(View view){
		switch(view.getId())
		{
		case R.id.button1:
			startActivity(new Intent("com.example.MainActivity"));//going to the main screen
			break;
		case R.id.button2:
			startActivity(new Intent("com.example.Maze"));// going back to the maze
			break;
		case R.id.button3:// exiting the game
			finish();
			break;
		}
	}
}

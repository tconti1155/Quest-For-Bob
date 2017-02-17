package com.example.project1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;





/* For tracking and find the cordnates for the ball movement then calling function to then redraw that fuction*/
public class Maze extends Activity {
	private  SensorManager sensorService;//call for sensor to decect movement
	private Ball ball;// call for the class where the ball is made
	Context bob;
	Bundle temp = new Bundle();
	EndLevel endlevel;
	private SensorEvent sensorEvent;//for the sensor event
	private Sensor sensor;// the sensor
	boolean winner = false;

	
	@Override
	//creating all the sensors and layouts for the maze
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.endlevel);
		ball = new Ball(this);
		setContentView(ball);
		sensorService=(SensorManager)getSystemService(SENSOR_SERVICE);
		sensor = sensorService.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		     sensorService.registerListener(mySensorEventListener,sensor,SensorManager.SENSOR_DELAY_NORMAL);
	}
	
	public void findwinner(){
		startActivity(new Intent("com.example.EndLevel"));
	}
	private SensorEventListener mySensorEventListener = new SensorEventListener(){
		@Override
	public void onSensorChanged(SensorEvent event){
		float moveballx = event.values[0];// sending the moveement of X cordnate for the ball
		float movebally = event.values[1];// sending the y cordnate for the ball movement
		ball.updateData(moveballx,movebally);// calling the funtion for updating the movement

	}

	
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}
	
	
	};
}

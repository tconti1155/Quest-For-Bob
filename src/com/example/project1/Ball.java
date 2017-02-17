package com.example.project1;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import android.os.Bundle;
import android.view.View;

/* The color and creationg of the ball also the rules for 
 * winning the game in the maze
 */
public class Ball  extends View {
	private Paint paint;// calling for paint to create the ball and color
	Maze maze = new Maze();
	Bundle bundle;
	int starter = 0;// to set ball start location
	private float Xaxis = 0;// xaxis holder
	private float Yaxis = 0;// y holder

	public Ball(Context context){
		super(context);
		IPiece();//calling the start functions for paint
	}
	
	private void IPiece(){
		paint = new Paint ();
		paint.setStrokeWidth(70);// the width of the stroke
		paint.setStyle(Paint.Style.STROKE);// setting the style of the paint 
		paint.setColor(Color.BLUE);// setting the color
	}

	@Override
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		float radius = 5;//setting the radius
		int x= getMeasuredWidth()/5;// get the width
		int y= getMeasuredHeight()/5;// getting the height
		canvas.drawCircle(70,100,radius,paint);// creatung the goal
		if(starter == 0)// start point
		{
			canvas.drawCircle(1000, 500, radius, paint);//setting the start point
			starter=1;// changing the starter to a new value
		}
		else// taking the movement and redrawingling
		{
		canvas.drawCircle((Xaxis*x), (Yaxis*y), radius, paint);// drawing the circle
		if((Xaxis*x)>= 70 && (Xaxis*x) <=80)// checking to see if x cordnate is in the right location
		{
			if((Yaxis*y) >= 100 && (Yaxis * y) <=110)// checking to see the y cordnate is the right location
			{
				maze.findwinner();
			}
		}
		}
	}


	public void updateData(float position, float position2){//the class for updating x and y
		this.Xaxis = position;// assinging x
		this.Yaxis = position2;//assigning y
		invalidate();//calling redraw
		
	}
	
}
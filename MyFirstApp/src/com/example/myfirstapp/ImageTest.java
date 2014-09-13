package com.example.myfirstapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

public class ImageTest extends View {
	private Paint paint;
	
	public ImageTest(Context context, AttributeSet attrs){
	    super(context, attrs);
	    paint = new Paint();
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
	    //draw the View
		
		paint.setColor(Color.BLUE);
		canvas.drawCircle(this.getMeasuredWidth()/2, this.getMeasuredHeight()/2, 20, paint);
	}
}

package com.example.myfirstapp;

import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	String LOG = "error message";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        String filename = "myfile";
        String string = "Hello world!";
        FileOutputStream outputStream;
        Log.d(LOG, "test: " + string);
        
        try {
          outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
          outputStream.write(string.getBytes());
          outputStream.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        getMenuInflater().inflate(R.menu.main_activity_actions, menu);
        
        
        return true;
    }
    
    public boolean onTouchEvent(MotionEvent touchevent) 
    {
    	
    	int x = (int) touchevent.getX();
    	int y = (int) touchevent.getY();
    	
    	EditText debugTextField = (EditText) findViewById(R.id.debugText);
    	debugTextField.setText(x+" "+y);
    	
    	if( x > 470 && x < 500 && y > 1330 && y <1360 )
    	{
    		Intent intent = new Intent(this, DisplayMessageActivity.class);
            EditText num1Text = (EditText) findViewById(R.id.num1);
            EditText num2Text = (EditText) findViewById(R.id.num2);
            int num1 = Integer.parseInt(num1Text.getText().toString());
            int num2 = Integer.parseInt(num2Text.getText().toString());
            
            int sum = num1 + num2;
            
            intent.putExtra("sum", sum );
            intent.putExtra("operation", "add" );
            
            startActivity(intent);
    	}
    	
    	if( x > 120 && x < 165 && y > 1330 && y <1360 )
    	{
    		MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.midnight);
    		mediaPlayer.start();
    	}
    	
    	if( x > 250 && x < 280 && y > 1330 && y <1360 )
    	{
    		MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.button1);
    		mediaPlayer.start();
    	}
    	
		return true;
    	
    }
    
   
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_search:
                openSearch();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    
    public void openSearch()
    {	
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
        startActivity(intent);
    }
    
    public void add(View view)
    {
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText num1Text = (EditText) findViewById(R.id.num1);
        EditText num2Text = (EditText) findViewById(R.id.num2);
        int num1 = Integer.parseInt(num1Text.getText().toString());
        int num2 = Integer.parseInt(num2Text.getText().toString());
        
        int sum = num1 + num2;
        
        intent.putExtra("sum", sum );
        intent.putExtra("operation", "add" );
        startActivity(intent);
        
       
    }
}

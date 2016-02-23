package com.example.yueat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends Activity {

	protected static Context context;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean emptyTest = false;
		// boolean pointsEmptyTest = false;
		// boolean weightEmptyTest = false;
	context = getApplicationContext();

//		File food = new File("food.txt");
//		FileOutputStream fos = null;
//		try {
//
//			fos = openFileOutput("food.txt", Context.MODE_APPEND);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				if (fos != null) {
//					fos.close();
//				}
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	//	this.textSet();
	//	ListView listView = (ListView) findViewById(R.id.listView1);
		//slv = (SwipeListView) findViewById(R.id.swipe_list);
		//Log.d("context = %s ...", String.valueOf(context));
		//Button add = (Button) findViewById(R.id.button1);
		// Log.d("boolean test",
		// String.valueOf(courseEmptyTest)+String.valueOf(pointsEmptyTest)+String.valueOf(weightEmptyTest));
		/*
		 * if ((courseEmptyTest == false) && (pointsEmptyTest == false) &&
		 * (weightEmptyTest == false)) { swipelistview.setAdapter(new
		 * MyAdapter(this));
		 * 
		 * this.textset(); }
		 */
		//Button one = (Button)findViewById(R.id.button1);
	//	one.setOnClickListener(new View.OnClickListener() {
			
			//@Override
			/*public void onClick(View v) {
			//	startActivity(new Intent("com.example.yueat.GRID"));
				Thread grid = new Thread(){
					public void run(){
						try{
							Intent gridIntent = new Intent("com.example.yueat.GRID");
						startActivity(gridIntent);
						}
						finally{
							finish();
						}
					}
				};
				grid.start();
			}
		});*/
			//listView.setAdapter(new MyAdapter(this));
			//this.textset();
		
    }
	public void buttonAction(View v){
		if(v.getId()==R.id.button1){
			//Thread grid = new Thread(){
			//	public void run(){
				//	try{
						Intent gridIntent = new Intent("com.example.yueat.GRID");
					startActivity(gridIntent);
				//	}
				//	finally{
				//		finish();
				//	}
		//		}
		//	};
		//	grid.start();
		}
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
   protected void onPause(){
    	super.onPause();
    }
    @Override
    protected void onResume(){
     	super.onResume();
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
    }}

    /**
     * A placeholder fragment containing a simple view.
     */






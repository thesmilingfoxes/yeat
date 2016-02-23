package com.example.yueat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
//need to get button id from Grid.java, it is defined as a protected static string variable
//the string id must then be compared ids listed the database or file (as a test) and the information corresponding to the id will be displayed in the textview descrText1

public class Descr extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.descr_layout);
		Intent mIntent = getIntent();
		int position = mIntent.getIntExtra("position", 0);
		Log.d("descr started", position + "");

		// TextView tv = (TextView)findViewById(R.id.descrText1);
		// String restaurants[] ={"don't know","Orange Snail"};
		// tv.setText(restaurants[position]);

		ListView lv = (ListView) findViewById(R.id.listViewDescr);
//
//		try {
			lv.setAdapter(new DescrAdapter(this, position));
//		} catch (EncryptedDocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// TODO Auto-generated catch block

	}
}
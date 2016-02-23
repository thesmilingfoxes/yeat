package com.example.yueat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class Grid extends Activity {

	protected static Context context;
	protected static int pos;

	// protected static double buttonID;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gridlayout);
		GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new ImageAdapter(this));
		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				// Open a new activity, in the new activity that is opened
				// display other information (let's start
				// with it displaying a simple textview
				//buttonAction(v);
				pos = position;
				Toast.makeText(Grid.this, "" + position, Toast.LENGTH_SHORT)
						.show();
				Intent descr = new Intent(Grid.this, Descr.class);
		        descr.putExtra("position", pos);
				Log.d("Grid", "extra put");
				startActivity(descr);
			}
		});
	}

	protected int getPos() {
		return pos;
	}

	protected void onPause() {
		super.onPause();
	}

	/*public void buttonAction(View v) {

		// buttonID = v.getId();//this way we can access the id of the button
		// grid image clicked later in the descr activity
		// Log.d("descr started", ""+buttonID);

		// Thread grid = new Thread(){
		// public void run(){
		// try{
		// buttonID = pos;
		Intent descr = new Intent("com.example.yueat.DESCR");
		startActivity(descr);

		// }
		// finally{
		// finish();
		// }
		// }
		// };
		// grid.start();

	}*/
}

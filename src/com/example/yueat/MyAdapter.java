package com.example.yueat;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Vector;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

class MyAdapter extends BaseAdapter {
	// GpaCalculator calculator = new GpaCalculator();
	Context context = MainActivity.context;
	static ArrayList<Row> rowList = new ArrayList<Row>();

	MyAdapter(Context c) {

		AssetManager manager;
		String line = null;
		boolean check = false;
		Vector <String> assetVector = new Vector();
		try{
			manager=context.getAssets();
			InputStream is = manager.open("food.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			while((line=br.readLine())!=null){
				line = line.toUpperCase();
				assetVector.add(line);
				Row temp = new Row(line);
				rowList.add(temp);
			}
			br.close();
			
		}catch (IOException e1){
			Log.d("MyAdapter", "Cbuffer appending...");
		}
		
		// String space = " ";
	//	Log.d("MyAdapter", "adapting haha");
		//InputStream fis = c.getResources().openRawResource(R.raw.food);
		// String sxml = tFile(fis);

/*		StringBuffer Cbuffer = new StringBuffer();
		int input = -1;
		try {
			while ((input = fis.read()) != -1) {
				Cbuffer.append((char) input);
				// Cbuffer.append((char)input);
				Log.d("MyAdapter", "Cbuffer appending...");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			StringBuffer Pbuffer = new StringBuffer();
			input = -1;
			try {
				while ((input = fis.read()) != -1) {
					Pbuffer.append((char) input);
					Log.d("MyAdapter", "Pbuffer appending...");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		
		StringBuffer CWbuffer = new StringBuffer();
		input = -1;
		try {
			while ((input = fis.read()) != -1) {
				CWbuffer.append((char) input);
				Log.d("MyAdapter", "CWbuffer appending...");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		ArrayList<String> Lnames = new ArrayList<String>();
		ArrayList<String> Lprice = new ArrayList<String>();
		ArrayList<String> LCW = new ArrayList<String>();
		// int k = 0;
		String cString = Cbuffer.substring(0, Cbuffer.length());
		Log.d("MyAdapter", "substrings" + cString);
		int start = 0;
		Log.d("MyAdapter",
				"lastIndexOf" + String.valueOf(cString.lastIndexOf(" ")));
		Log.d("MyAdapter", "substrings testing" + cString.substring(0, 1));

		while (cString.length() > 1) {
			start = cString.indexOf(" ") + 1;
			Lnames.add(cString.substring(0, start));
			Log.d("MyAdapter",
					"substrings 0 to start" + cString.substring(0, start));
			cString = cString.substring(start, cString.length());
			Log.d("MyAdapter",
					"cString length " + String.valueOf(cString.length()));
			Log.d("MyAdapter", "cStrings" + cString);
		}

		String pString = Pbuffer.substring(0, Pbuffer.length());
		Log.d("MyAdapter", "p substrings" + pString);
		start = 0;
		Log.d("MyAdapter", "p IndexOf" + String.valueOf(pString.indexOf(" ")));
		while (pString.length() > 1) {
			start = pString.indexOf(" ") + 1;
			Lprice.add(pString.substring(0, start));
			Log.d("MyAdapter",
					"substrings 0 to start" + pString.substring(0, start));
			pString = pString.substring(start, pString.length());
			Log.d("MyAdapter",
					"pString length " + String.valueOf(pString.length()));
			Log.d("MyAdapter", "pStrings" + pString);
			Log.d("MyAdapter", "Lnames.size" + String.valueOf(Lnames.size()));
			// Log.d("MyAdapter","Lprice.size" +
			// String.valueOf(Lprice.size()));

		}
		String cwString = CWbuffer.substring(0, CWbuffer.length());
		Log.d("MyAdapter", "cw substrings" + cwString);
		start = 0;
		Log.d("MyAdapter",
				"cw string length" + String.valueOf(cwString.length()));
		Log.d("MyAdapter", "cw IndexOf" + String.valueOf(cwString.indexOf(" ")));
		while (cwString.length() > 1) {
			start = cwString.indexOf(" ") + 1;
			LCW.add(cwString.substring(0, start));
			Log.d("MyAdapter",
					"substrings 0 to start" + cwString.substring(0, start));
			cwString = cwString.substring(start, cwString.length());
			Log.d("MyAdapter",
					"cwString length " + String.valueOf(cwString.length()));
			Log.d("MyAdapter", "cwStrings" + cwString);
			// Log.d("MyAdapter","Lnames.size" +
			// String.valueOf(Lnames.size()));
			// Log.d("MyAdapter","Lprice.size" +
			// String.valueOf(Lprice.size()));
			Log.d("MyAdapter", "LCW.size" + String.valueOf(LCW.size()));
		}
		Log.d("MyAdapter", "LCW.get(0)= " + String.valueOf(LCW.get(0)));
		for (int j = 0; j < Lnames.size(); j++) {
			Lnames.get(j).replaceAll("$", " ");
			Log.d("MyAdapter", "Done fixing the dollar signs");
			// rowList.add(new Row(Lnames.get(j),Lprice.get(j)));
			// Log.d("MyAdapter","Done adding to rowList");
		}
		for (int j = 0; j < Lnames.size(); j++) {
			// Lnames.get(j).replaceAll("$"," ");
			Log.d("MyAdapter", "adding into row list");
			rowList.add(new Row(Lnames.get(j), Lprice.get(j), LCW.get(j)));
			Log.d("MyAdapter", "Done adding to rowList");
		}
		}*/
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub

		return rowList.size();
	}

	/*public String tFile(InputStream inputStream) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		byte buf[] = new byte[1024];
		int len;
		try {
			while ((len = inputStream.read(buf)) != -1) {
				outputStream.write(buf, 0, len);
			}
			outputStream.close();
			inputStream.close();
		} catch (IOException e) {

		}
		return outputStream.toString();
	}*/

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		Log.d("MyAdapter", "getCount successful");

		return rowList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		Log.d("MyAdapter", "getItem successful");
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Log.d("context = %s ...", String.valueOf(context));
		Log.d("MyAdapter", "getItemId successful");
		View row = convertView;
		ViewHolder h = null;

		if (row == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			Log.d("MyAdapter", "layout inflater successful");
			row = inflater.inflate(R.layout.single_row, parent, false);
			h = new ViewHolder(row);
			row.setTag(h);
		} else {
			h = (ViewHolder) row.getTag();
		}
		Log.d("MyAdapter", "view row successful");
		Row temp = rowList.get(position);
		h.name.setText(temp.name);
		// ViewSet vs = new ViewSet();
		// vs.settingView();
		return row;

	}
}

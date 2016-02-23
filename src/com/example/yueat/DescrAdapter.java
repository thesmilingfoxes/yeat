package com.example.yueat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

class DescrAdapter extends BaseAdapter {
	// GpaCalculator calculator = new GpaCalculator();
	Context context = MainActivity.context;
	static ArrayList<DescrRow> rowList = new ArrayList<DescrRow>();

	DescrAdapter(Context c, int pos) {
        Log.d("descr adapter started", "success");

//        String name = "file"+pos+".txt";
//		
//		String line = "";
//		String categorys ="";
//	String itemNs = "";
//		String itemPs = "";
		
//	String misc = "";
//		boolean check = false;
//		Vector <String> assetVector = new Vector();
		
        AssetManager manager;
    	Log.d("asset mangaer", " asset...");
    	manager=context.getAssets();
//    	File f = new File("restaurantData.xls");
    	//try {s
    	
    		/*String array[] = {"","","",""};
    		Workbook wb = null;
    		
//    					try {
							try {
								wb = WorkbookFactory.create(manager.open("restaurantData.xls"));
							} catch (EncryptedDocumentException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (InvalidFormatException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
////							e.printStackTrace();
//							throw new EncryptedDocumentException(e.getMessage());
//							throw new InvalidFormatException(e.getMessage());
//							throw new IOException(e.getMessage());
//							
//						} 
//    			
    			
    				Sheet s = wb.getSheetAt(pos);
    				Row rows = s.getRow(0);
    				for(int i = 0;i<=s.getLastRowNum();i++){
    					rows = s.getRow(i);
    					for(int j = 0;j<rows.getLastCellNum();j++){//getLastcellnum starts from 1 to number whereas getLastRowNum starts from 0 to number
    						//System.out.println(rows.getCell(j).toString());
    						array[j] = rows.getCell(j).toString();
    					}
    					//assetVector.add(line);
    					DescrRow temp = new DescrRow(array[0],array[1],array[2],array[3]);
    					rowList.add(temp);
    					Log.d("Descr Adapter", " appending...");
    				}*/
		
      //  ExcelList x = new ExcelList(context);
		//rowList =	x.openExcelFile(pos);
		
		//rowList.add(temp);	
    		
    		try
    		{
    			// read from excel file
    			//FileInputStream file = new FileInputStream(new File("howtodoinjava_demo.xlsx"));
    			FileInputStream file = new FileInputStream(new File("restaurantData.xlsx"));
    			try {
    				manager.open("restaurantData.xls");
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			// Create Workbook instance holding reference to .xlsx file
    			XSSFWorkbook workbook = new XSSFWorkbook(file);

    			// Get first/desired sheet from the workbook
    			XSSFSheet s = workbook.getSheetAt(pos);

    			// Iterate through each rows one by one
    			//Iterator<Row> rowIterator = s.iterator();
    			String array[] = {"","","",""};
    			Row rows = s.getRow(0);
				for(int i = 0;i<=s.getLastRowNum();i++){
					rows = s.getRow(i);
					for(int j = 0;j<rows.getLastCellNum();j++){//getLastcellnum starts from 1 to number whereas getLastRowNum starts from 0 to number
						//System.out.println(rows.getCell(j).toString());
						array[j] = rows.getCell(j).toString();
					}
					//assetVector.add(line);
					DescrRow temp = new DescrRow(array[0],array[1],array[2],array[3]);
					rowList.add(temp);
					Log.d("Descr Adapter", " appending...");
				}

//			       ExcelList x = new ExcelList(context);
//					rowList =	x.openExcelFile(pos);
//					
//				rowList.add(temp);
//    			while (rowIterator.hasNext())
//    			{
//    				Row row = rowIterator.next();
//    				// For each row, iterate through all the columns
//    				Iterator<Cell> cellIterator = row.cellIterator();
//
//    				while (cellIterator.hasNext())
//    				{
//    					Cell cell = cellIterator.next();
//    					// Check the cell type and format accordingly
//    					switch (cell.getCellType())
//    					{
//    					case Cell.CELL_TYPE_NUMERIC: System.out.printf("%-50s",cell.getNumericCellValue() + "    ");
//    						break;
//    					case Cell.CELL_TYPE_STRING: System.out.printf("%-50s",cell.getStringCellValue() + "    ");
//    						break;
//    					}
//    				}
//    				System.out.println("");
//    			}
    			
    			file.close();
    		}
    		catch (Exception e)
    		{
    			e.printStackTrace();
    		}
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub

		return rowList.size();
	}

	

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
		Log.d("Descr context = %s ...", String.valueOf(context));
		Log.d("MyAdapter", "getItemId successful");
		View row = convertView;
		DescrViewHolder h = null;

		if (row == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			Log.d("MyAdapter", "layout inflater successful");
			row = inflater.inflate(R.layout.descr_menu, parent, false);
			h = new DescrViewHolder(row);
			row.setTag(h);
		} else {
			h = (DescrViewHolder) row.getTag();
		}
		Log.d("MyAdapter", "view row successful");
		DescrRow temp = rowList.get(position);
		h.category.setText(temp.category);
		h.itemName.setText(temp.itemName);
		h.itemPrice.setText(temp.itemPrice);
		h.misc.setText(temp.misc);
		return row;

	}
}

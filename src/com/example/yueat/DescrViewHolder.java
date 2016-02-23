package com.example.yueat;

import android.view.View;
import android.widget.TextView;

class DescrViewHolder {
	TextView category;
	TextView itemName;
	TextView itemPrice;
	TextView misc;



	DescrViewHolder(View v) {
		category = (TextView) v.findViewById(R.id.category);
		itemName = (TextView) v.findViewById(R.id.itemName);
		itemPrice = (TextView) v.findViewById(R.id.itemPrice);
		misc = (TextView) v.findViewById(R.id.misc);

		
	}}

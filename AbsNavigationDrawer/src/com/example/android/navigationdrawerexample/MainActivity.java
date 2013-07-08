package com.example.android.navigationdrawerexample;

import com.actionbarsherlock.app.SherlockListActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends SherlockListActivity  {

    private String[] mMenuTitles;
	
	/** {@inheritDoc} */
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);

		ListView lv = getListView();  
	    lv.setBackgroundColor(0xff000000);  
	    
		mMenuTitles = getResources().getStringArray(R.array.menu_array);
	
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1, mMenuTitles);

	    setListAdapter(adapter);
	}


	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
	    super.onListItemClick(l, v, position, id);
	
	    String menuTitle = mMenuTitles[position];
	    
	    Intent intent;
	    if (menuTitle.equals("ContentDrawer")){
			intent = new Intent(getApplicationContext(), ContentDrawerActivity.class);
	    }else if (menuTitle.equals("Horizon Left")){
			intent = new Intent(getApplicationContext(), LeftDrawerActivity.class);
	    }else if (menuTitle.equals("Horizon Right")){
			intent = new Intent(getApplicationContext(), RightDrawerActivity.class);
	    }else if (menuTitle.equals("Vertical Top")){
			intent = new Intent(getApplicationContext(), TopDrawerActivity.class);
	    }else if (menuTitle.equals("Vertical Bottom")){
			intent = new Intent(getApplicationContext(), BottomDrawerActivity.class);
	    }else{
	    	intent = new Intent(getApplicationContext(), DrawerActivity.class);
	    }
		startActivity(intent);
	}

}
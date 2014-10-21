package com.chris.geotag_app;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

public class MainActivity extends Activity implements LocationListener {
	protected LocationManager locationManager;
	protected LocationListener locationListener;
	
	protected ArrayAdapter<String> adapter;
	protected ListView tagList;
	
	protected ArrayList<String> listItems = new ArrayList<>();
	
	protected ProgressDialog progressDialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.tag_list_layout, listItems);
		tagList = (ListView) findViewById(R.id.tag_list);
		tagList.setAdapter(adapter);
		
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		
		progressDialog = new ProgressDialog(this);
		progressDialog.setTitle("Lade Daten");
		progressDialog.setMessage("Bitte warten...");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
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
	}

	@Override
	public void onLocationChanged(Location location) {
		Log.d("geoTagDebug", "Location Updated: " + location.toString());
		listItems.add("Lat: " + location.getLatitude() + ", Long: " + location.getLongitude());
		progressDialog.dismiss();
		adapter.notifyDataSetChanged();
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		Log.d("geoTagDebug", "Status changed");		
	}

	@Override
	public void onProviderEnabled(String provider) {
		Log.d("geoTagDebug", "Provider Enabled");
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		Log.d("geoTagDebug", "Provider Disabled");		
	}
	
	public void getGeoTag(View view) {
		Log.d("geoTagDebug", "Button pressed");
		progressDialog.show();
		locationManager.requestSingleUpdate(LocationManager.NETWORK_PROVIDER, this, Looper.getMainLooper());
	}
}

package com.example.gm;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class Harita extends FragmentActivity{
	private GoogleMap googleHarita;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.harita);
		
		 if (googleHarita == null) {
		        googleHarita = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.harita))
		                .getMap();
		        if (googleHarita != null) {
		            
		            LatLng koordinatlar = new LatLng(MainActivity.x,MainActivity.y);
		            googleHarita.addMarker(new MarkerOptions().position(koordinatlar).title("Burdayýz"));
		            googleHarita.moveCamera(CameraUpdateFactory.newLatLngZoom(koordinatlar, 13));         
		        }
		    }
	}


}

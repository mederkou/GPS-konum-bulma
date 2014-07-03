package com.example.gm;


import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
 

public class MainActivity extends Activity {
	
	public static double x,y;
	
	private static MainActivity kordinat;
	 
    public static MainActivity getInstance() {
        return kordinat;
    }
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		kordinat = this;
		
		final String gpsAcildi = "GPS Acýldý";
		final String gpsKapatildi = "GPS Kapalý";
		Button btn1=(Button) findViewById(R.id.btn1);	
		final Button btn2=(Button) findViewById(R.id.btn2);
		btn2.setEnabled(false);
		
		
btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				final TextView txt = (TextView)findViewById(R.id.txt);
				final TextView konumxText = (TextView)findViewById(R.id.txt1);
				
				LocationManager konumYoneticisi = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		 
				LocationListener konumDinleyicisi = new LocationListener() {
		 
					@Override
					public void onStatusChanged(String provider, int status, Bundle extras) {
		 
					}
		 
					@Override
					public void onProviderEnabled(String provider) {
						Toast.makeText( getApplicationContext(),gpsAcildi,Toast.LENGTH_SHORT).show();
						txt.setText("GPS Veri bilgileri Alýnýyor...");
					}
		 
					@Override
					public void onProviderDisabled(String provider) { 
						 Toast.makeText( getApplicationContext(),gpsKapatildi,Toast.LENGTH_SHORT).show();
						 txt.setText("GPS Baðlantý Bekleniyor...");
					}
		 
					@Override
					public void onLocationChanged(Location loc) {
						loc.getLatitude();
						loc.getLongitude();
		 
						x=loc.getLatitude();
						y=loc.getLongitude();
						
						String Text = "Bulunduðunuz konum bilgileri : \n" +"X Koordinatý = " + loc.getLatitude() +"\nY Koordinatý = "+ loc.getLongitude();
						konumxText.setText(Text);
						btn2.setEnabled(true);
					}
				};
				konumYoneticisi.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, konumDinleyicisi);
				
			}
		});

btn2.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		
		Intent yeni1=new Intent(MainActivity.this,Harita.class);
	    startActivity(yeni1);
		
	}
});


	}
}

	



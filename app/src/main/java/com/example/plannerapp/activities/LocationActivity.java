package com.example.plannerapp.activities;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.plannerapp.R;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class LocationActivity extends AppCompatActivity implements LocationListener {

    TextView txtaddress;
    Button btnlocation;
    Location loc;
    Double lat,lon;
    Geocoder geo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        txtaddress=(TextView)findViewById(R.id.txtaddress);
        btnlocation=(Button)findViewById(R.id.btnlocation);
    }

    public void printlocation(View v) throws IOException {
        getLocation();
        loc=getLocation();
        lat=loc.getLatitude();
        lon=loc.getLongitude();
        geo=new Geocoder(this, Locale.getDefault()); List<Address> addr ; addr=geo.getFromLocation(lat,lon,1);
        String streetaddress=addr.get(0).getAddressLine(0); String city=addr.get(0).getLocality();
        String country=addr.get(0).getCountryName(); String postalcode=addr.get(0).getPostalCode();
        txtaddress.setText(streetaddress+" "+city+" "+country+" "+postalcode);
    }

    public Location getLocation() {
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

        }
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, this); Location loc = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER); return loc;
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {

    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }
    @Override
    public void onProviderEnabled(@NonNull String provider) {
    }
    @Override
    public void onProviderDisabled(@NonNull String provider) {
    }
}

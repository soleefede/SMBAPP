package com.example.smbapp;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.supportMapFragment);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng targetLocation = new LatLng(24.826333, 121.770532);

        int height = getResources().getDimensionPixelSize(R.dimen.icon_size);
        int width = getResources().getDimensionPixelSize(R.dimen.icon_size);
        BitmapDrawable bitmapdrawable=(BitmapDrawable)getResources().getDrawable(R.drawable.icon);
        Bitmap smallMarker = Bitmap.createScaledBitmap(bitmapdrawable.getBitmap(), width, height, false);
        mMap.addMarker(new MarkerOptions().position(targetLocation).title("HoYa Rice Kitchen").icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(targetLocation));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(16f));

    }
}

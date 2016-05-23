package com.example.sebastian.pruebamapa;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        /*mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng coordenada) {
                mMap.addMarker(new MarkerOptions().position(coordenada).title("Nueva localizacion"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordenada, 15));
            }
        });*/
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng coordenada) {
                mMap.addMarker(new MarkerOptions().position(coordenada).title("Nueva localizacion"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordenada, 15));
            }
        });

        // Add a marker in Sydney and move the camera
        LatLng usach = new LatLng(-33.4501044,-70.6858881);
        mMap.addMarker(new MarkerOptions().position(usach).title("Usachita :3"));

        LatLng usach2 = new LatLng(-33.4497262,-70.6877551);
        mMap.addMarker(new MarkerOptions().position(usach2).title("Info"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(usach, 15));
    }
}

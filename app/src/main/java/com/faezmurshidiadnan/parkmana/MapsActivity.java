package com.faezmurshidiadnan.parkmana;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Bundle b = new Bundle();
        b = getIntent().getExtras();
        String name = b.getString("name");
        Double lat = b.getDouble("lat");
        Double lon = b.getDouble("lon");
        String dis = b.getString("dis");
        String lots = b.getString("lots");

       TextView tit = (TextView)findViewById(R.id.textView);
        TextView di = (TextView)findViewById(R.id.distance);
        TextView lo = (TextView)findViewById(R.id.lots);


        tit.setText(name);
        di.setText(dis);
        lo.setText(lots);

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


        Bundle b = new Bundle();
        b = getIntent().getExtras();
        String name = b.getString("name");
        Double lat = b.getDouble("lat");
        Double lon = b.getDouble("lon");
        String dis = b.getString("dis");
        String lots = b.getString("lots");





        LatLng pos = new LatLng(lat, lon);
        mMap.addMarker(new MarkerOptions().position(pos).title(name));

        float zoomLevel = (float) 18.0; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pos, zoomLevel));
    }

    public void Fav(View view) {
        Toast.makeText(this, "Favourite", Toast.LENGTH_SHORT).show();
    }
}

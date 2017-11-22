package edu.orangecoastcollege.cs273.caffeinefinder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class CaffeineDetailsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Location selectedLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caffeine_details);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.caffeineDetailsMapfragmentfragment);
        mapFragment.getMapAsync(this);

        TextView caffeineDetailsNameTextView = (TextView) findViewById(R.id.caffeineDetailsNameTextView);
        TextView caffeineDetailsAddressTextView = (TextView) findViewById(R.id.caffeineDetailsAddressTextView);
        TextView caffeineDetailsPhoneTextView = (TextView) findViewById(R.id.caffeineDetailsPhoneTextView);
        TextView caffeineDetailsLatLngTextView = (TextView) findViewById(R.id.caffeineDetailsLatLngTextView);

        selectedLocation = getIntent().getExtras().getParcelable("SelectedLocation");

        caffeineDetailsNameTextView.setText(selectedLocation.getName());
        caffeineDetailsAddressTextView.setText(selectedLocation.getAddress() + "\n" + selectedLocation.getCity() + ", " + selectedLocation.getState() + " " + selectedLocation.getZipCode());
        caffeineDetailsPhoneTextView.setText(selectedLocation.getPhone());
        caffeineDetailsLatLngTextView.setText(selectedLocation.getLatitude() + " " + selectedLocation.getLongitude());
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng myPosition = new LatLng(selectedLocation.getLatitude(), selectedLocation.getLongitude());

        mMap.addMarker(new MarkerOptions()
                .position(myPosition)
                .title(selectedLocation.getName())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.my_marker)));

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(myPosition)
                .zoom(18.0f)
                .build();
        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
        mMap.moveCamera(cameraUpdate);
    }
}

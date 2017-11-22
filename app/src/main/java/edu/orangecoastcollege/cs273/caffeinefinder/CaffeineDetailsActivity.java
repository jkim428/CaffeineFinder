package edu.orangecoastcollege.cs273.caffeinefinder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class CaffeineDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caffeine_details);

        TextView caffeineDetailsNameTextView = (TextView) findViewById(R.id.caffeineDetailsNameTextView);
        TextView caffeineDetailsAddressTextView = (TextView) findViewById(R.id.caffeineDetailsAddressTextView);
        TextView caffeineDetailsPhoneTextView = (TextView) findViewById(R.id.caffeineDetailsPhoneTextView);
        TextView caffeineDetailsLatLngTextView = (TextView) findViewById(R.id.caffeineDetailsLatLngTextView);

        Location selectedLocation = getIntent().getExtras().getParcelable("SelectedLocation");

    }
}

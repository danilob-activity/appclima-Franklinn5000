package com.londonappbrewery.climapm;

import android.Manifest;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONObject;

import java.text.CollationElementIterator;


public class WeatherController extends AppCompatActivity {

    // Constants:
    final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather";
    // App ID to use OpenWeather data
    final String APP_ID = "e72____PLEASE_REPLACE_ME_____13";
    // Time between location updates (5000 milliseconds or 5 seconds)
    final long MIN_TIME = 5000;
    // Distance between location updates (1000m or 1km)
    final float MIN_DISTANCE = 1000;

    // TODO: Set LOCATION_PROVIDER here:

    String LOCATION_PROVIDER = LocationManager.GPS_PROVIDER;
    final String LOGCAT_TAG = "Clima";



    // Member Variables:
    TextView mCityLabel;
    ImageView mWeatherImage;
    TextView mTemperatureLabel;



    // TODO: Declare a LocationManager and a LocationListener here:
    LocationManager mLocationManager;
    LocationListener mLocationListener;
    private CollationElementIterator mTextViewCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_controller_layout);

        // Linking the elements in the layout to Java code
        mCityLabel = (TextView) findViewById(R.id.locationTV);
        mWeatherImage = (ImageView) findViewById(R.id.weatherSymbolIV);
        mTemperatureLabel = (TextView) findViewById(R.id.tempTV);
        ImageButton changeCityButton = (ImageButton) findViewById(R.id.changeCityButton);


        // TODO: Add an OnClickListener to the changeCityButton here:






    }


    // TODO: Add onResume() here:
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOGCAT_TAG, "onResume() called");
        getWeatherForCurrentLocation();
    }

    private void getWeatherForCurrentLocation() {

        mLocationManager = (LocationManager) getSystemService(Context. LOCATION_SERVICE);
        mLocationListener = new LocationListener() {

            @Override
            public void onLocationChanged(Location location) {
                Log.d(LOGCAT_TAG, "onLocationChanged() callback received");
                String longitude = String. valueOf(location.getLongitude());
                String latitude = String. valueOf(location.getLatitude());
                Log.d(LOGCAT_TAG,"longitude is: "+longitude);
                Log.d(LOGCAT_TAG,"latitude is: "+latitude);
            }
            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {
                Log.d(LOGCAT_TAG, "onStatusChanged() callback received. Status: " + i);
                Log.d(LOGCAT_TAG, "2 means AVAILABLE, 1: TEMPORARILY_UNAVAILABLE, 0: OUT_OF_SERVICE");

            }
            @Override
            public void onProviderEnabled(String s) {
                Log.d(LOGCAT_TAG, "onProviderEnabled() callback received. Provider: " + s);
            }
            @Override
            public void onProviderDisabled(String s) {
                Log.d("Clima", "onProviderDisabled() callback received");
            }
        };
    }

    // TODO: Add getWeatherForNewCity(String city) here:






    // TODO: Add getWeatherForCurrentLocation() here:
        mLocationManager.requestLocationUpdates(LOCATION_PROVIDER, MIN_TIME,MIN_DISTANCE, mLocationListener);

    // TODO: Add letsDoSomeNetworking(RequestParams params) here:

    private void letsDoSomeNetworking(RequestParams params){
        private void letsDoSomeNetworking(RequestParams params){
            AsyncHttpClient client = new AsyncHttpClient();
            client.get( WEATHER_URL,params,new JsonHttpResponseHandler(){
                @Override
                public void onSuccess( int statusCode, PreferenceActivity.Header[] headers,
                                       JSONObject response) {
                    Log. d(LOGCAT_TAG,"Sucess! JSON: "+response.toString());
                }
                @Override
                public void onFailure(int statusCode, PreferenceActivity.Header[] headers, Throwable
                        throwable, JSONObject errorResponse) {
                    Log. e(LOGCAT_TAG,"Fail "+throwable.toString());
                    Log. d(LOGCAT_TAG,"Status code "+ statusCode);
                }
            });
        }





    // TODO: Add updateUI() here:

        private void updateUI(WeatherDataModel weatherData) {
        mTextViewCity.setText(weatherData.getCity());
        mTextViewTemperature.setText(weatherData.getTemperature());

        int resourceID = getResources().getIdentifier(weatherData.getIconName(),"drawable", getPackageName(
        ));


        // TODO: Add onPause() here:




}

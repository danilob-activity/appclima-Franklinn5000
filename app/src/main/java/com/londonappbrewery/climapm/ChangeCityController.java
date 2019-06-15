package com.londonappbrewery.climapm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class ChangeCityController extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_city_layout);

        ImageButton back = findViewById(R.id.backButton);
        final EditText edit = findViewById(R.id.queryET);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        edit.setOnEditorActionListener( new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String newCity = edit.getText().toString();
                Intent newCityIntent = new Intent(ChangeCityController. this,
                        WeatherController. class);
                newCityIntent.putExtra( "City", newCity);
                startActivity(newCityIntent);
                finish();
                return true;
            }
        });

    }
}

package com.example.externallibraries;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView show;

    private ArrayList cars;

    private int count = 0;

    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cars = new ArrayList<Car>();
        cars.add(new Car(2000, 200, "Red", "Audi"));
        cars.add(new Car(2100, 210, "Blue", "Volvo"));
        cars.add(new Car(2200, 220, "Yellow", "BMW"));
        cars.add(new Car(2300, 230, "Green", "Toyota"));
        show = findViewById(R.id.show);
        Button newCarButton = findViewById(R.id.newCarButton);
        newCarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String json = gson.toJson(cars.get(count));
                show.setText(json);
                count++;

                if (count == 4){
                    count = 0;
                }
            }
        });
    }
}

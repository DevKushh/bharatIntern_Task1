package com.example.temparatureconverterapp;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText celsiusInput;
    private EditText fahrenheitInput;
    private TextView celsiusResult;
    private TextView fahrenheitResult;
    private Button celsiusToFahrenheitButton;
    private Button fahrenheitToCelsiusButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        celsiusInput = findViewById(R.id.celsiusInput);
        fahrenheitInput = findViewById(R.id.fahrenheitInput);
        celsiusResult = findViewById(R.id.celsiusResult);
        fahrenheitResult = findViewById(R.id.fahrenheitResult);
        celsiusToFahrenheitButton = findViewById(R.id.celsiusToFahrenheit);
        fahrenheitToCelsiusButton = findViewById(R.id.fahrenheitToCelsius);

        celsiusToFahrenheitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                convertCelsiusToFahrenheit();
                Toast.makeText(MainActivity.this, "\nThankYou For Using Our App...!", Toast.LENGTH_SHORT).show();
            }
        });

        fahrenheitToCelsiusButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                convertFahrenheitToCelsius();
                Toast.makeText(MainActivity.this, "\nThankYou For Using Our App...!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void convertCelsiusToFahrenheit()
    {
        String celsiusStr = celsiusInput.getText().toString();
        try
        {
            double celsius = Double.parseDouble(celsiusStr);
            double fahrenheit = (celsius * 9 / 5) + 32;
            DecimalFormat df = new DecimalFormat("#.##");
            fahrenheitResult.setText("Temparature in Fahrenheit is : " + df.format(fahrenheit) + " °F");
        }
        catch (NumberFormatException e)
        {
            fahrenheitResult.setText("Temparature in Fahrenheit is : Invalid input");
        }
    }

    private void convertFahrenheitToCelsius()
    {
        String fahrenheitStr = fahrenheitInput.getText().toString();
        try
        {
            double fahrenheit = Double.parseDouble(fahrenheitStr);
            double celsius = (fahrenheit - 32) * 5 / 9;
            DecimalFormat df = new DecimalFormat("#.##");
            celsiusResult.setText("Temparature in Celsius is : " + df.format(celsius)+ " °C");


        }
        catch (NumberFormatException e)
        {
            celsiusResult.setText("Temparature in Celsius is : Invalid input");
        }
    }
}

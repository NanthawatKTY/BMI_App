package com.namo3t.bmi_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView result ;
        Button btnCal;


        btnCal = findViewById(R.id.btnCal);
        result = findViewById(R.id.txtresult);
        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(calBMI());
            }
        });

    }


    public String calBMI()
    {
        EditText editWeight;
        EditText editHeight;

        editWeight = findViewById(R.id.editTextWeight);
        editHeight = findViewById(R.id.editTextHeight);

        double weight = Double.parseDouble(editWeight.getText().toString());
        double height = Double.parseDouble(editHeight.getText().toString());

        height = height / 100; // CM. to Meter

        double BMI = weight / (height * height);
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        String msg = "Your BMI result is: " + decimalFormat.format(BMI) + "\n";
        msg += "Your body is: ";

        if (BMI >= 40) {
            msg += "Super FAT";
        } else if (BMI >= 35) {
            msg += "Fat lvl.2";
        } else if (BMI >= 28.5) {
            msg += "Fat lvl.1";
        } else if (BMI >= 23.5) {
            msg += "Weight over standard";
        } else if (BMI >= 18.5) {
            msg += "Normal standard";
        } else if (BMI < 18.5) {
            msg += "Lower standard";
        }

        //Toast.makeText(this, msg, Toast.LENGTH_SHORT).show(); //Show Hold
        return msg; //Return value to calBMI() to use in other method
    }
}

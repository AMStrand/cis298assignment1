package edu.kvcc.cis298.cis298assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import junit.framework.Test;

public class CounterActivity extends AppCompatActivity {

        // Declare variables for use:
    private Button mPlusButton;
    private Button mMinusButton;
    private TextView mNumberOfPeople;
    private int mPersonCount = 0;

        // Override the onCreate method:
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

            // Assign the variables to the buttons/textviews:
        mPlusButton = (Button)findViewById(R.id.plus_button);
        mMinusButton = (Button)findViewById(R.id.minus_button);
        mNumberOfPeople = (TextView)findViewById(R.id.number_of_people);

        mPlusButton.setOnClickListener(new View.OnClickListener() {
            // Set so that on click of plus button, the person count is incremented by 1,
            // call the method to update the number displayed, and call the method to test for toast:
            @Override
            public void onClick(View v) {
                mPersonCount++;
                UpdateNumber();
                TestForToast();
            }
        });

        mMinusButton.setOnClickListener(new View.OnClickListener() {
            // Set so that on click of minus button, the person count is decremented by 1,
            // and call the method to update the number displayed:
            @Override
            public void onClick(View v) {
                mPersonCount--;
                UpdateNumber();
            }
        });

    }

        // Method to update the number displayed:
    private void UpdateNumber() {
        mNumberOfPeople.setText(Integer.toString(mPersonCount));
    }

        // Method to test if over 20 people has been reached (by adding ONLY, and ONLY from 20)
    private void TestForToast() {
        if (mPersonCount > 20 & (mPersonCount - 1) == 20) {
            Toast.makeText(this, R.string.count_over_20, Toast.LENGTH_SHORT).show();
        }
    }
}

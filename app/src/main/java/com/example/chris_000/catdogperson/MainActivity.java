package com.example.chris_000.catdogperson;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {


    private SeekBar comfortableSeekBar;

    private CheckBox dogCheckBox;
    private CheckBox catCheckBox;
    private CheckBox parrotCheckBox;

    private RadioGroup afraidCaninesRG;
    private RadioButton yesAfraidRB;
    private RadioButton noAfraidRB;

    private RadioGroup droolRG;
    private RadioButton yesDroolRB;
    private RadioButton noDroolRB;

    private TextView comfortableText;

    private RadioButton afraidRadioButton;
    private RadioButton droolRadioButton;

    private Button showResultButton;

    int dogCounter;
    int catCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dogCounter = 0;
        catCounter = 0;

        //Setting up the views
        showResultButton = (Button) findViewById(R.id.showResultButton);

        dogCheckBox = (CheckBox) findViewById(R.id.dogCheckBox);
        catCheckBox = (CheckBox) findViewById(R.id.catCheckBox);
        parrotCheckBox = (CheckBox) findViewById(R.id.parrotCheckBox);

        afraidCaninesRG = (RadioGroup) findViewById(R.id.afraidCaninesRG);
        yesAfraidRB = (RadioButton) findViewById(R.id.yes_afraid_radioButton);
        noAfraidRB = (RadioButton) findViewById(R.id.no_afraid_radioButton);

        droolRG = (RadioGroup) findViewById(R.id.droolingCheckBoxes);
        yesDroolRB = (RadioButton) findViewById(R.id.yes_droll_checkbox);
        noDroolRB = (RadioButton) findViewById(R.id.no_droll_checkbox);

        //checking radio buttons if user likes canines or not
        afraidCaninesRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int value = afraidCaninesRG.getCheckedRadioButtonId();
                afraidRadioButton = (RadioButton) findViewById(value);
                if (afraidRadioButton.getText().equals("No")) {
                    dogCounter += 5;
                    System.out.println(dogCounter);

                }

            }
        });

        //checking radio buttons if user likes drool or not
        droolRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int value = droolRG.getCheckedRadioButtonId();
                droolRadioButton = (RadioButton) findViewById(value);
                if (droolRadioButton.getText().equals("Yes")) {
                    dogCounter += 5;
                    System.out.println(dogCounter);

                }
            }
        });

        comfortableText = (TextView) findViewById(R.id.comfortableText);
        comfortableSeekBar = (SeekBar) findViewById(R.id.comfortableSeekBar);

        comfortableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int value = comfortableSeekBar.getProgress();
                comfortableText.setText("Comfortableness: " + value + "/" + comfortableSeekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        }
        );

        showResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //checking checkboxes for cutest
                if (dogCheckBox.isChecked() && !catCheckBox.isChecked() && !parrotCheckBox.isChecked()) {
                    dogCounter += 5;
                    System.out.println(dogCounter);
                }
                else if (!dogCheckBox.isChecked() && catCheckBox.isChecked() && !parrotCheckBox.isChecked()) {
                    catCounter += 5;
                    System.out.println(catCounter);
                }
                else {
                    //nothing
                }
                
                //make intents
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("dogCounter", dogCounter);
                intent.putExtra("catCounter", catCounter);

                startActivity(intent);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


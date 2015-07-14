package com.example.chris_000.catdogperson;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class ResultActivity extends ActionBarActivity {

    private ImageView resultPicture;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultPicture = (ImageView) findViewById(R.id.petImageView);
        resultText = (TextView) findViewById(R.id.resultTextView);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int catResult = extras.getInt("catCounter");
            int dogResult = extras.getInt("dogCounter");
            System.out.println(catResult + "and" +  dogResult);

            if (catResult < dogResult) {
                resultText.setText("You are a dog person!");
                resultPicture.setImageDrawable(getResources().getDrawable(R.drawable.dog_image));
            }
            else if(catResult > dogResult) {
                resultText.setText("You are a cat person!");
                resultPicture.setImageDrawable(getResources().getDrawable(R.drawable.cat_image));
            }
            else {
                resultText.setText("You are a cat and dog person!");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
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

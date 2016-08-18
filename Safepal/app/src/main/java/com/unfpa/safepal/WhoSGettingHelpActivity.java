package com.unfpa.safepal;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;

public class WhoSGettingHelpActivity extends AppCompatActivity {

    Spinner wsghRelationshipSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_who_s_getting_help);
        /***
         * Declaration and assignments of xml user interfaces*
         * */

        //Toolbar of the who's getting help activity
        Toolbar wsghToolbar = (Toolbar) findViewById(R.id.wsgh_toolbar);
        //Abort fab of  who's getting help activity
        FloatingActionButton wsghAbortAppFab = (FloatingActionButton) findViewById(R.id.wsgh_abort_app_fab);
        //Back fab of  who's getting help activity
        FloatingActionButton wsghBackFab = (FloatingActionButton) findViewById(R.id.wsgh_back_fab);
        //Next fab of  who's getting help activity
        FloatingActionButton wsghNextFab = (FloatingActionButton) findViewById(R.id.wsgh_next_fab);
        // choose someone else relationship spinner
        wsghRelationshipSpinner = (Spinner) findViewById(R.id.wsgh_relationship_spinner);


        setSupportActionBar(wsghToolbar);

        /***********  wsghRelationshipSpinner  ***************/

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> wsghRSadapter = ArrayAdapter.createFromResource(this,
                R.array.wsgh_someone_else_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        wsghRSadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the (wsghRSadapter to the spinner
        wsghRelationshipSpinner.setAdapter(wsghRSadapter);



        /***********  ends wsghRelationshipSpinner  ***************/

        wsghAbortAppFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Fab to kill and abort app", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_who_sgetting_help, menu);
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

    public void onWSGHRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.wsgh_yes_radio:
                if (checked)
                    // Pirates are the best
                wsghRelationshipSpinner.setVisibility(View.GONE);
                    break;
            case R.id.wsgh_someoneelse_button:
                if (checked)
                  wsghRelationshipSpinner.setVisibility(View.VISIBLE);
                    break;
        }
    }

}

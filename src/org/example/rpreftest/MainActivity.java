package org.example.rpreftest;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

	private EditText editText;
	private SharedPreferences sharedPref;
	private TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        sharedPref = getPreferences(MODE_PRIVATE);
        editText = (EditText) findViewById(R.id.editText1);
        msg = (TextView) findViewById(R.id.msg);
        
        Button button = (Button) findViewById(R.id.buttonSave);
        button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String name = editText.getText().toString();
				SharedPreferences.Editor editor = sharedPref.edit();
				editor.putString("name", name);
				editor.commit();
				
			}
		});
        
        button = (Button) findViewById(R.id.buttonGet);
        button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String name = sharedPref.getString("name", "not found");
				msg.setText(name);
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

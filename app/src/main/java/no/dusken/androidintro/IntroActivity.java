package no.dusken.androidintro;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class IntroActivity extends Activity implements View.OnClickListener{

    private Button myButton;
    private EditText nameText;
    private ListView nameList;

    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        myButton = (Button)findViewById(R.id.button);
        nameText = (EditText)findViewById(R.id.editText);
        nameList = (ListView)findViewById(R.id.listView);

        myButton.setOnClickListener(this);
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        nameList.setAdapter(listAdapter);
    }

    @Override
    public void onClick(View v) {
        listAdapter.add(nameText.getText().toString());
        nameText.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_intro, menu);
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

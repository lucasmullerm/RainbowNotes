package com.rainbownotes;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements View.OnClickListener, AdapterView.OnItemClickListener{

    ListView mainListView;
    ArrayList mNameList = new ArrayList();
    ArrayAdapter mArrayAdapter;
    Button addButton;
    EditText mainEditText;


    @Override
    public void onClick (View view) {
        Log.d("-------->>>CLICOU", "clicou no botao");
        mNameList.add(mainEditText.getText().toString());
        mArrayAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("-------->>>>ADICIONOU", position + ": " + mNameList.get(position));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView mainTextView = (TextView) findViewById(R.id.main_textview);
        //mainTextView.setText("Novo Texto ");

        mainListView = (ListView) findViewById(R.id.main_listview);
        mArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mNameList);
        mainListView.setAdapter(mArrayAdapter);



        addButton = (Button) findViewById(R.id.add_button);
        addButton.setOnClickListener(this);

        mainListView.setOnItemClickListener(this);

        mainEditText = (EditText) findViewById(R.id.main_edittext);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /*@Override
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
    }*/
}

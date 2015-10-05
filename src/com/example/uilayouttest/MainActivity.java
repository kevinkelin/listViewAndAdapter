package com.example.uilayouttest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private String[] data = { "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Strawberry",
			"Cherry", "Mango" };

	private List<Fruit> frutlist = new ArrayList<Fruit>();

	private void initFruit() {
		Fruit apple = new Fruit("apple");
		Fruit banana = new Fruit("banane");
		Fruit orange = new Fruit("orange");
		Fruit Watermelon = new Fruit("Watermelon");
		Fruit Pear = new Fruit("Pear");
		Fruit Grape = new Fruit("Grape");
		Fruit Strawberry = new Fruit("Strawberry");
		Fruit Pineapple = new Fruit("Pineapple");
		Fruit Cherry = new Fruit("Cherry");
		Fruit Mango = new Fruit("Mango");
		frutlist.add(apple);
		frutlist.add(banana);
		frutlist.add(Mango);
		frutlist.add(Cherry);
		frutlist.add(Pineapple);
		frutlist.add(Strawberry);
		frutlist.add(Grape);
		frutlist.add(Pear);
		frutlist.add(Watermelon);
		frutlist.add(orange);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		initFruit();

		// ArrayAdapter<String> adapter = new
		// ArrayAdapter<String>(MainActivity.this,
		// android.R.layout.simple_list_item_1,
		// data);
		// ListView listView = (ListView) findViewById(R.id.list_view);
		// listView.setAdapter(adapter);

		FruitAdapter adapter = new FruitAdapter(MainActivity.this, R.layout.fruit_item, frutlist);
		ListView listView = (ListView) findViewById(R.id.list_view);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				String name = frutlist.get(position).getName();
				Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();

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

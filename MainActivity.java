package com.example.menuapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView menuListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuListView = findViewById(R.id.menuListView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu resource file to populate the menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // If the "Show Menu" button is clicked, display the list of menu items
        if (item.getItemId() == R.id.action_menu) {
            // Create an array of menu items
            String[] menuItems = {"New", "Open", "Save"};

            // Set up an ArrayAdapter to display the menu items in the ListView
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, menuItems);
            menuListView.setAdapter(adapter);

            // Set an item click listener to show a Toast when a menu item is clicked
            menuListView.setOnItemClickListener((parent, view, position, id) -> {
                String clickedItem = menuItems[position];
                Toast.makeText(MainActivity.this, "Menu Item: " + clickedItem, Toast.LENGTH_SHORT).show();
            });

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


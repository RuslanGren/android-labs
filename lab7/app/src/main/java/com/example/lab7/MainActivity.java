package com.example.lab7;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.friendsList);

        String[] projection = {FriendsContract.Columns._ID,
                FriendsContract.Columns.NAME,
                FriendsContract.Columns.PHONE};

        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(FriendsContract.CONTENT_URI, projection, null, null, null);

        if (cursor != null) {
            String[] from = {FriendsContract.Columns.NAME, FriendsContract.Columns.PHONE};
            int[] to = {android.R.id.text1, android.R.id.text2};

            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_2,
                    cursor,
                    from,
                    to,
                    0);
            listView.setAdapter(adapter);
        }
    }
}

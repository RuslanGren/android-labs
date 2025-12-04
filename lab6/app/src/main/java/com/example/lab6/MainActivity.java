package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvProducts = findViewById(R.id.productList);

        ArrayList<ProductItem> itemList = new ArrayList<>();
        itemList.add(new ProductItem("Морква", "кг"));
        itemList.add(new ProductItem("Кава", "шт"));
        itemList.add(new ProductItem("Яйця", "шт"));
        itemList.add(new ProductItem("Вода", "л"));
        itemList.add(new ProductItem("Гречка", "кг"));

        ProductListAdapter adapter = new ProductListAdapter(this, R.layout.list_item, itemList);

        lvProducts.setAdapter(adapter);
    }
}

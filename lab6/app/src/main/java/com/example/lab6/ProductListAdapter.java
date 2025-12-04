package com.example.lab6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

public class ProductListAdapter extends ArrayAdapter<ProductItem> {

    private final LayoutInflater inflater;
    private final int layoutRes;
    private final ArrayList<ProductItem> items;

    public ProductListAdapter(Context context, int resource, ArrayList<ProductItem> objects) {
        super(context, resource, objects);
        this.items = objects;
        this.layoutRes = resource;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(layoutRes, parent, false);
            holder = new ItemViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ItemViewHolder) convertView.getTag();
        }

        ProductItem product = items.get(position);
        holder.name.setText(product.getTitle());
        holder.quantity.setText(product.getQuantity() + " " + product.getUnit());

        holder.btnMinus.setText("-");
        holder.btnPlus.setText("+");

        holder.btnMinus.setOnClickListener(v -> {
            int q = product.getQuantity() - 1;
            if (q < 0) q = 0;
            product.setQuantity(q);
            holder.quantity.setText(q + " " + product.getUnit());
        });

        holder.btnPlus.setOnClickListener(v -> {
            int q = product.getQuantity() + 1;
            product.setQuantity(q);
            holder.quantity.setText(q + " " + product.getUnit());
        });

        return convertView;
    }

    private static class ItemViewHolder {
        final TextView name, quantity;
        final Button btnMinus, btnPlus;

        ItemViewHolder(View v) {
            name = v.findViewById(R.id.nameView);
            quantity = v.findViewById(R.id.countView);
            btnMinus = v.findViewById(R.id.removeButton);
            btnPlus = v.findViewById(R.id.addButton);
        }
    }
}

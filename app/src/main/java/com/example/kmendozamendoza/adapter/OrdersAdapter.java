package com.example.kmendozamendoza.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.kmendozamendoza.model.Order;
import com.example.kmendozamendoza.myapplication.R;

import java.util.ArrayList;

/**
 * Created by k.mendoza.mendoza on 13/03/2017.
 */

public class OrdersAdapter extends ArrayAdapter<Order> {

    public OrdersAdapter(Context context, Order[] users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Order order = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.order, parent, false);
        }
        // Lookup view for data population
        TextView orderDate = (TextView) convertView.findViewById(R.id.orderDate);
        TextView orderNumber = (TextView) convertView.findViewById(R.id.orderNumber);
        TextView orderCustomer = (TextView) convertView.findViewById(R.id.orderCustomer);
        TextView orderTotal = (TextView) convertView.findViewById(R.id.orderTotal);
        // Populate the data into the template view using the data object
        orderDate.setText(order.getDate().toString());
        orderNumber.setText(order.getId().toString());
        orderCustomer.setText(order.getUser());
        orderTotal.setText("$" + order.getTotal().toString());
        // Return the completed view to render on screen
        return convertView;
    }
}
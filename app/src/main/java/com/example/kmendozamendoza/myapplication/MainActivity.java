package com.example.kmendozamendoza.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.kmendozamendoza.adapter.OrdersAdapter;
import com.example.kmendozamendoza.model.Order;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        new HttpRequestTask().execute();
    }

    public void goToGraph(View view){
        Intent intent = new Intent(this, PieChartActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_go_to_graphs) {
            Intent intent = new Intent(this, PieChartActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class HttpRequestTask extends AsyncTask<Void, Void, Order[]> {
        @Override
        protected Order[] doInBackground(Void... params) {
            try {
                final String url = "http://10.0.2.2:8090/orderList";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                ResponseEntity<Order[]> responseEntity = restTemplate.getForEntity(url, Order[].class);
                Order[] orders = responseEntity.getBody();

                return orders;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }

        @Override
        protected void onPostExecute(Order[] orders) {
            // Create the adapter to convert the array to views
            OrdersAdapter adapter = new OrdersAdapter(MainActivity.this, orders);
            // Attach the adapter to a ListView
            ListView listView = (ListView) findViewById(R.id.listView);
            listView.setAdapter(adapter);
            View header = getLayoutInflater().inflate(R.layout.header, null);
            if(listView.getHeaderViewsCount() == 0) {
                listView.addHeaderView(header);
            }
        }
    }
}

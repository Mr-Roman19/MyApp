package com.mirea.kornelyuk.galperina.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mirea.kornelyuk.galperina.myapp.model.Course;
import com.mirea.kornelyuk.galperina.myapp.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        ListView orders_list = findViewById(R.id.orders_list);
        List<String> coursesTitle = new ArrayList<>();
        for(Course c: MainActivity.fullCoursesList){
            if(Order.items_id.contains(c.getId()))
                coursesTitle.add(c.getTitle());
        }
        orders_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,coursesTitle));
    }
}
package com.mirea.kornelyuk.galperina.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mirea.kornelyuk.galperina.myapp.adapter.CategoryAdapter;
import com.mirea.kornelyuk.galperina.myapp.model.Category;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView categoryRecycler;
    CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Мясо"));
        categoryList.add(new Category(2, "Птица"));
        categoryList.add(new Category(3, "Рыба"));
        categoryList.add(new Category(4,"Супы"));
        categoryList.add(new Category(5, "Салаты"));
        categoryList.add(new Category(6, "Десерты"));
        categoryList.add(new Category(7, "Выпечка"));

        setCategoryRecycler(categoryList);
    }

    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }
}
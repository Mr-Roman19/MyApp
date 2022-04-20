package com.mirea.kornelyuk.galperina.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mirea.kornelyuk.galperina.myapp.adapter.CategoryAdapter;
import com.mirea.kornelyuk.galperina.myapp.adapter.CourseAdapter;
import com.mirea.kornelyuk.galperina.myapp.model.Category;
import com.mirea.kornelyuk.galperina.myapp.model.Course;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    CourseAdapter courseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Мясо"));
        categoryList.add(new Category(2, "Птица"));
        categoryList.add(new Category(3,"Супы"));
        categoryList.add(new Category(4, "Салаты"));
        categoryList.add(new Category(5, "Десерты"));
        categoryList.add(new Category(6, "Выпечка"));

        setCategoryRecycler(categoryList);


        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course(1, "tramezzino", "Бургеры",  "Новичок", "25 минут","#F0F8C1", "Test"));
        courseList.add(new Course(2, "thank_2", "Курица-ляв\naнги",  "Средний","1,5 часа" ,"#F0F8C1", "Test"));
        courseList.add(new Course(3,"food_meat_gumbo", "Йеменский \nкуриный суп",  "Средний","2,5 часа", "#F0F8C1", "Test"));
        courseList.add(new Course(4, "food_big_salad", "Салат «Табуле»\n с петрушкой",  "Средний","25 минут", "#F0F8C1", "Test" ));
        courseList.add(new Course(5, "flambyxvi", "Еврейский яблочный пирог",  "Средний", "1,5 часа","#F0F8C1", "Test" ));
        courseList.add(new Course(6, "mincemeat_pie", "Нежная творожная запеканка", "Средний","1,5 часа", "#F0F8C1", "Test" ));

        setCourseRecycler(courseList);
    }

    private void setCourseRecycler(List<Course> courseList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);

        courseAdapter = new CourseAdapter(this, courseList);
        courseRecycler.setAdapter(courseAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }
}
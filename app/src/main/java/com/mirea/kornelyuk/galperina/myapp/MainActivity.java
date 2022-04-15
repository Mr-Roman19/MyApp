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
        categoryList.add(new Category(3, "Рыба"));
        categoryList.add(new Category(4,"Супы"));
        categoryList.add(new Category(5, "Салаты"));
        categoryList.add(new Category(6, "Десерты"));
        categoryList.add(new Category(7, "Выпечка"));

        setCategoryRecycler(categoryList);


        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course(1, "sandv", "Бургеры",  "Новичок", "25 минут","#F0F8C1"));
        courseList.add(new Course(2, "chickenplate", "Курица-ляванги азербайджанских евреев",  "Средний","1,5 часа" ,"#F0F8C1"));
        courseList.add(new Course(3, "fish", "Гефильте Фиш",  "Продвинутый","3 часа", "#F0F8C1" ));
        courseList.add(new Course(4,"soup", "Йеменский куриный суп",  "Средний","2,5 часа", "#F0F8C1"));
        courseList.add(new Course(5, "salad", "Салат «Табуле» с петрушкой",  "Средний","25 минут", "#F0F8C1" ));
        courseList.add(new Course(6, "bake", "Кугл с яблоками, изюмом и корицей",  "Средний", "1,5 часа","#F0F8C1" ));
        courseList.add(new Course(7, "pie", "Нежная творожная запеканка", "Средний","1,5 часа", "#F0F8C1" ));

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
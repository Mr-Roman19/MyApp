package com.mirea.kornelyuk.galperina.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mirea.kornelyuk.galperina.myapp.model.Order;

public class CoursePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page);

        ConstraintLayout courseBg = findViewById(R.id.coursePageBg);
        ImageView courseImage =  findViewById(R.id.coursePageImage);
        TextView courseTitle =  findViewById(R.id.coursePageTitle);
        TextView courseData =  findViewById(R.id.coursePageDate);
        TextView courseLvl =  findViewById(R.id.coursePageLvl);
        TextView courseText =  findViewById(R.id.coursePageText);

        courseBg.setBackgroundColor(getIntent().getIntExtra("courseBg",0));
        courseImage.setImageResource(getIntent().getIntExtra("courseImge", 0));
        courseTitle.setText(getIntent().getStringExtra("courseTitle"));
        courseData.setText(getIntent().getStringExtra("courseData"));
        courseLvl.setText(getIntent().getStringExtra("courseLvl"));
        courseText.setText(getIntent().getStringExtra("courseText"));

    }

    public void addToCard(View view){
        int item_id = getIntent().getIntExtra("courseId",0);
        Order.items_id.add(item_id);
        Toast.makeText(this,"Добавлено", Toast.LENGTH_LONG).show();
    }
}
package com.mirea.kornelyuk.galperina.myapp.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mirea.kornelyuk.galperina.myapp.CoursePage;
import com.mirea.kornelyuk.galperina.myapp.R;
import com.mirea.kornelyuk.galperina.myapp.model.Course;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    Context context;
    List<Course> courses;

    public CourseAdapter(Context context, List<Course> courses) {
        this.context = context;
        this.courses = courses;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View courseItem = LayoutInflater.from(context).inflate(R.layout.course_item, parent, false);//для всех эл определенный дизайн
        return new CourseViewHolder(courseItem);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.courseBg.setCardBackgroundColor(Color.parseColor(courses.get(position).getColour())); //цвет фона
        int imageId = context.getResources().getIdentifier("ic_" + courses.get(position).getImg(), "drawable", context.getPackageName()); //получаем картинку из строки в id
        holder.courseImage.setImageResource(imageId); //изображение
        holder.courseTitle.setText(courses.get(position).getTitle());
        holder.courseData.setText(courses.get(position).getDate());
        holder.courseLvl.setText(courses.get(position).getLvl());
        holder.itemView.setOnClickListener(new View.OnClickListener() { //обработка событий перелистывания
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CoursePage.class);

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) context, new Pair<View, String>(holder.courseImage, "courseImage"));

                intent.putExtra("courseBg",Color.parseColor(courses.get(position).getColour()));
                intent.putExtra("courseImage", imageId);
                intent.putExtra("courseTitle", courses.get(position).getTitle());
                intent.putExtra("courseData", courses.get(position).getDate());
                intent.putExtra("courseLvl",courses.get(position).getLvl());
                intent.putExtra("courseText",courses.get(position).getText());
                context.startActivity(intent, options.toBundle());

            }
        });

    }


    @Override
    public int getItemCount() {
        return courses.size();
    }

    public  static final class CourseViewHolder extends RecyclerView.ViewHolder{
        CardView courseBg;
        ImageView courseImage;
        TextView courseTitle, courseLvl, courseData;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);

            courseBg = itemView.findViewById(R.id.courseBg);
            courseImage = itemView.findViewById(R.id.courseImage);
            courseTitle = itemView.findViewById(R.id.courseTitle);
            courseData = itemView.findViewById(R.id.courseDate);
            courseLvl = itemView.findViewById(R.id.courseLvl);
        }
    }
}

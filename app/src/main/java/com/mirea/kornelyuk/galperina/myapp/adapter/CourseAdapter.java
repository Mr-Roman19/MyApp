package com.mirea.kornelyuk.galperina.myapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        return new CourseAdapter.CourseViewHolder(courseItem);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        holder.courseBg.setBackgroundColor(Color.parseColor(courses.get(position).getColour())); //цвет фона
        int imageId = context.getResources().getIdentifier("ic_" + courses.get(position).getImg(), "drawable", context.getPackageName()); //получаем картинку из строки в id
        holder.courseImage.setImageResource(imageId); //изображение
        holder.courseTitle.setText(courses.get(position).getTitle());
        holder.courseData.setText(courses.get(position).getDate());
        holder.courseLvl.setText(courses.get(position).getLvl());

    }


    @Override
    public int getItemCount() {
        return courses.size();
    }

    public  static final class CourseViewHolder extends RecyclerView.ViewHolder{
        LinearLayout courseBg;
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

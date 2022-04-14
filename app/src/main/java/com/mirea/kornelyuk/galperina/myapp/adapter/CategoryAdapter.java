package com.mirea.kornelyuk.galperina.myapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mirea.kornelyuk.galperina.myapp.R;
import com.mirea.kornelyuk.galperina.myapp.model.Category;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    Context context; //сюда будем передавать страницу на которой все будет выведено
    List<Category> categories;//список с категориями

    public CategoryAdapter(Context context, List<Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    //отображение пользователю
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View categoryItems = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false);//для всех эл определенный дизайн
        return new CategoryViewHolder(categoryItems);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {// что будем подставлять в полч
        holder.categoryTitle.setText(categories.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
    //можем обратиться к определенному дизайну и выбрать нужный элемент
    public static final class CategoryViewHolder extends  RecyclerView.ViewHolder{
        TextView categoryTitle;//какие поля будем менять (текст на овалах)

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryTitle = itemView.findViewById(R.id.categoryTitle);
        }
    }
}

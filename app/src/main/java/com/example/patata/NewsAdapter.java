package com.example.patata;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;
import java.util.Map;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private List<NewsItem> newsList;
    private String selectedLanguage;

    public NewsAdapter(List<NewsItem> newsList, String selectedLanguage) {
        this.newsList = newsList;
        this.selectedLanguage = selectedLanguage;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        NewsItem newsItem = newsList.get(position);
        Map<String, String> translations = newsItem.getTranslations();
        String message = translations != null ? translations.get(selectedLanguage) : "";
        holder.newsTitle.setText(message);
        Glide.with(holder.itemView.getContext()).load(newsItem.getImageLink()).into(holder.newsImage);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public void setLanguage(String language) {
        this.selectedLanguage = language;
        notifyDataSetChanged();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView newsTitle;
        ImageView newsImage;

        public NewsViewHolder(View itemView) {
            super(itemView);
            newsTitle = itemView.findViewById(R.id.news_title);
            newsImage = itemView.findViewById(R.id.news_image);
        }
    }
}

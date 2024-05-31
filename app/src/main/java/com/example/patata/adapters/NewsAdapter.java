package com.example.patata.adapters;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.patata.R;
import com.example.patata.models.NewsItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private List<NewsItem> newsItems;
    private String language = "en"; // Default language

    public NewsAdapter(List<NewsItem> newsItems) {
        this.newsItems = newsItems;
    }

    public void setLanguage(String language) {
        this.language = language;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        NewsItem newsItem = newsItems.get(position);
        String translatedMessage = newsItem.getTranslations().get(language);
        holder.newsTextView.setText(translatedMessage != null ? translatedMessage : newsItem.getMessage());
        Picasso.get().load(newsItem.getImageLink()).into(holder.newsImageView);
        holder.newsLinkTextView.setText(newsItem.getLink());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir el enlace en el navegador
                String link = newsItem.getLink(); // Obtener el enlace del elemento
                Uri uri = Uri.parse(link);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsItems.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView newsTextView;
        ImageView newsImageView;
        TextView newsLinkTextView;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            newsTextView = itemView.findViewById(R.id.news_text);
            newsImageView = itemView.findViewById(R.id.news_image);
            newsLinkTextView = itemView.findViewById(R.id.news_link);
        }
    }
}

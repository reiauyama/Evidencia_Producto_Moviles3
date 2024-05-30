package com.example.patata;

import java.util.Map;

public class NewsItem {
    private String imageLink;
    private Map<String, String> translations;

    // Constructor
    public NewsItem(String imageLink, Map<String, String> translations) {
        this.imageLink = imageLink;
        this.translations = translations;
    }

    // Getter for image link
    public String getImageLink() {
        return imageLink;
    }

    // Getter for translations
    public Map<String, String> getTranslations() {
        return translations;
    }
}

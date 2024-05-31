package com.example.patata;

import java.util.Map;

public class NewsItem {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    private String link;
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

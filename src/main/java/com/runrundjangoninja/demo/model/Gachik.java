package com.runrundjangoninja.demo.model;

import java.net.URL;

//POJOPE
public class Gachik {
    public static final int MAXIMUM_RATING = 5;

    private String name;
    private URL url;
    private double rating;

    public Gachik(String name, URL url, double rating) {
        this.name = name;
        this.url = url;
        setRating(rating);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        if (rating < 0) {
            this.rating = 0;
        } else if (rating > MAXIMUM_RATING) {
            this.rating = MAXIMUM_RATING;
        } else {
            this.rating = rating;
        }
    }
}

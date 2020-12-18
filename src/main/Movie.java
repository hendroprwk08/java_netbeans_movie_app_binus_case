package main;

import java.util.Comparator;

public class Movie {
    String id, title, genre;
    int price, rating;

    //GENERATE alt + ins 
    public Movie(String id, 
            String title, 
            String genre, 
            int rating, 
            int price) {
        
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.price = price;
    }
        
    //GENERATE alt + ins 
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    
    public String getGenre() {
        return genre;
    }

    public int getRating() {
        return rating;
    }
    
    public int getPrice() {
        return price;
    }
    
    //sort by name
    public static Comparator<Movie> sortByName = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.title.compareTo(o2.title);
        }
    }; 
}

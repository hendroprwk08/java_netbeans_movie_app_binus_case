package main;

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
}

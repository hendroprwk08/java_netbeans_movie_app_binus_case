package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Java_netbeans_movie_app_binus_case {

    public static void main(String[] args) {
        ArrayList<Movie> movies = new ArrayList();
        Scanner sc = new Scanner(System.in);
        int pilih = 0;
    
        do{
            System.out.println("=========================================");
            System.out.println("           BALADA MOVIE RENTAL");
            System.out.println("=========================================");
            System.out.println("  1. Add New Movie ");
            System.out.println("  2. View Movie (Sort by Title ascending)");
            System.out.println("  3. Rent Movie");
            System.out.println("  4. EXIT");
            System.out.println("=========================================");
            System.out.print(" Type [ 1, 2, 3 or 4 ]: " );
            pilih = sc.nextInt();
        
            if ( pilih == 1 ){
                movies = addMovies( movies );
            }else if ( pilih == 2 ){
                viewMovies( movies );
            }else if ( pilih == 3 ){
                movies = rentMovies( movies );
            }
        }while( pilih != 4 );
    }

    private static ArrayList<Movie> addMovies(ArrayList<Movie> m) {
        ArrayList<Movie> movies = new ArrayList();
        Scanner sc = new Scanner(System.in);
        String id, title, genre;
        int price, add_price = 0, rating;
        
        movies = m; //tampung array list
       
        //cek panjang string
        boolean ok = false;
        do{ 
            System.out.print("Movie’s Title: ");
            title = sc.nextLine();
            
            if ( title.length() >= 3 || title.length() <= 20  ){
                ok = true;
            }
        } while ( ok == false );
        
        //cek genre
        ok = false;
        do{ 
            System.out.print("Movie’s Genre: ");
            genre = sc.nextLine();
            
            if ( genre.equals("Horror") ) {
                add_price = 5000;
                ok = true;
            }else if ( genre.equals("Comedy") ) {
                add_price = 3000;
                ok = true;
            }else if ( genre.equals("Action") ) {
                add_price = 4000;
                ok = true;
            }
        } while ( ok == false );
        
        //cek rating
        ok = false;
        do{ 
            System.out.print("Movie’s Rating: ");
            rating = sc.nextInt();
            
            if ( rating >= 1 && rating <= 10 ){ 
                ok = true;
            }
        } while ( ok == false );
        
        //generate ID ( random )
        Random rnd = new Random(); 
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 
        id = chars.charAt(rnd.nextInt(chars.length()))+ ""+
            chars.charAt(rnd.nextInt(chars.length()))+ ""+
            String.valueOf( rnd.nextInt(8) ) + ""+ 
            String.valueOf( rnd.nextInt(8) ) + ""+ 
            String.valueOf( rnd.nextInt(8) );
        
        System.out.print("Generated MovieID: "+ id);
        
        //price
        price = ( ( title.length() * 500 ) + add_price );
        movies.add( new Movie( id, title, genre, rating, price ) );
        return movies;
    }

    private static void viewMovies(ArrayList<Movie> m) {
        Scanner sc = new Scanner(System.in);
        
        if ( m.size() == 0){
            System.out.println("No Movie Found");
            sc.nextLine();
        }else{
            System.out.println("Sort by title");
            System.out.print("=====================================================================================");
            System.out.println();
            System.out.printf("| %-5s| %-15s| %-13s| %-13s| %-13s| %-13s|", 
                    "No. ", 
                    "ID", 
                    "Title", 
                    "Genre", 
                    "Rating", 
                    "Price");
            System.out.println();
            System.out.print("=====================================================================================");
            System.out.println();
            
            int num = 1;
		
            for(int i = 0; i < m.size(); i++ ) {
                System.out.printf("| %-5s| %-15s| %-13s| %-13s| %-13s| %-13s|", 
                    num++ , 
                    m.get(i).getId(), 
                    m.get(i).getTitle(), 
                    m.get(i).getGenre(), 
                    m.get(i).getRating(), 
                    m.get(i).getPrice());
                System.out.println();
            }
            
            System.out.print("=====================================================================================");
            System.out.println();
            System.out.print("Press enter to continue..");
            sc.nextLine();
        }
    }

    private static ArrayList<Movie> rentMovies(ArrayList<Movie> movies) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

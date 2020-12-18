package main;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Collections;
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
                rentMovies( movies );
            }
        }while( pilih != 4 );
    }

    private static ArrayList<Movie> addMovies(ArrayList<Movie> m) {
        Scanner sc = new Scanner(System.in);
        String id, title, genre;
        int price, add_price = 0, rating;
        
        //cek panjang string
        boolean ok = false;
        do{ 
            System.out.print("Movie’s Title: ");
            title = sc.nextLine();
            
            if ( title.length() >= 3 || title.length() <= 20  ){
                ok = true;
            }else{
                System.out.println("[ type between 3 - 20 char ]: ");
                ok = false;
            }
            
        } while ( ok == false );
        
        //cek genre
        ok = false;
        do{ 
            System.out.print("Movie’s Genre [ Comedy / Action / Horror ]: ");
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
            }else{
                System.out.println("[ Wrong genre ]");
                ok = false;
            }
        } while ( ok == false );
        
        //cek rating
        ok = false;
        do{ 
            System.out.print("Movie’s Rating [ 1 - 10 ]: ");
            rating = sc.nextInt();
            
            if ( rating >= 1 && rating <= 10 ){ 
                ok = true;
            }else{
                System.out.print( "[ rating between 1 - 10 ]");
                ok = false;
            }
        } while ( ok == false );
        
        //price
        price = ( ( title.length() * 500 ) + add_price );
        System.out.println("Rent price: "+ price);
        
        //generate ID ( random )
        Random rnd = new Random(); 
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 
        id = chars.charAt(rnd.nextInt(chars.length()))+ ""+
            chars.charAt(rnd.nextInt(chars.length()))+ ""+
            String.valueOf( rnd.nextInt(8) ) + ""+ 
            String.valueOf( rnd.nextInt(8) ) + ""+ 
            String.valueOf( rnd.nextInt(8) );
        
        System.out.println("Generated MovieID: "+ id);
        
        m.add( new Movie( id, title, genre, rating, price ) );
        
        System.out.println( "[ "+ title +" added!  ] Press enter to continue.." );
        sc.nextLine();
        sc.nextLine();
        
        return m;
    }

    private static void viewMovies( ArrayList<Movie> m ) {
        Scanner sc = new Scanner(System.in);
        
        if ( m.size() == 0){
            System.out.println("No Movie Found");
            sc.nextLine();
        }else{
            System.out.println("Sort by title");
            System.out.print("=====================================================================================");
            System.out.println();
            System.out.printf("| %-3s| %-6s| %-20s| %-10s| %-10s| %-10s|", 
                    "No. ", 
                    "ID", 
                    "Title", 
                    "Genre", 
                    "Rating", 
                    "Price");
            System.out.println();
            System.out.print("=====================================================================================");
            System.out.println();
        
            Collections.sort(m, Movie.sortByName);
            
            int num = 1;
		
            for(int i = 0; i < m.size(); i++ ) {
                System.out.printf("| %-4s| %-6s| %-20s| %-10s| %-10s| %-10s|", 
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

    private static void rentMovies(ArrayList<Movie> m) {
        Scanner sc = new Scanner(System.in);
        int idx = 0, jumlah = 0, bayar = 0;
        boolean correct;
        
        //view movies
        System.out.println( "[ Type "+ ( m.size() + 1 ) +" to check out ]" );
        System.out.print("=========================================================================");
        System.out.println();
        System.out.printf("| %-3s| %-6s| %-20s| %-10s| %-10s| %-10s|", 
                "No. ", 
                "ID", 
                "Title", 
                "Genre", 
                "Rating", 
                "Price");
        System.out.println();
        System.out.print("=========================================================================");
        System.out.println();

        Collections.sort(m, Movie.sortByName);

        int num = 1;
        for(int i = 0; i < m.size(); i++ ) {
            System.out.printf("| %-4s| %-6s| %-20s| %-10s| %-10s| %-10s|", 
            num++ , 
            m.get(i).getId(), 
            m.get(i).getTitle(), 
            m.get(i).getGenre(), 
            m.get(i).getRating(), 
            m.get(i).getPrice());
            System.out.println();
        }

        System.out.print("=========================================================================");
        System.out.println();
        
        correct = true;
        do{ 
            System.out.print( "Choose Movie index [ 1 - "+ m.size() +" ]: " );
            idx = sc.nextInt();
            
            if ( idx > 0 && idx <= m.size() ){ 
                jumlah += m.get( idx - 1 ).getPrice();
                System.out.println( m.get( idx - 1 ).getTitle() + " " + m.get( idx - 1 ).getPrice() );
                correct = true;
            }else{
                correct = false;
            }
        } while ( correct == true );
        
        //payment
        System.out.println( "Total: "+ jumlah );
        
        correct = true;
        do{ 
            System.out.print( "Amount: ");
            bayar = sc.nextInt();
            
            if ( bayar < jumlah ){ 
                System.out.println( "[ less than Total ]");
                correct = false;
            }else{
                correct = true;
            }
        } while ( correct == false );
        
        System.out.println( "Change: "+ abs( bayar - jumlah ) );
        System.out.println( "[ Succesfully add new order! ]. Press enter to continue.." );
        sc.nextLine();
        sc.nextLine();
    }
}

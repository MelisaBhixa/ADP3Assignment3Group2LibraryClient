package za.ac.cput.factory;

import za.ac.cput.entity.BookGenre;
import za.ac.cput.util.GenericHelper;

/*
 * Genre.java
 * This code represents an entity using the builder pattern
 * @author Plamedie Bitota Bukasa (219260532)
 * Date: 10th June 2021
 */
public class BookGenreFactory {

        public static BookGenre createBookGenre()
        {
            // generating ids for book genre and bookgenre
            String generatedNumber= GenericHelper.generateId();
            BookGenre bookGenre=new BookGenre.Builder()
                    .setBookGenreId(generatedNumber)
                    .setGenreId(generatedNumber)
                    .setBookId(generatedNumber)
                    .build();
            return bookGenre;
        }
}

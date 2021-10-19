package za.ac.cput.factory;
import za.ac.cput.entity.Genre;
import za.ac.cput.util.GenericHelper;

/*
 * Genre.java
 * This code represents an entity using the builder pattern
 * @author Plamedie Bitota Bukasa (219260532)
 * Date: 10th June 2021
 */
public class GenreFactory
{
    public static Genre createGenre(String name)
    {
        // Name of the book genre
        String generatedNumber= GenericHelper.generateId();
        // getting a generated ID for the specific genre
        //creating or adding another genre
        Genre genre=new Genre.Builder()
                .setGenreId(generatedNumber)
                .setName(name)
                .build();
        return genre;
    }
}

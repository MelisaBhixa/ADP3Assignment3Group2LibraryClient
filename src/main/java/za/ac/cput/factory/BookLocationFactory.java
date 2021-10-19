package za.ac.cput.factory;

/**
 * bookLocationFactory.java
 * This code represents the BookLocationFactory.
 * @author: Melven Johannes Booysen (219201277)
 * Date: 10 June 2021
 */

//private String shelfLocation, genreId;
import za.ac.cput.entity.BookLocation;
import za.ac.cput.util.GenericHelper;

public class BookLocationFactory
{
    public static BookLocation createBookLocation (String shelfLocation, String genreId)
    {
        genreId = GenericHelper.generateId();
        shelfLocation = GenericHelper.generateId();

        //creating instance
        BookLocation bookLocation = new BookLocation.Builder()
                .setGenreId(genreId)
                .setShelfLocation(shelfLocation)
                .build();

        return bookLocation;
    }

}//*** End of class

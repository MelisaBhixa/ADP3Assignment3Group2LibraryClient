package za.ac.cput.factory;

import za.ac.cput.entity.BookLoanLog;
import za.ac.cput.util.GenericHelper;

import java.util.Date;

public class BookLoanLogFactory {

    public static BookLoanLog createBookLoanLog(Date lentFromDate, Date lentToDate, boolean isCheckOut){

        String bookLoanLogId = GenericHelper.generateId();
        String userId = GenericHelper.generateId();
        String bookId = GenericHelper.generateId();

        if(lentFromDate == null || lentToDate == null){
            return null;
        }

        return new BookLoanLog.Builder()
                .setBookLoanLogId(bookLoanLogId)
                .setUserId(userId)
                .setBookId(bookId)
                .setLentFromDate(lentFromDate)
                .setLentToDate(lentToDate)
                .setCheckOut(isCheckOut)
                .build();

    }
}

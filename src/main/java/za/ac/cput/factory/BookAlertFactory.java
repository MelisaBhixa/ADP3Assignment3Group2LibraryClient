package za.ac.cput.factory;


import za.ac.cput.entity.BookAlert;
import za.ac.cput.util.GenericHelper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
    Author: Ruphin Bolonda
    Student Number: 218321392
    Description: BookAlertFactory class
 */

public class BookAlertFactory {

    public static BookAlert createBookAlert(String createdBy,String message,boolean solved)
    {
        if(createdBy.isEmpty() || message.isEmpty()){
            return null;
        }
        String bookAlertNumber = GenericHelper.generateId();
        String alertNumber = GenericHelper.generateId();
        String bookId = GenericHelper.generateId();
        String createdDate = getCurrentDate();
        String createdTime = getCurrentTime();

        BookAlert bookAlert = BookAlert.bookAlertBuilder()
                                .withBookAlertNumber(bookAlertNumber)
                                .withAlertNumber(alertNumber)
                                .withBookId(bookId)
                                .withCreatedBy(createdBy)
                                .withCreatedDate(createdDate)
                                .withCreatedTime(createdTime)
                                .withSolved(solved)
                                .build();
        return bookAlert;


    }

    private static String getCurrentDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    private static String getCurrentTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}

package za.ac.cput.entity;

/*
    Author: Ruphin Bolonda
    Student Number: 218321392
    Description: BookLoanLog Entity using Builder Pattern
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class BookLoanLog implements Serializable {
    @Id
    private String bookLoanLogId;
    private String userId;
    private String bookId;
    String lentFromDate;
    String lentToDate;
    boolean isCheckOut;


    private BookLoanLog(){}

    private BookLoanLog(Builder builder){
        this.bookLoanLogId = builder.bookLoanLogId;
        this.userId = builder.userId;
        this.bookId = builder.bookId;
        this.lentFromDate = builder.lentFromDate;
        this.lentToDate = builder.lentToDate;
        this.isCheckOut = builder.isCheckOut;
    }

    public String getBookLoanLogId() {
        return bookLoanLogId;
    }

    public String getUserId() {
        return userId;
    }

    public String getBookId() {
        return bookId;
    }

    public String getLentFromDate() {
        return lentFromDate;
    }

    public String getLentToDate() {
        return lentToDate;
    }

    public boolean isCheckOut() {
        return isCheckOut;
    }

    @Override
    public String toString() {
        return "BookLoanLog{" +
                "bookLoanLogId='" + bookLoanLogId + '\'' +
                ", userId='" + userId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", lentFromDate=" + lentFromDate +
                ", lentToDate=" + lentToDate +
                ", isCheckOut=" + isCheckOut +
                '}';
    }

    public static class Builder{
        private String bookLoanLogId;
        private String userId;
        private String bookId;
        String lentFromDate;
        String lentToDate;
        boolean isCheckOut;

        public Builder setBookLoanLogId(String bookLoanLogId) {
            this.bookLoanLogId = bookLoanLogId;
            return this;
        }

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setBookId(String bookId) {
            this.bookId = bookId;
            return this;
        }

        public Builder setLentFromDate(String lentFromDate) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
            java.sql.Date timePara  = null;
            timePara = new java.sql.Date(new Date().getTime());
            this.lentFromDate = String.valueOf(timePara);
            return this;
        }

        public Builder setLentToDate(String lentToDate) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
            java.sql.Date timePara  = null;
            timePara = new java.sql.Date(new Date().getTime());
            this.lentToDate = String.valueOf(timePara);
            return this;
        }

        public Builder setCheckOut(boolean checkOut) {
            isCheckOut = checkOut;
            return this;
        }

        public BookLoanLog build(){

            return new BookLoanLog(this);
        }

        public Builder copy(BookLoanLog bookLoanLog){
            this.bookLoanLogId = bookLoanLog.bookLoanLogId;
            this.userId = bookLoanLog.userId;
            this.bookId = bookLoanLog.bookId;
            this.lentFromDate = bookLoanLog.lentFromDate;
            this.lentToDate = bookLoanLog.lentToDate;
            this.isCheckOut = bookLoanLog.isCheckOut;
            return this;
        }
    }
}

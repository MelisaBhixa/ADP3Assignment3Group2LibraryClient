package za.ac.cput.entity;

/*
    Author: Ruphin Bolonda
    Student Number: 218321392
    Description: BookLoanLog Entity using Builder Pattern
 */

public class BookLoanLog {
    private String bookLoanLogId;
    private String userId;
    private String bookId;
    private String lentFromDate;
    private String lentToDate;
    private boolean isCheckOut;

    private BookLoanLog(BookLoanLogBuilder bookLoanLogBuilder){
        this.bookLoanLogId = bookLoanLogBuilder.bookLoanLogId;
        this.userId = bookLoanLogBuilder.userId;
        this.bookId = bookLoanLogBuilder.bookId;
        this.lentFromDate = bookLoanLogBuilder.lentFromDate;
        this.lentToDate = bookLoanLogBuilder.lentToDate;
        this.isCheckOut = bookLoanLogBuilder.isCheckOut;
    }

    public static BookLoanLogBuilder bookLoanLogBuilder(){
        return new BookLoanLogBuilder();
    }

    public static BookLoanLogBuilder bookLoanLogBuilder(BookLoanLog copy){
        BookLoanLogBuilder bookLoanLogBuilder = new BookLoanLogBuilder();
        bookLoanLogBuilder.bookLoanLogId = copy.bookLoanLogId;
        bookLoanLogBuilder.userId = copy.userId;
        bookLoanLogBuilder.bookId = copy.bookId;
        bookLoanLogBuilder.lentFromDate = copy.lentFromDate;
        bookLoanLogBuilder.lentToDate = copy.lentToDate;
        bookLoanLogBuilder.isCheckOut = copy.isCheckOut;
        return bookLoanLogBuilder();
    }

    @Override
    public String toString() {
        return "BookLoanLog: \n" +
                "bookLoanLogId: " + bookLoanLogId + "\n" +
                "userId: " + userId + "\n" +
                "bookId: " + bookId + "\n" +
                "lentFromDate: " + lentFromDate + "\n" +
                "lentToDate: " + lentToDate + "\n" +
                "isCheckOut: " + isCheckOut + "\n"

                ;
    }


    public static class BookLoanLogBuilder{
        private String bookLoanLogId;
        private String userId;
        private String bookId;
        private String lentFromDate;
        private String lentToDate;
        private boolean isCheckOut;

        public BookLoanLogBuilder withBookLoanLogId(String bookLoanLogId) {
            this.bookLoanLogId = bookLoanLogId;
            return this;
        }

        public BookLoanLogBuilder withUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public BookLoanLogBuilder withBookId(String bookId) {
            this.bookId = bookId;
            return this;
        }

        public BookLoanLogBuilder withLentFromDate(String lentFromDate) {
            this.lentFromDate = lentFromDate;
            return this;
        }

        public BookLoanLogBuilder withLentToDate(String lentToDate) {
            this.lentToDate = lentToDate;
            return this;
        }

        public BookLoanLogBuilder withCheckOut(boolean checkOut) {
            isCheckOut = checkOut;
            return this;
        }

        public BookLoanLog build() {
            return new BookLoanLog(this);
        }
    }
}

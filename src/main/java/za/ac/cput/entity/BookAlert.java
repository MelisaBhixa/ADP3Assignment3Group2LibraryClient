package za.ac.cput.entity;


/*
    Author: Ruphin Bolonda
    Student Number: 218321392
    Description: BookAlert Entity using Builder Pattern
 */

public class BookAlert {
    private String bookAlertNumber;
    private String alertNumber;
    private String bookId;
    private String createdBy;
    private String createdDate;
    private String createdTime;
    private String message;
    private boolean solved;

    private BookAlert(BookAlertBuilder bookAlertBuilder) {
        this.bookAlertNumber = bookAlertBuilder.bookAlertNumber;
        this.alertNumber = bookAlertBuilder.alertNumber;
        this.bookId = bookAlertBuilder.bookId;
        this.createdBy = bookAlertBuilder.createdBy;
        this.createdDate = bookAlertBuilder.createdDate;
        this.createdTime = bookAlertBuilder.createdTime;
        this.message = bookAlertBuilder.message;
        this.solved = bookAlertBuilder.solved;
    }

    public static BookAlertBuilder bookAlertBuilder() {
        return new BookAlertBuilder();
    }

    public static BookAlertBuilder bookAlertBuilder(BookAlert copy) {
        BookAlertBuilder bookAlertBuilder = new BookAlertBuilder();
        bookAlertBuilder.bookAlertNumber = copy.bookAlertNumber;
        bookAlertBuilder.alertNumber = copy.alertNumber;
        bookAlertBuilder.bookId = copy.bookId;
        bookAlertBuilder.createdBy = copy.createdBy;
        bookAlertBuilder.createdDate = copy.createdDate;
        bookAlertBuilder.createdTime = copy.createdTime;
        bookAlertBuilder.message = copy.message;
        bookAlertBuilder.solved = copy.solved;
        return bookAlertBuilder;
    }

    @Override
    public String toString() {
        return "Book: \n" +
                "bookAlertNumber: " + bookAlertNumber + "\n" +
                "alertNumber: " + alertNumber + "\n" +
                "bookId: " + bookId + "\n" +
                "createdBy: " + createdBy + "\n" +
                "createdDate: " + createdDate + "\n" +
                "createdTime: " + bookAlertNumber + "\n" +
                "message: " + message + "\n" +
                "solved: " + solved + "\n"
                ;
    }

    public static class BookAlertBuilder{
        private String bookAlertNumber;
        private String alertNumber;
        private String bookId;
        private String createdBy;
        private String createdDate;
        private String createdTime;
        private String message;
        private boolean solved;

        public BookAlertBuilder withBookAlertNumber(String bookAlertNumber) {
            this.bookAlertNumber = bookAlertNumber;
            return this;
        }

        public BookAlertBuilder withAlertNumber(String alertNumber) {
            this.alertNumber = alertNumber;
            return this;
        }

        public BookAlertBuilder withBookId(String bookId) {
            this.bookId = bookId;
            return this;
        }

        public BookAlertBuilder withCreatedBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public BookAlertBuilder withCreatedDate(String createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public BookAlertBuilder withCreatedTime(String createdTime) {
            this.createdTime = createdTime;
            return this;
        }

        public BookAlertBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public BookAlertBuilder withSolved(boolean solved) {
            this.solved = solved;
            return this;
        }

        public BookAlert build() {
            return new BookAlert(this);
        }
    }
}

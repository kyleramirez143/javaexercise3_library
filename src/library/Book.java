/**
 * Provides classes for managing a simple library system.
 */
package library; // CheckStyle warning is present

/**
 * Represents a book in the library.
 */
public class Book {
    /** The title of the book. */
    private String title;

    /** The author of the book. */
    private final String author;

    /** The published year of the book. */
    private final int yearPublished;

    /** Indicates whether the book is already rented. */
    private boolean isRented;

    /**
     * Creates a new Book instance.
     *
     * @param bookTitle         the title of the book
     * @param bookAuthor        the author of the book
     * @param bookYearPublished the year the book was published
     */
    public Book(final String bookTitle, final String bookAuthor, // CheckStyle
                                                                 // warning is
                                                                 // present
            final int bookYearPublished) { // CheckStyle warning is present
        /*
         * Initialize the book with title, author, & yearPublished. The book is
         * not rented initially.
         */
        this.title = bookTitle;
        this.author = bookAuthor;
        this.yearPublished = bookYearPublished;
        this.isRented = false;
    }

    /**
     * Checks whether the book is rented.
     *
     * @return true if the book is rented, otherwise false
     */

    public boolean isRented() {
        return isRented;
    }

    /**
     * Marks the book as rented.
     */
    public void rent() {
        this.isRented = true;
    }

    /**
     * * Gets the title of the book.
     * @return the title of the book
     */
    public String getTitle() { // CheckStyle warning is present
        return title;
    }

    /**
     * * Gets the author of the book.
     * @return the author of the book
     */
    public String getAuthor() { // CheckStyle warning is present
        return author;
    }

    /**
     * Gets the year the book was published.
     * @return the publication year of the book
     */
    public int getYearPublished() { // CheckStyle warning is present
        return yearPublished;
    }
}

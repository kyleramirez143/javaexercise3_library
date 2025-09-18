package library;

public class NonFictionBook extends Book {
    /**
     * Creates a new NonFictionBook instance.
     *
     * @param title         the title of the book
     * @param author        the author of the book
     * @param yearPublished the year the book was published
     */
    public NonFictionBook(final String title, final String author,
            final int yearPublished) { // CheckStyle warning is present
        super(title, author, yearPublished);
    }

}

package library;

import java.util.ArrayList;

/**
 * Represents a rental system for books. Provides functionality to add books,
 * rent books, clear the library, and get the library size.
 */

public final class BookRentalSystem {

    /** Holds the list of books in the library. */
    private static ArrayList<Book> library; // CheckStyle warning is present

    /**
     * Creates a new BookRentalSystem with an empty library.
     */
    public BookRentalSystem() {

        library = new ArrayList<>();

    }

    /**
     * Adds a book to the library.
     *
     * @param book the book to add
     */
    public void addBooks(final Book book) {
        library.add(book);
    }

    /**
     * Rents a book from the library at the specified index.
     *
     * @param index the index of the book to rent
     */
    public void rentBooks(final int index) {
        Book selected = library.get(index);

        if (selected.isRented()) {
            System.out.println("Book is already rented");
        } else {
            selected.rent();
        }
    }

    /**
     * Clears all books from the library.
     */
    public static void clearLibrary() {
        library.clear();
    }

    /**
     * Returns the number of books currently in the library.
     *
     * @return the size of the library
     */
    public static int getLibrarySize() {
        return library.size();
    }

    /** Getter for the library.
     * @return library
     * */
    static ArrayList<Book> getLibrary() { // CheckStyle warning is
                                                 // present
        return library;
    }

    /** Display all books. */
    public static void displayAllBooks() { // CheckStyle warning is present
        System.out.println("All books:");
        for (Book b : library) {
            System.out.println(b.getTitle() + "\t" + b.getAuthor() + "\t"
                    + b.getYearPublished());
        }
    }

    /** Display the rented books. */
    public static void displayRentedBooks() { // CheckStyle warning is present
        System.out.println("Books rented:");
        for (Book b : library) {
            if (b.isRented()) {
                System.out.println(b.getTitle() + "\t" + b.getAuthor() + "\t"
                        + b.getYearPublished());
            }
        }
    }

    /** Year of publication for The Lord of the Rings. */
    private static final int YR_1954 = 1954;

    /** Year of publication for To Kill a Mockingbird. */
    private static final int YR_1960 = 1960;

    /** Year of publication for The Tipping Point. */
    private static final int YR_2000 = 2000;

    /** Year of publication for Guns, Germs, and Steel. */
    private static final int YR_1997 = 1997;

    /**
     * Entry point of the application.
     *
     * @param args the command-line arguments (not used)
     */
    public static void main(final String[] args) {
        BookRentalSystem mylib = new BookRentalSystem();
        mylib.addBooks(new FictionBook("The Lord of the Rings",
                "J.R.R. Tolkien", YR_1954)); // CheckStyle warning is present
        mylib.addBooks(
                new FictionBook("To Kill a Mockingbird", "Harper Lee",
                        YR_1960));
        mylib.addBooks(
                new NonFictionBook("The Tipping Point", "M. Gladwell",
                        YR_2000));
        mylib.addBooks(new NonFictionBook("Guns, Germs, and Steel",
                "Jared Diamond", YR_1997)); // CheckStyle warning is present

        mylib.rentBooks(0);
        mylib.rentBooks(2);

        // Display
        displayAllBooks();
        displayRentedBooks();
    }

}

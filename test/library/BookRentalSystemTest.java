/**
 * This package contains classes related to the Book Rental System.
 * It includes:
 * Book base class
 * FictionBook and NonFictionBook subclasses
 * BookRentalSystem for managing the library
 */
package library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BookRentalSystemTest {

    /** The BookRentalSystem instance used for testing. */
    private final BookRentalSystem aklatan = new BookRentalSystem();
    /** Captures the output printed to System.out during tests. */
    private final ByteArrayOutputStream outContent
    = new ByteArrayOutputStream();

    /** A book instance used for testing purposes. */
    private Book libro;
    /** Year of publication for The Lord of the Rings. */
    private static final int YR_1954 = 1954;
    /** Year of publication for To Kill a Mockingbird. */
    private static final int YR_1960 = 1960;
    /** Year of publication for The Tipping Point. */
    private static final int YR_2000 = 2000;
    /** Year of publication for Guns, Germs, and Steel. */
    private static final int YR_1997 = 1997;
    /** Invalid index for testing purposes. */
    private static final int INV_INDEX = 5;
    /** Fiction book. */
    private FictionBook f1 = new FictionBook("The Lord of the Rings",
            "J.R.R. Tolkien", YR_1954);
    /** Non-fiction book. */
    private NonFictionBook n1 = new NonFictionBook("The Tipping Point",
            "M. Gladwell", YR_2000);

    @BeforeEach
    void test() {
        BookRentalSystem.clearLibrary();
        outContent.reset();
        System.setOut(new PrintStream(outContent));

    }

    @DisplayName("Test Book Creation")
    @Test

    void testBookCreation() {
        libro = new Book("The Lord of the Rings", "J.R.R. Tolkien", YR_1954);
        assertNotNull(libro, "Book should not be null");
        assertFalse(libro.isRented(), "Book should be rented by default.");
    }

    @DisplayName("Test Rent Method")
    @Test

    void testRentMethod() {
        libro = new Book("The Lord of the Rings", "J.R.R. Tolkien", YR_1954);
        assertFalse(libro.isRented(), "Book should not be rented by default.");

        libro.rent();
        assertTrue(libro.isRented(), "Book should be rented by default.");
    }

    @DisplayName("Test Rent Method")
    @Test

    void testAddBooksMethod() {

        aklatan.addBooks(f1);
        aklatan.addBooks(n1);

        assertEquals(2, BookRentalSystem.getLibrarySize(),
                "Library should have 2 books.");
    }

    @DisplayName("Test Rent Books with valid index")
    @Test

    void testRentBooksValid() {

        aklatan.addBooks(f1);
        aklatan.addBooks(n1);

        aklatan.rentBooks(0);

        assertTrue(f1.isRented(), "Book should be rented.");
        assertFalse(n1.isRented(), "Book should not be rented.");
    }

    @DisplayName("Test Rent Books with invalid index")
    @Test

    void testRentBooksInvalid() {

        aklatan.addBooks(f1);

        Exception exception = assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    aklatan.rentBooks(INV_INDEX); // invalid index
                });

        assertTrue(exception.getMessage().contains("Index"),
                "Exception should mention index");
    }

    @DisplayName("Test All Display Books")
    @Test

    void testAllDisplayBooks() {
        aklatan.addBooks(f1);
        aklatan.addBooks(n1);

        for (Book b : BookRentalSystem.getLibrary()) {
            System.out.println(b);
        }

        String expectedOutput = f1.toString() + System.lineSeparator() + n1
                .toString() + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString(),
                "Printed books should match expected output");

    }

    @DisplayName("Test Display Rented Books")
    @Test

    void testDisplayRentedBooks() {
        aklatan.addBooks(f1);
        aklatan.addBooks(n1);

        aklatan.rentBooks(0);

        for (Book b : BookRentalSystem.getLibrary()) {
            if (b.isRented()) {
                System.out.println(b);
            }
        }

        String expectedOutput = f1.toString() + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString(),
                "Printed rented books should match expected output");
    }

    @DisplayName("Test main() method")
    @Test
    void testMainMethod() {
        String[] args = {};
        BookRentalSystem.main(args);

        String expectedOutput = "All books:" + System.lineSeparator()
                + "The Lord of the Rings\tJ.R.R. Tolkien\t" + YR_1954 + System
                        .lineSeparator() + "To Kill a Mockingbird\tHarper Lee\t"
                + YR_1960 + System.lineSeparator()
                + "The Tipping Point\tM. Gladwell\t" + YR_2000 + System
                        .lineSeparator()
                + "Guns, Germs, and Steel\tJared Diamond\t" + YR_1997 + System
                        .lineSeparator() + "Books rented:" + System
                                .lineSeparator()
                + "The Lord of the Rings\tJ.R.R. Tolkien\t" + YR_1954 + System
                        .lineSeparator() + "The Tipping Point\tM. Gladwell\t"
                + YR_2000 + System.lineSeparator();

        assertEquals(expectedOutput, outContent.toString());
    }
}

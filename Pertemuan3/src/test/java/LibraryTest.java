import org.example.Book;
import org.example.LibraryControl;
import org.example.LibraryModel;
import org.example.NotificationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class LibraryTest {

    @Mock
    private LibraryModel bookModel;

    @Mock
    private NotificationService notificationService; // mock baru

    @InjectMocks
    private LibraryControl control;

    @Test
    void TestSearchBookAuthor() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Intro OOP", "divi"));
        books.add(new Book(2, "Pengujian PL itu mudah", "putri"));

        Mockito.when(bookModel.getAllBooks()).thenReturn(books); // STUB
        Assertions.assertEquals("divi", control.searchBookAuthor("Intro OOP"));
        Mockito.verify(bookModel, Mockito.times(1)).getAllBooks(); // MOCK
    }

    @Test
    void testSearchBookAuthor_withNever() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Intro OOP", "divi"));
        books.add(new Book(11, "Apalah", "Saya"));
        books.add(new Book(45, "Lagi Zoom", "Kamu"));

        Mockito.when(bookModel.getAllBooks()).thenReturn(books); // STUB
        control.searchBookAuthor("Unknown Book");

        Mockito.verify(bookModel, Mockito.never()).saveSearchKeyword(Mockito.anyString()); // MOCK
    }

    @Test
    void testAvail() {
        Mockito.when(bookModel.cekKetersediaan(11)).thenReturn(true); // STUB
        boolean result = control.checkAvailability(11);
        Assertions.assertTrue(result);
    }

    @Test
    void tesNotAvail() {
        Mockito.when(bookModel.cekKetersediaan(99)).thenReturn(false); // STUB
        boolean result = control.checkAvailability(99);
        Assertions.assertFalse(result); // diperbaiki: harusnya assertFalse
    }

    @Test
    void testCheckAvailability_bookAvailable() {
        Mockito.when(bookModel.cekKetersediaan(1)).thenReturn(true);

        boolean result = control.checkAvailability(1);

        Assertions.assertTrue(result);
        Mockito.verify(bookModel, Mockito.times(1)).cekKetersediaan(1);
    }

    @Test
    void testCheckAvailability_bookNotAvailable() {
        Mockito.when(bookModel.cekKetersediaan(2)).thenReturn(false);

        boolean result = control.checkAvailability(2);

        Assertions.assertFalse(result);
        Mockito.verify(bookModel, Mockito.times(1)).cekKetersediaan(2);
    }

    @Test
    void testBorrowBook_bookAvailable_borrowCalled() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Intro OOP", "divi"));

        Mockito.when(bookModel.getAllBooks()).thenReturn(books);
        Mockito.when(bookModel.cekKetersediaan(1)).thenReturn(true);

        control.borrowBook(1, "zakki");

        Mockito.verify(bookModel, Mockito.times(1)).borrowBook(1);
    }

    @Test
    void testBorrowBook_bookNotAvailable_borrowNotCalled() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Intro OOP", "divi"));

        Mockito.when(bookModel.getAllBooks()).thenReturn(books);
        Mockito.when(bookModel.cekKetersediaan(1)).thenReturn(false);

        control.borrowBook(1, "zakki");

        Mockito.verify(bookModel, Mockito.never()).borrowBook(1);
    }

    @Test
    void testBorrowBook_inOrder_getAllBooks_borrow_sendNotification() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Intro OOP", "divi"));

        Mockito.when(bookModel.getAllBooks()).thenReturn(books);
        Mockito.when(bookModel.cekKetersediaan(1)).thenReturn(true);

        control.borrowBook(1, "zakki");

        InOrder inOrder = Mockito.inOrder(bookModel, notificationService);

        inOrder.verify(bookModel).getAllBooks();
        inOrder.verify(bookModel).borrowBook(1);
        inOrder.verify(notificationService).sendNotification("zakki", "Intro OOP");
    }
}
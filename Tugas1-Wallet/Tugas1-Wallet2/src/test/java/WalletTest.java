import org.example.Owner;
import org.example.Wallet;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WalletTest {

    //declare objek, biar bis alangsung dipakai oleh semua class
    private Wallet wallet;

    @BeforeAll
    static void initClass() {
        System.out.println("Testing dimulai");
    }

    @BeforeEach
    void setUp() {
//        defaultOwner = new Owner("O001", "Zakki", "zakki@mail.com");
        wallet = new Wallet("Zakki", 10000);
        System.out.println("Setting up wallet baru");
    }



    @Test
    @Order(1)
    void testConstructor() {
        assertEquals("Zakki", wallet.getOwner());
        assertEquals(10000, wallet.getCash());
        assertNotNull(wallet.getCards());
    }

    @Test
    @Order(2)
    void testDeposit() {
        wallet.deposit(5000);
        assertEquals(15000, wallet.getCash());
    }

    @Test
    @Order(3)
    void testWithdraw() {
        wallet.withdraw(4000);
        assertEquals(6000, wallet.getCash());
    }

    @Test
    @Order(4)
    void testWithdrawMelebihiSaldo() {
        assertThrows(IllegalArgumentException.class, () -> {
            wallet.withdraw(20000);
        });
    }


    @Nested
    @DisplayName("Pengujian Fitur Kartu")
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class CardTests {

        @BeforeEach
        void addInitialCard() {
            wallet.addCard("Debit Utama");
            System.out.println("Nested: Kartu awal ditambahkan");
        }

        @Test
        @Order(1)
        void testAddCard() {
            wallet.addCard("Visa");
            assertEquals(2, wallet.getCards().size());
        }

        @Test
        @Order(2)
        void testRemoveCard() {
            wallet.removeCard("Debit Utama");
            assertFalse(wallet.getCards().contains("Debit Utama"));
        }
    }
    //cleaing up untuk tiap2 setelah testing
    @AfterEach
    void tearDown() {

        wallet = null;
        System.out.println("cleaning up objek wallet");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Berhentikan seluruh testing");
    }
}

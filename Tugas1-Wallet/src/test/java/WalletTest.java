import org.example.Wallet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {
    @Test
    void testConstructor() {
        Wallet wallet = new Wallet ("zaki", 10000);
        Assertions.assertEquals("zaki", wallet.getOwner());
        Assertions.assertNotNull(wallet.getCash());
        Assertions.assertEquals(10000, wallet.getCash());
    }

    @Test
    void testAddCard() {
        Wallet wallet = new Wallet("zaki", 25000);
        wallet.addCard("ABC 123");
        Assertions.assertEquals(1, wallet.getCard().size());
    }

    @Test
    void testRemoveCard() {
        Wallet wallet = new Wallet("Dzakiya", 100);
        wallet.addCard("BCA 123");
        boolean result = wallet.removeCard(0);
        assertTrue(result);
        assertEquals(0, wallet.getCard().size());
    }

    @Test
    void testWithdraw() {
        Wallet wallet = new Wallet("zaki", 30000);
        boolean balance = wallet.withdraw(10000);
        assertTrue(balance);
        assertEquals(20000, wallet.getCash());
    }

    @Test
    void testDeposit() {
        Wallet wallet = new Wallet("zaki", 5000);
        boolean balance = wallet.deposit(3000);
        assertEquals(8000, wallet.getCash());
    }

}

import org.example.Wallet;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class WalletParameterizedTest {

    @ParameterizedTest(name = "Eksekusi ke- {index}, deposit nominal valid: {arguments}")
    @ValueSource(doubles = {1000, 5000, 10000, 50000})
    void testDepositValidAmount(double amount) {
        Wallet wallet = new Wallet("Zakki", 0);
        assertDoesNotThrow(() -> wallet.deposit(amount));
        assertEquals(amount, wallet.getCash());
    }

    @ParameterizedTest(name = "Eksekusi ke- {index}, deposit nominal tidak valid: {arguments}")
    @ValueSource(doubles = {-1000, -5000, 0, -0.01})
    void testDepositInvalidAmount(double amount) {
        Wallet wallet = new Wallet("Zakki", 10000);
        assertThrows(IllegalArgumentException.class, () -> wallet.deposit(amount));
    }

    @ParameterizedTest(name = "Eksekusi ke- {index}, deposit={0}, withdraw={1}, expectedTotal={2}")
    @CsvFileSource(resources = "/valid_withdraw.csv", numLinesToSkip = 1)
    void testWithdrawValid(double deposit, double withdraw, double expectedTotal) {
        Wallet wallet = new Wallet("Zakki", 0);
        wallet.deposit(deposit);
        wallet.withdraw(withdraw);
        assertEquals(expectedTotal, wallet.getCash());
    }

    @ParameterizedTest(name = "Eksekusi ke- {index}, deposit={0}, withdraw={1} (melebihi saldo)")
    @CsvFileSource(resources = "/invalid_withdraw.csv", numLinesToSkip = 1)
    void testWithdrawInvalid(double deposit, double withdraw) {
        Wallet wallet = new Wallet("Zakki", 0);
        wallet.deposit(deposit);
        assertThrows(IllegalArgumentException.class, () -> wallet.withdraw(withdraw));
    }
}
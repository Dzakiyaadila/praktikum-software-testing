

import org.example.penjumlahan;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KalkulatorTest {

    private penjumlahan kalkulator;

    @BeforeEach
    void setUp() {
        kalkulator = new penjumlahan();
    }

    @ParameterizedTest
    @DisplayName("Test Penjumlahan Berulang")
    @CsvSource({
            "1, 1, 2",
            "5, 5, 10",
            "10, 20, 30",
            "-5, 5, 0"
    })
    void testTambah(int angka1, int angka2, int hasilDiharapkan) {
        // Eksekusi method tambah
        int hasilActual = kalkulator.tambah(angka1, angka2);

        // Cek apakah hasilnya sesuai
        assertEquals(hasilDiharapkan, hasilActual,
                "Harusnya " + angka1 + " + " + angka2 + " sama dengan " + hasilDiharapkan);
    }

    @AfterEach
    void tearDown() {
        kalkulator = null;
    }
}
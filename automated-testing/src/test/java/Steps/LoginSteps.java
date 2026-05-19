package Steps;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {

    static WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tutup() {
        //tapi tidak mau langusng ditutup, kita lihat dulu hasilnya
    }

    // implementasi tugas np.1
    @Given("User berada pada halaman login Sauce Demo")
    public void userBeradaPadaHalamanLogin() {
        driver.get("https://www.saucedemo.com/");
    }

    // pakai param string supaya lbh dinamis dr file features nya
    @When("user memasukkan username {string} dan password {string}")
    public void userMemasukkanUsernameDanPassword(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("user klik button login")
    public void userKlikButtonLogin() {
        WebElement form = driver.findElement(By.name("login-button"));
        form.submit();
    }

    @Then("user harus directed ke halaman inventory")
    public void userHarusDirectedKeHalamanInventory() {
        Assertions.assertTrue(
                driver.getCurrentUrl().contains("inventory"),
                "Login gagal, tidak redirect ke halaman inventory"
        );
    }

    @Then("user harus melihat pesan yang mengandung {string}")
    public void userHarusMelihatPesanYangMengandung(String expectedKeyword) {
        String errorMessage = driver.findElement(By.cssSelector("h3")).getText();
        Assertions.assertTrue(
                errorMessage.contains(expectedKeyword),
                "Pesan error tidak sesuai dengan yang diharapkan!"
        );
    }
}
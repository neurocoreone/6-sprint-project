import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.practicum.qascooter.HomePage;
import ru.yandex.practicum.qascooter.OrderOptionsPage;
import ru.yandex.practicum.qascooter.OrderPage;

import java.util.stream.Stream;

public class OrderTestChrome {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
    }

    private static Stream <Arguments> personalData() {
        return Stream.of(
                Arguments.of( "Хруст", "Хрустов", "ул. Самокатова", "1", "88003553535", "30.08.2026", "ааааааааааа"),
                Arguments.of("Самокат", "Самокатов", "ул. Хрустова", "2", "+77777777777", "31.09.2026", "ббббббббббббб")
        );
    }

    @ParameterizedTest
    @MethodSource("personalData")
    public void successOrderTest(String name,
                                 String surname,
                                 String address,
                                 String station,
                                 String phone,
                                 String date,
                                 String comment) {
        OrderPage orderPage = new OrderPage(driver);
        OrderOptionsPage orderOptionsPage = new OrderOptionsPage(driver);
        HomePage homePage = new HomePage(driver);
        homePage.openSite();
        homePage.closeCookie();
        homePage.clickHeaderOrderButton();
        orderPage.waitUntilNameIsVisible();
        orderPage.fillFullForm(name, surname, address, station, phone);
        orderOptionsPage.waitUntilDateIsVisible();
        orderOptionsPage.fillFullRentForm(date, comment);
        orderOptionsPage.clickOnYesButton();
        orderOptionsPage.successWindow();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

package ru.yandex.practicum.qascooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    //ссылка на страницу сервиса
    private static final String HOME_PAGE = "https://qa-scooter.education-services.ru/";

    //локатор для куки
    private By cookieButton = By.id("rcc-confirm-button");

    //локатор для заказа вверху страницы
    private By upperOrderButton = By.className("Button_Button__ra12g");

    //локатор для заказа внизу страницы
    private By lowerOrderButton = By.cssSelector(".Button_Button__ra12g.Button_UltraBig__UU3Lp");

    // блок страницы вопросы о важном
    private By headerAboutImportant = By.xpath(".//div[text() = 'Вопросы о важном']");

    // локатор массива вопросов (блок Вопросы о важном)
    private String arrayForListOfImportantQuestion = ".//div[%d][@class = 'accordion__item']//div[@class = 'accordion__button']";

    // локатор масива ответов (блок Вопросы о важном)
    private String arrayForTextOfImportantQuestion = ".//div[%d][@class = 'accordion__item']//div[@class = 'accordion__panel']//p";



    //конструктор HomePage
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //методы

// открытие главной страницы
public void openSite() {
    driver.get(HOME_PAGE);
}

    //закрыть оно с кукамси
    public void closeCookie() {
        driver.findElement(cookieButton).click();
    }

    // получение текста из списка вопросов о важном
    public String getElementTextOfDropDownList(int elementNumber) {
        scrollPageToElement(headerAboutImportant);
        getVisibleElement(By.xpath(String.format(arrayForListOfImportantQuestion, elementNumber))).click();
        return getVisibleElement(By.xpath(String.format(arrayForTextOfImportantQuestion, elementNumber))).getText();
    }

    //сделать заказ сверху
    public void clickHeaderOrderButton() {
        driver.findElement(upperOrderButton).click();
    }

    //сделать заказ снизу
    public void clickLowerOrderButton() {
        driver.findElement(lowerOrderButton).click();
    }

}

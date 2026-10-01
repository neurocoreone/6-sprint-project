package ru.yandex.practicum.qascooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderOptionsPage extends BasePage {

    //локатор для даты заказа
    private By rentDate = By.xpath("//input[@placeholder='* Когда привезти самокат']");

    // Поле заголовка "Про Аренду"
    private By aboutRentHeader = By.xpath(".//div[text() = 'Про аренду']");

    //локатор поля срока аренды
    private By rentPeriod = By.className("Dropdown-placeholder");

    //локатор выбора срока аренды
    private By rentPeriodChoise = By.xpath("//div[contains(@class, 'Dropdown-menu')]//div[contains(@class, 'Dropdown-option')]");

    //локатор черного чекбокса
    private By checkboxBlack = By.xpath("//label[contains(@class, 'Checkbox_Label')][input[@id='black']]");

    //локатор серого чекбокса
    private By checkboxGray = By.xpath("//label[contains(@class, 'Checkbox_Label')][input[@id='gray']]");

    //локатор комментария
    private By commentField = By.xpath("//input[contains(@placeholder, 'Комментарий для курьера')]");

    //локатор кнопки заказа
    private By orderButton = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");

    //локатор кнопки подтверждения
    private By confirmButton = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да')]");

    //локатор окна успешного заказа
    private By orderSuccessWindow = By.xpath("//div[contains(@class, 'Order_Modal')]//div[contains(text(), 'Заказ оформлен')]");

    public OrderOptionsPage(WebDriver driver) {
        super(driver);
    }


    // методы

    // прверка загрузки страницы
    public void waitUntilDateIsVisible() {
        getVisibleElement(rentDate);
    }

    // заполнение даты доставки
    public void fillDateField(String date) {
        driver.findElement(rentDate).sendKeys(date);
        driver.findElement(aboutRentHeader).click();
    }

    // выбор срока аренды
    public void chooseRentInterval() {
        driver.findElement(rentPeriod).click();
        driver.findElement(rentPeriodChoise).click();
    }

    // выбора цвета
    public void chooseScooterColor() {
        driver.findElement(checkboxBlack).click();
    }

    // добавление комментария
    public void fillCommentField(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    // нажатие кнопки заказать
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    // заполнение формы аренды
    public void fillFullRentForm(String date, String comment) {
        fillDateField(date);
        chooseRentInterval();
        chooseScooterColor();
        fillCommentField(comment);
        clickOrderButton();
    }

    // подтверждение заказа
    public void clickOnYesButton() {
        getVisibleElement(confirmButton).click();
    }


    // окно усешного заказа
    public void successWindow() {
        getVisibleElement(orderSuccessWindow);
    }

}

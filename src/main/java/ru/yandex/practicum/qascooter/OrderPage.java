package ru.yandex.practicum.qascooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage extends BasePage {

    //локатор поля имени
    private By firstName = By.xpath("//input[contains(@placeholder, '* Имя')]");

    //локатор поля фамилии
    private By lastName = By.xpath("//input[contains(@placeholder, '* Фамилия')]");

    //локатор поля адреса
    private By deliveryAddress = By.xpath("//input[contains(@placeholder, '* Адрес: куда привезти заказ')]");

    //локатор поля станции метро
    private By metroStation = By.xpath("//input[contains(@placeholder, '* Станция метро')]");

    //локатор поля номера телефона
    private By phoneNumber = By.xpath("//input[contains(@placeholder, '* Телефон: на него позвонит курьер')]");

    //локатор кнопки далее
    private By nextButton = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее')]");


    //конструктор OrderPaige
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    //методы

    // проверка загрузки страницы
    public void waitUntilNameIsVisible() {
        getVisibleElement(firstName);
    }

    // заполнение имени
    public void fillNameField(String name) {
        driver.findElement(firstName).sendKeys(name);
    }

    // заполнение фамилии
    public void fillSurnameField(String surname) {
        driver.findElement(lastName).sendKeys(surname);
    }

    // заполнение адрекса
    public void fillAddressField(String address) {
        driver.findElement(deliveryAddress).sendKeys(address);
    }

    // выбор станции метро
    public void chooseMetroStationField(String station) {
        driver.findElement(metroStation).click();
        driver.findElement(By.xpath(String.format(".//button[@value = %s]", station))).click();
    }

    // заполнение телефона
    public void fillPhoneNumberField(String phone) {
        driver.findElement(phoneNumber).sendKeys(phone);
    }

    // нажатие кнопки далее
    public void clickOnButtonNext() {
        driver.findElement(nextButton).click();
    }

    // заполнение формы
    public void fillFullForm(String name, String surname, String address, String station, String phone) {
        fillNameField(name);
        fillSurnameField(surname);
        fillAddressField(address);
        chooseMetroStationField(station);
        fillPhoneNumberField(phone);
        clickOnButtonNext();
    }
}


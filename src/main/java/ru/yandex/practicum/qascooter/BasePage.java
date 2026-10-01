package ru.yandex.practicum.qascooter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

//драйвер браузера
public BasePage(WebDriver driver) {
    this.driver = driver;
}

//задержка
private static final int waiting_sec = 10;

// скролл страницы
    public void scrollPageToElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waiting_sec));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //ожидание видимости
    public WebElement getVisibleElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waiting_sec));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }















}

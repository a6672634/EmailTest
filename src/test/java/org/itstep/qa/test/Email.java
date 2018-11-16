package org.itstep.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Email {

        WebDriver driver;

        @BeforeClass

        public void initWebdriver() {
            System.setProperty("webdriver.chrome.driver",
                    "src/main/resources/chromedriver12.exe");
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
        }

        @AfterClass
        public void closeBrowser() {
            driver.manage().deleteAllCookies();
            driver.quit();
        }

        @org.testng.annotations.Test(dataProvider = "user[email]",
                dataProviderClass = Tester.class)
        public void testLesson(String value) {
            driver.get("https://dev.by/registration");
            WebElement field =
                    driver.findElement(By.xpath("//*[@id=\"user_email\"]"));
            field.sendKeys(value);
            WebElement field2 =
                    driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[4]/div/div/div/div[1]"));
            Assert.assertTrue(field2.isDisplayed(), "Не найдено сообщение об ощибке");
            String controlValue = "* Неверный формат email";
            Assert.assertEquals(field2.getText(), controlValue, "Текст не " +
                    "сответствует = " + controlValue);

        }
    }

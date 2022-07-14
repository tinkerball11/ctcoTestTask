package ru.mikhailovra;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.mikhailovra.pages.MainPage;
import ru.mikhailovra.pages.VacanciesPage;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest extends BaseTest {
    MainPage mainPage = new MainPage();
    VacanciesPage vacanciesPage = new VacanciesPage();

    @Test
    @DisplayName("Vacancy C.T.Co")
    void checkVacancyCTCo() {
        driver.get("https://ctco.lv/en");

        driver.findElement(mainPage.career).click();
        driver.findElement(mainPage.vacancies).click();
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(vacanciesPage.automationVacancy));

        driver.findElement(vacanciesPage.automationVacancy).click();

        List<WebElement> skills = driver
                .findElement(By.xpath("//*[contains(text(),'TEST AUTOMATION ENGINEER vacancy')]//..//ul"))
                .findElements(By.tagName("li"));
        assertEquals(skills.size(), 8);
    }
}

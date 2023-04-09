package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Homepage {
    @FindBy(className = "js-site-search-focus")
    public WebElement txtSearchField;
    @FindBy(tagName = "a")
    public List <WebElement> linkAbout;

    public Homepage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void doSearch(String repositoryKeyword) throws InterruptedException {
        txtSearchField.sendKeys(repositoryKeyword);
        Thread.sleep(2000);
        txtSearchField.sendKeys(Keys.ENTER);
    }
    public void clickAbout(){
        linkAbout.get(186).click();
    }
}

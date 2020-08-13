package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleStepDefinitions {

	WebDriver driver ;
	
	@Given("^I go to google$")  
    public void iGoToGoogle() throws Throwable {  
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\Prateek\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.google.com/"); 
    }  

    @When("^I query for \"([^\"]*)\"$")  
    public void iQueryFor(String arg0) throws Throwable {  
        driver.findElement(By.name("q")).sendKeys("cucumber spring selenium");
    }  

    @And("^click search$")  
    public void clickSearch() throws Throwable {  
    	 driver.findElement(By.name("btnK")).click();
    }  

    @Then("^google page title should become \"([^\"]*)\"$")  
    public void googlePageTitleShouldBecome(String arg0) throws Throwable {  
        String title = driver.getTitle();
        Assert.assertEquals(title, "cucumber spring selenium - Google Search");
    }  

    @Then("^i should see \"([^\"]*)\" as (\\d+) of the suggested search$")  
    public void iShouldSeeAsOfTheSuggestedSearch(String arg0, int arg1) throws Throwable {  
       List<WebElement> linkList = driver.findElements(By.tagName("a"));
       boolean flag = false;
       for(WebElement link:linkList)
       {
    	   if(link.toString().contains("spring-cucumber-selenium"))
    		   flag=true;
    	   break;
       }
       Assert.assertTrue(flag);
}
	
}

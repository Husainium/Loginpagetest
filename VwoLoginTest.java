package appvdo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VwoLoginTest {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");
        
        //To verify if a user cannot login with a invalid username and valid password.
        WebElement emailField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("//span[@data-qa='ezazsuguuy' and text()='Sign in']"));
        
        emailField.sendKeys("xyz@gmail.com");
        passwordField.sendKeys("123456789");
        loginButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (driver.getCurrentUrl().contains("/dashboard")) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }
        emailField.clear();
        passwordField.clear();
        
          //To verify if a user cannot login with a invalid username and invalid password.
            WebElement email = driver.findElement(By.name("username"));
            WebElement password = driver.findElement(By.name("password"));
            WebElement login = driver.findElement(By.xpath("//span[@data-qa='ezazsuguuy' and text()='Sign in']"));
            
            email.sendKeys("xyz@gmail.com");
            password.sendKeys("000000000");
            login.click();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (driver.getCurrentUrl().contains("/dashboard")) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed!");
            }
            email.clear();
            password.clear();
            
          //To verify the login page when we enter space in username and password then Submit button is clicked.
            WebElement emaila = driver.findElement(By.name("username"));
            WebElement passworda = driver.findElement(By.name("password"));
            WebElement logina = driver.findElement(By.xpath("//span[@data-qa='ezazsuguuy' and text()='Sign in']"));
            
            email.sendKeys(" ");
            password.sendKeys(" ");
            login.click();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (driver.getCurrentUrl().contains("/dashboard")) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed!");
            }
            emaila.clear();
            passworda.clear();
            
          //To verify the messages for invalid login.
            WebElement emailb = driver.findElement(By.name("username"));
            WebElement passwordb = driver.findElement(By.name("password"));
            WebElement loginb = driver.findElement(By.xpath("//span[@data-qa='ezazsuguuy' and text()='Sign in']"));
            
            email.sendKeys("xyz");
            password.sendKeys("000");
            login.click();
          
            Thread.sleep(5000);
            WebElement divElement = driver.findElement(By.id("js-notification-box-msg"));

            String notificationText = divElement.getText();
            System.out.println("Notification Text: " + notificationText);
            
            emailb.clear();
            passwordb.clear();
            
            //To verify if the data in password field is either visible as asterisk or bullet signs.
            WebElement passwordInput = driver.findElement(By.id("login-password"));
            String inputType = passwordInput.getAttribute("type");

            if ("password".equals(inputType)) {
                System.out.println("The input field is a password field.");
            } else {
                System.out.println("The input field is not a password field.");
            }
            
            //To verify if we are able to check mark on check box of 'remember me'.
            WebElement checkbox = driver.findElement(By.id("your-checkbox-id")); // Replace with the actual attribute and value

         if (!checkbox.isSelected()) {
             checkbox.click();
         }
         
        driver.quit();
    }
}
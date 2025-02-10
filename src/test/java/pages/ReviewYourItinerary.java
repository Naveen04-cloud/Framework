package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ThreadLocalDriver;

import java.util.ArrayList;
import java.util.Set;

public class ReviewYourItinerary {
    public ReviewYourItinerary(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "(//*[text()='Book'])[1]")
    WebElement clickonBookButton;

    public WebElement getClickonBookButton() {
        return clickonBookButton;
    }

    @FindBy(xpath="//button[@class='h_40p br-8 bg-intlnew-orange bg-primary-500 hover:bg-primary-600 c-white bc-transparent c-pointer py-2 px-4 h-9 fs-4 fw-600 t-all button bs-solid tp-color td-500 bw-1 br-4 lh-solid box-border']")
    WebElement userClicksOnBookButton;
    public WebElement getuserClicksOnBook(){
        return userClicksOnBookButton;

    }
    //****

    public void setClickonBookButton() {
        getuserClicksOnBook().click();
    }
    public void newpage() throws InterruptedException {
        String parentwindowhandle= ThreadLocalDriver.getWebDriverThreadLocal().getWindowHandle();
        System.out.println("parent Window"+parentwindowhandle);
        Set<String> windowhandle=ThreadLocalDriver.getWebDriverThreadLocal().getWindowHandles();
        System.out.println("window handle"+windowhandle);
        for(String h:windowhandle){
            if (h.equals(parentwindowhandle)){
                System.out.println("H is in a parent Window");
            }
            else {
              ThreadLocalDriver.getWebDriverThreadLocal().switchTo().window(h);
                System.out.println("Switched to the new window"+h);
                Thread.sleep(5000);
            }
        }
/*
//        ArrayList<String> tabs = new ArrayList<String> (ThreadLocalDriver.getWebDriverThreadLocal().getWindowHandles());
//        ThreadLocalDriver.getWebDriverThreadLocal().switchTo().window(tabs.get(1));
//        ThreadLocalDriver.getWebDriverThreadLocal().close();
//        ThreadLocalDriver.getWebDriverThreadLocal().switchTo().window(tabs.get(0));
        String windowHandle = ThreadLocalDriver.getWebDriverThreadLocal().getWindowHandle();

//Get the list of window handles
        ArrayList tabs = new ArrayList (ThreadLocalDriver.getWebDriverThreadLocal().getWindowHandles());
        System.out.println(tabs.size());
//Use the list of window handles to switch between windows
        ThreadLocalDriver.getWebDriverThreadLocal().switchTo().window((String) tabs.get(0));

//Switch back to original window
        String mainWindowHandle = ThreadLocalDriver.getWebDriverThreadLocal().getWindowHandle();
        ThreadLocalDriver.getWebDriverThreadLocal().switchTo().window(mainWindowHandle);
*/
         }

 }

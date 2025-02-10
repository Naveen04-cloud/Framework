package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ThreadLocalDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SearchFlightsPage {

    public SearchFlightsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /**
     * Mobile Elements
     */
    //user is on homepage on clear my trip
    @FindBy(xpath = "//div[@class='pb-1 px-1 flex flex-middle nmx-1']")
    WebElement userisoncleartriphomepageButton;

    public WebElement getUserisoncleartriphomepageButton() {
        return userisoncleartriphomepageButton;
    }
    //when click on where from to select the from city
    @FindBy(xpath ="//input[@placeholder='Where from?']")
    WebElement WhereFromDropdownButton;

    public WebElement getWhereFromDropdownButton() {
        return WhereFromDropdownButton;
    }
    //the user clicks on where to city

    @FindBy(xpath = "//input[@placeholder='Where to?']")
    WebElement userclicksonthewheretodropdownButton;
    public WebElement getUserclicksonthewheretodropdownButton(){
        return userclicksonthewheretodropdownButton;
    }
    //Click on the Date
    @FindBy(xpath ="//button[@class='sc-dAlyuH cIApyz']")
    WebElement clickOnSearchFlightsButton;
    public WebElement getClickOnSearchFlightsButton(){
        return clickOnSearchFlightsButton;
    }



    /**
     * Actions
     */
    //

    //public  datepicker(){
//        DateFormat datepicker = new SimpleDateFormat("dd");
//        Date date=new Date();
//        String date1=datepicker.format(date);


   // }
    public void flightsList(){

        boolean flights =ThreadLocalDriver.getWebDriverThreadLocal().findElement(By.xpath("(//img[@class='br-2 o-hidden mx-1'])[1]")).isDisplayed();
        if(flights==true){
            System.out.println("Flights Are Displayed");
        }
        else{
            System.out.println("NOt Displayed");
        }

    }
    public void searechFlights(){
        getClickOnSearchFlightsButton().click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void clickReturnDate(){
        ThreadLocalDriver.getWebDriverThreadLocal().findElement(By.xpath("//*[text()=\"Return\"]")).click();
    }
    public void clickFromDate(){
        ThreadLocalDriver.getWebDriverThreadLocal().findElement(By.xpath("(//div[@class='c-inherit flex flex-1 flex-nowrap fs-16 fw-500 card-price'])[3]")).click();

    }
    public void ReturnDate(){

        ThreadLocalDriver.getWebDriverThreadLocal().findElement(By.xpath("//*[text()="+SelecReturnDate()+"]")).click();

    }
    public String SelecReturnDate(){
//        LocalDate Currentdate=LocalDate.now().plusDays(2);
//        return Currentdate.toString().substring(8);
        LocalDate currentdate= LocalDate.now().plusDays(2);
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("d");
        return currentdate.format(formatter);

    }
    public void selectFromDate() {
        ThreadLocalDriver.getWebDriverThreadLocal().findElement(By.xpath("(//*[text()='"+getFromDate()+"'])[1]")).click();
    }

    public String getFromDate(){
        //        LocalDate CurrentDate=LocalDate.now().plusDays(1);
        //     return CurrentDate.toString().substring(9);
        LocalDate currentdate= LocalDate.now().plusDays(1);
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("d");
        return currentdate.format(formatter);


    }

    public void userSelectToCity(String tocity){
        ThreadLocalDriver.getWebDriverThreadLocal().findElement(By.xpath("//*[text()='"+tocity+"']")).click();

    }
    //To Validate the to city names
    public void differentcitiesaredisplayedinwheretodropdown(){
        List< WebElement> elementList= ThreadLocalDriver.getWebDriverThreadLocal().findElements(By.xpath("//div[@class='dropdown p-absolute t-13 ln-1 w-100p']"));
        List<String> TocityNames = new ArrayList<>();
        TocityNames.add("BWX");
        TocityNames.add("BMO");
        TocityNames.add("BPT");
        TocityNames.add("BNI");
        TocityNames.add("NSB");
        System.out.println("Tocitynames"+TocityNames);

        List<String>actualToCItyNames=new ArrayList<>();
        for (WebElement ToCity:elementList){
            actualToCItyNames.add(ToCity.getText());
        }
        System.out.println("citynames"+actualToCItyNames);
        if (TocityNames.equals(actualToCItyNames)){
            System.out.println("pass");

        }
        else {
            System.out.println("Fail");
        }
    }
    public void wheretodropdown(){
        getUserclicksonthewheretodropdownButton().click();
    }

    public void userselectsfromcity(String city) {
        ThreadLocalDriver.getWebDriverThreadLocal().findElement(By.xpath("//*[text()='"+city+"']")).click();
    }
    //TO validate the city names
    public boolean differentcitiesaredisplayedindropdown(){
        List< WebElement> elementList=ThreadLocalDriver.getWebDriverThreadLocal().findElements(By.xpath("//div[@class='dropdown p-absolute t-13 ln-1 w-100p']"));
        List<String> citynames=new ArrayList<>();
        citynames.add("BLR");
        citynames.add("BOM");
        citynames.add("DEL");
        citynames.add("CCU");
        citynames.add("GOI");
        citynames.add("HYD");
        citynames.add("MAA");

        System.out.println("citynames"+citynames);

        List<String>actualcitynames=new ArrayList<>();
        for (WebElement cityname:elementList){
            actualcitynames.add(cityname.getText().trim());
        }
        System.out.println("actualcitynames"+actualcitynames);
        if(citynames.equals(actualcitynames)){
            System.out.println("pass");
        }
        else {
            System.out.println("Fail");
        }
        return false;
    }

    public void WhereFromDropdown() {
        getWhereFromDropdownButton().click();
    }

    public void userisoncleartriphomepage() {
        ThreadLocalDriver.getWebDriverThreadLocal().get("https://www.cleartrip.com/");
    }

    public void closePopUp() {
        getUserisoncleartriphomepageButton().click();
    }
}
package org.example;

import org.openqa.selenium.By;

public class HomePage extends Utils{

    By _registerLinkButton = By.xpath("//a[@class='ico-register']"); //click on register button on home page
    By _clickingComputers = By.xpath("//div[@class='header-menu']/ul[1]/li[1]/a"); //click on computer menu
    By _detailsButton = By.xpath("//div[@class='news-items']/div[2]/div[3]/a");//Click on Details button

    public  void clickOnRegisterButton() {
        clickOnElement(_registerLinkButton);
    }

    public void clickOnComputersMenu(){
        clickOnElement(_clickingComputers);
    }

    public void clickOnNewsDetailsButton(){
        clickOnElement(_detailsButton);
    }

}

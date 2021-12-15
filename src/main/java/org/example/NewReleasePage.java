package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

public class NewReleasePage extends Utils {
    By _TitleBox = By.id("AddNewComment_CommentTitle");
    By _Comment = By.id("AddNewComment_CommentText");
    public void verifyUserIsOnNewReleasePage(){
        Assert.assertTrue(driver.getCurrentUrl().contains(loadProp.getProperty("UserIsOnNewsReleasePage")));
    }
    public void userEnterCommentDetails(){
        //type title
        typeText(_TitleBox,loadProp.getProperty("Title"));

        //type Comment
        typeText(_Comment, loadProp.getProperty("Comment"));

        //wait for new comment button is recognised
        waitForClickable(By.xpath("//button[@class='button-1 news-item-add-comment-button']"), 20);
    }
    public void clickOnNewCommentButton(){
        //wait for new comment button is recognised
        waitForClickable(By.xpath("//button[@class='button-1 news-item-add-comment-button']"), 20);
        //click on New Comment button
        clickOnElement(By.xpath("//button[@class='button-1 news-item-add-comment-button']"));
    }
    public void userHasAddedNewCommentSuccessfully(){
        String actualSuccessCommentMessage = getTextFromElement(By.xpath("//div[@class='result']"));
        String expectedSuccessCommentMessage = loadProp.getProperty("ExpectedSuccessCommentMessage");
        assertEquals(actualSuccessCommentMessage,expectedSuccessCommentMessage);
    }

}

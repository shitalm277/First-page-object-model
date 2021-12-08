package org.example;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest{
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationSuccessPage registrationSuccessPage = new RegistrationSuccessPage();
    ComputersPage computersPage = new ComputersPage();
    DesktopPage desktopPage = new DesktopPage();
    NewReleasePage newReleasePage = new NewReleasePage();
    BuildYourOwnComputer buildYourOwnComputer = new BuildYourOwnComputer();
    EmailTheProductToAFriend emailTheProductToAFriend = new EmailTheProductToAFriend();


    @Test
    public void verifyUserShouldBeAbleToRegisterSuccessfully(){
        homePage.clickOnRegisterButton();//click on register button
        registrationPage.verifyUserIsOnRegisterPage();//enter URL
        registrationPage.userEntersRegistrationDetails();//entering details in registration page
        registrationPage.clickOnRegisterButton();//clicking on register button
        registrationSuccessPage.verifyUserIsOnTheRegisterSuccessPage();//success page has opened.
        registrationSuccessPage.verifyUserHasSuccessfullyRegistered();//user is registered successfully
    }

    @Test
    public void verifyUserIsAbleToNavigateToDesktopPage(){

        homePage.clickOnComputersMenu();//click on Computer Menu
        computersPage.verifyUserIsOnComputerPage();//verify user is on Computers Menu page
        computersPage.clickOnDesktopsMenu();//click on desktop menu
        desktopPage.verifyUserIsOnDesktopPage();//verify user is on desktop page
        desktopPage.verifyUserIsShownDesktopMenu();//Verify user is shown desktops menu
    }

    @Test
    public void verifyUserCommentIsSuccessfullyAdded(){
        homePage.clickOnNewsDetailsButton();//click on news details
        newReleasePage.verifyUserIsOnNewReleasePage();//verify user is on news release page
        newReleasePage.userEnterCommentDetails();//type title and comment
        newReleasePage.clickOnNewCommentButton();//click on new comment button
        newReleasePage.userHasAddedNewCommentSuccessfully();//verify user has added new comment successfully.
    }

    @Test
    public void userIsAbleToReferAProductToFriend(){
        verifyUserShouldBeAbleToRegisterSuccessfully();//verify user is successfully registered.
        verifyUserIsAbleToNavigateToDesktopPage();//verify user is navigated to desktop page successfully
        desktopPage.clickOnBuildYourOwnComputer();//Click on Build Your Own Computer
        buildYourOwnComputer.clickOnEmailAFriend();//click on Email a Friend button
        emailTheProductToAFriend.verifyUserIsOnProductEmailAFriendPage();
        emailTheProductToAFriend.userEntersFriendsEmailAndMessage();//type friends email and personal message
        emailTheProductToAFriend.clickOnSendEmailButton();//click Send email button
        emailTheProductToAFriend.verifyUserHasSuccessfullySentEmailToAFriend();



    }

}

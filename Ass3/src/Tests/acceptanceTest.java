package Tests;
import Domain.User;
import Service.ASPresentation;
import Service.UserPresentation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class acceptanceTest {
    User user = new User("john","abcd");
    ASPresentation asPresentation = new ASPresentation();
    UserPresentation userPresentation = new UserPresentation(user);


    @Test
    @DisplayName("Should add new referee to DB")
    public void ShouldAddNewRefereeToDB( ) throws Exception {
        Assert.assertEquals("The referee referee11 was added successfully", asPresentation.addReferee("referee11", "main" , "True"));
    }

    @Test
    @DisplayName("Should NOT add new referee to DB")
    public void ShouldReturnException() throws Exception {
        Assert.assertEquals("isHeadReferee is null. try again", (asPresentation.addReferee("referee11", "main" , null)));

    }

    @Test
    @DisplayName("Should NOT add new referee to DB")
    public void refereeAlreadyExist() throws Exception {
        Assert.assertEquals("The referee referee11 was not added, because he already exists", asPresentation.addReferee("referee11", "main" , "True"));

    }

    @Test
    @DisplayName("Should add game policy")
    public void ShouldScheduleGamesPolicyPresentation() throws Exception {
        Assert.assertEquals("game policy 2 added for league 1 in season 2", asPresentation.scheduleGamesPolicyPresentation("2", "1", "2"));

    }



    @Test
    @DisplayName("user is not in the database")
    public void ShouldReturnDosentExistInDB() throws Exception {
        Assert.assertEquals("the user notregister dosent exist", userPresentation.logInService("notregister", "12345"));

    }

    @Test
    @DisplayName("user is already connected")
    public void ShouldReturnAlreadyLoggedIn() throws Exception {
        Assert.assertEquals("the user john is already connected", userPresentation.logInService("john", "abcd"));

    }
    @Test
    @DisplayName("Should Log in")
    public void ShouldReturnLoggedInSuccssefully() throws Exception {
        Assert.assertEquals("the user natalia is connected now", userPresentation.logInService("natalia", "12345"));

    }

}

package Tests;
import Domain.*;
import Service.ASPresentation;
import Service.UserPresentation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.Assert.*;

import java.nio.file.attribute.UserPrincipal;

import static org.junit.Assert.assertEquals;


public class unitTest {

    User user = new User("john","abcd");
    ASPresentation asPresentation = new ASPresentation();
    UserPresentation userPresentation = new UserPresentation(user);

    @Test
    @DisplayName("Should not add game because policy id is not 1 or 2")
    public void ShouldReturnException1or2 () throws Exception {
        Assert.assertEquals("game policy id must be 1 or 2", asPresentation.scheduleGamesPolicyPresentation("-1", "0", null));
    }
    @Test
    @DisplayName("Should not add game because league id is a negative number")
    public void ShouldReturnExceptionNotNegativeLeague () throws Exception {
        Assert.assertEquals("league id must be a positive number", asPresentation.scheduleGamesPolicyPresentation("1", "-1", null));
    }

    @Test
    @DisplayName("Should not add game because season id is a negative number")
    public void ShouldReturnExceptionNotNegativeSeason () throws Exception {
        Assert.assertEquals("season id must be a positive number", asPresentation.scheduleGamesPolicyPresentation("1", "1", null));
    }

    @Test
    @DisplayName("Should not add referee because his name is null")
    public void userNameIsNullRef () throws Exception {
        Assert.assertEquals("userName is null. try again", asPresentation.addReferee(null, "1", "1"));
    }

    @Test
    @DisplayName("Should not add referee because his qualification is null")
    public void qualificationNameIsNull () throws Exception {
        Assert.assertEquals("qualification is null. try again", asPresentation.addReferee("1", null, "1"));
    }

    @Test
    @DisplayName("Should not add referee because his isHead is null")
    public void isHeadIsNull () throws Exception {
        Assert.assertEquals("isHeadReferee is null. try again", asPresentation.addReferee("1", "1", null));
    }

    @Test
    @DisplayName("Should not add user because his username is null")
    public void userNameIsNullUser () throws Exception {
        Assert.assertEquals("username is null. try again", userPresentation.logInService(null, "1"));
    }

    @Test
    @DisplayName("Should not add user because his username is null")
    public void passwordIsNullUser () throws Exception {
        Assert.assertEquals("password is null. try again", userPresentation.logInService("john", null));
    }
}



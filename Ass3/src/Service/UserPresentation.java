package Service;


import Domain.User;
import Domain.associationRepresentatives;

public class UserPresentation {
    private User user;



    public UserPresentation(User user) {
        this.user = user;
    }




    //log a user into the system, goes first through the service layer to check if the parameters are not null
    public String logInService(String userName, String password) throws Exception {
        if (userName == null) {
            return ("username is null. try again");
        }
        else if (password == null) {
            return ("password is null. try again");
        }
        //now we send to the domain layer
        return user.logInDomain(userName, password);

    }
}



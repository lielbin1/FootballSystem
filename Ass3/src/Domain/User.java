package Domain;

import DataAccess.UserAccess;
import DataAccess.arAccess;


import javax.management.relation.Role;
import java.util.ArrayList;
// connection to database?
public class User {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private ArrayList<Role> roles;
    private Boolean isConnection;
    private UserHandler userHandler;
    private UserAccess userA;
    private Logger logFile;




    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public UserAccess getUserA() {
        return userA;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.userA = new UserAccess();
        this.logFile = new Logger();

    }


    //log a user into the System, check if the user exists or if he is already connected
    public String logInDomain(String userName, String password) throws Exception {

        //send parameters to the service layer to check the information in the database
        boolean isUsrExist = this.getUserA().checkIfUserExist(userName,password);

        //if the users exists in the database
        if(isUsrExist){
            //if the user is already connected
            if(this.getUserA().login_procedure(userName,password)) {
                java.lang.System.out.println("the user " + userName + " is already connected");
                this.logFile.writeToLog("the user " + userName + " is already connected");
                return "the user " + userName + " is already connected";
            }
            //the users exists and not connected , now we will connect him
            else
            {
                this.getUserA().updateIsConnected(userName,password);
                java.lang.System.out.println("the user " + userName + " is connected now");
                this.logFile.writeToLog("the user " + userName + " is connected now");
                return "the user " + userName + " is connected now";
            }
        }

        //the user does not exist in the database
        if (!isUsrExist){
            java.lang.System.out.println("the user " + userName + " dosent exist");
            this.logFile.writeToLog("the user " + userName + " dosent exist");
            return "the user " + userName + " dosent exist";
        }
       return null;
    }
}

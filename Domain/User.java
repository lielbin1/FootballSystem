package Domain;

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

    public void search(){

    }
    public void sortBy(){

    }

    public void logInUser(String username, String pass){
        this.userName = username;
        this.password = pass;
    }
    public void registerUser( String username, String password,String first_name ,String lastName,String email){
        //connections
    }
}

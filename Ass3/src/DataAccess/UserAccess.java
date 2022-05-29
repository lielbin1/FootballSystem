package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserAccess {
    @SuppressWarnings("Duplicates")
    //check if the user exists in the database
    public boolean checkIfUserExist(String userName,String password){
        try {
            //connect to mysql database locally
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
            Statement statement = connection.createStatement();
            //create an sql command
            String sql = "select * from userTable";
            //execute the command
            ResultSet resultSet = statement.executeQuery(sql);

            //check information in our database
            while (resultSet.next()) {
                // get user name and password from users in the database
                String userNameInDB = (resultSet.getString("userName"));
                String userPasswordInDB = (resultSet.getString("userPassword"));
                if (userNameInDB == null || userPasswordInDB == null) {
                    continue;
                }
                //check if the user exists in the database
                if (userNameInDB.compareTo(userName) == 0 && userPasswordInDB.compareTo(password) == 0) {
                    //the user exists, return true
                    return true;
                }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        //no user found, return false
        return  false;
    }

    @SuppressWarnings("Duplicates")
    //change the status of a user from not connected to the System to connected
    public void updateIsConnected(String username,String password) {

        System.out.println("connecting user " + username + "...");
        try {

            //connect to mysql database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
            Statement statement = connection.createStatement();
            //create proper sql command to chenge the status of the user to be connected to the system
            String quote_name = '"' + username + '"';
            String quote_pass = '"' + password + '"';

            // update the field "is connected" so we can know which user is connected
            String sql = "UPDATE userTable " +
                    "SET isConnected = 'yes' WHERE userName = " + quote_name + " and userPassword = " + quote_pass;
            statement.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }

    }



    @SuppressWarnings("Duplicates")
    //check if a user is connected to the System or not
    public boolean login_procedure(String username, String password) {

        try{
            //connect to mysql databse
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
            Statement statement = connection.createStatement();

            //create proper sql command to change the status of the user to be connected to the system
            String quote_name = '"' + username + '"';
            String quote_pass = '"' + password + '"';

            // update the field "is connected" so we can know which user is connected
            String sql = "SELECT isConnected From userTable " +
                    "WHERE userName = " +quote_name+ " and userPassword = " + quote_pass;

            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                String a = resultSet.getString("isConnected");
                //if the user is connected
                if(a.compareTo("yes") == 0){
                    return true;
                }
            }
            //the user is not connected
            return false;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
























   // @SuppressWarnings("Duplicates")

    //register user to the database
//    void registerUser(String userName,String password) {
//        boolean userExists = false;
//
//        try {
//            //connect to mysql database locally
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
//            Statement statement = connection.createStatement();
//
//            //create an sql command
//            String sql = "select * from userTable";
//
//            //execute the command
//            ResultSet resultSet = statement.executeQuery(sql);
//
//            //check information in our database
//            while (resultSet.next()) {
//                // get user name and password from users in the database
//                String userNameInDB = (resultSet.getString("userName"));
//                String userPasswordInDB = (resultSet.getString("userPassword"));
//                if (userNameInDB == null || userPasswordInDB == null){
//                    continue;
//                }
//                //check if the user exists in the database
//                if(userNameInDB.compareTo(userName)==0 && userPasswordInDB.compareTo(password) == 0){
//                    userExists = true;
//                    break;
//                }
//            }
//            //if the user exists in the database
//            if (userExists){
//                System.out.println("user is already registered");
//                return;
//            }
//
//            //if the user dosent exist we will create him
//            System.out.println("creating user " + userName);
//
//            // prepare and execute sql command to insert the new user to the database
//            String quote_name = '"' + userName + '"';
//            String quote_pass = '"' + password + '"';
//            String sql1 = "INSERT INTO userTable VALUES(";
//            String sql2 = quote_name +"," + quote_pass + ",";
//            String loggedIn = '"' + "no" + '"' + ")";
//            sql = sql1 +sql2 + loggedIn;
//
//            statement.executeUpdate(sql);
//            System.out.println("user " + userName + " has been added to the database");
//
//
//        } catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//    }

}

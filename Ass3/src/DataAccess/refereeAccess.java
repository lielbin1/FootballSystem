package DataAccess;

import Domain.Referee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class refereeAccess {
    public boolean refereeTable(Referee referee) {
        boolean userExists = false;
        try {
            //connect to mysql database locally
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
            Statement statement = connection.createStatement();
            //create an sql commands
            String sql = "select * from refereeTable";
            //execute the command
            ResultSet resultSet = statement.executeQuery(sql);

            //check information in our database
            while (resultSet.next()) {
                // get user name and password from users in the database
                String userNameInDB = (resultSet.getString("userName"));
                String qualificationInDB = (resultSet.getString("qualification"));
                String isHeadRefereeInDB = (resultSet.getString("isHeadReferee"));
                if (userNameInDB == null || qualificationInDB == null || isHeadRefereeInDB == null) {
                    continue;
                }
                //check if the user exists in the database
                if (userNameInDB.compareTo(referee.getUserName()) == 0 && qualificationInDB.compareTo(referee.getQualification() ) == 0 &&
                        isHeadRefereeInDB.compareTo(referee.getIsHeadReferee()) == 0) {
                    userExists = true;
                    break;
                }
            }

            //if the user exists in the database
            if (userExists) {
                return false;
            }

            //create proper sql command to chenge the status of the user to be connected to the system
            String quote_name = '"' + referee.getUserName() + '"';
            String quote_qualification = '"' + referee.getQualification() + '"';
            String quote_isHeadReferee = '"' + referee.getIsHeadReferee() + '"';
            //if the user dosent exist we will create him
            System.out.println("creating user " + referee.getUserName());

            // prepare and execute sql command to insert the new user to the database

            String sql1 = "INSERT INTO refereeTable VALUES(";
            String sql2 = quote_name + "," + quote_qualification + "," + quote_isHeadReferee + ")";

            sql = sql1 + sql2;

            statement.executeUpdate(sql);



        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


}


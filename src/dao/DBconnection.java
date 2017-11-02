package dao;

import controller.UserInterface;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hitesh on 4/7/17.
 */
public class DBconnection  implements UserInterface {
    static Statement statement = null;
    static Connection conn=null;

    DBconnection() {



    }

    public  static  void FindByUsername(){

    }



    public   void  connect() {
        try {

            Class.forName("com.mysql.jdbc.Driver");

              conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "12qw12");
              statement = conn.createStatement();






        } catch (Exception e) {
            System.out.println(e);
        }



    }


      public static List<User> getAllUsers() throws SQLException {
        List<User> users= new ArrayList<User>();



        ResultSet rs= statement.executeQuery("SELECT * from contact");

        while(rs.next())
        {
            int id= Integer.parseInt(rs.getString( "id"));
            String name=rs.getString("name");
            String username=rs.getString("username");
            String password= rs.getString("password");

            User user= new User(id,name,username,password);

            users.add(user);


            System.out.println("id :"+id+ "    " + "name :"+name+ "    " + "username :"+username+ "    " + "password :"+password+ "    " );



        }
           return users;
       }





}

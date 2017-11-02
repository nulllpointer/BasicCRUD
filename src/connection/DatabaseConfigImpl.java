package connection;

import controller.UserInterface;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hitesh on 4/7/17.
 */
public class DatabaseConfigImpl implements IDatabaseConfig {


    private Statement stat;
    private Connection conn;

    @Override
    public void connect() {

        try {

            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "12qw12");


        } catch (Exception e) {
            System.out.println(e);
        }


    }

    @Override
    public Statement getStatement(Connection connection) throws SQLException {

        return connection.createStatement();

    }
}

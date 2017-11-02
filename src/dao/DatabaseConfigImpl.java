package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by hitesh on 4/7/17.
 */
public class DatabaseConfigImpl implements IDatabaseConfig {


    private Statement stat;
    private Connection conn;

    @Override
    public Connection connect() {

        try {

            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "12qw12");


        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;


    }

    @Override
    public Statement getStatement(Connection connection) throws SQLException {

        return connection.createStatement();

    }
}

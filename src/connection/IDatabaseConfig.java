package connection;

import controller.UserInterface;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hitesh on 4/7/17.
 */
public interface IDatabaseConfig {
    void connect();
    Statement getStatement(Connection connection) throws SQLException;


}

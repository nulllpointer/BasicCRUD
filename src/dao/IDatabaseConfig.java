package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by hitesh on 4/7/17.
 */
public interface IDatabaseConfig {
    Connection connect();
    Statement getStatement(Connection connection) throws SQLException;


}

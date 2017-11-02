package dao;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by hitesh on 4/7/17.
 */
public class UserDao implements IUserDao {
    private final Connection connection;
    Statement statement = null;
    PreparedStatement preparedStatement = null;

    public UserDao() throws SQLException {
        DatabaseConfigImpl db = new DatabaseConfigImpl();
        Connection conn = db.connect();
        statement = conn.createStatement();
        this.connection = conn;


    }


    @Override
    public void update(User aayekoUser) {
        try {
            PreparedStatement st = connection.prepareStatement("UPDATE user SET name=?,username=?,password=? where id=?");
            st.setInt(4, aayekoUser.getId());
            st.setString(1, aayekoUser.getName());
            st.setString(2, aayekoUser.getUsername());
            st.setString(3, aayekoUser.getPassword());

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void create(User user) {
        try {
            PreparedStatement st = connection.prepareStatement("insert into user values (?,?,?,?)");

            st.setInt(1, user.getId());
            st.setString(2, user.getName());
            st.setString(3, user.getPassword());
            st.setString(4, user.getUsername());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM user WHERE  id=?");
            st.setInt(1, id);

            st.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<User>();


        ResultSet rs = null;
        try {
            rs = statement.executeQuery("seLect * from user");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("id"));
                String name = rs.getString("name");
                String username = rs.getString("username");
                String password = rs.getString("password");

                User user = new User(id, name, username, password);

                users.add(user);


                System.out.println("id :" + id + "    " + "name :" + name + "    " + "username :" + username + "    " + "password :" + password + "    ");


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;

    }

    @Override
    public User getbyid(int id) {
        ResultSet rs = null;
        User user=null;
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery("select * from user WHERE  id=" + id);


            while (rs.next()) {


                String name = rs.getString("name");
                String username = rs.getString("username");
                String password = rs.getString("password");
                  user = new User(id, name, username, password);
                System.out.println(name + "  :" + username + "   " + password);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}


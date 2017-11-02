package dao;

import model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by hitesh on 4/7/17.
 */
public interface IUserDao {
  void  create(User user);
   void update(User user);
   void delete(int id);
   List<User> getAll();
   User getbyid(int id);


}

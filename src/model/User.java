package model;

/**
 * Created by hitesh on 4/7/17.
 */
 public class User {
     //String user= "SELECT * from contact where id=";
int id;
String username;
String password;
String name;

      public User(int id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.username = username;
    }

    public User(){

    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
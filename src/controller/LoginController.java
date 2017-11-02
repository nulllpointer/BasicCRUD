package controller;

import connection.DBconnection;
import dao.UserDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by hitesh on 4/7/17.
 */
@WebServlet(name = "Loginjava", urlPatterns = {"/home", "/controller", "/logout", "/users", "/user", "/deleteuser"})
public class LoginController extends HttpServlet {
    UserDao dao = null;
    private List<User> users;

    @Override
    public void init() throws ServletException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (dao == null) {
            try {
                dao = new UserDao();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        System.out.println("here" + request.getServletPath());
        //  response.sendRedirect("login.jsp");

        if (request.getServletPath().equals("/controller")) {

            request.getRequestDispatcher("login.jsp").forward(request, response);

        }

        if (request.getServletPath().equals("/deleteuser")) {
            int id = Integer.parseInt(request.getParameter("id"));


            dao.delete(id);

            request.setAttribute("hitesh", dao.getAll());
            request.setAttribute("hiteshHeader", "List of all Students");

            request.getRequestDispatcher("tables.jsp").forward(request, response);

        }


        if (request.getServletPath().equals("/user")) {

            request.setAttribute("hitesh", users);
            request.setAttribute("hiteshHeader", "List of all Students");

            String id = request.getParameter("id");

            User user = dao.getbyid(Integer.parseInt(id));

            request.setAttribute("currentUser", user);


            request.getRequestDispatcher("tables.jsp").forward(request, response);


        } else if (request.getServletPath().equals("/users")) {


            List<User> users = dao.getAll();
            this.users = users;

            request.setAttribute("hitesh", users);
            request.setAttribute("hiteshHeader", "List of all Students");

            //   dao.create(new User());
//            dao.update(new User());


         /*

            int id = 2;

            int idToBeDeleted=33;
            String name = "Johen";
            String username = "john11";
            String password = "pass11";
            User userToBeUpdated = new User(id, name, username, password);
            User userToBeGet= new User(id, name, username, password);

            try {
                dao = new UserDao();
                //dao.update(userToBeUpdated);
              //  dao.delete(idToBeDeleted);
                 User user= dao.getbyid(2);

                 if(user.getName().equals("Johen")){
                     System.out.println("John is hero.....");
                 }


            } catch (SQLException e) {
                e.printStackTrace();
            }*/


            request.getRequestDispatcher("tables.jsp").forward(request, response);

        }





       /* if(request.getServletPath().equals("/")){
            response.sendRedirect("login.jsp");
*/
    }


    //DoPost method

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // super.doPost(request, response);


        if (request.getServletPath().equals("/user")) {

            int id = Integer.parseInt(request.getParameter("id"));

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String name = request.getParameter("name");

            User u = new User(id, name, username, password);


            User user = dao.getbyid(id);


            if (user == null) {
                dao.create(u);

                users = dao.getAll();


            } else {
                dao.update(u);
                users = dao.getAll();

            }
            request.setAttribute("hitesh", users);
            request.setAttribute("hiteshHeader", "List of all Students");
            request.getRequestDispatcher("tables.jsp").forward(request, response);



        }


    }
}













    /*

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}*/

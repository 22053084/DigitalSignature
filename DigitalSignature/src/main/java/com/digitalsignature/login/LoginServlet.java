package com.digitalsignature.login;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4431256265434288648L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        Login login = new Login();
        login.setEmail(email);
        login.setPassword(password);

//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//        Date lastLoginDate;
//        try {
//            lastLoginDate = dateFormat.parse(lastLogin);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//        login.setLastLogin(lastLoginDate);

        LoginDAO loginDAO = new LoginDAO();
        boolean status = false;
        try {
            if (loginDAO.loginValidate(login)!=null){

                List<Login> loginobj = new ArrayList<>();
                loginobj.add(login);
                request.setAttribute("dslogin", loginobj);
                session.setAttribute("dslogin", loginobj);
                status = true;
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        if (status) {
            request.getRequestDispatcher("/Dashboard/welcome").forward(request, response);
        }
        else {
            request.setAttribute("message", "Incorrect username or password");
            request.getRequestDispatcher("/index.jsp").forward(request, response);

        }
    }
}

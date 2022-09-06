package com.digitalsignature.login;

import com.digitalsignature.login.Login;
import com.digitalsignature.login.LoginDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2428415542985682250L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String cfmpassword = request.getParameter("cfmpassword");
        String forwardPage = "/index.jsp";

        if (!password.trim().equalsIgnoreCase(cfmpassword.trim())){
            request.setAttribute("message", "Password does not match! Please enter your details again.");
            forwardPage = "/register.jsp";
        }
        else {

            String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
            if(isValidPassword(password,regex)){
                Login login = new Login();
                login.setEmail(email.trim());
                login.setPassword(password.trim());
                login.setName(name.trim());

                LoginDAO loginDAO = new LoginDAO();

                if (loginDAO.registerUser(login) > 0)
                    request.setAttribute("message", "Registration successful. You may login to your account.");
                else
                    request.setAttribute("message", "Error in registration. Please try again.");
            }
            else {
                request.setAttribute("message", "Invalid password! Must have at least one numeric, lowercase, uppercase, special character (@#$%) and length should be between 8 and 20.");
                forwardPage = "/register.jsp";
            }
        }
        request.getRequestDispatcher(forwardPage).forward(request, response);

    }

    public static boolean isValidPassword(String password,String regex)
    {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}

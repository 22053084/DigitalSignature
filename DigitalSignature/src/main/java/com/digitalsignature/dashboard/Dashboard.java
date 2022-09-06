package com.digitalsignature.dashboard;

import com.digitalsignature.project.ProjectDAO;
import com.digitalsignature.project.ProjectServlet;
import com.digitalsignature.login.Login;
import com.digitalsignature.login.LoginDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "Dashboard", value = "/Dashboard")
public class Dashboard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.getWriter().append("Served at: ").append(request.getContextPath());

        String action = request.getServletPath();
        try {
            switch (action) {
                case "/Dashboard/welcome":
                    showDashboard(request, response);
                    break;
                default:
                    showDashboard(request, response);
                    break;
            }

        }
        catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    private void showDashboard(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {

        int loginUserID = 0;
        HttpSession session = request.getSession();
        ProjectDAO projectDAO = new ProjectDAO();

        List <Login> loginobjs = (List<Login>) session.getAttribute("dslogin");

        for(Login loginobj : loginobjs) {
            loginUserID = loginobj.getUserID();
        }
        projectDAO.queryProject("WHERE user = " + loginUserID + " ORDER BY creationDate DESC ", request,response);

        request.setAttribute("dssession","Session ID: " + session.getId() + "<br>Creation Time: " + new Date(session.getCreationTime()) + "<br>Last Accessed Time: " + new Date(session.getLastAccessedTime()));
        request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
    }
}

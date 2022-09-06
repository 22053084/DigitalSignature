package com.digitalsignature.project;

import com.digitalsignature.project.Project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class ProjectDAO {
    private static String SELECT_STATEMENT = "";
    private final String jdbcURL = "jdbc:mysql://localhost:3306/digitalsignature";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "password";
    private static final String SELECT_PROJECT_BY = "SELECT * FROM Project ";
    private static final String SELECT_ALL_PROJECT = "SELECT * FROM Project ";
    private static final String INSERT_PROJECT_SQL = "INSERT INTO Project VALUES(?,?,?,?,?)";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public boolean queryProject(String condition, HttpServletRequest request, HttpServletResponse response)  {

        boolean status = false;
        List <Project> projects = new ArrayList <>();
        SELECT_STATEMENT = SELECT_PROJECT_BY + condition;
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STATEMENT);) {

            ResultSet rs = preparedStatement.executeQuery();
            Timestamp dateTimeNow = new Timestamp(System.currentTimeMillis());

            while (rs.next()) {
                projects.add(new Project(rs.getInt("projectID"),
                                rs.getString("projectName"),
                                rs.getInt("user"),
                                rs.getString("status"),
                                rs.getTimestamp("creationDate"),
                                rs.getTimestamp("completionDate")));
            }
            status = true;
            request.setAttribute("userProjects", projects);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return status;
    }
}

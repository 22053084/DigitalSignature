package com.digitalsignature.login;

import com.digitalsignature.login.Login;

import java.sql.*;
import java.util.*;

public class LoginDAO {

    private final String jdbcURL = "jdbc:mysql://localhost:3306/digitalsignature";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "password";
    private static final String SELECT_USER_BY_EM_PW = "SELECT * FROM User WHERE email = ? and password = ?";
    private static final String SELECT_ALL_USERS = "SELECT * FROM User ";
    private static final String INSERT_USERS_SQL = "INSERT INTO User (loginName, email, password, lastLogin) VALUES(?,?,?,?)";

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



    public Login loginValidate(Login login) throws ClassNotFoundException, SQLException {

        boolean status = false;

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EM_PW);) {
            preparedStatement.setString(1, login.getEmail());
            preparedStatement.setString(2, login.getPassword());

            ResultSet rs = preparedStatement.executeQuery();
            Timestamp lastLoginDate = new Timestamp(System.currentTimeMillis());
            // login object have email and password from user input
            while (rs.next()) {
                login.setLastLogin(lastLoginDate);
                login.setUserID(rs.getInt("userID"));
                login.setName(rs.getString("loginName"));
                updateUser(login,"lastLogin"); // "ALL" - update all attributes in the given obj based on userID. Else indicate the specific attribute name, based on userID
                status = true;
            }




        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }

        if (!status)
            return null;
        else
            return login;

    }

    public int registerUser(Login login) {

        int status = 0;

        Timestamp lastLoginDate = new Timestamp(System.currentTimeMillis());

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);) {
            preparedStatement.setString(1, login.getLoginName());
            preparedStatement.setString(2, login.getEmail());
            preparedStatement.setString(3, login.getPassword());
            preparedStatement.setTimestamp(4, lastLoginDate);

            status = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return status;
    }

    public int updateUser(Login login, String mode) {

        int status = 0;
        int counter = 0;
        int number = 4;
        Timestamp lastLoginDate = new Timestamp(System.currentTimeMillis());
        int userID = login.getUserID();
        HashMap<String, String> login_dict = new HashMap<>();

        login_dict.put("loginName",login.getLoginName());
        login_dict.put("email",login.getEmail());
        login_dict.put("password",login.getPassword());
        login_dict.put("lastLogin",String.valueOf(lastLoginDate));

        StringBuilder sql = new StringBuilder("UPDATE User SET ");

        if(!login_dict.isEmpty()) {
            if (mode.trim().equals("ALL")){
                // For every keyset (key name)
                for (String i : login_dict.keySet()) {
                    sql.append(i).append(" = ?");
                    counter ++;
                    if (counter != number) {
                        sql.append(", ");
                    }
                    //System.out.println("key: " + i + " value: " + login_dict.get(i));
                }
            }
            else
                sql.append(mode.trim()).append(" = ?");

            sql.append(" WHERE userID = ").append(userID);

            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());) {
                counter = 0;
                if (mode.trim().equals("ALL")){
                    for (String i : login_dict.keySet()) {
                        preparedStatement.setString(counter+1, login_dict.get(i));
                        counter ++;
                    }
                }
                else
                    preparedStatement.setString(counter+1, login_dict.get(mode.trim()));

                status = preparedStatement.executeUpdate();

            } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
            }
        }

        return status;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}


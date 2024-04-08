/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author nakyumdepzaii
 */
public class DBHelper {
        public static Connection createConnection() throws /*ClassNotFoundException*/ NamingException, SQLException, ClassNotFoundException {
        //1. Get current context
        Context currentContext = new InitialContext();
        //2. Look up tomcat context
        Context tomcatContext = (Context) currentContext.lookup("java:comp/env");
        //3. Look up datasource
        DataSource ds = (DataSource) tomcatContext.lookup("ExpenseSharing");
        //4. Open connection
        Connection con = ds.getConnection();
        
//        //1. Load Driver
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        //2. Create conection String url
//        String url = "jdbc:sqlserver://localhost:1433;databaseName=ExpenseSharing";
//        //3. Open connection
//        Connection con = DriverManager.getConnection(url, "sa", "12345");
        return con;
    }
}

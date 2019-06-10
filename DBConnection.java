/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author astra1
 */
public class DBConnection 
{
    Connection connection=null;
    static Statement statement;
    private Connection getConnection(String driver,String host,String port,String dbname,String username,String password) throws ClassNotFoundException, SQLException
    {
        Class.forName(driver);
        connection = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+dbname,username,password);
        return connection;
    }
    public DBConnection() throws SQLException, ClassNotFoundException
    {
        if(connection == null)
        {
           connection = getConnection("com.mysql.jdbc.Driver","localhost","3306","new","root","12345");
           statement= connection.createStatement();
           connection.setAutoCommit(false);
        }   
    }

    public ResultSet datagetAll() throws SQLException 
    {
        ResultSet resultSet = statement.executeQuery("select * from item");
        return  resultSet;
    }
    
}

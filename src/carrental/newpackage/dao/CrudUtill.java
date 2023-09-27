/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrental.newpackage.dao;
import carrental.newpackage.db.DBConnection;
import com.mysql.cj.protocol.Resultset;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author eshan
 */
public class CrudUtill {
    private static PreparedStatement getPreparedStatement(String sql, Object... args) throws SQLException{
        Connection connection=DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        if(args != null){
            for(int i=0; i<args.length;i++){
                preparedStatement.setObject(i+1, args[i]);
            }
            
        }
        return preparedStatement;
    }
    public static boolean executeUpdate(String sql, Object... args) throws SQLException{
        return getPreparedStatement(sql,args).executeUpdate()>0;
    }
    
    public static Resultset executeQuery(String sql, Object... args) throws SQLException{
        return (Resultset) getPreparedStatement(sql,args).executeQuery();
    }
}

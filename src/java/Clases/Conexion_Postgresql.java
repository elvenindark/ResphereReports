/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Unknown
 */
public class Conexion_Postgresql {
    String url="jdbc:postgresql://localhost:5432/Resphere2";
    
    public Connection getconexion(){
        Connection cn=null;
        try{
            Class.forName("org.postgresql.Driver");
            cn=DriverManager.getConnection(url,"postgres","admin2012");
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return cn;
    }
    
   
}

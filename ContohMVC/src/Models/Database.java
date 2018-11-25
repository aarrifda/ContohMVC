/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


//KELAS DATABASE: ISINYA BIKIN METHOD2 APA YANG BAKAL DIJALANIN DI VIEWNYA

public class Database {
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String DATABASE_LOC = "jdbc:mysql://localhost/db_contoh_mvc";
    String username = "root";
    String password = "";
    
    private Connection connection; //menghubingkan database
    private Statement statement; //eksekusi kueri
    
    public void connect(){
        //Koneksi Database
        try {
            
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_LOC,username,password);
            statement = connection.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void disconnect(){
        try {
            connection.close(); // tutup koneksi
            statement.close(); // tutup statement
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean eksekusiQuery(String query){ //manipulasi(insert/delete/update/dll) data ke MySQL/DB
        boolean berhasil = false;
        try {
            int rows = statement.executeUpdate(query); //cek baris
            if (rows>0) {   
                berhasil = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return berhasil;
    }
    
    public ResultSet getData(String query){
        ResultSet rs = null; //menampung data hasil query.
        try {
            rs = statement.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}

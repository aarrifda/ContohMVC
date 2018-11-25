/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models; //bungkus 2 kelas

import java.sql.ResultSet;
import java.util.ArrayList;

public class Aplikasi {
    private Database db;

    public Aplikasi() {
        db = new Database();
    }
    
    public boolean saveMahasiswa(Mahasiswa m){
        db.connect();
        boolean berhasil = db.eksekusiQuery("insert into mahasiswa (nim, nama) values ('"+m.getNim()+"','"+m.getNama()+ "');");
        db.disconnect();
        return berhasil;
    }
    
    public ArrayList<Mahasiswa> getAllMahasiswa(){ //MINDAHIN DATA DARI MYSQL KE LIST
        db.connect();
        ArrayList<Mahasiswa> arrayMhs = new ArrayList<>();
        ResultSet rs = db.getData("select * from mahasiswa");
        try {
            while (rs.next()) {
                Mahasiswa m = new Mahasiswa(rs.getString("nim"), rs.getString("nama"));
                arrayMhs.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.disconnect();
        return arrayMhs;
    }
}

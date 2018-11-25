/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Aplikasi;
import Models.Mahasiswa;
import Views.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Verly
 */
public class ControllerMainFrame implements ActionListener{

    private MainFrame frame; //VIEW
    private Aplikasi aplikasi; //MODEL

    public ControllerMainFrame() {
        try { //TEMA GUI
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        aplikasi = new Aplikasi();
        
        frame = new MainFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //matiin program
        frame.getBtnSave().addActionListener(this);
        frame.getBtnRefresh().addActionListener(this);
        frame.setLocationRelativeTo(null); //biar guinya ditengah
        frame.setVisible(true); //munculin GUI
    }
    
    
    
    private void RefreshTable(ArrayList<Mahasiswa> data, JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (Mahasiswa mahasiswa : data) {
            
        }
    }
   
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(frame.getBtnSave())) {
            Mahasiswa m = new Mahasiswa(frame.getTvNama().getText(),frame.getTvNim().getText());
            boolean berhasil = aplikasi.saveMahasiswa(m);
            if (berhasil) {
                frame.showMessage("Berhasil disimpan");
            }
        } else if (ae.getSource().equals(frame.getBtnRefresh())){
            RefreshTable(aplikasi.getAllMahasiswa(), frame.getTblGetAllData());
        }
    }
    
}

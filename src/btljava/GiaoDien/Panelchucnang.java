/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btljava.GiaoDien;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author tung
 */
public class Panelchucnang extends JPanel {

    public JButton btThem;

    public JButton btXoa;

    public JButton btSua;

    public JButton btOk;

    public JButton btCancel;

    public JButton btLuuvaohethong;

    public Panelchucnang() {

        btThem = new JButton("Thêm");

        btXoa = new JButton("Xóa");

        btSua = new JButton("Sửa");

        btOk = new JButton("OK");

        btCancel = new JButton("Thoát");

        btLuuvaohethong = new JButton(" Lưu ");
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));

        this.add(btThem);
        this.add(btOk);
        this.add(btXoa);
        this.add(btSua);
        this.add(btCancel);
        this.add(btLuuvaohethong);
        btOk.setEnabled(false);

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btljava.GiaoDien;

import Xuly.Cacchucnang;
import btljava.Dulieu.Thamchieu;
import btljava.Dulieu.ThiSinh;
import btljava.Dulieu.myThiSinh;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author tung
 */
public class PanelChinh extends JPanel implements ActionListener {

    public Paneltim paneltim;
    public Paneldanhsach paneldanhsach;
    public Panelthongtin panelthongtin;
    public Panelchucnang panelchucnang;
    Cacchucnang cacchucnang;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public PanelChinh() {

//
        //    this.setVisible(true);
        //     this.setSize(750, 730);
        //     this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
//        ChucnangTim tim = new ChucnangTim();
//        Chucnanghiendanhsach hien = new Chucnanghiendanhsach();
//        Chucnanghienthongtin hienthongting = new Chucnanghienthongtin();
//        jFrame.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//                paneldanhsach.jTable.getSelectionModel().clearSelection();
//            }
//
//        });
        cacchucnang = new Cacchucnang();

        createContent();
        event();
        loaddata();
    }

    private void createContent() {
        panelthongtin = new Panelthongtin();
        paneldanhsach = new Paneldanhsach();
        panelchucnang = new Panelchucnang();
        paneltim = new Paneltim();
        //    paneldanhsach.setSize(780, 300);
        addTitled(paneltim, "Student Filtre");
        addTitled(paneldanhsach, "List Student");
        addTitled(panelthongtin, "Student Infomation");
        //     this.add(menu.getm);
        this.add(paneltim, BorderLayout.NORTH);
        this.add(paneldanhsach, BorderLayout.CENTER);

        paneldanhsach.add(panelthongtin, BorderLayout.CENTER);
        this.add(panelchucnang, BorderLayout.SOUTH);

    }

    private void addTitled(JPanel panel, String nhan) {
        TitledBorder titledBorder = new TitledBorder(nhan);
        panel.setBorder(titledBorder);
    }

    private void event() {
        panelchucnang.btOk.addActionListener(this);
        panelchucnang.btXoa.addActionListener(this);
        panelchucnang.btThem.addActionListener(this);
        panelchucnang.btCancel.addActionListener(this);
        panelchucnang.btSua.addActionListener(this);
        panelchucnang.btLuuvaohethong.addActionListener(this);

        paneltim.btTim.addActionListener(this);
        paneltim.btQuaylai.addActionListener(this);

    }

    // sự kiện khi chọn các button trong từng panel
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(paneltim.btQuaylai)) {

            cacchucnang.chucnangquaylai(paneltim, paneldanhsach, panelchucnang, panelthongtin);
        }
        if (e.getSource().equals(paneltim.btTim)) {

            cacchucnang.chucnangtimkiem(paneltim, paneldanhsach, panelchucnang, panelthongtin);

        }

        if (e.getSource().equals(panelchucnang.btLuuvaohethong)) {

            cacchucnang.chucnangluu(paneltim, paneldanhsach, panelchucnang, panelthongtin);

        }
        if (e.getSource().equals(panelchucnang.btXoa)) {

           // int row = paneldanhsach.jTable.getSelectedRow();
            cacchucnang.chucnangxoa(paneltim, paneldanhsach, panelchucnang, panelthongtin);

        }
        if (e.getSource().equals(panelchucnang.btThem)) {

            cacchucnang.chucnangthem(paneltim, paneldanhsach, panelchucnang, panelthongtin);

        }
        if (e.getSource().equals(panelchucnang.btSua)) {
            cacchucnang.chucnangsua(paneltim, paneldanhsach, panelchucnang, panelthongtin);

        }
        if (e.getSource().equals(panelchucnang.btCancel)) {
            cacchucnang.chucnangcacel(paneltim, paneldanhsach, panelchucnang, panelthongtin);
        }

        if (e.getSource().equals(panelchucnang.btOk)) {

            cacchucnang.chucnangok(paneltim, paneldanhsach, panelchucnang, panelthongtin);

        }
    }

    public void loaddata() {

        // sự kiện click chuột vào table trong paneldanhsach
        paneldanhsach.jTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               cacchucnang.show(paneltim, paneldanhsach, panelchucnang, panelthongtin);
            }

        });
    }
    
    float tong(String a, String b, String c) {
        return Float.parseFloat(a) + Float.parseFloat(b) + Float.parseFloat(c);
    }

}

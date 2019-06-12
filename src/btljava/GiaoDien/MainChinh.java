/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btljava.GiaoDien;

import btljava.GiaoDien.panelLogo;
import Xuly.Cacchucnang;
import Xuly.Kiemtra;
import btljava.GiaoDien.Menu;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Arrays;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class MainChinh extends JFrame {

    private static final long serialVersionUID = 1L;
    Menu menu;
    

    public MainChinh(String title) {

        super(title);

    }

    public void doShow() {

        menu = new Menu();
        setSize(820, 800);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addControl();

        setVisible(true);
        setResizable(true);
        this.setJMenuBar(menu);

    }

    public void addControl() {

        JPanel pnBorder = new JPanel();

        pnBorder.setLayout(new BorderLayout());
        final JPanel pnCenter = new JPanel();

        pnCenter.setLayout(new CardLayout());

        final panelLogo pnCard1 = new panelLogo();

        final PanelChinh pnCard2 = new PanelChinh();

        // add 2 card layout
        pnCenter.add(pnCard1, "mycard1");
        pnCenter.add(pnCard2, "mycard2");
        pnBorder.add(pnCenter, BorderLayout.CENTER);

        Container con = getContentPane();

        con.add(pnBorder);

        // ấn btn đăng nhập thig gọi đến card2
        pnCard1.btdangnhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                CardLayout cl = (CardLayout) pnCenter.getLayout();
               cl.show(pnCenter, "mycard2");


            }
        });
   
        
          
        
    }
    }

//    public static void main(String[] args) {
//
//        MainChinh card = new MainChinh("Project: Student");
//        card.doShow();
//
//    }
//    private void setMenuBar(JMenuBar mb) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }


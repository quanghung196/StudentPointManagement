/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btljava.GiaoDien;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author tung
 */
public class panelLogo extends JPanel {

  
    public JButton btdangnhap;
    public JButton btthoat;
    //   JFrame fr = new JFrame("Quản Lý Thí Sinh Dự Thi Đại Học");

    public JPanel panelbt;

    public panelLogo() {
//       fr.setVisible(true);
        //     this.setSize(600, 400);
        //    fr.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        createPanel();
        createLabel();

    }

    private void createPanel() {
        // tạo panel vafset layout
        panelbt = new JPanel();
        this.setLayout(new BorderLayout());
        panelbt.setLayout(new FlowLayout());
        this.add(panelbt, BorderLayout.CENTER);
      
    }

    private void createLabel() {
        // gán 2 button cho panel
        btdangnhap = new JButton("     Đăng nhập     ");
        panelbt.add(btdangnhap);

        btthoat = new JButton("         Thoát       ");
        panelbt.add(btthoat);
        btthoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}

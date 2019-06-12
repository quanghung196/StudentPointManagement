/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btljava.GiaoDien;

import Xuly.Kiemtra;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author tung
 */
public class Paneltim extends JPanel {

    public JLabel lbQue;
    public JTextField tfQue;
    public JLabel lbMsv;
    public JTextField tfMsv;
    public JButton btTim;
    public JButton btQuaylai;

    Kiemtra kiemtra = new Kiemtra();

    public Paneltim() {

        this.setLayout(new FlowLayout());
       // this.setSize(200, 730);
        lbQue = new JLabel("    Quê quán   ");
        tfQue = new JTextField(15);
        lbMsv = new JLabel("        Student ID        ");
        tfMsv = new JTextField(10);
        btTim = new JButton("      Tim      ");
        btQuaylai = new JButton("   Quay lại   ");

        this.add(lbQue);
        this.add(tfQue);
        this.add(lbMsv);
        this.add(tfMsv);
        this.add(btQuaylai);
        this.add(btTim);
        btQuaylai.setEnabled(false);

        tfMsv.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (kiemtra.isMsv(c)) {
                    e.consume();
                }
            }

        });

    }

}

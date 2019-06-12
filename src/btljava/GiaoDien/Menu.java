/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btljava.GiaoDien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author tung
 */
public class Menu extends JMenuBar {
    
    // add các menu
    JMenu fileMenu = new JMenu("File");
    JMenu aboutMenu = new JMenu("About");
    
    JMenuItem openItem;
    JMenuItem closeItem;
    JMenuItem exitItem;
    JMenuItem aboutmeItem;
    
    public Menu() {
        openItem = new JMenuItem("Open...");
        closeItem = new JMenuItem("Close....");
        exitItem = new JMenuItem("Exit...");
        aboutmeItem = new JMenuItem("About me...");
        
        fileMenu.add(openItem);
        
        fileMenu.add(closeItem);
        
        fileMenu.addSeparator();
        
        fileMenu.add(exitItem);
        
        aboutMenu.add(aboutmeItem);
        
        this.add(fileMenu);
        
        this.add(aboutMenu);
        sukien();
        
    }
    
    private void sukien() {
        exitItem.setMnemonic(KeyEvent.VK_E);
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // gọi hộp hội thoại  JFileChooser
                JFileChooser choice = new JFileChooser();
                int option = choice.showOpenDialog(null);
                if (option == JFileChooser.APPROVE_OPTION) {
                    Runtime rt = Runtime.getRuntime();
                    try {
                        String x = choice.getSelectedFile().toString();
                      
                        rt.exec("hh.exe " + x);
                        
                    } catch (Exception ex) {
                        ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Không thể mở file");
                    }
                }
            }
        });
        
        aboutmeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Họ và tên: Bùi Quang Hưng\n"
                        + "Mã sinh viên: 160713696\n");        
            }
        });
        closeItem.setMnemonic(KeyEvent.VK_E);
        closeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xuly;

import java.awt.event.KeyEvent;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author tung
 */
public class Kiemtra {

    public Kiemtra() {
    }

    // kiểm tra số
    public boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }

    // kiểm tra số thập phân
    public boolean validatePoint(char ch, JTextField tf) {
        if (ch != '.') {
            return false;
        }
        if (tf.getText() == null || "".equals(tf.getText().trim())) {
            tf.setText("0.");
            return false;
        } else if ("-".equals(tf.getText())) {
            tf.setText("-0.");
        }

        return true;
    }

    // kiểm tra chuỗi
    public boolean isInString(String s, char ch) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch && s.charAt(i)=='.') {
                return true;
            }
        }
        return false;
    }

    // kiểm tra tên
    public boolean isName(char ch) {
        if ((!Character.isLetter(ch)) && ch != KeyEvent.VK_SPACE) {
            return true;
        }

        return false;
    }

    // kiểm tra mã sinh viên
    public boolean isMsv(char ch) {
        if ((!Character.isDigit(ch))) {
            return true;
        }

        return false;
    }

    public boolean isThapPhan(char ch, JTextField tf) {

        if (ch == '.') {
            if (!isInString(tf.getText(), ch)) {
                return false;
            } else {
                return true;
            }

        }
        return true;
    }

  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btljava.GiaoDien;

import Xuly.Kiemtra;
import btljava.Dulieu.Data;
import btljava.Dulieu.TinhThanh;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Panelthongtin extends JPanel {

    static Vector<TinhThanh> arrayList = new Vector<TinhThanh>();
    JLabel lbId;
    public JTextField tfId;
    JLabel name;
    public JTextField tfName;
    JLabel lbQue;
    public JComboBox<String> cbQue = new JComboBox<>();
    JLabel lbNgaySinh;
    // JTextField setdate;
    public JDateChooser setdate = new JDateChooser();
    JLabel lbToan;
    public JTextField tfToan;
    JLabel lbLy;
    public JTextField tfLy;
    JLabel lbHoa;
    public JTextField tfHoa;
    JLabel lbTong;
    public JTextField tfTong;
    JLabel lbGioitinh;
    public ButtonGroup genderGroup;
    public JRadioButton nam;
    public JRadioButton nu;

    Kiemtra kiemtra = new Kiemtra();

    public Panelthongtin() {
        lbId = new JLabel("ID");
        tfId = new JTextField(15);

        name = new JLabel("   NAME");
        tfName = new JTextField();

        lbQue = new JLabel("PLACE");

        lbNgaySinh = new JLabel("   DATE");
        setdate = new JDateChooser();
        //   setdate = new JTextField(15);
        lbToan = new JLabel("Math");
        tfToan = new JTextField();
        lbLy = new JLabel("   Physical");
        tfLy = new JTextField();
        lbHoa = new JLabel("Chemistry");
        tfHoa = new JTextField();
        lbTong = new JLabel("   Total");
        tfTong = new JTextField(15);
        lbGioitinh = new JLabel("SEX");
        genderGroup = new ButtonGroup();

        GridLayout layout = new GridLayout(5, 4, 2, 3);
        layout.setVgap(2);
        this.setLayout(layout);

        nam = createRadioButton("NAM", false);
        nu = createRadioButton("NU", false);

        genderGroup.add(nam);
        genderGroup.add(nu);
        this.add(lbId);

        this.add(tfId);
        this.add(name);
        this.add(tfName);
        this.add(lbQue);
        cbQue.setModel(ModelCbb());
        this.add(cbQue);
        this.add(lbNgaySinh);
        this.add(setdate);
        this.add(lbToan);
        this.add(tfToan);
        this.add(lbLy);
        this.add(tfLy);
        this.add(lbHoa);
        this.add(tfHoa);
        this.add(lbTong);
        this.add(tfTong);
        tfTong.setEnabled(false);

        this.add(lbGioitinh);
        this.add(nam);
        this.add(nu);
        tfId.setEnabled(false);
        boolean x = false;
        tfName.setEnabled(x);
        cbQue.setEnabled(x);
        JTextFieldDateEditor dateE = (JTextFieldDateEditor) setdate.getDateEditor();
        dateE.setEditable(false);
        tfToan.setEnabled(x);
        tfLy.setEnabled(x);
        tfHoa.setEnabled(x);
        tfTong.setEnabled(x);
        nam.setEnabled(x);
        nu.setEnabled(x);

        kiemtra();

    }

    private JRadioButton createRadioButton(String name, boolean select) {
        JRadioButton rad = new JRadioButton(name, select);
        return rad;
    }

    public DefaultComboBoxModel<String> ModelCbb() {

        Data data = new Data();
        data.DocDuLieuTinhThanh(arrayList);

        DefaultComboBoxModel<String> dc = new DefaultComboBoxModel<>();
        for (int i = 0; i < arrayList.size(); i++) {
            dc.addElement(arrayList.get(i).getTentinh());

        }
        return dc;

    }

    private void kiemtra() {

        tfName.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // kiểm tra nhập đúng tên
                if (kiemtra.isName(c)) {
                    e.consume();
                }
            }

        });
        tfId.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // kiểm tra nhập đúng mã sinh viên
                if (kiemtra.isMsv(c)) {
                    
                    e.consume();
                }
            }

        });
        tfToan.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char ch = e.getKeyChar();
// kiểm tra phải nhập số và điểm toán
                if (!kiemtra.isNumber(ch) && !kiemtra.validatePoint(ch, tfToan)) {
                    e.consume();
// kiểm tra nhập số thập phân
                } else if (kiemtra.isThapPhan(ch, tfToan)) {
                    if (!kiemtra.isInString(tfToan.getText(), ch)) {
                        tfToan.setText(tfToan.getText());
                    } else {
                        e.consume();
                    }
                }
            }
        });

        tfHoa.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char ch = e.getKeyChar();
                    
                if (!kiemtra.isNumber(ch) && !kiemtra.validatePoint(ch, tfHoa)) {
                    e.consume();

                } else if (kiemtra.isThapPhan(ch, tfHoa)) {
                    if (!kiemtra.isInString(tfHoa.getText(), ch)) {
                        tfHoa.setText(tfHoa.getText());
                    } else {
                        e.consume();
                    }
                }
            }
        });

        tfLy.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char ch = e.getKeyChar();

                if (!kiemtra.isNumber(ch) && !kiemtra.validatePoint(ch, tfLy)) {
                    e.consume();

                } else if (kiemtra.isThapPhan(ch, tfLy)) {
                    if (!kiemtra.isInString(tfLy.getText(), ch)) {
                        tfLy.setText(tfLy.getText());
                    } else {
                        e.consume();
                    }
                }
            }
        });
    }

//     private void ktDiem(JTextField tf) {
//        int soDiem = Integer.parseInt(tf.getText());
//        if(soDiem >10){
//            JOptionPane.showMessageDialog(null, "Điểm số không hợp lệ.");
//        }
//        
//    }
}

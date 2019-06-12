/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xuly;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import btljava.Dulieu.Data;
import btljava.Dulieu.Thamchieu;
import btljava.Dulieu.ThiSinh;
import btljava.Dulieu.myThiSinh;
import btljava.GiaoDien.Menu;
import btljava.GiaoDien.PanelChinh;
import btljava.GiaoDien.Panelchucnang;
import btljava.GiaoDien.Paneldanhsach;
import btljava.GiaoDien.Panelthongtin;
import btljava.GiaoDien.Paneltim;
import com.sun.xml.internal.ws.wsdl.parser.InaccessibleWSDLException;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Cacchucnang extends JPanel {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    // JFrame jFrame = new JFrame("Project: Student");
    public Cacchucnang() {

        // loaddata();
//
        //    this.setVisible(true);
        //     this.setSize(750, 730);
        //     this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
//        jFrame.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//                paneldanhsach.jTable.getSelectionModel().clearSelection();
//            }
//
//        });
    }

    float tong(String a, String b, String c) {
        return Float.parseFloat(a) + Float.parseFloat(b) + Float.parseFloat(c);
    }

    public void show(Paneltim paneltim, Paneldanhsach paneldanhsach, Panelchucnang panelchucnang, Panelthongtin panelthongtin) {
        int row = paneldanhsach.jTable.getSelectedRow();
        //set text cho table trong paneldanhsach
        panelthongtin.tfId.setText(paneldanhsach.model.getValueAt(row, 0).toString());
        panelthongtin.tfName.setText(paneldanhsach.model.getValueAt(row, 1).toString());
        //    panelthongtin.setdate.setText(paneldanhsach.model.getValueAt(row, 3).toString());
        String xxx = paneldanhsach.model.getValueAt(row, 3).toString();

        try {
            panelthongtin.setdate.setDate(simpleDateFormat.parse(xxx));
        } catch (ParseException ex) {
            Logger.getLogger(Cacchucnang.class.getName()).log(Level.SEVERE, null, ex);
        }
        //set text cho từng textview trong panelthongtin
        panelthongtin.tfToan.setText(paneldanhsach.model.getValueAt(row, 5).toString());
        panelthongtin.tfLy.setText(paneldanhsach.model.getValueAt(row, 6).toString());
        panelthongtin.tfHoa.setText(paneldanhsach.model.getValueAt(row, 7).toString());
        panelthongtin.cbQue.setSelectedItem(paneldanhsach.model.getValueAt(row, 2).toString());
        panelthongtin.tfTong.setText(String.valueOf(tong(paneldanhsach.model.getValueAt(row, 5).toString(), paneldanhsach.model.getValueAt(row, 6).toString(), paneldanhsach.model.getValueAt(row, 7).toString())));
        panelthongtin.tfTong.setEnabled(false);
        if ((paneldanhsach.model.getValueAt(row, 4).toString()).equals("Nam")) {
            panelthongtin.nam.setSelected(true);
        } else {
            panelthongtin.nu.setSelected(true);
        }
    }

    public void chucnangquaylai(Paneltim paneltim, Paneldanhsach paneldanhsach, Panelchucnang panelchucnang, Panelthongtin panelthongtin) {

        paneltim.tfMsv.setEnabled(true);
        paneltim.tfQue.setEnabled(true);
        panelchucnang.btThem.setEnabled(true);
        Thamchieu thamchieu = new Thamchieu();
        String[] s = thamchieu.getTinhthanh();
        myThiSinh DS;
        paneldanhsach.model.setRowCount(0);
                    // đưa thông tin sinh viên ra bảng

        for (ThiSinh i : paneldanhsach.DS.getDS()) {
            String row[] = new String[]{i.getMaThiSinh() + "", i.getTenThiSinh(), s[i.getQueQuan()], i.getNamSinh(), i.getGioiTinh(), i.getDiemToan() + "", i.getDiemLy() + "", i.getDiemHoa() + ""};
            paneldanhsach.model.addRow(row);
        }
        paneltim.tfMsv.setText("");
        paneltim.tfQue.setText("");
        paneltim.btQuaylai.setEnabled(false);

    }

    public void chucnangtimkiem(Paneltim paneltim, Paneldanhsach paneldanhsach, Panelchucnang panelchucnang, Panelthongtin panelthongtin) {
        paneldanhsach.jTable.getSelectionModel().clearSelection();
        Thamchieu thamchieu = new Thamchieu();
        String[] s = thamchieu.getTinhthanh();

        if (paneltim.tfMsv.getText().equals("") && paneltim.tfQue.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Lỗi ! Chưa nhập mã thí sinh và quê quán để tìm kiếm");
            paneltim.btQuaylai.setEnabled(false);

        } else if (!paneltim.tfMsv.getText().equals("") && !paneltim.tfQue.getText().equals("")) {
            int ma = Integer.parseInt(paneltim.tfMsv.getText());
            ThiSinh val = new ThiSinh();
            // tìm sinh viên theo mã
            val = paneldanhsach.DS.timtheomsv(ma);

            if (val == null) {
                JOptionPane.showMessageDialog(null, "Lỗi ! Không có thí sinh này");
                paneltim.tfMsv.setText("");
                paneltim.tfQue.setText("");
                paneltim.btQuaylai.setEnabled(false);
                            // đưa thông tin sinh viên ra bảng

            } else if (val != null && (s[val.getQueQuan()].equals(paneltim.tfQue.getText()))) {
                panelchucnang.btThem.setEnabled(false);
                paneltim.btQuaylai.setEnabled(true);
                String rowData[] = new String[]{val.getMaThiSinh() + "", val.getTenThiSinh(), s[val.getQueQuan()], val.getNamSinh(), val.getGioiTinh(), val.getDiemToan() + "", val.getDiemLy() + "", val.getDiemHoa() + ""};
                paneldanhsach.model.setRowCount(0);
                paneldanhsach.model.addRow(rowData);

            } else {
                JOptionPane.showMessageDialog(null, "Lỗi ! Không có thí sinh này");
                paneltim.tfMsv.setText("");
                paneltim.tfQue.setText("");
                paneltim.btQuaylai.setEnabled(false);

            }

        } else if (!paneltim.tfMsv.getText().equals("")) {
            paneltim.tfQue.setEnabled(false);
            int ma = Integer.parseInt(paneltim.tfMsv.getText());
            ThiSinh val = new ThiSinh();
            val = paneldanhsach.DS.timtheomsv(ma);
            if (val != null) {
                panelchucnang.btThem.setEnabled(false);
                paneltim.btQuaylai.setEnabled(true);
                String rowData[] = new String[]{val.getMaThiSinh() + "", val.getTenThiSinh(), s[val.getQueQuan()], val.getNamSinh(), val.getGioiTinh(), val.getDiemToan() + "", val.getDiemLy() + "", val.getDiemHoa() + ""};
                paneldanhsach.model.setRowCount(0);
                paneldanhsach.model.addRow(rowData);
            } else {
                JOptionPane.showMessageDialog(null, "Lỗi ! Không có thí sinh này");
                paneltim.tfMsv.setText("");
                paneltim.tfQue.setText("");
                paneltim.btQuaylai.setEnabled(false);
                paneltim.tfQue.setEnabled(true);

            }

        } else if (!paneltim.tfQue.getText().equals("")) {
            // tìm theo quê
            String x = paneltim.tfQue.getText();

            paneltim.tfMsv.setEnabled(false);
            ArrayList<ThiSinh> listThisinh = new ArrayList<>();
            // lọc theo quê
            listThisinh = paneldanhsach.DS.loctheoque(x);
            // đưa thông tin sinh viên ra bảng
            if (listThisinh.size() != 0) {
                panelchucnang.btThem.setEnabled(false);
                paneltim.btQuaylai.setEnabled(true);
                paneldanhsach.model.setRowCount(0);
                for (int i = 0; i < listThisinh.size(); i++) {
                    String rowData[] = new String[]{listThisinh.get(i).getMaThiSinh() + "", listThisinh.get(i).getTenThiSinh(), s[listThisinh.get(i).getQueQuan()], listThisinh.get(i).getNamSinh(), listThisinh.get(i).getGioiTinh(), listThisinh.get(i).getDiemToan() + "", listThisinh.get(i).getDiemLy() + "", listThisinh.get(i).getDiemHoa() + ""};
                    paneldanhsach.model.addRow(rowData);

                }
            } else if (listThisinh.size() == 0) {
                JOptionPane.showMessageDialog(null, "Lỗi ! Không có thí sinh này");
                paneltim.tfMsv.setText("");
                paneltim.tfQue.setText("");
                paneltim.btQuaylai.setEnabled(false);
                paneltim.tfMsv.setEnabled(true);

            }

        }

    }

    public void chucnangluu(Paneltim paneltim, Paneldanhsach paneldanhsach, Panelchucnang panelchucnang, Panelthongtin panelthongtin) {
        paneldanhsach.DS.sx();
        // mở hộp hội thoại hỏi
        int check = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn lưu dữ liệu này vào hệ thống ? ", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (check == JOptionPane.YES_OPTION) {
            try {
                // ghi dữ liệu ra file để lưu
                paneldanhsach.DS.GhiDuLieuRaFile();
                JOptionPane.showMessageDialog(null, "Lưu thành công");
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Lỗi rồi");
            }

        }
//            TableRowSorter<TableModel> sort = new TableRowSorter<TableModel>(paneldanhsach.dt);
//            paneldanhsach.jTable.setRowSorter(sort);

    }

    public void chucnangxoa(Paneltim paneltim, Paneldanhsach paneldanhsach, Panelchucnang panelchucnang, Panelthongtin panelthongtin) {
        paneltim.btQuaylai.setEnabled(false);
        paneltim.tfMsv.setText("");
        int row = paneldanhsach.jTable.getSelectedRow();
        //    System.out.println(row);
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng để xóa");
        } else {
            int check = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa ? ", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (check == JOptionPane.YES_OPTION) {
                // paneldanhsach.model.removeRow(row);
                // lấy ra mã sinh viên đang chọn trong dòng đó
                String ss = paneldanhsach.model.getValueAt(row, 0).toString();
                int msv = Integer.parseInt(ss);
                // xóa sinh viên này
                paneldanhsach.DS.xoa(msv);
                Thamchieu thamchieu = new Thamchieu();
                String[] s = thamchieu.getTinhthanh();
                paneldanhsach.model.setRowCount(0);
                //  DS = Data.DocDuLieuThiSinh();
                
                // load lại dữ liệu lên bảng
                for (ThiSinh i : paneldanhsach.DS.getDS()) {
                    String xxx[] = new String[]{i.getMaThiSinh() + "", i.getTenThiSinh(), s[i.getQueQuan()], i.getNamSinh(), i.getGioiTinh(), i.getDiemToan() + "", i.getDiemLy() + "", i.getDiemHoa() + ""};
                    paneldanhsach.model.addRow(xxx);
                }
            }
        }
        panelchucnang.btThem.setEnabled(true);

    }

    public void chucnangthem(Paneltim paneltim, Paneldanhsach paneldanhsach, Panelchucnang panelchucnang, Panelthongtin panelthongtin) {

        if (((panelchucnang.btThem.getText()).trim()).equalsIgnoreCase("Thêm")) {
            suaText(true, paneltim, paneldanhsach, panelchucnang, panelthongtin);
            paneldanhsach.jTable.setEnabled(false);
            panelchucnang.btThem.setText("  Hủy  ");
            panelchucnang.btThem.setEnabled(true);
            panelchucnang.btXoa.setEnabled(false);
            panelchucnang.btSua.setEnabled(false);
            panelchucnang.btOk.setEnabled(true);
            panelchucnang.btCancel.setEnabled(false);
        } else if (((panelchucnang.btThem.getText()).trim()).equalsIgnoreCase("Hủy")) {
            suaText(false, paneltim, paneldanhsach, panelchucnang, panelthongtin);
             paneldanhsach.jTable.setEnabled(true);
            panelchucnang.btThem.setText("  Thêm  ");
            panelchucnang.btThem.setEnabled(true);
            panelchucnang.btXoa.setEnabled(true);
            panelchucnang.btSua.setEnabled(true);
            panelchucnang.btOk.setEnabled(false);
            panelchucnang.btCancel.setEnabled(true);

        }

    }

    public void chucnangsua(Paneltim paneltim, Paneldanhsach paneldanhsach, Panelchucnang panelchucnang, Panelthongtin panelthongtin) {

        if (((panelchucnang.btSua.getText()).trim()).equalsIgnoreCase("Sửa")) {
            suaText(true, paneltim, paneldanhsach, panelchucnang, panelthongtin);
            panelthongtin.tfId.setEnabled(false);
            panelchucnang.btSua.setText("  Hủy  ");
            panelchucnang.btSua.setEnabled(true);
            panelchucnang.btXoa.setEnabled(false);
            panelchucnang.btThem.setEnabled(false);
            panelchucnang.btOk.setEnabled(true);
            panelchucnang.btCancel.setEnabled(false);
        } else if (((panelchucnang.btSua.getText()).trim()).equalsIgnoreCase("Hủy")) {
            suaText(false, paneltim, paneldanhsach, panelchucnang, panelthongtin);
            panelthongtin.tfId.setEnabled(false);
            panelchucnang.btSua.setText("  Sửa  ");
            panelchucnang.btSua.setEnabled(true);
            panelchucnang.btXoa.setEnabled(true);
            panelchucnang.btThem.setEnabled(true);
            panelchucnang.btOk.setEnabled(false);
            panelchucnang.btCancel.setEnabled(true);

        }

    }

    public void chucnangcacel(Paneltim paneltim, Paneldanhsach paneldanhsach, Panelchucnang panelchucnang, Panelthongtin panelThongtin) {
        paneldanhsach.DS.sx();
        int check = JOptionPane.showConfirmDialog(null, "Bạn có muốn lưu dữ liệu này vào hệ thống? ", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (check == JOptionPane.YES_OPTION) {
            try {
                paneldanhsach.DS.GhiDuLieuRaFile();
                JOptionPane.showMessageDialog(null, "Lưu thành công");

            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Lỗi rồi");
            }
        }
        paneldanhsach.DS.GhiDuLieuRaFile();
        System.exit(0);

    }

    public void chucnangok(Paneltim paneltim, Paneldanhsach paneldanhsach, Panelchucnang panelchucnang, Panelthongtin panelthongtin) {

       
        if (panelthongtin.tfId.getText().equals("") || panelthongtin.tfName.getText().equals("") || simpleDateFormat.format(panelthongtin.setdate.getDate()).equals("") || panelthongtin.tfToan.getText().equals("") || panelthongtin.tfLy.getText().equals("") || panelthongtin.tfHoa.getText().equals("")) {
            // panelthongtin.setid.requestFocus();
            JOptionPane.showMessageDialog(null, "Lỗi rồi");
            return;

        } else if ((paneldanhsach.DS).kiemtraMSV(Integer.parseInt((panelthongtin.tfId).getText())) == false) {
            luu(paneltim, paneldanhsach, panelchucnang, panelthongtin);
        } else if ((paneldanhsach.DS).kiemtraMSV(Integer.parseInt((panelthongtin.tfId).getText())) == true) {
            sua(paneltim, paneldanhsach, panelchucnang, panelthongtin);
        } else {
            JOptionPane.showMessageDialog(null, "Lỗi rồi");
        }

        panelthongtin.tfTong.setText(String.valueOf(tong(panelthongtin.tfToan.getText(), panelthongtin.tfLy.getText(), panelthongtin.tfHoa.getText())));
    }

    private void luu(Paneltim paneltim, Paneldanhsach paneldanhsach, Panelchucnang panelchucnang, Panelthongtin panelthongtin) {
        {
            // lấy các dữ liệu tương ứng
            String matisinh = panelthongtin.tfId.getText();
            String ten = panelthongtin.tfName.getText();
            String ngayy = simpleDateFormat.format(panelthongtin.setdate.getDate());
            String dtoan = panelthongtin.tfToan.getText();
            String dl = panelthongtin.tfLy.getText();
            String dh = panelthongtin.tfHoa.getText();
            String gioitinh;
            int tinhthanh = 2;
            Thamchieu thamchieu = new Thamchieu();
            String[] s = new String[70];
            s = thamchieu.getTinhthanh();

            float valdiemtoan = Float.parseFloat(dtoan);
            float valdiemly = Float.parseFloat(dl);
            float valdiemhoa = Float.parseFloat(dh);

            if (valdiemtoan > 10 || valdiemtoan < 0 || valdiemly > 10 || valdiemly < 0 || valdiemhoa > 10 || valdiemhoa < 0) {
                if (valdiemtoan > 10 || valdiemtoan < 0) {
                    // đặt con trỏ vào textview Toán
                    panelthongtin.tfToan.requestFocus();
                }
                if (valdiemly > 10 || valdiemly < 0) {
                    panelthongtin.tfLy.requestFocus();
                }
                if (valdiemhoa > 10 || valdiemhoa < 0) {
                    panelthongtin.tfHoa.requestFocus();
                }
                JOptionPane.showMessageDialog(null, "Điểm không phù hợp");
                return;
            }

            boolean gt = true;
            String que = (String) panelthongtin.cbQue.getSelectedItem();
            for (int j = 0; j < s.length; j++) {
                if (que.equals(s[j])) {
                    tinhthanh = j;

                    break;
                }
            }

            if (panelthongtin.nam.isSelected()) {
                gioitinh = "Nam";
                gt = true;
            } else {
                gioitinh = "Nu";
                gt = false;
            }
            int check = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thêm thí sinh này ? ", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (check == JOptionPane.YES_OPTION) {
                String[] ts = {matisinh, ten, que, ngayy, gioitinh, dtoan, dl, dh};
                paneldanhsach.model.addRow(ts);
                ThiSinh x = new ThiSinh(Integer.parseInt(matisinh), ten, tinhthanh, ngayy, gt, Float.parseFloat(dtoan), Float.parseFloat(dl), Float.parseFloat(dh));
                paneldanhsach.DS.themmoi(x);
                JOptionPane.showMessageDialog(null, "Thêm thành công ");
            }
            //  resetTf();

        }
    }

    private void sua(Paneltim paneltim, Paneldanhsach paneldanhsach, Panelchucnang panelchucnang, Panelthongtin panelthongtin) {

        float valdiemtoan = Float.parseFloat(panelthongtin.tfToan.getText());
        float valdiemly = Float.parseFloat(panelthongtin.tfLy.getText());
        float valdiemhoa = Float.parseFloat(panelthongtin.tfHoa.getText());

        if (valdiemtoan > 10 || valdiemtoan < 0 || valdiemly > 10 || valdiemly < 0 || valdiemhoa > 10 || valdiemhoa < 0) {
            JOptionPane.showMessageDialog(null, "Điểm không phù hợp");
            if (valdiemtoan > 10 || valdiemtoan < 0) {
                panelthongtin.tfToan.requestFocus();
            }
            if (valdiemly > 10 || valdiemly < 0) {
                panelthongtin.tfLy.requestFocus();
            }
            if (valdiemhoa > 10 || valdiemhoa < 0) {
                panelthongtin.tfHoa.requestFocus();
            }
            return;
        }

        if (!(panelchucnang.btThem).isEnabled()) {
            int check = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa thí sinh này ? ", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (check == JOptionPane.YES_OPTION) {
                String gt = "";
                boolean gtt = true;
                if (panelthongtin.nam.isSelected()) {
                    gt = "Nam";
                    gtt = true;
                } else {
                    gt = "Nu";
                    gtt = false;
                }
                Thamchieu thamchieu = new Thamchieu();
                String[] s = new String[70];
                s = thamchieu.getTinhthanh();
                String que = (String) panelthongtin.cbQue.getSelectedItem();
                int tinhthanh = 0;
                for (int j = 0; j < s.length; j++) {
                    if (que.equals(s[j])) {
                        tinhthanh = j;
                        break;
                    }
                }

                paneldanhsach.DS.thaydoi(Integer.parseInt(panelthongtin.tfId.getText()), panelthongtin.tfName.getText(), tinhthanh, simpleDateFormat.format(panelthongtin.setdate.getDate()), gtt, Float.parseFloat(panelthongtin.tfToan.getText()), Float.parseFloat(panelthongtin.tfLy.getText()), Float.parseFloat(panelthongtin.tfHoa.getText()));

                paneldanhsach.model.setValueAt(panelthongtin.tfName.getText(), paneldanhsach.jTable.getSelectedRow(), 1);
                paneldanhsach.model.setValueAt(panelthongtin.cbQue.getSelectedItem(), paneldanhsach.jTable.getSelectedRow(), 2);
                paneldanhsach.model.setValueAt(simpleDateFormat.format(panelthongtin.setdate.getDate()), paneldanhsach.jTable.getSelectedRow(), 3);
                paneldanhsach.model.setValueAt(gt, paneldanhsach.jTable.getSelectedRow(), 4);
                paneldanhsach.model.setValueAt(panelthongtin.tfToan.getText(), paneldanhsach.jTable.getSelectedRow(), 5);
                paneldanhsach.model.setValueAt(panelthongtin.tfLy.getText(), paneldanhsach.jTable.getSelectedRow(), 6);
                paneldanhsach.model.setValueAt(panelthongtin.tfHoa.getText(), paneldanhsach.jTable.getSelectedRow(), 7);
                JOptionPane.showMessageDialog(null, "Chỉnh sửa thành công ");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Mã sinh viên này đã tồn tại");
        }

    }

    private void suaText(boolean x, Paneltim paneltim, Paneldanhsach paneldanhsach, Panelchucnang panelchucnang, Panelthongtin panelthongtin) {
        panelthongtin.tfId.setEnabled(x);
        panelthongtin.tfName.setEnabled(x);
        panelthongtin.cbQue.setEnabled(x);
        JTextFieldDateEditor dateE = (JTextFieldDateEditor) panelthongtin.setdate.getDateEditor();
        dateE.setEditable(false);
        panelthongtin.tfToan.setEnabled(x);
        panelthongtin.tfLy.setEnabled(x);
        panelthongtin.tfHoa.setEnabled(x);
        panelthongtin.nam.setEnabled(x);
        panelthongtin.nu.setEnabled(x);
        if (x) {
            resetTf(paneltim, paneldanhsach, panelchucnang, panelthongtin);
        }
    }

    private void resetTf(Paneltim paneltim, Paneldanhsach paneldanhsach, Panelchucnang panelchucnang, Panelthongtin panelthongtin) {
        String val = paneldanhsach.jTable.getValueAt(paneldanhsach.jTable.getRowCount() - 1, 0).toString();
        int val2 = Integer.parseInt(val) + 1;
        panelthongtin.tfId.setText(String.valueOf(val2));
        panelthongtin.tfName.setText("");
        //   panelthongtin.setdate.setText("");
        panelthongtin.tfToan.setText("");
        panelthongtin.tfLy.setText("");
        panelthongtin.tfHoa.setText("");
        panelthongtin.nam.setSelected(false);
        panelthongtin.nu.setSelected(false);
        panelthongtin.tfTong.setText("");
    }

//    public static void main(String[] args) {
//        new Cacchucnang();
//    }
}

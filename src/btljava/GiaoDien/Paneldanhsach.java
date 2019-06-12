/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btljava.GiaoDien;

import btljava.Dulieu.Data;
import btljava.Dulieu.Thamchieu;
import btljava.Dulieu.ThiSinh;
import btljava.Dulieu.myThiSinh;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author tung
 */
public class Paneldanhsach extends JPanel {

    public DefaultTableModel model = new DefaultTableModel();
    public JTable jTable;
    public myThiSinh DS;
    public  Data data;
    public Paneldanhsach() {
        jTable = new JTable();
        //   jTable.setAutoCreateRowSorter(true);
        this.setLayout(new BorderLayout());
        model = createTable();
        jTable.setModel(model);
       // jTable.setEnabled(false);
//        TableRowSorter<TableModel> sort = new TableRowSorter<TableModel>(model);
//        jTable.setRowSorter(sort);
        DS.sx();
        JScrollPane sc = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       // sc.setSize(600, 300);
        this.add(sc, BorderLayout.NORTH);
        hienthongtin();
    }

    public DefaultTableModel createTable() {

        DefaultTableModel model = new DefaultTableModel();
        Thamchieu thamchieu = new Thamchieu();
        String[] s = thamchieu.getTinhthanh();

  // add các column cho table
        model.addColumn("MaSV");
        model.addColumn("TenSV");
        model.addColumn("QueQuan");
        model.addColumn("NgaySinh");
        model.addColumn("GioiTinh");
        model.addColumn("DiemToan");
        model.addColumn("DiemLy");
        model.addColumn("DiemHoa");
        model.addColumn("TongDiem");
        data = new Data();
        DS = data.DocDuLieuThiSinh();
        
        
        for (ThiSinh i : DS.getDS()) {
            String row[] = new String[]{i.getMaThiSinh() + "", i.getTenThiSinh(), s[i.getQueQuan()], i.getNamSinh(), i.getGioiTinh(), i.getDiemToan() + "", i.getDiemLy() + "", i.getDiemHoa() + "", i.getTongDiem() + ""};
            model.addRow(row);
        }
        return model;
    }

    private void hienthongtin() {

        TableColumn column = null;
        // set độ rộng cho các table
        for (int i = 0; i < 8; i++) {
            column = jTable.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(40);
            } else if (i == 1) {
                column.setPreferredWidth(100);
            } else if (i == 2) {
                column.setPreferredWidth(70);
            } else if (i == 3) {
                column.setPreferredWidth(60);
            } else if (i == 4) {
                column.setPreferredWidth(40);
            } else {
                column.setPreferredWidth(50);
            }

        }

    }

}

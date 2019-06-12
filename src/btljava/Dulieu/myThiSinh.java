/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btljava.Dulieu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tung
 */
public class myThiSinh {

    ArrayList<ThiSinh> arrayList = new ArrayList<>();

    public myThiSinh() {
    }

    public void GhiDuLieuRaFile() {
        try {
            // gọi file thisinh.txt
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("thisinh.txt"));
            for (int i = 0; i < arrayList.size(); i++) {
                // ghi dữ liệu ra cùng với dấu ;
                bufferedWriter.write(String.valueOf(arrayList.get(i).getMaThiSinh() + "; "));
                bufferedWriter.write(String.valueOf(arrayList.get(i).getTenThiSinh() + "; "));
                bufferedWriter.write(String.valueOf(arrayList.get(i).getQueQuan()) + "; ");
                bufferedWriter.write(arrayList.get(i).getNamSinh() + "; ");

                boolean x = true;
                // vì kiểu giới tính là bool, nên nếu nam thì lưu là true
                if (arrayList.get(i).getGioiTinh().equals("Nam")) {
                    x = true;
                } else {
                    x = false;
                }
                bufferedWriter.write(String.valueOf(x + "; "));
                bufferedWriter.write(String.valueOf(arrayList.get(i).getDiemToan() + "; "));
                bufferedWriter.write(String.valueOf(arrayList.get(i).getDiemLy() + "; "));
                bufferedWriter.write(String.valueOf(arrayList.get(i).getDiemHoa()));

                bufferedWriter.newLine();
            }
            bufferedWriter.flush();

        } catch (IOException ex) {
            Logger.getLogger(myThiSinh.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<ThiSinh> getDS() {
        return arrayList;
    }

    public int size() {
        return arrayList.size();
    }

    public void xuat() {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));

        }
    }

    public boolean themmoi(ThiSinh x) {
        if (arrayList.add(x)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean thaydoi(int maThiSinh, String tenThiSinh, int queQuan, String namSinh, boolean gioiTinh,
            float diemToan, float diemLy, float diemHoa
    ) {
        // lấy ra thí sinh
        ThiSinh temp = new ThiSinh(maThiSinh, tenThiSinh, queQuan, namSinh, gioiTinh, diemToan, diemLy, diemHoa);
        int val = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            // duyệt nếu tìm thấy thí sinh đó
            if (arrayList.get(i).getMaThiSinh() == maThiSinh) {
                val = i;
                break;
            }
        }
        // thay đổi thông tin thí sinh
        arrayList.set(val, temp);
        return true;
    }

    public boolean loaibo(int k) {

        if (k >= 0 && k <= arrayList.size() - 1) {
            arrayList.remove(k);
            return true;
        }
        return false;
    }

    public boolean xoa(int msv) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getMaThiSinh() == msv) {
                arrayList.remove(i);
                return true;

            }
        }

        return false;
    }

    public ArrayList<ThiSinh> loctheoque(String x) {
        ArrayList<ThiSinh> list = new ArrayList<>();
        
        Thamchieu tt = new Thamchieu();
        String[] s = new String[70];
        // lấy tinh thành đưa vào mảng s
        s = tt.getTinhthanh();
        int val = -1;
        
        // nếu tìm thấy tỉnh thành
        for (int i = 1; i <= 63; i++) {
            if ((s[i].trim()).equalsIgnoreCase(x.trim())) {
                val = i;
                break;
            }
        }
        if (val == -1) {
            return list;
        }
        // lưu hết thí sinh tìm dc vào list
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getQueQuan() == val) {
                ThiSinh ts = new ThiSinh();
                ts = arrayList.get(i);
                list.add(ts);
            }
        }

        return list;
    }

    public ThiSinh timtheomsv(int x) {
        ThiSinh val = null;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getMaThiSinh() == x) {
                val = arrayList.get(i);
            }
        }
        return val;
    }

    public boolean kiemtraMSV(int msv) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getMaThiSinh() == msv) {
                return true;
            }
        }

        return false;
    }

    public void sx() {
        Collections.sort(arrayList, new SapXep());
    }

}

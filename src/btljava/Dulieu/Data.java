/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btljava.Dulieu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Data {

    public myThiSinh data = new myThiSinh();

   public Data() {
        
    }

    public myThiSinh DocDuLieuThiSinh() {

        BufferedReader bufferedReader = null;

        try {

            //đọc file thisinh.txt
            bufferedReader = new BufferedReader(new FileReader("thisinh.txt"));

            String s = null;
            while ((s = bufferedReader.readLine()) != null) {
                String[] str;
                // xử lý cắt chuỗi theo dấu ; rồi lưu vào mảng str
                str = s.split("; ");

                ThiSinh x = new ThiSinh();
                
                // lấy từng phần tử của mảng str đã cắt gán vào đối tượng thí sinh x
                x.setMaThiSinh(Integer.parseInt(str[0]));
                x.setTenThiSinh(str[1]);
                x.setQueQuan(Integer.parseInt(str[2]));
                x.setNamSinh(str[3]);

                x.setGioiTinh(Boolean.valueOf(str[4]));

                x.setDiemToan(Float.parseFloat(str[5]));
                x.setDiemLy(Float.parseFloat(str[6]));
                x.setDiemHoa(Float.parseFloat(str[7]));

                // add dữ liệu vào 
                data.themmoi(x);

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(myThiSinh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(myThiSinh.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                Logger.getLogger(myThiSinh.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
        return data;
    }

    public void DocDuLieuTinhThanh(Vector<TinhThanh> arrayList) {
        BufferedReader bufferedReader = null;

        try {

            bufferedReader = new BufferedReader(new FileReader("tinhthanh.txt"));

            String s = null;
            while ((s = bufferedReader.readLine()) != null) {
                String[] str;
                str = s.split("; ");

                TinhThanh x = new TinhThanh();
                x.setMatinhTentinh(Integer.parseInt(str[0]), str[1]);
                arrayList.add(x);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(myThiSinh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(myThiSinh.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                Logger.getLogger(myThiSinh.class.getName()).log(Level.SEVERE, null, ex);

            }

        }

    }
}

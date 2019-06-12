/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btljava.Dulieu;

import java.util.Vector;

/**
 *
 * @author tung
 */
public class Thamchieu {

    // dùng để trả ra tên tỉnh thành
    Vector<TinhThanh> list = new Vector<TinhThanh>();
    Data data = new Data();
    public Thamchieu() {;

    }
    
    public String[] getTinhthanh() {
        // đọc dữ liệu tỉnh thành vào lưu vào list
        data.DocDuLieuTinhThanh(list);
        String[] ten = new String[70];

        //lấy từng đối tượng và trả ra mảng string
        for (int i = 0; i < list.size(); i++) {
            ten[i + 1] = list.get(i).getTentinh();
        }
        return ten;
    }
}

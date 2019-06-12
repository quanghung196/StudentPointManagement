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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tung
 */
public class myTinhThanh {

    ArrayList<TinhThanh> arrayList = new ArrayList<>();

    public myTinhThanh() {

    }

    /**
     *
     */
    public void DocDuLieuTinhThanh() {
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

    void xuat() {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}

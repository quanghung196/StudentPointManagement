/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btljava.Dulieu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA. User: tung Date: 17/02/2017 Time: 22:30 To change
 * this template use File | Settings | File Templates.
 */
public class ThiSinh {

    private int maThiSinh;
    private String tenThiSinh;
    private int queQuan;
    private Date namSinh;
    private boolean gioiTinh;
    private float diemToan;
    private float diemLy;
    private float diemHoa;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");

    public ThiSinh() {

    }

    public String getNamSinh() {
        return simpleDateFormat.format(namSinh);
    }

    public void setNamSinh(String namSinh) {
        try {
            this.namSinh = simpleDateFormat.parse(namSinh);
        } catch (ParseException ex) {
            Logger.getLogger(ThiSinh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public float getDiemHoa() {
        return diemHoa;
    }

    public void setDiemHoa(float diemHoa) {
        this.diemHoa = diemHoa;
    }

    public float getDiemLy() {
        return diemLy;
    }

    public void setDiemLy(float diemLy) {
        this.diemLy = diemLy;
    }

    public float getDiemToan() {
        return diemToan;
    }

    public void setDiemToan(float diemToan) {
        this.diemToan = diemToan;
    }

    public String getGioiTinh() {
        if (gioiTinh) {
            return "Nam";
        } else {
            return "Nu";
        }
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getQueQuan() {

        return queQuan;
    }

    public String toString() {
        String x = "nam";

        if (this.gioiTinh == false) {
            x = "nu";
        } else {
            x = "nam";
        }

        return "ThiSinh{" + "maThiSinh=" + maThiSinh + ", tenThiSinh=" + tenThiSinh + ", queQuan=" + queQuan + ", namSinh=" + (namSinh) + ", gioiTinh=" + x + ", diemToan=" + diemToan + ", diemLy=" + diemLy + ", diemHoa=" + diemHoa + '}';
    }

    public void setQueQuan(int queQuan) {

        this.queQuan = queQuan;
    }

    public int getMaThiSinh() {
        return maThiSinh;
    }

    public void setMaThiSinh(int maThiSinh) {
        this.maThiSinh = maThiSinh;
    }

    public String getTenThiSinh() {
        return tenThiSinh;
    }

    public void setTenThiSinh(String tenThiSinh) {
        this.tenThiSinh = tenThiSinh;
    }

    public ThiSinh(int maThiSinh, String tenThiSinh, int queQuan, String namSinh, boolean gioiTinh, float diemToan, float diemLy, float diemHoa) {
        this.maThiSinh = maThiSinh;
        this.tenThiSinh = tenThiSinh;
        this.queQuan = queQuan;

        try {
            this.namSinh = simpleDateFormat.parse(namSinh);
        } catch (ParseException ex) {
            Logger.getLogger(ThiSinh.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.gioiTinh = gioiTinh;
        this.diemToan = diemToan;
        this.diemLy = diemLy;
        this.diemHoa = diemHoa;
    }

    public ThiSinh(int x) {
        this.maThiSinh = x;
    }
    
    public float getTongDiem() {
        return diemToan + diemLy + diemHoa;
    }
}

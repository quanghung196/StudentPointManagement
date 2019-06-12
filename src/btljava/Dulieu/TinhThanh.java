/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btljava.Dulieu;

public class TinhThanh {

    private int maTinh;
    private String tenTinh;

    public int getMatinh() {
        return maTinh;
    }

    public String getTentinh() {
        return tenTinh;
    }

    public void setTenTinh(String tenTinh) {
        this.tenTinh = tenTinh;
    }

    public void setMaTinh(int maTinh) {
        this.maTinh = maTinh;
    }

    public void setMatinhTentinh(int matinh, String tentinh) {
        this.maTinh = matinh;
        this.tenTinh = tentinh;
    }

    @Override
    public String toString() {
        return "TinhThanh{" + "maTinh=" + maTinh + ", tenTinh=" + tenTinh + '}';
    }

}

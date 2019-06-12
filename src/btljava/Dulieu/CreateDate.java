/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btljava.Dulieu;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author tung
 */
public class CreateDate {

    // khởi tạo kiểu đối tượng JDateChooser
    JDateChooser dateChooser;
    // định dạng kiểu date
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public void enabled() {
        // tạo đối tượng JTextFieldDateEditor để hiện kiểu date
        JTextFieldDateEditor dateE = (JTextFieldDateEditor) dateChooser.getDateEditor();
        dateE.setEditable(false);
    }
    
    // lấy kiểu date
    public String getDate(Date x){
        String s=simpleDateFormat.format(x);
        return s;
    }
    // gán date
     public Date setDate(String x) throws ParseException{
        Date s=simpleDateFormat.parse(x);
        return s;
    }
     
     
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package images;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eshan
 */
public class NewClass {
    public static void main(String[] args) {
       
        try {
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date today = sdf.parse("2023-10-11");
                Date date = sdf.parse("2023-10-10");
            if (date.after(today)) {
                    System.out.println("111111");
                } else {
                System.out.println("222222");
            }
        } catch (ParseException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
}

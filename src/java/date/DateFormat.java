/*
 * Copyright(C) 2021,  FPT University
 * J3.L.P0010
 * FPT Education System
 *
 * Record of change:
 * DATE          Version             AUTHOR             DESCRIPTION
 * 2021-07-22    1.0              LongPHHE141469       First Implement
 */
package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class format the date and time 
 * 
 * @author LongPHHE141469 
 */
public class DateFormat {
   /**
     * This method uses <code>SimpleDateFormat</code> to format date and time
     * following the request
     *
     * @return date and time had formated, it is <code>String</code>
     */
    public String getDate() {
        //Get day of week
        SimpleDateFormat formatTime = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE \n dd/MM/yyyy");
        Date date = null;
        try {
            date = formatTime.parse(java.time.LocalDate.now().toString());
        } catch (ParseException ex) {
            Logger.getLogger(DateFormat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dateFormat.format(date);
    }
  
}

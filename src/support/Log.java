/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author adichouhanofficial
 */
public class Log implements Serializable
{
    private String user,timestamp,detail;
    private Date date;

    public Log(String user,String detail) 
    {
        Date d = new Date();
        this.user = user;
        this.timestamp = new SimpleDateFormat("hh:mm a").format(d);
        this.detail = detail;
        this.date = d;
    }

    
    public String getUser() {
        return user;
    }
    public String getTimestamp() {
        return timestamp;
    }

    public String getDetail() {
        return detail;
    }
    public Date getDate() {
        return date;
    }
    @Override
    public String toString() {
        return "Log{" + "user=" + user + ", timestamp=" + timestamp + ", time=" + detail + ", date=" + date + '}';
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Log other = (Log) obj;
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.timestamp, other.timestamp)) {
            return false;
        }
        if (!Objects.equals(this.detail, other.detail)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }
    
    
}

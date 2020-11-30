/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author adichouhanofficial
 */
public class Logs 
{
    private static void saveObject(List<Log> alllogs) throws IOException
    {
        File f = new File("myfile//logs.sar");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        fos.flush();
        oos.flush();
        oos.writeObject(alllogs);
        fos.close();
        oos.close();
    }
    private static List<Log> getObject() throws IOException 
    {
        File f = new File("myfile");
        if(!f.exists())
            f.mkdir();
        f = new File("myfile//logs.sar");
        List<Log> alllogs = new ArrayList();
        try 
        {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            alllogs=(List)ois.readObject();
            fis.close();
            ois.close();
        }  
        catch (FileNotFoundException ex) 
        {
            f.createNewFile();
        } 
        catch (ClassNotFoundException ex) 
        {
            ex.printStackTrace();
        }
        return alllogs;
    }
    
    public static void  addLog(Log log) throws IOException
    {
        List alllogs = getObject();
        alllogs.add(log);
        saveObject(alllogs);
    }
    public static List<Log> getLog(Date from,Date to) throws IOException
    {
        List<Log> logInRange = new ArrayList();
        List<Log> alllogs=getObject();
        for(Log log : alllogs)
        {
            Date date = log.getDate();
            if(date.compareTo(from)>=0 && date.compareTo(to)<=0)
                logInRange.add(log);
        }
        return logInRange;
    }
}

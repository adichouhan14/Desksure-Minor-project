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
import java.util.List;

/**
 *
 * @author adichouhanofficial
 */
public class UserFiles 
{
    
    
    private static void saveObject(List<UserFile> allfiles) throws IOException
    {
        File f = new File("myfile//userfile.sar");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        fos.flush();
        oos.flush();
        oos.writeObject(allfiles);
        fos.close();
        oos.close();
    }    
    private static List<UserFile> getObject() throws IOException 
    {
//        File f = new File("myfile");
//        if(!f.exists())
//            f.mkdir();
        File f = new File("myfile//userfile.sar");
        List<UserFile> allfiles = new <UserFile>ArrayList();
        try 
        {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            allfiles=(List)ois.readObject();
            fis.close();
            ois.close();
        }  
        catch (FileNotFoundException ex) 
        {
            //f.createNewFile();
        } 
        catch (ClassNotFoundException ex) 
        {
            ex.printStackTrace();
        }
        return allfiles;
    }
    
    public static void addFile(UserFile file) throws IOException
    {
        List<UserFile> allfiles = getObject();
        allfiles.add(file);
        saveObject(allfiles);
    }
     public static boolean removeFile(UserFile file) throws IOException
    {
        List<UserFile> allfiles = getObject();
        boolean b=allfiles.remove(file);
        saveObject(allfiles);
        return b;
    }
    public static List<UserFile> getSelectedUserFiles(User user) throws IOException
    {
        String name=user.getMAC();
        List<UserFile> allfiles = getObject();
        List<UserFile> myfile = new ArrayList();
        for(UserFile file : allfiles)
        {
            if(name.equals(file.addedBy.getMAC()))
                myfile.add(file);
        }
        return myfile;
    }

    public static List<UserFile> getAllFile() throws IOException
    {
        return getObject();
    }
    public static boolean fileNotPresent()
    {
        File f = new File("myfile//userfile.sar");
        return !f.exists();
    }
            
    
    
}

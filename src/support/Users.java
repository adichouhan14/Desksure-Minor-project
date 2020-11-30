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
public class Users 
{
    private static void saveObject(List<User> allusers) throws IOException
    {
        File f = new File("myfile//user.sar");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        fos.flush();
        oos.flush();
        oos.writeObject(allusers);
        fos.close();
        oos.close();
    }
    private static List<User> getObject() throws IOException 
    {
        File f = new File("myfile");
        if(!f.exists())
            f.mkdir();
        f = new File("myfile//user.sar");
        List<User> users = new <User>ArrayList();
        try 
        {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            users=(List)ois.readObject();
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
        return users;
    }
    public static boolean fileNotPresent()
    {
        File f = new File("myfile//user.sar");
        return !f.exists();
    }

    public static void addUser(User user) throws IOException
    {       
            List<User>users= getObject();
            users.add(user);
            saveObject(users);
        
    }
    public static boolean removeUser(User user) throws IOException
    {
        boolean b;
        List<User> users=(List)getObject();
        b=users.remove(user);
        saveObject(users);        
        return b;
    }
    public static boolean removeByMAC(String MAC) throws IOException
    {
        List<User> users=getObject();
        boolean flag=false;
        for(User user : users)
        {
            if(user.getMAC().equals(MAC))
            {
                flag=users.remove(user);
                break;
            }
        }
        if(flag) saveObject(users);
        return flag;
    }
    public static List<User> getUsers() throws IOException 
    {
        return(getObject());
    }
    
    public static User getUserByAddress(String MAC) throws IOException 
    {
        
        List<User> users=getObject();
        for(User user : users)
        {
            if(user.getMAC().equals(MAC))
                return user;
        }
        return null;
    }
    
}

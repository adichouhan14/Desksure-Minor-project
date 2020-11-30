/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import support.FileStatus;
import support.User;
import support.UserFile;
import support.UserFiles;
import support.Users;

/**
 *
 * @author adichouhanofficial
 */
public class Test 
{
    public static void main(String[] args) throws IOException 
    {
        //checking i/p o/p operation on both file
        
//        User u1= new User("Test","abc123456",false);
//        File f = new File("C:\\Users\\adichouhanofficial\\Documents\\Desksure test\\test.jpg");
//        UserFile myfile = new UserFile(f,"jpg",u1,FileStatus.DECRYPTED);
//        UserFiles.addFile(myfile);
//        Date date = new Date();
//        String sdf=new SimpleDateFormat("dd / MM /yyyy").format(date);
//        System.out.println(sdf);
        //System.out.println(date.toString().sub);

//        List<UserFile> allfiles=UserFiles.getAllFile();
//        for(UserFile file : allfiles)
//        {
//            System.out.println(file.getFile());
//            System.out.println(file.getTimestamp());
//            System.out.println(file.getExtension());
//            System.out.println(file.getStatus());
//            System.out.println(file.getAddedBy().getName());
//            System.out.println(file.getAddedBy().getMAC());
//            System.out.println("");
//            System.out.println(file.getTimestamp());
//        }
//        
//        List<User> users = Users.getUsers();
//        User u=null;
//        for(User user: users)
//        {
//            u=user;
//            break;
//        }
//
//        String MAC=u.getMAC();
//        System.out.println(MAC);
//        System.out.println("length ="+MAC.length());
//        String key = Resources.key(MAC);
//        System.out.println(key);
//        System.out.println("Key length = "+ key.length());
//        EncryptionEngine ee = new EncryptionEngine(key);
//
//        File file= new File("C:\\Users\\adichouhanofficial\\Documents\\Desksure test\\hi.txt");
//        File newfile = new File("C:\\Users\\adichouhanofficial\\Documents\\Desksure test\\hi.desksure");
//        file.renameTo(newfile);
//        ee.fileEncrypt(newfile);
//        System.out.println("Encrypted");
//
//
//          File file= new File("C:\\Users\\adichouhanofficial\\Documents\\Desksure test\\hi.txt");
//          File newfile = new File("C:\\Users\\adichouhanofficial\\Documents\\Desksure test\\hi.desksure");          
//          newfile.renameTo(file);
//          ee.fileDecrypt(file);
//          System.out.println("decrypted");
//        
//        List<User> users=Users.getUsers();
//        for(User user:users)
//        {
//            System.out.println(user);
//        }    
//
//        List<UserFile> allfiles = UserFiles.getAllFile();
//        for(UserFile file : allfiles)
//        {
//            System.out.println(file.getFile());
//        }
//        File file= new File("C:\\Users\\adichouhanofficial\\Documents\\Desksure test\\");
//        System.out.println(file.setWritable(true));
//        File newFile = new File(Resources.getDesksureURL(file.getAbsolutePath()));
//        System.out.println(file.getAbsoluteFile());
//        System.out.println(newFile.getAbsoluteFile());
//        System.out.println(file.getAbsolutePath().length()+"  "+newFile.getAbsolutePath().length());
//        ProcessBuilder pb = new ProcessBuilder("notpad.exe",);
//       file.
        Runtime.getRuntime().exec("C:/Windows/Notepad.exe C:\\Users\\adichouhanofficial\\Documents\\FR.txt");
        Runtime.getRuntime().exec("C:/Windows/Notepad.exe C:\\Users\\adichouhanofficial\\Documents\\insert.html");
    }

}

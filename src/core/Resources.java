package core;

import java.io.File;
import javax.obex.ClientSession;
import support.UserFile;

public class Resources 
{
    private static final Resources resourceSingleton = new Resources();
    private static Bluetooth bluetooth;
    public static ClientSession connection;
    public static boolean lockFlag=true;

    private Resources(){}
    public static Resources getInstance()
    {
        return resourceSingleton;
    }
//    private static String key(String unFormatted)
//    {    
//        String b1= "@128";
//        String b2=unFormatted.substring(2, 4);
//        String b3=unFormatted.substring(4, 6);
//        String b4=unFormatted.substring(6, 8);
//        String b5= "kE";    
//        return b1+":"+b2+":" +b3+":"+b4+":"+b5;
//    }
    
     public static String key(String MAC)
    {  
        // 04 : D1 : 3A : 88 : 3B : 10  MAC example
        // 012345678901234567890123456

        String b1= "@128";
        String b2=MAC.substring(0,2);
        String b3=MAC.substring(5,7);
        String b4=MAC.substring(10,12);
        String b5=MAC.substring(15,17);
        String b6=MAC.substring(25,27);
        String b7= "kE";    
        return b1+b6+b2+b5+b3+b4+b7;
    }
     public Bluetooth getBluetoothStack()
     {
         return resourceSingleton.bluetooth;
     }
     public void setBluetoothStack(Bluetooth bluetooth)
     {
         resourceSingleton.bluetooth=bluetooth;
     }
     public static String fetchFileExtension(String path)
     {
         int i= path.lastIndexOf('.');
         return path.substring(i+1,path.length());
     }
     public static String getFormattedAddress(String unFormatted)
    {  
        String b1=unFormatted.substring(0, 2);
        String b2=unFormatted.substring(2, 4);
        String b3=unFormatted.substring(4, 6);
        String b4=unFormatted.substring(6, 8);
        String b5=unFormatted.substring(8, 10);
        String b6=unFormatted.substring(10, 12);
        
        return b1+" : "+b2+" : " +b3+" : "+b4+" : "+b5+" : "+b6;
    }
     
     public static boolean changeName(String oldurl,String newurl)
     {
         File old= new File(oldurl);
         File neww = new File(newurl);
         boolean b = old.renameTo(neww);
         return true;
     }
     
     public static String getDesksurePath(String oldpath)
     {
        int i = oldpath.lastIndexOf('.');
        String newpath = oldpath.substring(0,i+1)+"desksure";
        return (newpath);
     }
     public static String getActualFileName(UserFile myfile)
     {
         String extension=myfile.getExtension();
         String oldpath=myfile.getFile().getAbsolutePath();
         int i=oldpath.lastIndexOf('.');
         String newPath=oldpath.substring(0,i+1)+extension;
         return (newPath);
     }
}

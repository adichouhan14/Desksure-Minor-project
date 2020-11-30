package core;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Key;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionEngine 
{   
    private String unFormatted;
    public EncryptionEngine(String unFormatted) 
    {
        this.unFormatted = unFormatted;
    }
    
    public byte[] fromFile(File f)
    {
        byte b[] = null;
        try{
        FileInputStream fin = new FileInputStream(f);
        b = new byte[(int)f.length()];
        fin.read(b);
        }
        catch(FileNotFoundException e){System.err.println("the specified file is not find");}
        catch(IOException e){System.err.println("can\'t read file");}
        return b;
    }
    
    public Key generateKey()
    {
        byte[] keyBytes = Resources.key(unFormatted).getBytes();   //"ThisIs128bitSize".getBytes();
        Key key = new SecretKeySpec(keyBytes, "AES");
        return key;
    }
    public byte[] encrypt(byte[] b) throws IllegalBlockSizeException, BadPaddingException{ 
        Cipher a =null;
        try{
        a = Cipher.getInstance("AES");
        a.init(Cipher.ENCRYPT_MODE, generateKey());
        
        }
        catch(Exception e){e.printStackTrace();}
        return a.doFinal(b);
    }
    public byte[] decrypt(byte[] b) throws IllegalBlockSizeException, BadPaddingException{
        Cipher a=null;
        try{
            a = Cipher.getInstance("AES");
            a.init(Cipher.DECRYPT_MODE, generateKey());
        }
        catch(Exception e){e.printStackTrace();}
        return a.doFinal(b);
    }
    
    public void toFile(File f,byte[] b){
        try{
        FileOutputStream fout = new FileOutputStream(f);
        fout.write(b);
        }
        catch(Exception e){e.printStackTrace();}
    }
    
    public void fileEncrypt(File f)
    {
        byte[] fileData = fromFile(f);
        byte[] encryptData = null;
        try
        {
            encryptData = encrypt(fileData);
        }
        catch(Exception e){e.printStackTrace();}
        toFile(f,encryptData);
    }
    
    public void fileDecrypt(File f)
    {
        byte[] fileData = fromFile(f);
        byte[] decryptData = null;
        try{
            decryptData = decrypt(fileData);
        }
        catch(Exception e){e.printStackTrace();}
        toFile(f,decryptData);
    }
}

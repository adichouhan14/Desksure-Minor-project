/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support;

import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author adichouhanofficial
 */
public class UserFile implements Serializable
{
    File file;
    String extension;
    String timestamp;
    User addedBy;
    FileStatus status;

    public UserFile(File file,String extension,User addedBy,FileStatus status)
    {
        this.file=file;
        this.extension=extension;
        this.addedBy=addedBy;
        this.status=status;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY | hh:mm a");
        this.timestamp = dateFormat.format(new Date());
    }
    public void setEncrypted(boolean b)
    {
        if(b)
            this.status=FileStatus.ENCRYPTED;
        else
            this.status=FileStatus.DECRYPTED;
    }
    public boolean isEncrypted()
    {
        if(this.status==FileStatus.ENCRYPTED)
            return true;
        else
            return false;
    }
    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        
    }

    public User getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(User addedBy) {
        this.addedBy = addedBy;
    }

    public FileStatus getStatus() {
        return status;
    }

    public void setStatus(FileStatus status) 
    {
        this.status = status;
    }

    
    @Override
    public String toString()
    {
        return "UserFile{" + "file=" + file + ", extension=" + extension + ", timestamp=" + timestamp + ", addedBy=" + addedBy.getName() + ", status=" + status + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        final UserFile other = (UserFile) obj;
        if (!Objects.equals(this.extension, other.extension)) {
            return false;
        }
        if (!Objects.equals(this.file, other.file)) {
            return false;
        }
        return true;
    }

    
    
      
}

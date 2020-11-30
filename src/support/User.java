/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support;

import java.io.Serializable;

/**
 *
 * @author adichouhanofficial
 */
public class User implements Serializable
{
    private String name,MAC;
    private boolean type;

    public User(String name, String MAC, boolean type) {
        this.name = name;
        this.MAC = MAC;
        this.type = type;
    }
    public User(){}
    public String getName() 
    {
        return name;
    }
    public void setName(String name) 
    {
        this.name = name;
    }
    public String getMAC() 
    {
        return MAC;
    }
    public void setMAC(String MAC) 
    {
        this.MAC = MAC;
    }
    public boolean isType() 
    {
        return type;
    }
    public void setType(boolean type) 
    {
        this.type = type;
    }

    public boolean equals(User obj)
    {
        return this.MAC.equals(obj.MAC);
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", MAC=" + MAC + ", type=" + type + '}';
    }
    
    
}
